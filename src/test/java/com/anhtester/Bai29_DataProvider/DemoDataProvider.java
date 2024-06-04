package com.anhtester.Bai29_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {
    @DataProvider(name = "data_provider_01")
    public Object[][] dataString() {
        return new Object[][]{
                {"First-Value"},
                {"Second-Value"},
                {"Third-Value"}
        };
    }

    @DataProvider(name = "data_provider_02", parallel = true)
    public Object[][] dataStringMulti() {
        return new Object[][]{
                {"Value1", 10, "Value3"},
                {"Value4", 5, "Value6"},
                {"Value7", 7, "Value9"}
        };
    }

    @Test(dataProvider = "data_provider_01")
    public void testDataProvider01(String value) {
        System.out.println("Passed Parameter is: " + value);
    }

    @Test(dataProvider = "data_provider_02")
    public void testDataProvider02(String value1, int value2, String value3) {
        System.out.println("Parameter 1: " + value1);
        System.out.println("Parameter 2: " + value2);
        System.out.println("Parameter 3: " + value3);
    }
}
