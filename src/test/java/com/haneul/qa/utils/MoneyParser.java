package com.haneul.qa.utils;

public class MoneyParser {
    private MoneyParser() {
    }

    public static double parseUsd(String text) {
        if (text == null) return 0.0;
        String cleaned = text.replace("$", "").trim();
        return Double.parseDouble(cleaned);
    }
}
