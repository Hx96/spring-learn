package org.hx.java.leetcode.linkedlist;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ListNodeTest {

    @Mock
    private ListNode mockNext;

    private ListNode listNodeUnderTest;

    @Before
    public void setUp() {
        listNodeUnderTest = new ListNode(0, mockNext);
    }
}
