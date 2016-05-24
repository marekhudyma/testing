package mh.junit.assertion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.theInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class AssertThatTest {

    @Test
    public void testEqualTo() throws Exception {
        assertThat(1, equalTo(1));
        assertThat(1, is(1));
        assertThat(1, not(equalTo(2)));
        assertThat(1, is(not(2)));
        assertThat(1, not(is(2)));
        assertThat(1, not(2));
    }

    @Test
    public void testConditions() throws Exception {
        assertThat(1, either(is(1)).or(is(2)));
        assertThat(1, both(not(2)).and(not(3)));
        assertThat(1, anyOf(is(1), is(2), is(3)));
        assertThat(1, not(anyOf(is(10), is(20), is(30))));
        assertThat(1, not(allOf(is(10), is(20), is(30))));
    }

    @Test
    public void testOthers() throws Exception {
        List<Integer> sameItems = new ArrayList<Integer>() {{
            add(1);
            add(1);
        }};
        List<Integer> differentItems = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        assertThat(sameItems, everyItem(is(1)));
        assertThat(differentItems, hasItem(1));
        assertThat(differentItems, hasItems(1, 2));
    }

    @Test
    public void testString() throws Exception {
        assertThat("abc", startsWith("a"));
        assertThat("abc", containsString("b"));
        assertThat("abc", endsWith("c"));
    }

    @Test
    public void testInstance() throws Exception {
        Object object = new Object();
        assertThat(object, sameInstance(object));
        assertThat(object, theInstance(object));
        assertThat("abc", instanceOf(String.class));
    }

}
