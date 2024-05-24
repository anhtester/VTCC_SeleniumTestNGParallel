package com.anhtester.Bai25_ParallelExecution;

import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CRMTest extends BaseTest {
    @Test
    public void loginCRM() {
        DriverManager.getDriver().get("https://crm.anhtester.com/admin/authentication");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        DriverManager.getDriver().findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}
