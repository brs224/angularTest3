/*
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or 
 * Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.smokeTest;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thomson.west.j3.web.ManifestServlet;
import com.thomson.west.j3.web.WebTestCommand;
import com.thomson.west.j3.web.WebTestServlet;

/**
 * Overrides WebTestServlet to run smoke tests that are provided with the
 * ServletContext object.
 */
public class WebServicesTestServlet extends WebTestServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Overrides WebTestServlet's doPost to run {@link WebServicesTestCommand}
     * instead.
     * 
     * @param servletRequest
     *            The request being processed.
     * @param servletResponse
     *            The response object to write to.
     * @throws ServletException
     *             Standard exception required by API.
     * @throws IOException
     *             Standard exception required by API.
     */
    @Override
    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws ServletException, IOException {

        String appTestName = getServletConfig().getInitParameter("app.test.impl");
        if (appTestName != null) {

            ServletContext servletContext = getServletContext();
            java.net.URL url = servletContext.getResource("/META-INF/MANIFEST.MF");
            String releaseLabel = (new ManifestServlet()).getReleaseLabel(url);

            WebTestCommand test = new WebServicesTestCommand(appTestName, releaseLabel, servletContext);

            test.execute(servletRequest, servletResponse);
        } else {

            super.doPost(servletRequest, servletResponse);
        }
    }
}
