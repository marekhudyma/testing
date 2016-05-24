package mh.junit.parameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameters(name="{index}: factorial({0})={1}") //for example [5: factorial(5)=123]
    public static Collection<Object[]> factorialData() {
        return Arrays.asList(new Object[][]{
            {0,1}, {1,1}, {2,2}, {3,6}, {4,24}, {5,120}, {6,720}
        });
    }

//    private int number;
//    private int expectedResult;
//    public ParameterizedTest(int input, int expected) {
//        this.number = input;
//        this.expectedResult = expected;
//    }

    @Parameter(value = 0)
    public int number;

    @Parameter(value = 1)
    public int expectedResult;

    @Test
    public void testParameters() throws Exception {
        assertEquals(expectedResult, new Factorial().factorial(number));
    }

    private static class Factorial {
        public long factorial(long number) {
            if(number == 0){
                return 1;
            }
            return number * factorial(number-1);
        }
    }
}
