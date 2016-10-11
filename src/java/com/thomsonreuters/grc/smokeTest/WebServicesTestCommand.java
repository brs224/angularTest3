/* 
 * Copyright 2012: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or Reproduction without the written 
 * authorization of TRGR is prohibited
 */
package com.thomsonreuters.grc.smokeTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.NullWriter;
import org.apache.log4j.Logger;

import com.thomson.west.j3.commons.AppTest;
import com.thomson.west.j3.commons.AppTestContext;
import com.thomson.west.j3.commons.AppTestResult;
import com.thomson.west.j3.web.WebTestCommand;
import com.thomson.west.j3.web.WebTestHtmlResponseFormatter;

/**
 * Overrides WebTestCommand to pass additional information in <code>AppTestContext</code> to the tests being run.
 */
public class WebServicesTestCommand extends WebTestCommand {

    private static final Logger LOG = Logger.getLogger(WebServicesTestCommand.class);
    
    /** The version retrieved from the manifest, or provided by the build tool. */
    private String manifestVersion;

    /** The servlet context this test is running in. */
    private ServletContext servletContext;


    /**
     * Create an instance of the object with the given values.
     * 
     * @param appTestName The name used for this test run.
     * @param releaseLabel The version retrieved from the manifest, or provided by the build tool.
     * @param context The servlet context this test will run in.
     */
    public WebServicesTestCommand(String appTestName, String releaseLabel, ServletContext context) {
        
        super(appTestName, releaseLabel);
        manifestVersion = releaseLabel;
        servletContext = context;
    }

    /**
     * Execute the configured AppTestImpl via the AppTest interface.
     * 
     * @param request The request being processed.
     * @param response The response object to write the output to.
     * @throws ServletException when a servlet exception is encountered.
     * @throws IOException when an IO exception is encountered.
     */
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int OUTPUT_HTML = 0;
        int OUTPUT_XML = 1;
        int OUTPUT_JSON = 2;
        int outputFormat = OUTPUT_HTML;
        String accept = request.getHeader("Accept");
        System.out.println("accept=" + accept);
        if (accept != null) {
            if ((accept.indexOf("application/xml") >= 0) || (accept.indexOf("text/xml") >= 0)) {
                outputFormat = OUTPUT_XML;
            }
            if ((accept.indexOf("application/json") >= 0) || (accept.indexOf("text/json") >= 0)) {
                outputFormat = OUTPUT_JSON;
            }
            if ((accept.indexOf("text/html") >= 0)) {
                outputFormat = OUTPUT_HTML;
            }
        }
        PrintWriter out = response.getWriter();

        AppTestResult[] results = null;
        int port = request.getLocalPort();
        AppTestContext context = new AppTestContext();
        context.put(AppTestContext.PORT, port);
        context.put(TEST_CTX_REQUEST, request);
        context.put(TEST_CTX_RESPONSE, response);
        context.put(TEST_CTX_SERVLET_CONTEXT, servletContext);

