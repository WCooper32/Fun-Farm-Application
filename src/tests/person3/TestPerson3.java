package tests.person3;

import main.Person3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPerson3{

    Person3 p3;

    @Before
    public void setup() {
        p3 = new Person3("Will");
    }

    @Test
    public void testAdd() {
        long expected = 10;
        long actual = p3.add(7,3);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        long expected = 4;
        long actual = p3.subtract(7,3);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        long expected = 21;
        long actual = p3.multiply(7,3);
        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        long expected = 2;
        long actual = p3.divide(6,3);
        assertEquals(expected, actual);
    }

    /*
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testDivideByZero() {
        long d1 = 73;
        long d2 = 0;
        long quotient = p3.divide(d1, d2);
    }
    */

}