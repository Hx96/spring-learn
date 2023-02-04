package org.hx.java.thread.safe;

import org.junit.Test;

public class WorkerThreadTest {

    @Test
    public void testMain() throws Exception {
        execute(5);
    }

    public void execute(int retryCOUNT) {
        if(retryCOUNT < 0) return;
        System.out.println("test");
        System.out.println(retryCOUNT);
        execute(-- retryCOUNT);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme