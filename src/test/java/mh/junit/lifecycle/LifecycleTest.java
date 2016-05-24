package mh.junit.lifecycle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifecycleTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("before class");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @Test
    public void testNotnig() throws Exception {
        System.out.println("test");
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("after class");
    }
}
