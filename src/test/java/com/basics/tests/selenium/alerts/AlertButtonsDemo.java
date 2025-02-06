package com.basics.tests.selenium.alerts;

enum AlertButtonsDemo {
    ALERT("Click for JS Alert"),
    CONFIRM("Click for JS Confirm"),
    PROMPT("Click for JS Prompt");

    private final String buttonText;

    AlertButtonsDemo(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonText() {
        return buttonText;
    }
}
