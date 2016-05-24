package mh.mockito;

import mh.mockito.util.SampleInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSettingsTest {

    @Mock
    private SampleInterface sampleObject1;

    @Mock
    private SampleInterface sampleObject2;

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


}
