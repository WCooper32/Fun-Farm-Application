package main;

/**
 *  TODO: 
 *  1. Change the author to your full name
 *  2. Follow the tutorial located here: https://www.tutorialspoint.com/junit/junit_environment_setup.htm
 *       to setup your junit environment and begin creating test cases.
 *  3. Create a new directory for your tests located at M1/src/tests/person5
 *  4. Now create a TestPerson5 Class and write methods to test add, subtract, multiply and divide
 *  5. Create a TestRunner Class and verify your tests run successfully.
 *  Reminder: Each individual is to complete this TODO
 *
 *  @author Bob
 *  @version 1.1
 */
public class Person5 {

    private String name;

    public Person5(String name) {
        this.name = name;
    }

    public long add(long first, long second) {
        return first + second;
    }

    public long subtract(long first, long second) {
        return first - second;
    }

    public long multiply(long first, long second) {
        return first * second;
    }

    public long divide(long first, long second) {
        if (second == 0L)
            throw new IllegalArgumentException("Cannot divide by zero!");
        return first / second;
    }
}
