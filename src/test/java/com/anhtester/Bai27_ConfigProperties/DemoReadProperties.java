package com.anhtester.Bai27_ConfigProperties;

import com.anhtester.Bai26_ParallelPageObject.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadProperties extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginCRM(){

        //Read all properties file
        PropertiesHelper.loadAllFiles();

        //Get value from properties file
        System.out.println(PropertiesHelper.getValue("BROWSER"));
        System.out.println(PropertiesHelper.getValue("URL"));
        System.out.println(PropertiesHelper.getValue("EMAIL"));
        System.out.println(PropertiesHelper.getValue("PASSWORD"));
        //System.out.println(PropertiesHelper.getValue("ENVIRONMENT"));
        //System.out.println(PropertiesHelper.getValue("HEADLESS"));

        //Set key value to properties file
        //PropertiesHelper.setValue("WIDTH", "1920");
        //PropertiesHelper.setValue("HEIGHT", "1080");

        loginPage = new LoginPage();
        loginPage.loginCRM(PropertiesHelper.getValue("EMAIL"), PropertiesHelper.getValue("PASSWORD"));
        loginPage.verifyLoginSuccess();
    }
}
