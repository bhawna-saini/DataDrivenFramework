package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener {
	
	public void onStart(ITestContext context) {
		//System.out.println("In onStart method of ITestListener. Method name is : " +context.getName());

	}

	public void onTestStart(ITestResult result) {
		//System.out.println("In onTestStart method of ITestListener. Method name is : " +result.getMethod().getMethodName());

		test = report.startTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		//System.out.println("In onTestSuccess method of ITestListener. Method name is : " +result.getMethod().getMethodName());
		
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"Pass");
		report.endTest(test);
		report.flush();

	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<br>");
		Reporter.log("Failed method name is : " +result.getMethod().getMethodName()+" click to see screenshot");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "failed with exception : " +result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		
		
		
		Reporter.log("<a target= \"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target= \"_blank\" href="+TestUtil.screenshotName+"><img src ="+TestUtil.screenshotName+" height=200 width =200></img></a>");
		report.endTest(test);
		report.flush();

	}

	public void onTestSkipped(ITestResult result) {
		//System.out.println("In onTestSkipped method of ITestListener. Method name is : " +result.getMethod().getMethodName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
		
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
