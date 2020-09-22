package main.state;

import javax.swing.plaf.nimbus.State;

public class StateEnvironment {

    // Add environment state like plots and such here
    private int day;

    // default constructor
    public StateEnvironment() {
        day = 1;
    }
    /**
     * increments day
     */
    public void incrementDay() {
        day++;
    }

    public int getDay() {
        return day;
    }
}
