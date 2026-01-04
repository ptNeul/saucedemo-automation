package com.haneul.qa.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeEach
    void setUp() {
        DriverManager.setDriver(DriverFactory.createChrome());
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver();
    }
}
