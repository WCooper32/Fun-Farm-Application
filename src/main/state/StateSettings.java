package main.state;

public class StateSettings {

    public boolean initialized = false;

    public String name;
    public int difficulty;
    public int seed;
    public int season;

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
