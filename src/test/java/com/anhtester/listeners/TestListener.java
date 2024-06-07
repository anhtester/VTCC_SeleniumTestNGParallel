package com.anhtester.listeners;

import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext iTestContext) {
        LogUtils.info("onStart: " + iTestContext.getStartDate());
        PropertiesHelper.loadAllFiles();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LogUtils.info("onFinish: " + iTestContext.getEndDate());
        //Gửi mail
        //Kết xuất report
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        CaptureHelper.startRecord(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info("PASSED!! Test case " + iTestResult.getName());
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        CaptureHelper.stopRecord();
        CaptureHelper.captureScreenshot(iTestResult.getName());

        LogUtils.error(iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        CaptureHelper.stopRecord();
    }
}