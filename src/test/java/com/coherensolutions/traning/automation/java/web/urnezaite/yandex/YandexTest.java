package com.coherensolutions.traning.automation.java.web.urnezaite.yandex;

import com.coherensolutions.traning.automation.java.web.urnezaite.Timeouts;
import com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy.BaseTest;
import org.junit.jupiter.api.BeforeEach;

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
        driver.get(YandexConstants.YANDEX_MAIL_LINK);
    }

    @ParameterizedTest
    @CsvSource({
            "selenium.test.account,   seleniumtestaccount",
            "selenium.test.account2,  seleniumtestaccount2"
    })
    public void logInTest(String username, String password) {
        driver.findElement(YandexConstants.LOGIN_OPTION).click();
        driver.findElement(YandexConstants.USERNAME_INPUT).sendKeys(username);
        driver.findElement(YandexConstants.LOGIN_BUTTON).click();
        driver.findElement(YandexConstants.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(YandexConstants.LOGIN_BUTTON).click();

        try {
            Thread.sleep(Timeouts.YANDEX_LOG_IN_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts.YANDEX_DRIVERS_EXPLICIT_WAIT));
        wait.pollingEvery(Duration.ofMillis(Timeouts.YANDEX_DRIVERS_EXPLICIT_WAIT_POLLING));
        WebElement userElement = wait.until(ExpectedConditions.presenceOfElementLocated(YandexConstants.USER_LOCATOR));

        Assertions.assertEquals(username, userElement.getText(), "users logo has incorrect username");
        Assertions.assertTrue(driver.findElement(YandexConstants.MAIL_ICON).isDisplayed(), "email icon is not displayed");
        Assertions.assertTrue(driver.findElement(YandexConstants.COMPOSE_BUTTON).isEnabled(), "compose button is not enabled");
    }
}