package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest {
    public WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void comfirmBoxAfterConfirmTextTest() {
        driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String textOnComfirm = driver.findElement(By.cssSelector("p#confirm-demo")).getText();
        assertEquals("You pressed OK!", textOnComfirm);
    }

    @Test
    public void comfirmBoxAfterCancelTextTest() {
        driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String textOnCancel = driver.findElement(By.cssSelector("p#confirm-demo")).getText();
        assertEquals("You pressed Cancel!", textOnCancel);
    }

    @Test
    public void alertBoxTextTest() {
        driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']")).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        assertEquals("I am an alert box!", textOnAlert);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}

/*
6.
Create 3 tests for alerts
(URL - https://demo.seleniumeasy.com/javascript-alert-box-demo.html).
2 tests for “Java Script Confirm Box” and
1 for “Java Script Alert Box”.
 */
