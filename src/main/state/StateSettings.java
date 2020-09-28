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

    public int getStartingMoney() {
        if (difficulty == 3) {
            return 50;
        } else if (difficulty == 2) {
            return 75;
        } else {
            return 100;
        }
    }

    public enum Difficulty {
        EASY(1), MEDIUM(2), HARD(3);
        private int value;
        private Difficulty(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    };
    public enum Season {
        SPRING(1), SUMMER(2), FALL(3), WINTER(4);
        private int value;
        private Season(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    };
    public enum Seed {
        CARROTS(1), POTATOES(2), CELERY(3);
        private int value;
        private Seed(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    };

}
