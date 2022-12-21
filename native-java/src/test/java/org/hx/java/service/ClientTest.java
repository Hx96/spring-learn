package org.hx.java.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ClientTest {

    @Test
    public void testMain() {
        String str = null;
        String tt = Optional.ofNullable(str).orElse("tt");
        Assert.assertEquals(tt, "tt");
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Object o = Optional.of(null).orElse("");
    }

    @Test
    public void testEmpty() {
        Optional<Object> empty = Optional.empty();
        Assert.assertFalse(empty.isPresent());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNullTh() {
        System.out.println(Optional.empty().get());
    }

    @Test(expected = RuntimeException.class)
    public void testThrow() {
        Optional.ofNullable(null).orElseThrow(() -> new RuntimeException("test"));
    }

    @Test
    public void testMap() {
        String xxxxxxxxx = Optional.ofNullable("xxxxxxxxx").map((s) -> s.substring(0, 5))
                .map((s) -> s.substring(0, 3)).orElse(":");
        Assert.assertEquals(xxxxxxxxx, "xxx");
        Assert.assertEquals(xxxxxxxxx.length(), 3);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme