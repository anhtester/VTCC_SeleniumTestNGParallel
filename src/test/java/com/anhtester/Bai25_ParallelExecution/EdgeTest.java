package com.anhtester.Bai25_ParallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class EdgeTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Initilizing the Microsoft Edge driver");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void EdgeTestMethod() {
        //Initialize the Edge driver
        System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='API Testing']")).click();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Quit the browser ");
        driver.quit();
    }

}