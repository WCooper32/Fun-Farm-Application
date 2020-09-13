import main.Person1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPerson1 {

    private static final int TIMEOUT = 200;
    private Person1 person;

    @Before
    public void setup() {
        person = new Person1("Alex");
    }

    @Test (timeout = TIMEOUT)
    public void testAdd() {
        assertEquals(person.add(6, 2), 8);
    }

    @Test (timeout = TIMEOUT)
    public void testSubtract() {
        assertEquals(person.subtract(6, 2), 4);
    }

    @Test (timeout = TIMEOUT)
    public void testMultiply() {
        assertEquals(person.multiply(6, 2), 12);
    }

    @Test (timeout = TIMEOUT)
    public void testDivide() {
        assertEquals(person.divide(6, 2), 3);
    }

}