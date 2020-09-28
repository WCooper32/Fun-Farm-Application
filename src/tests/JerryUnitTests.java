package tests;

import main.state.StateInventory;
import main.state.StateEnvironment;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JerryUnitTests {
    private static final int TIMEOUT = 200;
    private StateInventory jerry;
    private StateEnvironment currentEnvironment;

    @Before
    public void setup() {
        jerry = new StateInventory();
        currentEnvironment = new StateEnvironment();
    }

    @Test (timeout = TIMEOUT)
    public void testDay() {
        currentEnvironment.incrementDay();
        int expected = 2;
        int actual = currentEnvironment.getDay();
        assertEquals(expected, actual);
    }

    @Test
    public void testWheat() {
        jerry.setWheat(5);
        int expected = 5;
        int actual = jerry.getWheat();
        assertEquals(expected, actual);
    }
}