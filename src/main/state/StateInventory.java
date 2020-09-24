package main.state;

public class StateInventory {

    public int money;
    public int wheat;
    public int corn;

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