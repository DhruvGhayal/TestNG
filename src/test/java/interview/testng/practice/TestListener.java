package interview.testng.practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started : "+result.getName());
	    
	  }

	  public void onTestSuccess(ITestResult result) {
		  System.out.println("Test Sucess : "+result.getName());
	  }

	  
	  public void onTestFailure(ITestResult result) {
		  System.out.println("Test Failure : "+result.getName());
	  }

	  
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("Test Skipped :"+result.getName());
	  }

	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
	  }

	  public void onTestFailedWithTimeout(ITestResult result) {
		  System.out.println();
	    onTestFailure(result);
	  }

	  public void onStart(ITestContext context) {
		  System.out.println("Started");
	  }

	  public void onFinish(ITestContext context) {
		  System.out.println("Finish");
	  }
}