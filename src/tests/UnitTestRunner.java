package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class UnitTestRunner {
    public static void main (String [] args) {
        Result andrew = JUnitCore.runClasses(AndrewUnitTests.class);
        for (Failure failure : andrew.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(andrew.wasSuccessful());

        Result jerry = JUnitCore.runClasses(JerryUnitTests.class);
        for (Failure failure : jerry.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(jerry.wasSuccessful());

        Result UiUnitTests = JUnitCore.runClasses(overlayUiTests.class);
        for (Failure failure : UiUnitTests.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(UiUnitTests.wasSuccessful());
    }
}
