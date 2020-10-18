package tests.person4;

import main.Person4;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPerson4 {
    private static final int TIMEOUT = 200;
    private Person4 person;

    @Before
    public void setup() {
        person = new Person4("Jerry");
    }

    @Test
    public void testAdd() {
        long expected = 10;
        long actual = person.add(7, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        long expected = 7-3;
        long actual = person.subtract(7, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        long expected = 7*3;
        long actual = person.multiply(7, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        long expected = 6/3;
        long actual = person.divide(6, 3);
        assertEquals(expected, actual);
    }
}
