/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

/**
 * TODO: use an annotation(s) in this class to apply some control over the order of test execution.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MethodOrderTest {
  @Rule
  public TestName testName = new TestName();


  @Test
  public void shouldIOrderTheExceutionOfMyTests() {
    assertEquals("shouldIOrderTheExceutionOfMyTests", testName.getMethodName());
    System.out.println("current MethodName is:" + testName.getMethodName());
  }

  @Test
  public void testSomething() {
    assertEquals("testSomething", testName.getMethodName());
    System.out.println("current MethodName is:" + testName.getMethodName());
  }

  @Test
  public void businessMethodShouldWorkCorrectly() {
    assertEquals("businessMethodShouldWorkCorrectly", testName.getMethodName());
    System.out.println("current MethodName is:" + testName.getMethodName());
  }
  
  @Test
  public void throwsExceptionIfUserDoesNotHaveSufficientPrivileges() {
    assertEquals("throwsExceptionIfUserDoesNotHaveSufficientPrivileges", testName.getMethodName());
    System.out.println("current MethodName is:" + testName.getMethodName());
  }
}