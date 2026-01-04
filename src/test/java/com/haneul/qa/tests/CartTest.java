package com.haneul.qa.tests;

import com.haneul.qa.core.BaseTest;
import com.haneul.qa.core.DriverManager;
import com.haneul.qa.pages.CartPage;
import com.haneul.qa.pages.InventoryPage;
import com.haneul.qa.pages.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("SauceDemo Automation")
@Feature("Cart")
public class CartTest extends BaseTest {

    @Story("Add item to cart")
    @Test
    void addItemToCart_success() {
        InventoryPage inventoryPage = new LoginPage(DriverManager.getDriver()).open()
                .typeUsername("standard_user")
                .typePassword("secret_sauce")
                .submitExpectSuccess();

        assertThat(inventoryPage.isLoaded()).isTrue();

        List<String> inventoryItems = inventoryPage.getItemNames();
        String expectedFirstItem = inventoryItems.get(0);

        CartPage cartPage = inventoryPage
                .addItemToCartByIndex(0)
                .goToCart();

        assertThat(cartPage.isLoaded()).isTrue();
        assertThat(cartPage.getCartItemNames()).contains(expectedFirstItem);
        assertThat(cartPage.getItemCount()).isEqualTo(1);
    }
}
