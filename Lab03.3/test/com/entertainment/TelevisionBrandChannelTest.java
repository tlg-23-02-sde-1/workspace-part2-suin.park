package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelTest {
    private Television tv =new Television();
    private Television tv1 = new Television();

    @Before
    public void setUp(){
        tv = new Television("Samsung", 50, DisplayType.OLED);
        tv1 = new Television("Samsung", 50, DisplayType.OLED);
    }

    @Test
    public void comparator_shouldReturnEqual_sameBrand_sameChannel() {
        TelevisionBrandChannelComparator comp = new TelevisionBrandChannelComparator();
        assertEquals(0,comp.compare(tv,tv1));
    }

    @Test
    public void comparator_shouldReturnNegative_differentBrand_sameChannel() {
        tv1.setBrand("Sony");
        TelevisionBrandChannelComparator comp = new TelevisionBrandChannelComparator();
        assertTrue(comp.compare(tv,tv1) < 0);
    }

    @Test
    public void comparator_shouldReturnPositive_sameBrand_DifferentChannel() throws InvalidChannelException{
        tv.changeChannel(20);
        TelevisionBrandChannelComparator comp = new TelevisionBrandChannelComparator();
        assertTrue(comp.compare(tv,tv1) > 0);
    }
}