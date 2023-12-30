package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FrameworkRetryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    int retryLimit = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (count < retryLimit) {
            count++;
            return true;
        }
        return false;
    }
}
