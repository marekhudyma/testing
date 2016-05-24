package mh.junit.assertion;

import org.hamcrest.BaseMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.Test;

import static mh.junit.assertion.AssertThatCustomTest.LessThanOrEqual.lessThanOrEqual;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertThatCustomTest {

    public static class LessThanOrEqual<T extends Comparable<T>> extends BaseMatcher<Comparable<T>> {

        private final Comparable<T> expectedValue;

        public LessThanOrEqual(T expectedValue) {
            this.expectedValue = expectedValue;
        }

        @Override
        public boolean matches(final Object item) {
            int compareTo = expectedValue.compareTo((T)item);
            return compareTo > -1;
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText(" less that or equal(<=) " + expectedValue);
        }

        @Factory
        public static <T extends Comparable<T>> Matcher<T> lessThanOrEqual(T t) {
            return (Matcher<T>) new LessThanOrEqual<T>(t);
        }
    }

    @Test
    public void testAssertCustom() throws Exception {
        assertThat(1, CoreMatchers.is(lessThanOrEqual(1)));
        assertThat(1.0, CoreMatchers.is(lessThanOrEqual(1.0)));
    }
}
