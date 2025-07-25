package com.ygsoft.quotes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestSingleModule1 {

    @Before
    public void init() {}


    @Test
    public void testFake1() {
        assertTrue(true);
    }

    @Test
    public void testFake2() {
        assertTrue(true);
    }

    @Test
    public void testFake3() {
        assertNull(null);
    }

    @Test
    public void thisIsAlsoTest() {
        assertTrue(!true);
    }


    @Test
    public void testFake4() {
        assertEquals("Should be the same", "A", "A");
    }
}
