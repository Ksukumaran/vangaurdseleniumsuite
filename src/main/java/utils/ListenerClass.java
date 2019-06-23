package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BaseClass;

import java.io.IOException;

public class ListenerClass implements ITestListener {
	
	private static final Logger log = LogManager.getLogger(ListenerClass.class.getName());
	BaseClass baseClass = new BaseClass();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		try {
			baseClass.screenShotCaptureSuccess(result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	public void onTestFailure(ITestResult result) {
		log.error("Assertion Failed for: "+result.getName());

		try {
			baseClass.screenShotCaptureFailure(result.getName());
//			baseClass.addIssue();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.error(result.getName()+"Test Case Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
