package mh.junit.suite;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryTest {

    @Category(Slow.class)
    @Test
    public void testSlow() throws Exception {
        System.out.println("slow test");
    }

    @Category(Fast.class)
    @Test
    public void testFast() throws Exception {
        System.out.println("fast test");
    }

    @Test
    public void testOther() throws Exception {
        System.out.println("other test");
    }
}
