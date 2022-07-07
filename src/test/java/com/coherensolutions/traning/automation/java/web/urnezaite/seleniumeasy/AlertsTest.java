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
    public static final String COMFIRM_BOX_AFTER_CONFIRM_EXPECTED_TEXT = "You pressed OK!";
    public static final String COMFIRM_BOX_AFTER_CANCEL_EXPECTED_TEXT = "You pressed Cancel!";
    public static final String ALERT_BOX_TEXT = "I am an alert box!";

    @BeforeEach
    public void  navigateToMainPage() {
        driver.get(SeleniumEasyConstants.ALERT_BOX_LINK);
    }

    @Test
    public void confirmBoxAfterConfirmTextTest() {
        driver.findElement(SeleniumEasyConstants.COMFIRM_BOX).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String textOnComfirm = driver.findElement(SeleniumEasyConstants.COMFIRM_BOX_ON_CONFIRM_CANCEL_TEXT).getText();
        assertEquals(COMFIRM_BOX_AFTER_CONFIRM_EXPECTED_TEXT, textOnComfirm, "text after confirmation must match");
    }

    @Test
    public void confirmBoxAfterCancelTextTest() {
        driver.findElement(SeleniumEasyConstants.COMFIRM_BOX).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String textOnCancel = driver.findElement(SeleniumEasyConstants.COMFIRM_BOX_ON_CONFIRM_CANCEL_TEXT).getText();
        assertEquals(COMFIRM_BOX_AFTER_CANCEL_EXPECTED_TEXT, textOnCancel, "text after cancellation must match");
    }

    @Test
    public void alertBoxTextTest() {
        driver.findElement(SeleniumEasyConstants.ALERT_BOX).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        assertEquals(ALERT_BOX_TEXT, textOnAlert, "alert message text must match");
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}