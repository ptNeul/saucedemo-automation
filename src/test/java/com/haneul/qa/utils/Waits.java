package com.haneul.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class Waits {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);

    private Waits() {
    }

    public static void visible(WebDriver driver, By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clickable(WebDriver driver, By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void presence(WebDriver driver, By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
