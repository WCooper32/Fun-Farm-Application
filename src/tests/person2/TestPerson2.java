package tests.person2;

import main.Person2;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPerson2 {

    private static final int TIMEOUT = 200;
    private Person2 person;

    @Before
    public void setup() {
        person = new Person2("Andrew");
    }

    @Test (timeout = TIMEOUT)
    public void testAdd() {
        assertEquals(person.add(4, 2), 6);
    }

    @Test (timeout = TIMEOUT)
    public void testSubtract() {
        assertEquals(person.subtract(4, 2), 2);
    }

    @Test (timeout = TIMEOUT)
    public void testMultiply() {
        assertEquals(person.multiply(4, 2), 8);
    }

    @Test (timeout = TIMEOUT)
    public void testDivide() {
        assertEquals(person.divide(4, 2), 2);
    }
}