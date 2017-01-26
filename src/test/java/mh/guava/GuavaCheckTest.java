package mh.guava;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class GuavaCheckTest {

    @Test
    public void testCheckNotNull() throws Exception {
        checkNotNull("aa", "someVariable is null");
        checkArgument(true, "someVariable doesn't fit");
    }

}
