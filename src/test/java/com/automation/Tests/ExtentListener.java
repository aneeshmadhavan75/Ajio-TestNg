package com.automation.Tests;


import com.automation.Utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {


    public void onStart(ITestContext context){
        ExtentReportManager.initExtendReporter();
    }

    public void onFinish(ITestContext context){
        ExtentReportManager.flush();
    }
    
    public void onTestStart(ITestResult result){
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test Passed");
        ExtentReportManager.attachScreenshot();
    }

    public void onTestFailure(ITestResult result) {

        ExtentReportManager.getTest().fail("Test Failed \n"+ result.getThrowable().getMessage());
        ExtentReportManager.attachScreenshot();

    }

    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Skipped");
    }

}
