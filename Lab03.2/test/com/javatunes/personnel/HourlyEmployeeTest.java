package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    // object under test
    private HourlyEmployee hemp;

    @Before
    public void setUp() {
        hemp = new HourlyEmployee("Mari", Date.valueOf("2020-10-11"),41.0,35.0);
    }

    @Test
    public void testPay() {
        assertEquals(1435.0,hemp.pay(),.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(358.75, hemp.payTaxes(), .001);
    }
}