package tests.person4;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.person4.TestPerson4;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestPerson4.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}