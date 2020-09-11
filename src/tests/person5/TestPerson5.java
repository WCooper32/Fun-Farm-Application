package tests.person5;

import main.Person5;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPerson5 {

    private static final int TIMEOUT = 200;
    private Person5 person;

    @Before
    public void setup() {
        person = new Person5("Harrison");
    }

    @Test (timeout = TIMEOUT)
    public void testAdd(){
        long x = 7;
        long y = 3;
        long result = x + y;
        assertEquals(result, person.add(x, y));
    }
    @Test (timeout = TIMEOUT)
    public void testSubtract(){
        long x = 7;
        long y = 3;
        long result = x - y;
        assertEquals(result, person.subtract(x, y));
    }
    @Test (timeout = TIMEOUT)
    public void testMultiply(){
        long x = 7;
        long y = 3;
        long result = x * y;
        assertEquals(result, person.multiply(x, y));
    }
    @Test (timeout = TIMEOUT)
    public void testDivide(){
        long x = 7;
        long y = 3;
        long result = x / y;
        assertEquals(result, person.divide(x, y));
    }


}