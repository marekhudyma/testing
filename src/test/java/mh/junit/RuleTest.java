package mh.junit;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RuleTest {

    @Rule
    public Timeout globalTimeout = new Timeout(100);
    //instead @Test(timeout=100)

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public TestName testName = new TestName();

    @Test
    public void testRule() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("test timed out after 100 milliseconds");
        Uninterruptibles.sleepUninterruptibly(101, TimeUnit.MILLISECONDS);
    }

    //collect all the problems and fails at the end
//    @Test
//    public void testErrorCollector() {
//        errorCollector.checkThat("a", equalTo("b"));
//        errorCollector.checkThat(1, equalTo(2));
//    }

    @Test
    public void testTestName() throws Exception {
        assertThat("testTestName", equalTo(testName.getMethodName()));
    }
}
