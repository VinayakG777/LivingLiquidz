package extentListeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testClass.BaseTest;
import utility.Screenshots;

public class TestngListeners extends BaseTest implements ITestListener {
public static 	ExtentTest test ;
	
	ExtentReports extent= ExtentReportGen.extentReportGenerator();
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TestCase started"+result.getName());
	 test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase passed"+result.getName());
		test.log(Status.PASS,"Test case Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("TestCase failed"+result.getName());
		test.fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(Screenshots.captureScreenShot(driver, result.getName()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCase skipped"+result.getName());
		test.log(Status.SKIP,"TestCase Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("TestTag started"+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("TestTag finished"+context.getName());
		extent.flush();
	}

}
