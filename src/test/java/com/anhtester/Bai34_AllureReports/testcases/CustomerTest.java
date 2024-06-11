package com.anhtester.Bai34_AllureReports.testcases;

import com.anhtester.Bai34_AllureReports.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "VTCC Viettel 11/06/2024 A2";

        loginPage = new LoginPage();

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openCustomerPage()
                .verifyRedirectToCustomerPage()
                .addNewCustomer(CUSTOMER_NAME)
                .verifyAddNewCustomer(CUSTOMER_NAME);
    }
}
