package main.state;

public class StateGame {

    private StateSettings settings;
    private StateInventory inventory;
    private StateEnvironment environment;

    public StateGame() {
        settings = new StateSettings();
        inventory = new StateInventory();
        environment = new StateEnvironment();
    }

    public StateSettings getSettings() {
        return settings;
    }

    public StateInventory getInventory() {
        return inventory;
    }

    public StateEnvironment getEnvironment() {
        return environment;
    }

}
