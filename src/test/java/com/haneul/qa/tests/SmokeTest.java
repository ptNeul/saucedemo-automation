package com.haneul.qa.tests;

import com.haneul.qa.core.BaseTest;
import com.haneul.qa.core.DriverManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest extends BaseTest {

    @Test
    void openSauceDemo() {
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        assertThat(DriverManager.getDriver().getTitle()).isNotBlank();
    }
}
