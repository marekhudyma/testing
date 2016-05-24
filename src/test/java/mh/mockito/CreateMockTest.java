package mh.mockito;

import mh.mockito.util.SampleClass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateMockTest {

    @Test
    public void testMock() throws Exception {
        SampleClass sampleClass = mock(SampleClass.class);

        when(sampleClass.methodWithoutArguments()).thenReturn(15);

        assertEquals(15, sampleClass.methodWithoutArguments());
    }

    //equal solution

    @Mock
    private SampleClass sampleClass;

    //need to init
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(sampleClass.methodWithoutArguments()).thenReturn(15);
    }

    @Test
    public void testMockAnnotation() throws Exception {
        assertEquals(15, sampleClass.methodWithoutArguments());
    }
}
