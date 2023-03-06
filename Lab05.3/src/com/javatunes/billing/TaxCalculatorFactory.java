package com.javatunes.billing;

import java.util.HashMap;
import java.util.Map;

public class TaxCalculatorFactory {

    // prevent instantiation - this is an "all-static" class
    private TaxCalculatorFactory() {
    }

    /*
     * OPTIONAL CHALLENGE:
     * Implement a cache of TaxCalculator objects, such that
     * we return a previously-created one if one is in there,
     * and if not, we create a new one, put it in the map, and then return it.
     *
     * Hint: you can use a Map<Location,TaxCalculation> for the cache
     *
     * Location    |       TaxCalculator
     * EUROPE               EuropeTax object
     */
    private static Map<Location, TaxCalculator> taxCalculatorCache = new HashMap<>();

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = taxCalculatorCache.get(location);
        if (calc == null) {
            switch (location) {
                case ONLINE:
                    calc = new OnlineTax();
                    break;
                case USA:
                    calc = new USATax();
                    break;
                case EUROPE:
                    calc = new EuropeTax();
            }
            taxCalculatorCache.put(location, calc);
        }
        return calc;
    }
}