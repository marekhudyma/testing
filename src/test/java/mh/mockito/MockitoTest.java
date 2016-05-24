package mh.mockito;

import com.google.common.util.concurrent.Uninterruptibles;
import mh.mockito.util.SampleInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.after;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private SampleInterface sampleObject1;

    @Mock
    private SampleInterface sampleObject2;

    //reset mocks
    @Before
    public void setUp() throws Exception {
        Mockito.reset(sampleObject1, sampleObject2);
    }

    @Test
    public void testWhenThenReturn() throws Exception {
        when(sampleObject1.methodWithArguments(anyInt(), anyString())).thenReturn(5);
        when(sampleObject2.methodWithArguments(anyInt(), anyString())).thenReturn(6);

        assertEquals(5, sampleObject1.methodWithArguments(1, "a"));
        assertEquals(5, sampleObject1.methodWithArguments(2, "b"));

        verify(sampleObject1, times(2)).methodWithArguments(anyInt(), anyString());
        verify(sampleObject1, times(0)).methodWithoutArguments();

        verify(sampleObject1, atLeastOnce()).methodWithArguments(anyInt(), anyString());
        verify(sampleObject1, atLeast(2)).methodWithArguments(anyInt(), anyString());
        verify(sampleObject1, atMost(2)).methodWithArguments(anyInt(), anyString());
        verify(sampleObject1, never()).methodWithoutArguments();

        verifyNoMoreInteractions(sampleObject1);

        sampleObject2.methodWithArguments(1, "a");
        verify(sampleObject2, only()).methodWithArguments(anyInt(), eq("a")); //eq
    }

    @Test
    public void testWhenThenReturnMany() throws Exception {
        when(sampleObject1.methodWithoutArguments()).thenReturn(1, 2);

        assertEquals(1, sampleObject1.methodWithoutArguments());
        assertEquals(2, sampleObject1.methodWithoutArguments());
        assertEquals(2, sampleObject1.methodWithoutArguments());
    }

    //and similar doNothing(), doAnswer()
    @Test(expected = RuntimeException.class)
    public void testVoid() throws Exception {
        doThrow(new RuntimeException()).when(sampleObject1).method();
        sampleObject1.method();
    }

    @Test(expected = RuntimeException.class)
    public void testThrow() throws Exception {
        when(sampleObject1.methodWithoutArguments()).thenThrow(new RuntimeException());
        sampleObject1.methodWithoutArguments();
    }

    @Test
    public void testAnswer() throws Exception {
        when(sampleObject1.methodWithArguments(anyInt(), anyString())).thenAnswer(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) {
                int value = (Integer) invocation.getArguments()[0];
                String str = (String) invocation.getArguments()[1];
                return value + str.length();
            }
        });
        assertEquals(16, sampleObject1.methodWithArguments(13, "abc"));
    }

    @Test
    public void testVerify() throws Exception {
        List<String> mockList = mock(List.class);

        when(mockList.addAll(argThat(new IsListOfTwoElements()))).thenReturn(true);

        mockList.addAll(Arrays.asList("one", "two"));

        verify(mockList).addAll(argThat(new IsListOfTwoElements()));
    }

    // ------- timeout, after

    // Allows verifying with timeout. It causes a verify to wait for a specified period of time for a
    // _desired_interaction !!! rather than fails immediately if had not already happened.
    // May be useful for testing in concurrent conditions.

    //This differs from after() in that after() will wait the full period, unless the final test
    // result is known early (e.g. if a never() fails),
    //whereas timeout() will stop early as soon as verification passes, producing different behaviour
    // when used with times(2), for example, which can pass and then later fail.
    // In that case, timeout would pass as soon as times(2) passes,
    // whereas after would run until times(2) failed, and then fail.

    @Test
    public void testBigTimeout() throws Exception {
        new Thread(getRunnable()).start();
        verify(sampleObject1, timeout(2000)).methodWithoutArguments();
    }

    @Test
    public void testBigAfter() throws Exception {
        new Thread(getRunnable()).start();
        verify(sampleObject1, after(2000)).methodWithoutArguments();
    }

    @Test
    public void testSmallAfter() throws Exception {
        new Thread(getRunnable()).start();
        verify(sampleObject1, after(200).never()).methodWithoutArguments();
    }

    private Runnable getRunnable() {
        return new Runnable() {
            public void run() {
                Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
                sampleObject1.methodWithoutArguments();
            }
        };
    }

    private static class IsListOfTwoElements extends ArgumentMatcher<List> {
        public boolean matches(Object list) {
            return ((List) list).size() == 2;
        }
    }

}

