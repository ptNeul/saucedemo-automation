package com.haneul.qa.tests;

import com.haneul.qa.core.BaseTest;
import com.haneul.qa.core.DriverManager;
import com.haneul.qa.pages.InventoryPage;
import com.haneul.qa.pages.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("SauceDemo Automation")
@Feature("Product Sorting")
public class SortTest extends BaseTest {

    @Story("Price high to low sort")
    @Test
    void SortPriceHighToLow() {
        InventoryPage inventoryPage = new LoginPage(DriverManager.getDriver()).open()
                .typeUsername("standard_user")
                .typePassword("secret_sauce")
                .submitExpectSuccess();

        assertThat(inventoryPage.isLoaded()).isTrue();

        inventoryPage.selectSortHighLow();
        List<Double> prices = inventoryPage.getPrices();

        assertThat(prices).isNotEmpty();

        for (int i = 0; i < prices.size() - 1; i++) {
            assertThat(prices.get(i)).isGreaterThanOrEqualTo(prices.get(i + 1));
        }
    }
}
