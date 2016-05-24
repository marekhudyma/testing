package mh.guava;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class GuavaCheckTest {

    @Test
    public void aaa() throws Exception {
        checkNotNull("aa", "someVariable is null");
        checkArgument(true, "someVariable doesn't fit");
    }

}
