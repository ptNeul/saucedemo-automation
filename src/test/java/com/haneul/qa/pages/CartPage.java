package com.haneul.qa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.haneul.qa.utils.Waits.*;

public class CartPage {
    private final WebDriver driver;

    private final By cartItemNames = By.cssSelector("[data-test='inventory-item-name']");
    private final By cartContainer = By.id("cart_contents_container");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("장바구니 페이지 로드 확인")
    public boolean isLoaded() {
        visible(driver, cartContainer);
        return true;
    }

    @Step("장바구니 상품명 목록 조회")
    public List<String> getCartItemNames() {
        presence(driver, cartItemNames);
        return driver.findElements(cartItemNames).stream()
                .map(e -> e.getText())
                .toList();
    }

    @Step("장바구니 상품 개수 조회")
    public int getItemCount() {
        return getCartItemNames().size();
    }
}
