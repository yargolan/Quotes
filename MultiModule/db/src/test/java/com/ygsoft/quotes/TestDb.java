package com.ygsoft.quotes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestDb {

    @Before
    public void init() {
        TestDb testDb = new TestDb();
    }


    @Test
    public void testResult() {
        boolean returnedResult = getResult();
        assertTrue(returnedResult);
    }


    private boolean getResult() {
        return true;
    }
}