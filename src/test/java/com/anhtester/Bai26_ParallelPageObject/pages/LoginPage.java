package com.anhtester.Bai26_ParallelPageObject.pages;

import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends CommonPage {

    private String URL = "https://crm.anhtester.com/admin/authentication";

    public LoginPage() {
    }

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");

    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);

        return new DashboardPage();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(WebUI.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail(String errorMassageContent) {
        Assert.assertTrue(WebUI.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(WebUI.isDisplayed(errorMessage), "Error message NOT displays");
        Assert.assertEquals(WebUI.getElementText(errorMessage), errorMassageContent, "Content of error massage NOT match.");
    }

    public void verifyRedirectToLoginPage() {
        boolean checkHeader = WebUI.isDisplayed(headerPage);
        String textHeader = WebUI.getElementText(headerPage);

        Assert.assertTrue(checkHeader, "The header of Login page not display.");
        Assert.assertEquals(textHeader, "Login", "The header content of Login page not match.");
    }

}
