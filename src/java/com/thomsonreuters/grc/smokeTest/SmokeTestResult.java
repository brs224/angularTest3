/* 
 * Copyright 2011: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or Reproduction without the written 
 * authorization of TRGR is prohibited
 */
package com.thomsonreuters.grc.smokeTest;

/**
 * <p>Used by methods of <code>ComponentSmokeTest</code> and <code>IntegrationSmokeTest</code> to
 * communicate the results of a test method.  To create instances of this class, static factory
 * methods are provided:</p>
 *
 * <p><code>SmokeTest.passed("The REST call succeeded.");</code></p>
 * <p><code>SmokeTest.failed("Unable to contact Audit Service.");</code></p>
 * <p><code>SmokeTest.fatal("Unable to establish a DB connection.");</code></p>
 */
public class SmokeTestResult {

    /** Used for <code>result</code> to indicate the test passed. */
    public static final int TEST_PASSED = 0;

    /** Used for <code>result</code> to indicate the test failed, but not in a fatal way. */
    public static final int TEST_FAILED = 1;

    /** Used for <code>result</code> to indicate a fatal failure. */
    public static final int TEST_FATAL_FAIL = 2;


    /**
     * Identifies whether the test passed or failed, and if the failure is fatal or not.
     */
    private int result;

    /**
     * A comment to accompany the result of the test.  Can be used to explain why a test failed
     * or is marked fatal.
     */
    private String comment;


    //*********************************************************************************************
    // Constructors

    /**
     * Creates an instance of this class with both required fields provided.  For most needs, use
     * one of the static factory methods to create instances of this class instead of calling this
     * constructor.
     *
     * @param result    Use one of the TEST_XXXX values defined in this class.
     * @param comment   An optional comment to describe the test outcome.
     */
    protected SmokeTestResult(int result, String comment) {
        this.result = result;
        this.comment = comment;
    }

    //*********************************************************************************************
    // Static factory methods

    /**
     * Create an instance of this object that indicates that the test passed.
     * @return  A SmokeTestResult object used for tests that passed.
     */
    public static SmokeTestResult passed() {
        return new SmokeTestResult(TEST_PASSED, null);
    }

    /**
     * Create an instance of this object that indicates that the test passed and a helpful comment.
     * @param comment   Describes the outcome of the test.
     * @return  A SmokeTestResult object used for tests that passed.
     */
    public static SmokeTestResult passed(String comment) {
        return new SmokeTestResult(TEST_PASSED, comment);
    }

    /**
     * Create an instance of this object that indicates that the test failed with some description
     * about the outcome.
     * @param comment   Describes the outcome of the test.
     * @return  A SmokeTestResult object used for tests that failed.
     */
    public static SmokeTestResult failed(String comment) {
        return new SmokeTestResult(TEST_FAILED, comment);
    }

    /**
     * Create an instance of this object that indicates that the test failed with some description
     * about the outcome.
     * @param comment   Describes the outcome of the test.
     * @return  A SmokeTestResult object used for tests that failed.
     */
    public static SmokeTestResult fatal(String comment) {
        return new SmokeTestResult(TEST_FATAL_FAIL, comment);
    }

    //*********************************************************************************************
    // Accessors

    /**
     * Identifies whether the test passed or failed, and if the failure is fatal or not.  Compare
     * against the TEST_XXXX values to interpret the value.
     * @return  One of the TEST_XXXX values defined in this class.
     */
    public int getResult() {
        return result;
    }

    /**
     * A comment to accompany the result of the test.  Can be used to explain why a test failed
     * or is marked fatal.
     * @return A description of the test outcome.
     */
    public String getComment() {
        return comment;
    }


    /**
     * Implemented for debugging.
     * @return  A string with the values of the object properties.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SmokeTestResult");
        sb.append("{result=").append(result);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
