package com.coherensolutions.traning.automation.java.web.urnezaite.yandex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class YandexTest {
    public WebDriver driver = new ChromeDriver();


    @BeforeEach
    public void setUp() {
        driver.get("https://mail.yandex.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @ParameterizedTest
    @CsvSource({
            "selenium.test.account,   seleniumtestaccount",
            "selenium.test.account2,  seleniumtestaccount2"
    })
    public void logInTest(String username, String password) {
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.cssSelector("input[id='passp-field-login']")).sendKeys(username);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']")).click();
        driver.findElement(By.xpath("//input[@id='passp-field-passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='passp:sign-in']")).click();

//                   Explicit Wait
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By userLocator = By.xpath("//span[contains(@class, 'user-account')]");

//        WebElement userElement = (new WebDriverWait(driver, Duration.ofSeconds(10)))
//                .until(ExpectedConditions.presenceOfElementLocated(userLocator));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.pollingEvery(Duration.ofMillis(700));
        WebElement userElement = wait.until(ExpectedConditions.presenceOfElementLocated(userLocator));

        Assertions.assertEquals(username, userElement.getText());   //users logo has correct username
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'PSHeaderIcon-Image_Mail')]")).isDisplayed());    //email icon is displayed
        Assertions.assertTrue(driver.findElement(By.cssSelector("a[href='#compose']")).isEnabled());    //compose button is enabled
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}