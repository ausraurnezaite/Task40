package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * 5.
 * Create test with multiselect
 * (URL - https://demo.seleniumeasy.com/basic-select-dropdown-demo.html).
 * Select 3 random options in “Multi Select List Demo” section and verify that they are selected
 * (for this case don’t work with UI verification)
 */
public class MultiSelectTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        set(SeleniumEasyConstants.selectDropdownLink);
    }

    @Test
    public void multiSelectTest() {
        Select selection = new Select(driver.findElement(SeleniumEasyConstants.multiSelect));

        if (selection.isMultiple()) {
            selection.selectByIndex(new Random().nextInt(selection.getOptions().size()));
            selection.selectByIndex(new Random().nextInt(selection.getOptions().size()));
            selection.selectByIndex(new Random().nextInt(selection.getOptions().size()));
            selection.getAllSelectedOptions().forEach(webElement -> System.out.println(webElement.getText()));
        } else {
            fail("List in not a multi-select");
        }
    }
}