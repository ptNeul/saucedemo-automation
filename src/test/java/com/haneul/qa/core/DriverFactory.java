package com.haneul.qa.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver createChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "profile.password_manager_leak_detection", false
        ));
        options.addArguments("--disable-features=PasswordManagerEnabled");
        options.addArguments("--disable-save-password-bubble");

        return new ChromeDriver(options);
    }
}
