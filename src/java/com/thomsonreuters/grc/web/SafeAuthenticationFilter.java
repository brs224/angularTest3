package com.thomsonreuters.grc.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.thomsonreuters.grc.service.security.SecurityServiceWeb;

public class SafeAuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
        final ServletContext servletContext = filterConfig.getServletContext();
		final WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        servletResponse.setContentType("text/html; charset=UTF-8");

        try {
        	final String pathInfo = request.getRequestURI();
            boolean sessionValid = true;
            SecurityServiceWeb securityService = null;
            		securityService = getSecurityServiceWeb(request);
            		sessionValid = securityService.validateSessionToken(request, response);

            	String param = request.getParameter("debugworkbench");

            	if (sessionValid) {
            		System.out.println("Session is valid");
            		ServletContext context = request.getSession().getServletContext();
            	} else {
            		System.out.println("Session is invalid");
            		securityService.handleInvalidSessionToken(request, response);
            	}

        } catch (Exception e) {
        }
   		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

    private SecurityServiceWeb getSecurityServiceWeb(HttpServletRequest request) {
        ServletContext context = request.getSession().getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        return (SecurityServiceWeb)ctx.getBean(SecurityServiceWeb.class);
    }


}
