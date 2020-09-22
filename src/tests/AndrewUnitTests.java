package tests;

import main.state.StateInventory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AndrewUnitTests {

    private static final int TIMEOUT = 200;
    private StateInventory inventory;

    @Before
    public void setup() {
        inventory = new StateInventory();
        inventory.money = 0;
        inventory.corn = 10;
    }

    @Test (timeout = TIMEOUT)
    public void testMoney() {
        inventory.incrementMoney(5);
        int expect = 5;
        int actual = inventory.money;
        assertEquals(expect, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testCorn() {
        inventory.incrementCorn(5);
        int expect = 15;
        int actual = inventory.corn;
        assertEquals(expect, actual);
    }
}