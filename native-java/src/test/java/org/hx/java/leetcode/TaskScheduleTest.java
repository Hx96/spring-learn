package org.hx.java.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskScheduleTest {
    /**
     * Method under test: {@link TaskSchedule#leastInterval(char[], int)}
     */
    @Test
    public void testLeastInterval() {
        TaskSchedule taskSchedule = new TaskSchedule();
        assertEquals(8, taskSchedule.leastInterval("AAABBB".toCharArray(), 2));
    }

    @Test
    public void testLeastInterval1() {
        TaskSchedule taskSchedule = new TaskSchedule();
        assertEquals(6, taskSchedule.leastInterval("AAABBB".toCharArray(), 0));
    }

    @Test
    public void testLeastInterval3() {
        TaskSchedule taskSchedule = new TaskSchedule();
        String[] chars = new String[]{
                "A","A","A","A","A","A","B","C","D","E","F","G"
        };
        String join = StringUtils.join(chars);
        assertEquals(16, taskSchedule.leastInterval(join.toCharArray(), 2));
    }

    /**
     * Method under test: {@link TaskSchedule#leastInterval(char[], int)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testLeastInterval2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: -39
        //       at org.hx.java.leetcode.TaskSchedule.leastInterval(TaskSchedule.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        (new TaskSchedule()).leastInterval(new char[]{'\u001a', 'A', 'A', 'A'}, 1);
    }
}

