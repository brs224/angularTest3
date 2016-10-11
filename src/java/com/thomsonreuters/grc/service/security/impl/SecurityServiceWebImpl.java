package com.thomsonreuters.grc.service.security.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.thomsonreuters.grc.service.security.SecurityServiceWeb;

/**
 * Can potentially be folded into SecurityServiceClient in grccommon. Not sure
 * we want to include all of grccommon as is. It's gotten far too heavy.
 * 
 * @author U0165176
 *
 */
public class SecurityServiceWebImpl implements SecurityServiceWeb {
	private static final String SESSION_RENEW_URI = "/session/renew";

	private String securityServiceUrl = null;

	public static final String SECURITY_SERVICE_CONTEXT = "/resources/security";
	protected static final String SECURITY_PASS_THROUGH_URLSUFFIX = "/SecPassThrough?originalURL=";

	public static final String HEADER_SESSION_TOKEN = "X-West-session-token";

	// Cookie Names
	protected static final String COOKIE_SESSION_TOKEN = "jwSessionToken";
	protected static final String COOKIE_USER_FIRST_NAME = "jwUserFirstName";
	protected static final String COOKIE_USER_LAST_NAME = "jwUserLastName";
	protected static final String COOKIE_USER_ID = "jwUserId";
	protected static final String COOKIE_LOGIN_TIME = "safeLoginTime";

	// Request Parameters returned from SecurityService
	protected static final String SESSION_TOKEN = "SessionToken";
	protected static final String USER_ID = "USER_ID";
	protected static final String USER_LAST_NAME = "lastname";
	protected static final String USER_FIRST_NAME = "firstname";
	// the time the user has logged into safe.
	protected static final String LOGIN_TIME = "time";

	@Override
	public boolean validateSessionToken(HttpServletRequest request, HttpServletResponse response) {

		boolean sessionValid = false;

		String sessionToken = getSessionToken(request);
		System.out.println("sessionToken is " + sessionToken);

		if (sessionToken != null) {
			sessionValid = isSessionTokenValid(sessionToken);
		}

		System.out.println("Is sessionToken valid? = " + sessionValid);

		int maxAge = 0;
		if (sessionValid) {
			maxAge = -1;
		} else {
			maxAge = 0;
			sessionToken = "";
		}

		updateSessionInfo(sessionToken, maxAge, request, response);

		return sessionValid;

	}

