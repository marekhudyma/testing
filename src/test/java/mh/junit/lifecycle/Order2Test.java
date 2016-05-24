package mh.junit.lifecycle;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM) //for me it is A C B
public class Order2Test {

    @Test
    public void testC() throws Exception {
        System.out.println("C");
    }

    @Test
    public void testA() throws Exception {
        System.out.println("A");
    }

    @Test
    public void testB() throws Exception {
        System.out.println("B");
    }

}
