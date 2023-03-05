package org.hx.java.leetcode;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TheKBigNumberTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Method under test: {@link TheKBigNumber#findKthLargest(int[], int)}
     */
    @Test
    public void testFindKthLargest() {
        assertEquals(5, (new TheKBigNumber()).findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

//    /**
//     * Method under test: {@link TheKBigNumber#findKthLargest(int[], int)}
//     */
//    @Test
//    public void testFindKthLargest2() {
//        thrown.expect(NegativeArraySizeException.class);
//        (new TheKBigNumber()).findKthLargest(new int[]{1000, 1000, 1000, 1000}, -1);
//    }
}

