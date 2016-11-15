/*
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or 
 * Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.smokeTest;

import com.thomson.west.j3.commons.AppTestContext;
import com.thomson.west.j3.commons.AppTestResult;
import org.apache.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Runs the smoke test methods found in a provided class and collects and
 * processes their results.
 * </p>
 *
 *
 * <p>
 * Classes provided to the {@link #runTests} method should itself have methods
 * that and annotate those with then {@link SmokeTest} annotation. Smoke test
 * methods should not require any parameters, and should return a
 * {@link SmokeTestResult} object.
 * </p>
 *
 * <p>
 * The smoke test class can also provide a setter for an {@link AppTestContext}
 * class. If present, it will be called with the context class for the current
 * test session.
 * </p>
 *
 * <p>
 * Smoke test classes can optionally be annotated with
 * {@link ComponentSmokeTest} or {@link IntegrationSmokeTest} to indicate the
 * type of smoke tests that a class contains, however, this is not required by
 * this class.
 * </p>
 * For example:
 * 
 * <pre>
 *  &#64;literal{@}ComponentSmokeTest
 *  public class SampleSmokeTests {
 *
 *      &#64;literal{@}SmokeTest("Sample Test Method")
 *      public SmokeTestResult sampleTestMethod() {
 *          return SmokeTestResult.passed("This test passed.");
 *      }
 *
 *  }
 * </pre>
 *
 * @see SmokeTestResult
 * @see SmokeTest
 * @see IntegrationSmokeTest
 * @see ComponentSmokeTest
 */
public class SmokeTestRunner {

    /** Private logger. */
    private static Logger logger = Logger.getLogger(SmokeTestRunner.class);

    /** The context values provided by the call of this object. */
    private AppTestContext appTestContext;

    /**
     * Create an instance of this test.
     */
    public SmokeTestRunner() {
    }

    /**
     * Run the tests in the given class and return the results.
     * 
     * @param smokeTestClass
     *            the class whose smoke tests will be invoked.
     * @return The list of results for each of the tests this class ran.
     */
    public List<AppTestResult> runTests(Object smokeTestClass) {
        List<AppTestResult> resultList = new ArrayList<AppTestResult>();

        Class c = smokeTestClass.getClass();
        Method[] methods = c.getMethods();

        // Check if there's a setter for appTestContext
        setContextForSmokeTestClass(smokeTestClass);

        // Loop through the methods and run those marked as smoke tests
        for (Method method : methods) {
            SmokeTest smokeTest = method.getAnnotation(SmokeTest.class);

            if (smokeTest != null) {
                String testName = smokeTest.value();

                logger.trace("method " + method.getName() + " is a smoke test");
                AppTestResult result = runSmokeTestMethod(smokeTestClass, method, testName);
                resultList.add(result);
            } else {
                logger.trace("method " + method.getName() + " is NOT a smoke test");
            }
        }

        return resultList;
    }

    /**
     * Check if the given class has a setter for the AppTestContext, and if so,
     * call it to pass the smoke test context to it.
     * 
     * @param smokeTestClass
     *            the class whose smoke tests will be invoked.
     */
    protected void setContextForSmokeTestClass(Object smokeTestClass) {
        try {
            BeanInfo info = Introspector.getBeanInfo(smokeTestClass.getClass());

            // Look for the write method for the "appTestContext" property
            for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
                String name = pd.getName();
                Method setter = pd.getWriteMethod();
                if (("appTestContext".equals(name)) && (setter != null)) {
                    setter.invoke(smokeTestClass, appTestContext);
                    return; // we're done, we can return
                }
            }
        } catch (Exception e) {
            logger.warn("Unable to pass AppTestContext to smoke test class");
        }
    }

    /**
     * Run the given method which has been identified as a SmokeTest method.
     * 
     * @param smokeTestClass
     *            The class whose smoke test method will be called.
     * @param method
     *            The smoke test method.
     * @param testName
     *            The test name to use for this method.
     * @return The result from the smoke test execution.
     */
    protected AppTestResult runSmokeTestMethod(Object smokeTestClass, Method method, String testName) {
        try {
            // Run the test
            Object result = method.invoke(smokeTestClass);

            // Add the result to our internal list
            if (result instanceof SmokeTestResult) {
                return createAppTestResult(testName, (SmokeTestResult) result);
            } else {
                return createAppTestResult(testName,
                        SmokeTestResult.failed("Unrecognized return value from smoke test"));
            }

        } catch (InvocationTargetException ite) {
            Throwable t = ite.getCause();
            String message = t.getMessage();
            String exceptionName = t.getClass().getSimpleName();
            String comment = "The test threw the exception " + exceptionName + " with the message [" + message + "]";
            return createAppTestResult(testName, SmokeTestResult.failed(comment));
        } catch (Exception e) {
            String message = e.getMessage();
            String exceptionName = e.getClass().getSimpleName();
            String comment = "Unable to run the test; Exception: " + exceptionName + "; message: [" + message + "]";
            return createAppTestResult(testName, SmokeTestResult.failed(comment));
        }
    }

    /**
     * Create an AppTestResult from the given {@link SmokeTestResult}.
     *
     * @param testName
     *            The name of the test that was run.
     * @param result
     *            The result of the test.
     * @result The AppTestResult object created.
     */
    protected AppTestResult createAppTestResult(String testName, SmokeTestResult result) {
        AppTestResult appTestResult = new AppTestResult();
        appTestResult.setTestName(testName);

        if (result == null) {

            appTestResult.setPassed(false);
            appTestResult.setFatal(false);
            appTestResult.setComment("This test did not return a result object.");

        } else {
            // Inspect the given SmokeTestResult

            // First, copy the comment, if present
            if (result.getComment() != null) {
                appTestResult.setComment(result.getComment());
            }

            // Next, interpret the result value
            if (result.getResult() == SmokeTestResult.TEST_PASSED) {
                appTestResult.setPassed(true);
                appTestResult.setFatal(false);
            } else if (result.getResult() == SmokeTestResult.TEST_FAILED) {
                appTestResult.setPassed(false);
                appTestResult.setFatal(false);
            } else if (result.getResult() == SmokeTestResult.TEST_FATAL_FAIL) {
                appTestResult.setPassed(false);
                appTestResult.setFatal(true);
            } else {
                // Can't understand the value
                appTestResult.setPassed(false);
                appTestResult.setFatal(false);
                appTestResult.setComment("This test did not return a recognizable result value.");
            }
        }

        return appTestResult;
    }

    // *********************************************************************************************
    // Accessors

    /**
     * @param appTestContext
     *            The context values provided by the caller of this object.
     */
    public void setAppTestContext(AppTestContext appTestContext) {
        this.appTestContext = appTestContext;
    }
}