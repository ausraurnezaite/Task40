package com.coherensolutions.traning.automation.java.web.urnezaite.yandex;

import org.openqa.selenium.By;

public class YandexConstants {
    public static final String yandexMailLink = "https://mail.yandex.com/";
    public static final By logInOption = By.partialLinkText("Log in");
    public static final By usernameInput = By.cssSelector("input[id='passp-field-login']");
    public static final By logInButton = By.xpath("//button[@id='passp:sign-in']");
    public static final By passwordInput = By.xpath("//input[@id='passp-field-passwd']");
    public static final By userLocator = By.xpath("//span[contains(@class, 'user-account')]");
    public static final By mailIcon = By.xpath("//div[contains(@class, 'PSHeaderIcon-Image_Mail')]");
    public static final By composeButton = By.cssSelector("a[href='#compose']");
}
