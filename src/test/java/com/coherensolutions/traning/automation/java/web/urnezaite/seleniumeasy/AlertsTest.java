package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 6.
 * Create 3 tests for alerts
 * (URL - https://demo.seleniumeasy.com/javascript-alert-box-demo.html).
 * 2 tests for “Java Script Confirm Box” and
 * 1 for “Java Script Alert Box”.
 */
public class AlertsTest extends BaseTest {
    public static final String comfirmBoxAfterConfirmExpectedText = "You pressed OK!";
    public static final String comfirmBoxAfterCancelExpectedText = "You pressed Cancel!";
    public static final String alertBoxText = "I am an alert box!";

    @BeforeEach
    public void set() {
        driver.get(SeleniumEasyConstants.alertBoxLink);
    }

    @Test
    public void confirmBoxAfterConfirmTextTest() {
        driver.findElement(SeleniumEasyConstants.comfirmBox).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String textOnComfirm = driver.findElement(SeleniumEasyConstants.comfirmBoxOnConfirmCancelText).getText();
        assertEquals(comfirmBoxAfterConfirmExpectedText, textOnComfirm, "text after confirmation must match");
    }

    @Test
    public void confirmBoxAfterCancelTextTest() {
        driver.findElement(SeleniumEasyConstants.comfirmBox).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String textOnCancel = driver.findElement(SeleniumEasyConstants.comfirmBoxOnConfirmCancelText).getText();
        assertEquals(comfirmBoxAfterCancelExpectedText, textOnCancel, "text after cancellation must match");
    }

    @Test
    public void alertBoxTextTest() {
        driver.findElement(SeleniumEasyConstants.alertBox).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        assertEquals(alertBoxText, textOnAlert, "alert message text must match");
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}