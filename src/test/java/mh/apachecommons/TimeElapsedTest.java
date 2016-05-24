package mh.apachecommons;

import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeElapsedTest {

    @Test
    public void testTimeElapsed() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

        stopWatch.suspend();
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        stopWatch.resume();

        stopWatch.stop();

        System.out.println(stopWatch);
    }

}
