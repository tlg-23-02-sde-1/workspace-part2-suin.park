package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {
    private Map<String, String> seMap;
    private Map<String, String> heMap;

    /**
     * client input request is a Map<String,String>, here's a sample
     * key        value
     * ---        -----
     * type       HE or SE
     * name       Jackie
     * hireDate   1990-08-24
     * <p>
     * salary     50000.00
     * OR
     * rate       50.0
     * hours      40.0
     * <p>
     * NOTES:
     * 1. yes, we have redundant setup code, and even some redundant test code (to keep it simple)
     * 2. this is representative of how UIs send user input data to an application:
     * - Java Swing UI components all return their input data as strings
     * - in webapps, HTTP requests from browsers (e.g., a form submission) carry all values as strings
     */
    @Before
    public void init() {
        seMap = new HashMap<>();
        seMap.put("type", "SE");
        seMap.put("name", "Jackie");
        seMap.put("hireDate", "1990-08-24");
        seMap.put("salary", "50000.0");

        heMap = new HashMap<>();
        heMap.put("type", "HE");
        heMap.put("name", "Jackie");
        heMap.put("hireDate", "1990-08-24");
        heMap.put("rate", "50.0");
        heMap.put("hours", "40.0");
    }

    /**
     * TASK: verify that passing seMap into your factory returns a SalariedEmployee,
     * with all properties set.
     * to check an object's type, you can use instanceof or check its Class object (preferred):
     * assertEquals(SalariedEmployee.class, emp.getClass())
     */
    @Test
    public void createEmployee_shouldReturnSalariedEmployee_whenTypeSE() {
        Employee emp = EmployeeFactory.createEmployee(seMap);

        // check that 'emp' is EXACTLY a SalariedEmployee object
        assertEquals(SalariedEmployee.class, emp.getClass());

        // check that name, hireDate, and salary are indeed correct
        // refactor this, so I don't have to say it twice (DRY Principle)
        checkNameHireDate(emp);

        // downcast 'emp' reference to more specific type SalariedEmployee
        SalariedEmployee semp = (SalariedEmployee) emp;
        assertEquals("50000.0", semp.getSalary().toString());
    }

    private void checkNameHireDate(Employee emp) {
        assertEquals("Jackie", emp.getName());
        assertEquals("1990-08-24", emp.getHireDate().toString());
    }

    /**
     * TASK: verify that passing heMap into your factory returns a HourlyEmployee, with all properties set.
     */
    @Test
    public void createEmployee_shouldReturnHourlyEmployee_whenTypeHe() {
        Employee emp = EmployeeFactory.createEmployee(heMap);

        // check that 'emp' is EXACTLY a HourlyEmployee object
        assertEquals(HourlyEmployee.class, emp.getClass());

        // check that name, hireDATE, rate, and hour are indeed correct
        assertSame(heMap.get("name"),emp.getName());
        assertEquals(heMap.get("hireDate"), emp.getHireDate().toString());

        // downcast 'emp' reference to more specific type HourlyEmployee
        HourlyEmployee hemp = (HourlyEmployee) emp;
        assertEquals("50.0", hemp.getRate().toString());
        assertEquals("40.0", hemp.getHours().toString()); // expected, actual, delta
    }

    /**
     * TASK: verify that passing a map with an invalid "type" value results in IllegalArgumentException.
     * The only valid values for "type" are "HE" or "SE".
     */

/*  @Test(expected = IllegalArgumentException.class)
    public void createEmployee_shouldThrowIllegalArgumentException_whenInvalidType_expectedAttribute() {
        seMap.put("type", "INVALID-TYPE");
        EmployeeFactory.createEmployee(seMap);  // should trigger exception, class.method
*/
    @Test
    public void createEmployee_shouldThrowIllegalArgumentException_whenInvalidType_try_catch_fail() {
        seMap.put("type", "INVALID-TYPE");
        try {
            EmployeeFactory.createEmployee(seMap);  // should trigger exception, class.method
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid type: INVALID-TYPE", e.getMessage());
        }
    }
}