        AppTest appTestImpl = getAppTestImplInst();
        String testType = getTestType(request);
        try {
            appTestImpl.setAppTestContext(context);
            if (isComponentTest(request)) {
                
                results = appTestImpl.doComponentTest();
            } else if (isIntegrationTest(request)) {
                
                results = appTestImpl.doIntegrationTest();
            } else {
                
                results = appTestImpl.doComponentTest();
            }

            if (outputFormat == OUTPUT_HTML) {
                response.setContentType("text/html");
                WebTestHtmlResponseFormatter formatter = new WebTestHtmlResponseFormatter();
                formatter.format(results, appTestImpl.getApplicationName(), appTestImpl.getVersion(), manifestVersion,
                        appTestImpl.getEnvironment(), appTestImpl.getServer(),
                        new CustomPrintWriter(out, testType), testType);
            } else if (outputFormat == OUTPUT_XML) {
                response.setContentType("application/xml");
                out.append(formatXmlOutput(results, context));
            }
        } catch (Exception e) {
            response.setContentType("text/html");
            WebTestHtmlResponseFormatter formatter = new WebTestHtmlResponseFormatter();
            formatter.formatException(e, appTestImpl.getApplicationName(), appTestImpl.getVersion(), manifestVersion,
                    appTestImpl.getEnvironment(), appTestImpl.getServer(), out, testType);
        }
        out.close();
    }

    // *********************************************************************************************
    // Accessors

    /** @return The version retrieved from the manifest, or provided by the build tool. */
    public String getManifestVersion() {
        return manifestVersion;
    }

    /** @return The servlet context this test is running in. */
    public ServletContext getServletContext() {
        return servletContext;
    }

    // *********************************************************************************************
    // Private members copied from WebTestCommand

    /** Used to identify a component test request. */
    private static final String COMPONENT_TEST = "COMPONENT";

    /** Used to identify an integration test request. */
    private static final String INTEGRATION_TEST = "INTEGRATION";

    /**
     * Checks if the request specifies component tests should be run.
     * 
     * @param req The request being processed.
     * @return True if component testing was requested.
     */
    private boolean isComponentTest(HttpServletRequest req) {
        
        boolean isComponentTest = false;
        if (getTestType(req).toUpperCase().compareTo(COMPONENT_TEST) == 0) {
            isComponentTest = true;
        }
        return isComponentTest;
    }

    /**
     * Checks if the request specifies integration tests should be run.
     * 
     * @param req The request being processed.
     * @return True if integration testing was requested.
     */
    private boolean isIntegrationTest(HttpServletRequest req) {
        
        boolean isIntegrationTest = false;
        if (getTestType(req).toUpperCase().compareTo(INTEGRATION_TEST) == 0) {
            isIntegrationTest = true;
        }
        return isIntegrationTest;
    }

    /**
     * Get the value of type from the passed request.
     * 
     * @param req
     * @return a non-null String so calls on the return value succeed
     */
    private String getTestType(HttpServletRequest req) {
        
        String testType = null;
        testType = req.getParameter("type");
        if (testType == null) {
            testType = COMPONENT_TEST;
        }
        return testType;
    }

    /**
     * Dynamically create the class identified in the appTestImplClassName and insure it supports the the AppTest
     * interface.
     * 
     * @throws ServletException in the event of a ClassNotFoundException caught when trying to create the Class.
     */
    private AppTest getAppTestImplInst() throws ServletException {
        
        String whereAmI = this.getClass().getName() + ".getAppTestImplInst()";
        try {
            return (AppTest) createObject(this.appTestImplClassName, "com.thomson.west.j3.commons.AppTest");
        } catch (ClassNotFoundException e) {
            String msg = whereAmI + " Could not locate class specified in app.test.impl named "
                    + this.appTestImplClassName;
            // TODO Add LoggingService support
            LOG.warn(msg, e);
            throw new ServletException(msg);
        }
    }

    /**
     * Used to dynamically create an instance of a desired class and insure it supports the desiredInterfaceName.
     * 
     * @param className concrete type of requested class
     * @param desiredInterfaceName to cast into
     * @return the requested class as an object which can be casted to the desiredInterfaceName
     * @throws ClassNotFoundException in the event of any exception being caught including if the class could not be
     *         found and if the class does not support the desired interface.
     */
    private static Object createObject(String className, String desiredInterfaceName) throws ClassNotFoundException {
        
        String whereAmI = "WebTestCommand.createObject()";
        Object object = null;

        Class classDefinition;
        try {
            classDefinition = Class.forName(className);
        } catch (Exception e) {
            String msg = whereAmI + " " + e.getClass().getName()
                    + " encountered when trying to get a class with name of " + className
                    + " with desiredInterfaceName of " + desiredInterfaceName;
            // TODO Add LoggingService support
            LOG.warn(msg, e);
            throw new ClassNotFoundException(msg, e);
        } catch (Error e) {
            String msg = whereAmI + " " + e.getClass().getName()
                    + " encountered when trying to get a class with name of " + className
                    + " with desiredInterfaceName of " + desiredInterfaceName;
            // TODO Add LoggingService support
            LOG.warn(msg, e);
            throw new ClassNotFoundException(msg, e);
        }
        try {
            object = classDefinition.newInstance();

            // may as well test so we can log if the interface is not implemented!
            if (!Class.forName(desiredInterfaceName).isInstance(object)) {
                String msg = whereAmI + " - " + object.getClass().getName() + " Does not support "
                        + desiredInterfaceName + " interface!";
                msg += " return specified class of type " + object.getClass().getName() + " must support "
                        + desiredInterfaceName + " interface.";
                ClassNotFoundException e =  new ClassNotFoundException(msg);
                // TODO Add LoggingService support
                LOG.warn(msg, e);
                throw e;
            }
        } catch (Exception e) {
            String msg = whereAmI + " " + e.getClass().getName()
                    + " encountered when trying to create a class with name of " + className
                    + " with desiredInterfaceName of " + desiredInterfaceName;
            // TODO Add LoggingService support
            LOG.warn(msg, e);
            throw new ClassNotFoundException(msg, e);
        } catch (Error e) {
            String msg = whereAmI + " " + e.getClass().getName()
                    + " encountered when trying to create a class with name of " + className
                    + " with desiredInterfaceName of " + desiredInterfaceName;
            // TODO Add LoggingService support
            LOG.warn(msg, e);
            throw new ClassNotFoundException(msg, e);
        }
        return object;
    }

    /**
     * @return The server name and port specified in the request.
     *          Ex: qa.workbench.judicial.int.westgroup.com:80.
     */
