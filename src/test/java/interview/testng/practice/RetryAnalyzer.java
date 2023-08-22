package interview.testng.practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counterForRetry = 0;
	int maxRetry = 3;
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(counterForRetry<maxRetry) {
				counterForRetry++;
				return true;
			}
		}
		return false;
	}

}
