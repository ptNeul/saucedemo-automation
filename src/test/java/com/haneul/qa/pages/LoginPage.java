package com.haneul.qa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.haneul.qa.utils.Waits.*;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("로그인 페이지 오픈")
    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        visible(driver, usernameInput);
        return this;
    }

    @Step("아이디 입력: {username}")
    public LoginPage typeUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        return this;
    }

    @Step("비밀번호 입력")
    public LoginPage typePassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step("로그인 버튼 클릭")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("로그인 성공 제출")
    public InventoryPage submitExpectSuccess() {
        clickLogin();
        return new InventoryPage(driver);
    }

    @Step("로그인 실패 제출")
    public LoginPage submitExpectFailure() {
        clickLogin();
        visible(driver, errorMessage);
        return this;
    }

    @Step("에러 메시지 표시 확인")
    public String getErrorMessage() {
        visible(driver, errorMessage);
        return driver.findElement(errorMessage).getText();
    }
}
