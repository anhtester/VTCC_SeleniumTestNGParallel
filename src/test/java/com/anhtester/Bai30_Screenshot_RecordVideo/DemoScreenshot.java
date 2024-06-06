package com.anhtester.Bai30_Screenshot_RecordVideo;

import com.anhtester.Bai29_DataProvider.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.dataproviders.DataProviderFactory;
import com.anhtester.drivers.DriverManager;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DemoScreenshot extends BaseTest {
    @Test(priority = 1)
    public void testHomePage1() {
        DriverManager.getDriver().get("https://crm.anhtester.com/admin/authentication");

        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        File theDir = new File("./screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        try {
            FileHandler.copy(source, new File("./screenshots/testHomePage1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Screenshot success !!");
    }

    @Test(priority = 2)
    public void testHomePage2() {
        DriverManager.getDriver().get("https://hrm.anhtester.com/");
        WebUI.waitForPageLoaded();
        CaptureHelper.captureScreenshot("LoginPageHRM");
    }

    LoginPage loginPage;
    @Test(priority = 3, dataProvider = "data_provider_login", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password){
        loginPage = new LoginPage();

        CaptureHelper.startRecord("testLoginSuccess");

        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();

        //Stop record video in AfterMethod at BaseTest class
    }

    @Test(priority = 4)
    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "VTCC Viettel 06/06/2024 A2";

        loginPage = new LoginPage();

        CaptureHelper.startRecord("testAddNewCustomer");

        loginPage.loginCRM("admin@example.com", "123456")
                .openCustomerPage()
                .verifyRedirectToCustomerPage()
                .addNewCustomer(CUSTOMER_NAME)
                .verifyAddNewCustomer(CUSTOMER_NAME);

        //Stop record video in AfterMethod at BaseTest class
    }
}
