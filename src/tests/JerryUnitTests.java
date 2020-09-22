package tests;

import main.state.StateInventory;
import main.state.StateEnvironment;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JerryUnitTests {
    private static final int TIMEOUT = 200;
    StateInventory Jerry;
    StateEnvironment currentEnvironment;

    @Test (timeout = TIMEOUT)
    public void setup() {
        Jerry = new StateInventory();
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
        Jerry.incrementWheat(5);
        int expected = 5;
        int actual = Jerry.wheat;
        assertEquals(expected, actual);
    }
}