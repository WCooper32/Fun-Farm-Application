package main.state;

public class StateSettings {

    public boolean initialized = false;

    public String name;
    public int difficulty;
    public int seed;
    public int season;

    public int setStartingMoney() {
        if (difficulty == 3) {
            return 50;
        } else if (difficulty == 2) {
            return 75;
        } else {
            return 100;
        }
    }

}
