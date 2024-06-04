package com.anhtester.Bai29_DataProvider.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage extends CommonPage {

    public DashboardPage() {
    }

    private By labelTotalTasksNotFinished = By.xpath("((//div[@class='top_stats_wrapper'])[4]//span)[2]");

    public void verifyRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        boolean checkMenuDashboard = WebUI.isDisplayed(menuDashboard);
        WebUI.logConsole("Check Menu Dashboard: " + checkMenuDashboard);
        Assert.assertTrue(checkMenuDashboard, "The menu Dashboard page not display.");
    }

    public void openPage(String menuName) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + menuName + "']"));
    }

    public void verifyTotalOfTasksNotFinished(String totalValue) {
        WebUI.waitForPageLoaded();
        String total = WebUI.getElementText(labelTotalTasksNotFinished);
        WebUI.logConsole("Total Actual: " + total);
        Assert.assertEquals(total, totalValue, "The total of Tasks Not Finished not match.");
    }
}
