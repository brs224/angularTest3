/*
 * Copyright 2011: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or Reproduction without the written
 * authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.smokeTest;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.sun.jersey.api.client.Client;
import com.thomson.west.j3.commons.AppTestContext;

/**
 * Superclass for web resource based smoke tests.
 * 
 * Extend this class for simple smoke tests that would exercise a GET command on a given URL and
 * then read the response as a stream.
 */
public abstract class WebResourceSmokeTest {
    
    private AppTestContext appTestContext;

    public void setAppTestContext(AppTestContext appTestContext) {
        
        this.appTestContext = appTestContext;
    }

    /**
     * @return A URL including the local server name and port. Ex: http://ctjdg9084:8183.
     *          This method is to be used when running component smoke tests as it would not
     *          depend on BigIP being available for mapping resolution.
     * 
     * @throws Exception
     */
    protected final String getLocalDomainURL() throws Exception {
        
        String host = System.getProperty(SmokeTestUtils.SYSTEM_CONTAINER_HOST);
        if (host == null || host.equals("")) {
            
            throw new Exception("Undefined system property '" + SmokeTestUtils.SYSTEM_CONTAINER_HOST + "'.");
        }

        String port = System.getProperty(SmokeTestUtils.SYSTEM_CONTAINER_PORT);
        if (port == null || port.equals("")) {
            
            throw new Exception("Undefined system property '" + SmokeTestUtils.SYSTEM_CONTAINER_PORT + "'.");
        }
        
        return "http://" + host + ":" + port;
    }

    /**
     * @return A URL including the server name and port specified in the request. 
     *          Ex: http://qa.workbench.judicial.int.westgroup.com:80.
     *          This method is bo be used when running integration smoke tests as BigIP will be required
     *          to perform mapping resolution. 
     *          
     * @throws Exception
     */
    protected final String getRequestDomainURL() throws Exception {
        
        HttpServletRequest request =
            (HttpServletRequest) appTestContext.getObjectValue(SmokeTestUtils.TEST_CTX_REQUEST);

        return "http://" + request.getServerName() + ":" + request.getServerPort();
    }

    /**
     * Performs a smoke test by reading the response from a GET on the specified resource.
     * 
     * @param resourceName The name of the resource to be used for messages produced by the test.
     * @param resourceURI The base URI to the resource, usually the domain URL. 
     * @param additionalPath Any additional path to be appended to the resource URI.
     * @return The result of the test.
     */
    protected final SmokeTestResult performTest(String resourceName, String resourceURI, String additionalPath) {
        
        try {
            
            Client.create().resource(resourceURI).path(additionalPath).get(InputStream.class);

            return SmokeTestResult.passed("Able to access " + resourceName + ".");
            
        } catch (Exception e) {
        
            return SmokeTestResult.fatal("Unable to access " + resourceName + " [" + e.getMessage() + "]");
        }
    }
}
