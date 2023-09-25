package org.hx.java.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SolutionWeekTest {

    @Test
    public void maximumOddBinaryNumber() {
        SolutionWeek solutionWeek = new SolutionWeek();
        System.out.println(solutionWeek.maximumOddBinaryNumber("0111"));
        Assert.assertEquals("1101", solutionWeek.maximumOddBinaryNumber("0111"));
    }

    @Test
    public void maximumOddBinaryNumber1() {
        SolutionWeek solutionWeek = new SolutionWeek();
        System.out.println(solutionWeek.maximumOddBinaryNumber("010"));
        Assert.assertEquals("001", solutionWeek.maximumOddBinaryNumber("010"));

    }
}