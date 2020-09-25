package main.state;

public class StateInventory {

    public int money;
    public int wheat;
    public int corn;

    public StateInventory() {
        money = 0;
        wheat = 0;
        corn = 0;
    }

    public void incrementMoney(int increment) {
        this.money += increment;
    }

    public void incrementWheat(int increment) {
        this.wheat += increment;
    }

    public void incrementCorn(int increment) {
        this.corn += increment;
    }

}