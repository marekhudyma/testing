package mh.junit.theories;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class Theories2Test {

    @DataPoints
    public static String[] positiveIntegers() {
        return new String[] {"a", "b", "c"};
    }

    @Theory
    public void theory(String str1, String str2) throws Exception {
        System.out.println(str1 + " " + str2);
    }


}
