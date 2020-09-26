package main.state;

public class StateInventory {

    private int money;
    private int wheat;
    private int corn;

    public StateInventory() {
        money = 0;
        wheat = 0;
        corn = 0;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int set) {
        this.money = set;
    }

    public int getWheat() {
        return this.wheat;
    }

    public void setWheat(int set) {
        this.wheat = set;
    }

    public int getCorn() {
        return this.corn;
    }

    public void setCorn(int set) {
        this.corn = set;
    }

}