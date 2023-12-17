package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import factory.DriverFactory;

public final class ExtentLogger {

    private ExtentLogger() {

    }

    public static void pass(String message) {
        ExtentManager.getExtTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(DriverFactory.getBase64Image()).build());
    }

    public static void skip(String message) {
        ExtentManager.getExtTest().skip(message);
    }

}
