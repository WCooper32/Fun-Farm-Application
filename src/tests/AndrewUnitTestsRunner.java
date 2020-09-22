package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.AndrewUnitTests;

public class AndrewUnitTestsRunner {
    public static void main (String [] args) {
        Result result = JUnitCore.runClasses(AndrewUnitTests.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
