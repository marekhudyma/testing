package mh.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptorTest {

    private class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(final int age) {
            this.age = age;
        }
    }

    private interface PersonService {
        void save(Person person);
    }

    private void createPerson(PersonService personService) {
        Person person = new Person();
        person.setName("Marek");
        person.setAge(32);

        personService.save(person);
    }

    @Mock
    PersonService personService;

    @Test
    public void testArgumentCaptor() throws Exception {
        ArgumentCaptor<Person> arg = ArgumentCaptor.forClass(Person.class);

        createPerson(personService);

        verify(personService).save(arg.capture());

        assertEquals("Marek", arg.getValue().getName());
        assertEquals(32, arg.getValue().getAge());
    }


}
