package com.haneul.qa.pages;

import com.haneul.qa.utils.MoneyParser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.haneul.qa.utils.Waits.*;

public class InventoryPage {
    private final WebDriver driver;

    private final By inventoryContainer = By.id("inventory_container");
    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By sortSelect = By.cssSelector("[data-test='product-sort-container']");
    private final By priceTexts = By.cssSelector("[data-test='inventory-item-price']");
    private final By itemNames = By.cssSelector("[data-test='inventory-item-name']");
    private final By addToCartButtons = By.cssSelector("[data-test^='add-to-cart']");
    private final By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("상품 목록 페이지 로드 확인")
    public boolean isLoaded() {
        visible(driver, inventoryContainer);
        return true;
    }

    @Step("페이지 타이틀 조회")
    public String getTitleText() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("정렬 선택: value={value}")
    public InventoryPage selectSortByValue(String value) {
        Select select = new Select(driver.findElement(sortSelect));
        select.selectByValue(value);
        presence(driver, priceTexts);
        return this;
    }

    @Step("정렬 선택: 가격 높은순")
    public InventoryPage selectSortHighLow() {
        return selectSortByValue("hilo");
    }

    @Step("가격 목록 조회")
    public List<Double> getPrices() {
        presence(driver, priceTexts);
        return driver.findElements(priceTexts).stream()
                .map(e -> MoneyParser.parseUsd((e.getText())))
                .toList();
    }

    @Step("상품명 목록 조회")
    public List<String> getItemNames() {
        presence(driver, itemNames);
        return driver.findElements(itemNames).stream()
                .map(e -> e.getText())
                .toList();
    }

    @Step("장바구니 담기: index={index}")
    public InventoryPage addItemToCartByIndex(int index) {
        presence(driver, addToCartButtons);
        driver.findElements(addToCartButtons).get(index).click();
        return this;
    }

    @Step("장바구니로 이동")
    public CartPage goToCart() {
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }
}
