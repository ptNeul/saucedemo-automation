package com.haneul.qa.tests;

import com.haneul.qa.core.BaseTest;
import com.haneul.qa.core.DriverManager;
import com.haneul.qa.pages.InventoryPage;
import com.haneul.qa.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("SauceDemo Automation")
@Feature("Authentication")
public class LoginTest extends BaseTest {

    @Story("Login success")
    @Test
    void loginSuccess() {
        InventoryPage inventoryPage = new LoginPage(DriverManager.getDriver()).open()
                .typeUsername("standard_user")
                .typePassword("secret_sauce")
                .submitExpectSuccess();

        assertThat(inventoryPage.isLoaded()).isTrue();
        assertThat(inventoryPage.getTitleText()).isEqualTo("Products");
    }

    @Story("Login failure shows error")
    @Test
    void loginFail_wrongPassword() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver()).open()
                .typeUsername("standard_user")
                .typePassword("wrong_password")
                .submitExpectFailure();

        assertThat(loginPage.getErrorMessage()).isNotBlank();
    }
}
