package com.anhtester.Bai32_WriteLogToFile;

import com.anhtester.Bai26_ParallelPageObject.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.utils.LogUtils;
import org.testng.annotations.Test;

public class DemoLog4j extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess(){
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();
    }

}
