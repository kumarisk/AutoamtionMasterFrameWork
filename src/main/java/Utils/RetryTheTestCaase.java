package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTheTestCaase implements IRetryAnalyzer {

    int start = 0;
    int retryLimit = 2;

    @Override
    public boolean retry(ITestResult result) {

        if(start<retryLimit) {
            start++;
            return true;
        }
        return false;
    }
}
