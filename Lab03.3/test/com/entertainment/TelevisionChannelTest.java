package com.entertainment;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelTest {
    private Television tv = new Television();
    private Television tv1 = new Television();

    @Before
    public void setUp() {
        tv = new Television("Samsung", 50, DisplayType.OLED);
        tv1 = new Television("Samsung", 50, DisplayType.OLED);
    }

    @Test
    public void comparator_shouldEqualZERO_sameChannel() {
        TelevisionChannelComparator comp = new TelevisionChannelComparator();
        assertTrue(comp.compare(tv,tv1) == 0);
    }

    @Test
    public void comparator_shouldReturnNegative_lowerChannel() throws InvalidChannelException {
        tv.changeChannel(1);
        TelevisionChannelComparator comp = new TelevisionChannelComparator();
        assertTrue(comp.compare(tv,tv1) < 0);
    }

    @Test
    public void comparator_shoulReturnPositive_higherChannel() throws InvalidChannelException {
        tv.changeChannel(20);
        TelevisionChannelComparator comp = new TelevisionChannelComparator();
        assertTrue(comp.compare(tv,tv1) > 0);
    }
}