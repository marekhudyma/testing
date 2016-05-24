package mh.junit.assumption;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Before executing a test, we can check our assumption using the assumeXXX methods.
 * If our assumption fails, then the assumeXXX methods throw AssumptionViolatedException,
 * and the JUnit runner _ignored_ the tests with failing assumptions.
 *
 * You can check if timezone is "proper" or
 */
public class AssumptionTest {

    @Test
    public void assumeTrue() throws Exception {
        Assume.assumeTrue(false);
        //Assume.assumeTrue(true);

    }

    //if the assumption fails, test is not run at all
    @Test
    public void testNothing() throws Exception {
        System.out.println("test");
    }

    @Test
    public void testSomethingCritical() throws Exception {
        boolean isSonarRunning = true;
        Assume.assumeFalse(isSonarRunning);
        assertTrue(true);
    }
}
