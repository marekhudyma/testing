package mh.mockito;

import mh.mockito.util.SampleInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherTest {

    private class CustomArgumentMatcher extends ArgumentMatcher<String> {
        @Override
        public boolean matches(final Object argument) {
            return "custom".equals(argument);
        }
    }

    @Mock
    private SampleInterface sampleObject1;

    @Test
    public void testWhenThenReturn() throws Exception {
        when(sampleObject1.methodWithArguments(anyInt(), argThat(new CustomArgumentMatcher()))).thenReturn(5);

        assertEquals(5, sampleObject1.methodWithArguments(1, "custom"));
    }

}
