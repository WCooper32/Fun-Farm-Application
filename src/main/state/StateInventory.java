package main.state;

public class StateInventory {

    public int money;

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