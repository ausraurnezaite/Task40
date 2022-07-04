package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.fail;

public class MultiselectTest {
    public WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void multiSelectTest() {
        Select selection = new Select(driver.findElement(By.cssSelector("select#multi-select")));

        if (selection.isMultiple()) {
            selection.selectByIndex(new Random().nextInt(selection.getOptions().size()));
            selection.selectByIndex(new Random().nextInt(selection.getOptions().size()));
            selection.selectByIndex(new Random().nextInt(selection.getOptions().size()));
            selection.getAllSelectedOptions().forEach(webElement -> System.out.println(webElement.getText()));
        } else {
            fail("List in not a multi-select");
        }
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}


/*
5.
Create test with multiselect
(URL - https://demo.seleniumeasy.com/basic-select-dropdown-demo.html).
Select 3 random options in “Multi Select List Demo” section and verify that they are selected
(for this case don’t work with UI verification)
 */