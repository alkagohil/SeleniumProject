package testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends TestBase implements ITestListener{
static ExtentReports r;
static ExtentTest t;
	public void onTestStart(ITestResult result) {
	System.out.println("@Test started");
	//t=r.startTest("LoginTest has started");
	t=r.startTest(result.getMethod().getMethodName()+ " has started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("@Test passed");
		
		t.log(LogStatus.PASS, result.getMethod().getMethodName()
				+" has passed"+t.addScreenCapture(captureScreenshot()));
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("@Test failed");
		t.log(LogStatus.FAIL, result.getMethod().getMethodName()
				+" has failed"+t.addScreenCapture(captureScreenshot()));
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("@Test skipped");
		t.log(LogStatus.SKIP, result.getMethod().getMethodName()+" has skipped");
	}

	public void onStart(ITestContext context) {
		System.out.println("Testng started");
		if(r==null)
		{
		r = new ExtentReports("test-output/myreport.html");
		r.addSystemInfo("cycle", "smoketesting");
		r.addSystemInfo("Browser", "chrome");
		}
	}

	public void onFinish(ITestContext context) {
		System.out.println("Testng completed");
		r.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}



}