	/**
	 * If the session is invalid the request is redirected to security service
	 * pass through servlet, which redirects the request to SAFE
	 */
	public void handleInvalidSessionToken(HttpServletRequest request, HttpServletResponse response) {

		try {

			String requestUrl = getRequestUrl(request);
			String securityServiceUrl = getSecurityServiceUrl();
			String url = securityServiceUrl + SECURITY_PASS_THROUGH_URLSUFFIX + URLEncoder.encode(requestUrl, "UTF-8");

			System.out.println("REDIRECTING TO SECURITY SERVICE");
			System.out.println("requestUrl=" + requestUrl);
			System.out.println("redirect URL=" + url);

			url = response.encodeRedirectURL(url);
			response.sendRedirect(url);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Gets the session token either from the header, url parameter, or from a
	 * cookie
	 * 
	 * @param request
	 *            a {@link HttpServletRequest}
	 * @return <code>null</code> if there is no session token
	 */
	protected String getSessionToken(HttpServletRequest request) {

		// the session token might be passed as header or url parameter when the
		// user get
		// forwareded to JW after they login
		String sessionToken = request.getParameter(SESSION_TOKEN);
		if (sessionToken == null) {
			sessionToken = request.getHeader(SESSION_TOKEN);
		}

		// The session token is an url parameter only after they login from
		// safe.
		// if session token is not part of the parameters, it should be in the
		// cookies.
		if (sessionToken == null) {
			sessionToken = getCookieValue(request, COOKIE_SESSION_TOKEN, null);
		}

		return sessionToken;
	}

	protected String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue) {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookieName.equals(cookie.getName())) {
					return (cookie.getValue());
				}
			}
		}

		return (defaultValue);
	}

	/**
	 * Persists the session info (user id, last name, first name, session token,
	 * time of login) to cookies
	 * 
	 * @param sessionToken
	 *            The session token passed from security service
	 * @param maxAge
	 *            Sets the maximum age of the cookie. The cookie will expire
	 *            after that many seconds have passed. Negative values indicate
	 *            the default behaviour: the cookie is not stored persistently,
	 *            and will be deleted when the user agent (web browser) exits. A
	 *            zero value causes the cookie to be deleted.
	 * @param request
	 *            the {@link HttpServletRequest}
	 * @param response
	 *            the {@link HttpServletResponse}
	 */
	protected void updateSessionInfo(String sessionToken, int maxAge, HttpServletRequest request,
			HttpServletResponse response) {

		String firstName = request.getParameter(USER_FIRST_NAME);
		if (firstName == null) {
			firstName = getCookieValue(request, COOKIE_USER_FIRST_NAME, null);
		}
		String lastName = request.getParameter(USER_LAST_NAME);
		if (lastName == null) {
			lastName = getCookieValue(request, COOKIE_USER_LAST_NAME, null);
		}
		String userId = request.getParameter(USER_ID);
		if (userId == null) {
			userId = getCookieValue(request, COOKIE_USER_ID, null);
		}
		String loginTime = request.getParameter(LOGIN_TIME);
		if (loginTime == null) {
			loginTime = getCookieValue(request, COOKIE_LOGIN_TIME, null);
		}

		firstName = (sessionToken == null || firstName == null) ? "" : firstName;

		try {
			firstName = URLDecoder.decode(firstName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception(UnsupportedEncodingException) Decoded FirstName " + e.getMessage());
		}

		System.out.println("FirstName: " + firstName);

		lastName = (sessionToken == null || lastName == null) ? "" : lastName;

		try {
			lastName = URLDecoder.decode(lastName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception(UnsupportedEncodingException) Decoded lastName " + e.getMessage());
		}

		System.out.println("LastName: " + lastName);

		userId = (sessionToken == null || userId == null) ? "" : userId;
		loginTime = (sessionToken == null || loginTime == null) ? "" : loginTime;

		try {
			loginTime = URLDecoder.decode(loginTime, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception(UnsupportedEncodingException) Decoded loginTime " + e.getMessage());
		}

		System.out.println("loginTime: " + loginTime);

		sessionToken = (sessionToken == null) ? "" : sessionToken;

		// add session token
		addCookie(COOKIE_SESSION_TOKEN, sessionToken, maxAge, request, response);
		// add user's first name
		addCookie(COOKIE_USER_FIRST_NAME, firstName, maxAge, request, response);
		// add user's last name
		addCookie(COOKIE_USER_LAST_NAME, lastName, maxAge, request, response);
		// add user's id
		addCookie(COOKIE_USER_ID, userId, maxAge, request, response);
		// add login time to safe
		addCookie(COOKIE_LOGIN_TIME, loginTime, maxAge, request, response);
	}

	/**
	 * Add a cookie and sets its path to the context path
	 * 
	 * @param name
	 *            the name of the cookie
	 * @param value
	 *            the value of the cookie
	 * @param maxAge
	 *            Sets the maximum age of the cookie. The cookie will expire
	 *            after that many seconds have passed. Negative values indicate
	 *            the default behaviour: the cookie is not stored persistently,
	 *            and will be deleted when the user agent (web browser) exits.
	 * @param request
	 *            the {@link HttpServletRequest}
	 * @param response
	 *            the {@link HttpServletResponse}
	 */
	protected void addCookie(String name, String value, int maxAge, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			// Cookies will be send with every request. This change was needed
			// to support security service with multiple context path
			cookie.setPath("/");
			if (maxAge >= 0) {
				cookie.setMaxAge(maxAge);
			}
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception(UnsupportedEncodingException) creating workbench cookie " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	protected String getRequestUrl(HttpServletRequest request) throws UnsupportedEncodingException {

		StringBuffer requestUrl = request.getRequestURL();

		Enumeration<String> parameterNames = request.getParameterNames();

		StringBuffer parameters = new StringBuffer();
		while (parameterNames.hasMoreElements()) {

			String key = parameterNames.nextElement();
			String value = URLEncoder.encode(request.getParameter(key), "UTF-8");

			parameters.append(key).append("=").append(value);

			if (parameterNames.hasMoreElements()) {
				parameters.append("&");
			}
		}

		if (parameters.length() > 0) {
			requestUrl.append("?").append(parameters);
		}

		return requestUrl.toString();

	}

	/**
	 * Contacts Security Service and validates the session token
	 * 
	 * @return <code>false</code> if the sessionToken is invalid.
	 */
	@Override
	public boolean isSessionTokenValid(String sessionToken) {
		boolean isSessionTokenValid = false;
		String securityServiceUrl = getSecurityServiceUrl();

		Client client = Client.create();
		// just makes sense to renew the authentication rather than just check if valid.
		// we will want to renew the session anyway and renew will return indication that
		// the session token is no longer valid if that is the case anyway.
		WebResource webResource = client.resource(securityServiceUrl)
				.path(SECURITY_SERVICE_CONTEXT + SESSION_RENEW_URI);

		Builder builder = webResource.type(MediaType.APPLICATION_XML);
		builder.header(HEADER_SESSION_TOKEN, sessionToken);
		try {
			ClientResponse response = builder.put(ClientResponse.class);
			
			System.out.println("ResponseStatus is "+response.getStatus());
			//200 status indicates session token was successfully renewed
			if (response.getStatus() == 200){
				isSessionTokenValid = true;
			}
			
			String xml = response.getEntity(String.class);
			System.out.println("ResponsePayload is "+xml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.destroy();
		}
		return isSessionTokenValid;
	}

	@Override
	public String getSecurityServiceUrl() {
		return securityServiceUrl;
	}

	public void setSecurityServiceUrl(String securityServiceUrl) {
		this.securityServiceUrl = securityServiceUrl;
	}

}
