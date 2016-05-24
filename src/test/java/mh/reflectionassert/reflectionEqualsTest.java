package mh.reflectionassert;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.util.List;
import java.util.Set;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class reflectionEqualsTest {

    private class Person {
        private Integer id;
        private String name;

        public Person(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    public void testReflectionEquals() throws Exception {
        Person expected = new Person(32, "Marek");
        Person actual = new Person(32, "Marek");

        assertReflectionEquals(expected, actual);
    }

    @Test
    public void testReflectionWithNullsEquals() throws Exception {
        Person expected = new Person(null, "Marek");
        Person actual = new Person(32, "Marek");

        assertReflectionEquals(expected, actual, ReflectionComparatorMode.IGNORE_DEFAULTS);
    }

    @Test
    public void testReflectionEqualsWithList() throws Exception {
        List<Person> expected = ImmutableList.of(
                new Person(32, "Marek"),
                new Person(2, "Adam")
        );

        List<Person> actual = ImmutableList.of(
                new Person(2, "Adam"),
                new Person(32, "Marek")
        );

        assertReflectionEquals(expected, actual, ReflectionComparatorMode.LENIENT_ORDER);
    }

    @Test
    public void testReflectionEqualsWithSetAndNull() throws Exception {
        Set<Person> expected = ImmutableSet.of(
                new Person(null, "Marek"),
                new Person(null, "Adam")
        );

        Set<Person> actual = ImmutableSet.of(
                new Person(2, "Adam"),
                new Person(32, "Marek")
        );

        assertReflectionEquals(expected,
                               actual,
                               ReflectionComparatorMode.IGNORE_DEFAULTS,
                               ReflectionComparatorMode.LENIENT_ORDER);
    }

}
