package mh.junit.timeout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest {

    @Rule
    public Timeout globalTimeout = new Timeout(100);
    //instead @Test(timeout=100)

    @Test(timeout = 100)
    public void testTooLong() throws Exception {
        //Uninterruptibles.sleepUninterruptibly(1, TimeUnit.HOURS);
    }

}
