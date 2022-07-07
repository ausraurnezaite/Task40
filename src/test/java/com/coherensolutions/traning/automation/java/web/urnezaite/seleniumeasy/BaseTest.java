package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
