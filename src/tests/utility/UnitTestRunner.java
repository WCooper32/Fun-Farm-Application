package tests.utility;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.AlexUnitTests;
import tests.AndrewUnitTests;
import tests.JerryUnitTests;
import tests.OverlayUITests;

public class UnitTestRunner {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(
                AndrewUnitTests.class,
                JerryUnitTests.class,
                OverlayUITests.class,
                AlexUnitTests.class
        );

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful() ? "All tests passed" : "Some tests failed");

    }

}
