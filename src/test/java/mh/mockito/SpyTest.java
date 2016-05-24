package mh.mockito;

import mh.mockito.util.SampleClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    // spy allows to use real object instead of mocks by replacing some of the method with the stubbed ones.

    // spy is "oposite" to mock

    private SampleClass sampleObject1 = spy(new SampleClass());

    @Test
    public void spyTest() throws Exception {
        assertEquals(4, sampleObject1.methodWithArguments(1, "abc"));

        when(sampleObject1.methodWithArguments(anyInt(), anyString())).thenReturn(17);
        sampleObject1.methodWithArguments(1, "abc");

        assertEquals(17, sampleObject1.methodWithArguments(1, "abc"));
    }




}
