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
        inventory.setMoney(0);
        inventory.setMoney(10);
    }

    @Test (timeout = TIMEOUT)
    public void testMoney() {
        inventory.setMoney(5);
        int expect = 5;
        int actual = inventory.getMoney();
        assertEquals(expect, actual);
    }

    @Test (timeout = TIMEOUT)
    public void testCorn() {
        inventory.setMoney(15);
        int expect = 15;
        int actual = inventory.getMoney();
        assertEquals(expect, actual);
    }

}