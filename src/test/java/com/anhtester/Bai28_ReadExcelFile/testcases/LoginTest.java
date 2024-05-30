package com.anhtester.Bai28_ReadExcelFile.testcases;

import com.anhtester.Bai28_ReadExcelFile.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginCRM.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1));
        loginPage.verifyLoginSuccess();
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();

        excelHelper.setCellData("Passed", "STATUS", 1);
    }

    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginCRM.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD", 2));
        loginPage.verifyLoginFail("Invalid email or password");

        excelHelper.setCellData("Passed", "STATUS", 2);
    }

    @Test(priority = 3)
    public void testLoginFailWithEmailNull(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginCRM.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 3),
                excelHelper.getCellData("PASSWORD", 3));
        loginPage.verifyLoginFail("The Email Address field is required.");

        excelHelper.setCellData("Passed", "STATUS", 3);
    }

    @Test(priority = 4)
    public void testLoginFailWithPasswordInvalid(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginCRM.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 4),
                excelHelper.getCellData("PASSWORD", 4));
        loginPage.verifyLoginFail("Invalid email or password");

        excelHelper.setCellData("Passed", "STATUS", 4);
    }

    @Test(priority = 5)
    public void testLoginFailWithPasswordNull(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginCRM.xlsx", "Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(excelHelper.getCellData("EMAIL", 5),
                excelHelper.getCellData("PASSWORD", 5));
        loginPage.verifyLoginFail("The Password field is required.");

        excelHelper.setCellData("Passed", "STATUS", 5);
    }
}
