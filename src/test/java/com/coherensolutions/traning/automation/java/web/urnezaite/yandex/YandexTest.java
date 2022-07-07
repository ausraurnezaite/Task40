package com.coherensolutions.traning.automation.java.web.urnezaite.yandex;

import com.coherensolutions.traning.automation.java.web.urnezaite.Timeouts;
import com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexTest extends BaseTest {
    public WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void set() {
        driver.get(YandexConstants.yandexMailLink);
    }

    @ParameterizedTest
    @CsvSource({
            "selenium.test.account,   seleniumtestaccount",
            "selenium.test.account2,  seleniumtestaccount2"
    })
    public void logInTest(String username, String password) {
        driver.findElement(YandexConstants.logInOption).click();
        driver.findElement(YandexConstants.usernameInput).sendKeys(username);
        driver.findElement(YandexConstants.logInButton).click();
        driver.findElement(YandexConstants.passwordInput).sendKeys(password);
        driver.findElement(YandexConstants.logInButton).click();

        try {
            Thread.sleep(Timeouts.yandexLogInSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts.yandexDriversExplicitWait));
        wait.pollingEvery(Duration.ofMillis(Timeouts.yandexDriversExplicitWaitPolling));
        WebElement userElement = wait.until(ExpectedConditions.presenceOfElementLocated(YandexConstants.userLocator));

        Assertions.assertEquals(username, userElement.getText(), "users logo has incorrect username");
        Assertions.assertTrue(driver.findElement(YandexConstants.mailIcon).isDisplayed(), "email icon is not displayed");
        Assertions.assertTrue(driver.findElement(YandexConstants.composeButton).isEnabled(), "compose button is not enabled");
    }
}