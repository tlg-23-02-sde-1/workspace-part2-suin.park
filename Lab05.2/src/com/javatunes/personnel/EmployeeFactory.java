/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

    // prevent direct instantiation - this is an all-static factory class
    private EmployeeFactory() {
    }

    /**
     * Given the input map, create and
     * (with its properties set).
     * If the input map's "type" value is not "HE" or "SE",
     * throw IllegalArgumentException with a suitable message.
     */
    /*
     * if ("SE".equals(type))
     *  create a salariedemployee object
     * else if ("HE".equals(type))
     *  creat a hourlyemployee object
     * else
     *  throw new exception
     */
    public static Employee createEmployee(Map<String,String> inputMap)
            throws IllegalArgumentException {
        // return value
        Employee emp = null;
        // first, figure out what we're doing - here, the 'type' is the "indicator"
        String type = inputMap.get("type");

        if (!"SE".equals(type) && !"HE".equals(type)) {
          throw new IllegalArgumentException("Invalid type: " + type);
        }
        // at this point, we KNOW that we have "se or "HE"
        String name = inputMap.get("name");
        Date hireDate = Date.valueOf(inputMap.get("hireDate"));

        if ("SE".equals(type)) {
            Double salary = Double.valueOf(inputMap.get("salary"));
            emp = new SalariedEmployee(name, hireDate, salary);

        }
        else {
            Double rate = Double.valueOf(inputMap.get("rate"));
            Double hours = Double.valueOf(inputMap.get("hours"));
            emp = new HourlyEmployee(name, hireDate, rate, hours);

//            emp = new HourlyEmployee(inputMap.get("name"), Date.valueOf(inputMap.get("hireDate")),
//                    Double.valueOf(inputMap.get("rate")), Double.valueOf("hours"));
        }

        return emp;
    }
}