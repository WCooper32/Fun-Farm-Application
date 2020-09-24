package main.state;

public class StateGame {

    public StateSettings settings;
    public StateInventory inventory;
    public StateEnvironment environment;

    public StateGame() {
        settings = new StateSettings();
        inventory = new StateInventory();
        environment = new StateEnvironment();
    }

}
