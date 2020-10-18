package tests.person3;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.person3.TestPerson3;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestPerson3.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}