package com.anhtester.dataproviders;

import com.anhtester.helpers.ExcelHelper;
import com.anhtester.helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "data_provider_login", parallel = false)
    public Object[][] dataLoginMulti() {
        return new Object[][]{
                {"admin@example.com", "123456"},
                {"admin123@example.com", "123456"},
        };
    }

    @DataProvider(name = "data_provider_login_excel", parallel = true)
    public Object[][] dataLoginFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(SystemHelper.getCurrentDir() + "src/test/resources/testdata/LoginCRM.xlsx", "LoginSuccess");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_multi_row", parallel = true)
    public Object[][] dataLoginFromExcelMultiRow() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/LoginCRM.xlsx", "LoginSuccess", 5, 7);
        System.out.println("Login Data from Excel Hashtable: " + data);
        return data;
    }

}
