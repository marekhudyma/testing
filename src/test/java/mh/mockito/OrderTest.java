package mh.mockito;

import mh.mockito.util.SampleInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    @Mock
    private SampleInterface sampleObject1;

    @Test
    public void testOrder() throws Exception {
        sampleObject1.methodWithoutArguments();
        sampleObject1.method();

        InOrder inOrder = Mockito.inOrder(sampleObject1);
        inOrder.verify(sampleObject1).methodWithoutArguments();
        inOrder.verify(sampleObject1).method();
    }

}
