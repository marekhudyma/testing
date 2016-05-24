package mh.awaitility;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.jayway.awaitility.Awaitility.with;
import static java.util.concurrent.TimeUnit.SECONDS;

public class AwaitilityTest {

    private final AtomicBoolean condition = new AtomicBoolean(false);

    @Test
    public void testAwaitility() throws Exception {
        // some asynchronous event
        new Thread(getRunnable(9)).start();

        // Awaitility lets you wait until the asynchronous operation completes:
        with().pollInterval(1, SECONDS)
              .and().pollDelay(5, SECONDS)
              .await().atMost(10, SECONDS).until(
                new Callable<Boolean>() {
                    public Boolean call() throws Exception {
                        boolean value = condition.get();
                        System.out.println("check = " + value);
                        return value; // The condition that must be fulfilled
                    }
                }
        );

    }

    private Runnable getRunnable(final int secondsToSleep) {
        return new Runnable() {
            public void run() {
                Uninterruptibles.sleepUninterruptibly(secondsToSleep, TimeUnit.SECONDS);
                condition.set(true);
            }
        };
    }

}
