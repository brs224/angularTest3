/* 
 * Copyright 2011: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or Reproduction without the written 
 * authorization of TRGR is prohibited
 */
package com.thomsonreuters.grc.smokeTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Marks a method to be used for smoke testing.  This annotation is used in concrete implementations
 * of {@link BaseSmokeTest}.  Methods marked with this annotation should return
 * {@link SmokeTestResult} to indicate the outcome of the test that was performed.
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SmokeTest {
    /** The name to be used for the test being conducted. */
    String value();
}
