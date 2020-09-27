package main.state;

public class StateSettings {

    private boolean initialized = false;

    private String name;
    private int difficulty;
    private int seed;
    private int season;

    public boolean isInitialized() {
        return initialized;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getSeed() {
        return seed;
    }

    public int getSeason() {
        return season;
    }

    public void setInitialized(boolean b) {
        initialized = b;
    }

    public void setName(String input) {
        name = input;
    }

    public void setDifficulty(int dif) {
        difficulty = dif;
    }

    public void setSeed(int s) {
        seed = s;
    }

    public void setSeason(int s) {
        season = s;
    }

}
