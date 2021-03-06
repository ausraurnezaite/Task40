package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * 8.	Create automated script for the following task:
 * a)	Go to https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html
 * b)	Click Download
 * c)	Refresh page when percentage is >= 50
 */
public class DownloadProgress extends BaseTest {
    public static final String DOWNLOAD_BOUNDARY = "50%";

    @BeforeEach
    public void  navigateToMainPage() {
        driver.get(SeleniumEasyConstants.DOWNLOAD_PROGRESS_LINK);
    }

    @Test
    public void refreshPageWhenPercentageIsMoreThan50() {
        driver.findElement(SeleniumEasyConstants.DOWNLOAD_BUTTON).click();

        (new WebDriverWait(driver, Duration.ofSeconds(60))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(SeleniumEasyConstants.DOWNLOAD_PROGRESS).
                        getText().contains(DOWNLOAD_BOUNDARY);
            }
        });
        driver.navigate().refresh();
    }
}