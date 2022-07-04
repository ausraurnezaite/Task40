package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DownloadProgress {
    public WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void refreshPageWhenPercentageIsMoreThan50() {
        driver.findElement(By.cssSelector("button#cricle-btn")).click();

        (new WebDriverWait(driver, Duration.ofSeconds(60))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector("div.percenttext")).
                        getText().contains("50%");
            }
        });
        driver.navigate().refresh();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}

/*
8.	Create automated script for the following task:
a)	Go to https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html
b)	Click Download
c)	Refresh page when percentage is >= 50
 */