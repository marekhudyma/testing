package mh.junit.assertion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;



public class AssertTest {

    @Test
    public void testAssertTrue() throws Exception {
        assertTrue(true);
        assertTrue("Should be true", true);
    }

    @Test
    public void testAssertFalse() throws Exception {
        assertFalse(false);
        assertFalse("Should be false", false);
    }

    @Test
    public void testAssertNull() throws Exception {
        assertNull(null);
        assertNull("Should be null", null);
    }

    @Test
    public void testAssertNotNull() throws Exception {
        assertNotNull(new Object());
        assertNotNull("Should not be null", new Object());
    }

    @Test
    public void testAssertEquals() throws Exception {
        assertEquals(1l, 1l);
        assertEquals("Should be equals", 1l, 1l);
    }

    @Test
    public void testAssertEqualsForDoubleDelta() throws Exception {
        assertEquals(1.98d, .999d + .98d, 0.01d);
        assertEquals("Should be equals with delta", 1.98d, .999d + .98d, 0.01d);
    }

    @Test
    public void testAssertSame() throws Exception {
        Object a = new Object();
        assertSame(a, a);
        assertSame("Should be same", a, a);
    }

    @Test
    public void testAssertNotSame() throws Exception {
        assertNotSame(new Object(), new Object());
        assertNotSame("Should be same", new Object(), new Object());
    }


}