//    protected final String getRequestDomain(AppTestContext context) {
//        HttpServletRequest request =
//            (HttpServletRequest) context.getObjectValue(TEST_CTX_REQUEST);
//
//        return request.getServerName() + ":" + request.getServerPort();
//    }


    protected String formatXmlOutput(AppTestResult[] testResults, AppTestContext context) {
        /*
        StringBuilder result = new StringBuilder("<results>");
        for (AppTestResult testResult : testResults) {
            result.append("<test>");
            result.append("<name>").append(testResult.getTestName()).append("</name>");
            if (testResult.isPassed()) {
                result.append("<result>passed</name>");
            } else if (testResult.isFatal()) {
                result.append("<result>fatal</name>");
            } else {
                result.append("<result>failed</name>");
            }
            result.append("</test>");
        }

        result.append("</results>");
        */
        StringBuilder result = new StringBuilder("<service name=\"ContentService\"");
        result.append(" host=\"").append(getRequestDomain(context)).append("\"");
        result.append(">");
        for (AppTestResult testResult : testResults) {
            result.append("<dependency");
            result.append(" name=\"").append(testResult.getTestName()).append("\"");
            if (testResult.isPassed()) {
                result.append(" available=\"1\"");
            } else if (testResult.isFatal()) {
                result.append(" available=\"0\"");
            } else {
                result.append(" available=\"0\"");
            }
            result.append(" message=\"").append(testResult.getComment()).append("\"");
            result.append("/>");
        }

        result.append("</service>");
        return result.toString();
    }


    /**
     * Used to inject a link before the HTML is closed; works around the private methods of
     * <code>WebTestHtmlResponseFormatter</code>.
     */
    private static final class CustomPrintWriter extends PrintWriter {

        private PrintWriter orig;
        private boolean isComponentTest;

        /**
         * Create a custom print writer that sends all requests to the orig PrintWriter, and knows
         * which report is being generated.
         */
        private CustomPrintWriter(PrintWriter orig, String testType) {
            
            super(new NullWriter());
            this.orig = orig;
            this.isComponentTest = !INTEGRATION_TEST.equalsIgnoreCase(testType);
        }

        /**
         * If the HTML is being closed, insert links to the other smoke test page.
         * @param s
         */
        @Override
        public void println(String s) {
            
            if (s != null) {
                if (s.equalsIgnoreCase("</html>")) {
                    // insert the links we want
                    String snippet = "<br/>";
                    if (isComponentTest) {
                        snippet += "<a href='J3Commons?type=Integration'>Integration Test</a>";
                    } else {
                        snippet += "<a href='J3Commons?type=Component'>Component Test</a>";
                    }
                    snippet +=  "<br/>";
                    s = snippet + s;
                }
            }
            orig.println(s);
        }
    }
}
