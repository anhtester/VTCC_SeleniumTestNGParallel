package com.anhtester.common;

import com.anhtester.drivers.DriverManager;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    @Parameters({"browserName"})
    public void createDriver(@Optional("chrome") String browserName) {

        WebDriver driver;

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Launching Firefox browser...");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Launching Edge browser...");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }

        DriverManager.setDriver(driver); //Set to ThreadLocal

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void closeDriver() {
        DriverManager.quit();
    }

}
