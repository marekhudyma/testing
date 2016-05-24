package mh.junit.theories;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * JUnit theories are an alternative to JUnit's parameterized tests
 *
 * test data cannot be externalized
 */
@RunWith(Theories.class)
public class TheoriesTest {

    @DataPoint
    public static String str1 = "str1";
    @DataPoint
    public static String str2 = "str2";

    @Theory
    public void theory(String strA, String strB) throws Exception {
        System.out.println(strA + " " + strB);
    }

}
