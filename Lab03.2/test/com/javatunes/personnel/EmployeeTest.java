package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;



    @Before
    public void setUp() {
        // emp1 = new DummyEmployee("Jack", Date.valueOf("2020-10-10"));
        // emp2 = new DummyEmployee("Jack", Date.valueOf("2020-10-10"));

        emp1 = getEmp1();
        emp2 = getEmp1();

    }
    private Employee getEmp1() {
        return new Employee("Jack", Date.valueOf("2020-10-10")) {
            public double pay() {return 0;}
            public double payTaxes() {return 0;}
        };
    }

    @Test
    public void hashCode_shouldBeEqual_whenEqualObjects() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Jill");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2000-10-10"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() { // should do what when what
        assertEquals(emp1,emp2);        // for objects, equals() gets called
        assertTrue(emp1.equals(emp2));  // alternative assertion
    }

    // NAMED MEMBER-LEVEL INNER CLASSES
    private class DummyEmployee extends Employee {

        // ctor
        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }
        // contracts
        public double pay() {
            return 0;
        }
        public double payTaxes() {
            return 0;
        }
    }

}