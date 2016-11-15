/*
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or 
 * Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.smokeTest;

import static com.thomsonreuters.grc.smokeTest.SmokeTestUtils.SYSTEM_CONTAINER_HOST;
import static com.thomsonreuters.grc.smokeTest.SmokeTestUtils.SYSTEM_CONTAINER_PORT;
import static com.thomsonreuters.grc.smokeTest.SmokeTestUtils.SYSTEM_ENVIRONMENT;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.thomson.west.j3.commons.AppTest;
import com.thomson.west.j3.commons.AppTestContext;
import com.thomson.west.j3.commons.AppTestResult;

/**
 * JudicialWorkbenchSmokeTest implements the AppTest interface as specified by
 * the J3 Commons Web Test Framework.
 * <p>
 * Copyright 2009-2011: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or
 * Reproduction without the written authorization of TRGR is prohibited.
 */
public class WebServicesSmokeTest implements AppTest {

    private static final String UNKNOWN_RESULT = "(Unknown)";

    private static final String APP_DISPLAY_NAME = "GRC Web Services";

    /** The context values provided by the call of this object. */
    private AppTestContext appTestContext;

    /** The object used for running smoke test classes. */
    private SmokeTestRunner smokeTestRunner = new SmokeTestRunner();

    public AppTestResult[] execute() {

        AppTestResult appTestResult = new AppTestResult();
        appTestResult.setComment(APP_DISPLAY_NAME + " - Comment");
        appTestResult.setFatal(false);
        appTestResult.setPassed(true);
        appTestResult.setTestName(APP_DISPLAY_NAME + " - Test #1");

        return new AppTestResult[] { appTestResult };
    }

    public AppTestResult[] doComponentTest() throws Exception {

        List<AppTestResult> results = new ArrayList<AppTestResult>();

        // Ask spring for the ComponentSmokeTest subclasses
        Map<String, Object> componentSmokeTests = getSmokeTests(ComponentSmokeTest.class);

        // Go through each class and run their tests
        for (Object test : componentSmokeTests.values()) {

            List<AppTestResult> appTestResults = smokeTestRunner.runTests(test);
            if (appTestResults != null) {

                // Add the test results to the list we're building
                results.addAll(appTestResults);
            }
        }

        return results.toArray(new AppTestResult[results.size()]);
    }

    public AppTestResult[] doIntegrationTest() throws Exception {

        List<AppTestResult> results = new ArrayList<AppTestResult>();

        // Ask spring for the IntegrationSmokeTest subclasses
        Map<String, Object> integrationSmokeTests = getSmokeTests(IntegrationSmokeTest.class);

        // Go through each class and run their tests
        for (Object test : integrationSmokeTests.values()) {

            List<AppTestResult> appTestResults = smokeTestRunner.runTests(test);
            if (appTestResults != null) {

                // Add the test results to the list we're building
                results.addAll(appTestResults);
            }
        }

        return results.toArray(new AppTestResult[results.size()]);
    }

    public String getApplicationName() {

        return APP_DISPLAY_NAME;
    }

    public String getEnvironment() {

        return System.getProperty(SYSTEM_ENVIRONMENT, UNKNOWN_RESULT);
    }

    public String getServer() {

        return System.getProperty(SYSTEM_CONTAINER_HOST, UNKNOWN_RESULT) + "-"
                + System.getProperty(SYSTEM_CONTAINER_PORT, UNKNOWN_RESULT);
    }

    public String getVersion() {

        return null;
    }

    public void setAppTestContext(AppTestContext appTestContext) {

        this.appTestContext = appTestContext;
        this.smokeTestRunner.setAppTestContext(appTestContext);
    }

    public Map<String, Object> getSmokeTests(Class<? extends Annotation> type) {

        ServletContext servletContext = (ServletContext) appTestContext
                .getObjectValue(WebServicesTestCommand.TEST_CTX_SERVLET_CONTEXT);

        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        return ctx.getBeansWithAnnotation(type);
    }

}
