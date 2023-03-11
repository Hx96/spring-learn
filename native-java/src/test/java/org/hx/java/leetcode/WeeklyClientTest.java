package org.hx.java.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WeeklyClientTest {

    private WeeklyClient weeklyClientUnderTest;

    @Before
    public void setUp() {
        weeklyClientUnderTest = new WeeklyClient();
    }


    @Test
    public void testPlusOne1() {
        assertArrayEquals(weeklyClientUnderTest.plusOne(new int[]{9}), new int[]{1,0});
    }

    @Test
    public void testPlusOne2() {
        assertArrayEquals(weeklyClientUnderTest.plusOne(new int[]{8,9,9,9}), new int[]{9,0,0,0});
    }
}
