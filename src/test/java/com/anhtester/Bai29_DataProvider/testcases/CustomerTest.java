package com.anhtester.Bai29_DataProvider.testcases;

import com.anhtester.Bai29_DataProvider.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "VTCC Viettel 09/05 A1";

        loginPage = new LoginPage();

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openCustomerPage()
                .verifyRedirectToCustomerPage()
                .addNewCustomer(CUSTOMER_NAME)
                .verifyAddNewCustomer(CUSTOMER_NAME);
    }
}
