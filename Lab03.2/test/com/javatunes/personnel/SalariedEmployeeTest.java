package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    // object under test - called a "fisture" in JUnit
    private SalariedEmployee semp;
    private SalariedEmployee semp2;

    @Before
    public void setUp() {
        semp = new SalariedEmployee("Mary", Date.valueOf("2010-10-10"),4500.0);
        semp2 = new SalariedEmployee("Mary",Date.valueOf("2010-10-10"),4500.0);
    }

    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCode() {
        assertEquals(semp.hashCode(), semp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameRest() {
        semp2.setName("mike");

        assertNotEquals(semp, semp2);
    }

    @Test
    public void equal_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        semp2.setHireDate(Date.valueOf("1990-09-09"));

        assertNotEquals(semp, semp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        semp2.setSalary(5000.0);

        assertNotEquals(semp, semp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(semp, semp2);
    }

    @Test
    public void testPay() {
        assertEquals(4500.0,semp.pay(),.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(1350.0,semp.payTaxes(),.001);
    }
}