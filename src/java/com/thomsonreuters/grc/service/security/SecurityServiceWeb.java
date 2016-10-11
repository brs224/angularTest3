package com.thomsonreuters.grc.service.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SecurityServiceWeb{

    public boolean validateSessionToken(
            HttpServletRequest request,
            HttpServletResponse response);

    public void handleInvalidSessionToken(
            HttpServletRequest request,
            HttpServletResponse response);

    /**
     * Contacts Security Service and validates the session token
     * @return <code>false</code> if the sessionToken is invalid. 
     */
    public boolean isSessionTokenValid(String sessionToken) throws Exception;

    /**
     * The url of the security service
     * @return the url of the SecurityService being used
     */
    public String getSecurityServiceUrl();



}
