/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        System.out.println("testAdd");

        Calculator calc = new Calculator();
        int result = calc.add(1, 4);

        assertEquals(5, result);  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");

        Calculator calc = new Calculator();
        double result = calc.divide(5, 2);

        assertEquals(2.5, result, .001); // expected, actual, delta
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");

        Calculator calc = new Calculator();

        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(11));
    }
}