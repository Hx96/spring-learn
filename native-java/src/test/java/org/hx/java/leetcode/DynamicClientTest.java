package org.hx.java.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicClientTest {
    DynamicClient dynamicClient = new DynamicClient();

    @Test
    public void testSubarraySum() throws Exception {
        // [1,2,1,2,1] k=3
        int result = dynamicClient.subarraySum(new int[]{1, 2, 1, 2, 1}, 3);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testSubarraySum1() throws Exception {
        // [1,2,1,2,1] k=3
        int result = dynamicClient.subarraySum(new int[]{1, -1, 0}, 0);
        Assert.assertEquals(3, result);
    }

    /**
     * Method under test: {@link DynamicClient#subarraySum(int[], int)}
     */
    @Test
    public void testSubarraySum2() {
        assertEquals(0, (new DynamicClient()).subarraySum(new int[]{1000, 1000, 1000, 1000}, 1));
    }

    /**
     * Method under test: {@link DynamicClient#subarraySum(int[], int)}
     */
    @Test
    public void testSubarraySum3() {
        assertEquals(4, (new DynamicClient()).subarraySum(new int[]{1, 1, 1, 1}, 1));
    }

    @Test
    public void testSubarraySumM1() throws Exception {
        // [1,2,1,2,1] k=3
        int result = dynamicClient.subarraySumM1(new int[]{1, -1, 0}, 0);
        Assert.assertEquals(3, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme