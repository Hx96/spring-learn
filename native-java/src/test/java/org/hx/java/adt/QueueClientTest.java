package org.hx.java.adt;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class QueueClientTest {

    @Test
    public void testMain() throws Exception {
        QueueClient.main(new String[]{"args"});
    }

    @Test
    public void testPriorityQueue() {
        PriorityQueue<String> stringQueue = new PriorityQueue<>();

        stringQueue.add("blueberry");
        stringQueue.add("apple");
        stringQueue.add("cherry");
        System.out.println(stringQueue);

        String first = stringQueue.poll();
        String second = stringQueue.poll();
        String third = stringQueue.poll();

        assertEquals("apple", first);
        assertEquals("blueberry", second);
        assertEquals("cherry", third);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme