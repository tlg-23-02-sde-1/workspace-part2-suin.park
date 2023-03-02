package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv = new Television();
    private Television tv1 = new Television();
    private Television tv2 = new Television();

    @Before
    public void setUp() {
       tv1 = new Television("Samsung", 50, DisplayType.OLED);
       tv2 = new Television("Samsung", 50, DisplayType.OLED);
    }

    // compareTo Test
    @Test
    public void compareTo_shouldFail_whenDifferentBrand() {
        tv2.setBrand("Sony");
        assertTrue(tv1.compareTo(tv2) < 0); // when tv1's brand comes before tv2's rand
    }

    @Test
    public void compareTo_shouldEqual_whenEqualBrand() {
        assertTrue(tv1.compareTo(tv2) == 0);
    }

    // equals() and hashCode() Test;
    @Test
    public void hashCode_shouldEqual_whenEqualObject() {
        assertEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_sameDisplay() {
        tv2.setBrand("Sony");
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_sameDisplay() {
        tv2.setVolume(60);
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.PLASMA);
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnTrue_allProperties() {
        assertEquals(tv1, tv2);
    }

    // changeChannel Test
    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalidChannel_UpperBound() {
        try {
            tv.changeChannel(1000);
            fail("should throw InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValidChannel_upperBound() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)  // catch and rethrow
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound()
            throws InvalidChannelException {
        try {
            tv.changeChannel(0);  // should trigger the exception

            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            // you can assert that the exception's reason message is what you expect
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
            throw e;
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);  // throws checked exception, punt or try-catch // 1 should shouldn't throw exception
        assertEquals(1,tv.getCurrentChannel());
    }

    // setVolume Test
    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalidVolume_upperBound() {
        try{
            tv.setVolume(101);
            fail("should have thrown InvalidVolumeException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage());
        }
    }

    @Test
    public void setVolume_shouldStoreValue_whenValidVolume_upperBound() {
        tv.setVolume(100);
        assertEquals(100,tv.getVolume());
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv.setVolume(-1);  // trigger the exception, and DON'T catch it
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {  // unchecked so no throws
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }
}