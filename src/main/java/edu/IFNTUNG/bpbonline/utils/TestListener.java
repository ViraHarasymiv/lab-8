package edu.IFNTUNG.bpbonline.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
//        System.out.println("beforeInvocation");
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
//        System.out.println("afterInvocation");
    }

    @Override
    public void onStart(ISuite iSuite) {
//        System.out.println("onStart suite");
    }

    @Override
    public void onFinish(ISuite iSuite) {
//        System.out.println("onFinish suite");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure");
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("driver");
        saveScreenshot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart Test");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish Test");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
