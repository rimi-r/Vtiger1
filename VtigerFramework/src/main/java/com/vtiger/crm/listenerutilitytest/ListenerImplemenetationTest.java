package com.vtiger.crm.listenerutilitytest;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseutility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplemenetationTest implements ITestListener, ISuiteListener, IRetryAnalyzer {
	public static ExtentTest test;
	public ExtentSparkReporter spark;
	public static ExtentReports report;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

		System.out.println("On start ISuite");
		String date = new Date().toString().replaceAll(":", "-");
		// extent report add configuration
		spark = new ExtentSparkReporter("./Advanced-report/report " + date + ".html");
		spark.config().setDocumentTitle("CRM suite Test results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add system info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-11");
		report.setSystemInfo("Browser", "chrome");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("On finish ISuite");

		// report backup
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("On test start ITestListener");

		String testName = result.getMethod().getMethodName();
		test = report.createTest(testName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, testName + "---started---");
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On test success ITestListener");
		test.log(Status.PASS, result.getMethod().getMethodName() + "--Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		String mName = result.getMethod().getMethodName();

		// EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		// System.out.println("Efw:"+edriver);

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);

		String date = new Date().toString().replaceAll(":", "-");

		test.addScreenCaptureFromBase64String(src, mName + "_" + date);

		test.log(Status.FAIL, result.getMethod().getMethodName() + "--Failed---");
		test.log(Status.FAIL, result.getThrowable());

//		try {
//			FileUtils.copyFile(src, new File("./screenshots/"+mName+"+"+date+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("onTestFailure -ItestResult");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String mName=result.getMethod().getMethodName();
		test.log(Status.FAIL, mName+"---failed---");
		test.log(Status.FAIL, result.getThrowable());
		System.out.println("On test skipped ITestListener");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On test failed but within success percentagestart ITestListener");

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On start iTestContext");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On finish iTestContext");

	}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub

		int count = 0;
		int limitCount = 0;
		while (count < limitCount) {
			count++;
			return true;
		}

		return false;
	}

}
