/*
 * Copyright 2010: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or
 * Reproduction without the written authorization of TRGR is prohibited
 */

package com.thomson.west.j3.template;

import com.thomson.west.j3.commons.AppTest;
import com.thomson.west.j3.commons.AppTestResult;
import com.thomson.west.j3.commons.AppTestContext;

/**
 * HelloWorldSmokeTest provides a simple implementation of the AppTest
 * interface as specified by the J3 Commons Web Test Framework.
 * <p>
 * This is not intended to be production code. It exists to provide an
 * easy mechanism for determining if the deployment of a new WPT-based project
 * is successful.
 * <p>
 * It is assumed that this implementation will be replaced by the developers
 * of the WPT based project with an implementation more appropriate to the
 * specific project.
 */
public class HelloWorldSmokeTest implements AppTest {

    public AppTestResult[] execute() {
        
        AppTestResult appTestResult = new AppTestResult();
        appTestResult.setComment("WPT Hello World - Comment");
        appTestResult.setFatal(false);
        appTestResult.setPassed(true);
        appTestResult.setTestName("WPT Hello World - Test #1");
        
        return new AppTestResult[]{appTestResult};                
    }

    public AppTestResult[] doComponentTest() throws Exception {
        return new AppTestResult[0];
    }

    public AppTestResult[] doIntegrationTest() throws Exception {
        return new AppTestResult[0];  
    }

    public String getApplicationName() {
    	//test
        return "WPT Hello World";
    }

    public String getEnvironment() {
        return "WPT Hello World - Environment";
    }

    public String getServer() {
        return "WPT Hello World - Servlet";
    }

    public String getVersion() {
        return "WPT Hello World - Version";
    }

    public void setAppTestContext(AppTestContext appTestContext) {
        
    }

}
