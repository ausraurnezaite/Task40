package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 9.	Create automated script for the following task:
 * a)	Go to https://demo.seleniumeasy.com/table-sort-search-demo.html
 * b)	Select “10” option in dropdown “Show () entries”
 * c)	Create method, which returns list of your custom objects (class fields: Name, Position, Office) with age > x and salary <= y for all pages
 */
public class TableSortSearchDemoPage {
    private final WebDriver driver;
    public final String rowsShown = "10";

    public TableSortSearchDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Employee> filterEmployees(int ageMoreThanFilter, int salaryLessThanFilter) {
        List<Employee> employees = new ArrayList<>();

        Select selection = new Select(driver.findElement(SeleniumEasyConstants.rowsQuantityDisplayed));
        selection.selectByVisibleText(rowsShown);

        boolean tableEnd = false;

        while (!tableEnd) {

            List<WebElement> rows = driver.findElements(SeleniumEasyConstants.tr);

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(SeleniumEasyConstants.td);
                String name = cells.get(0).getText();
                String position = cells.get(1).getText();
                String office = cells.get(2).getText();
                int age = Integer.parseInt(cells.get(3).getText());
                int salary = convertSalary(cells.get(5).getText());

                if (age > ageMoreThanFilter && salary <= salaryLessThanFilter) {
                    employees.add(new Employee(name, position, office));
                }
            }

            if (!driver.findElement(SeleniumEasyConstants.nextButton).getAttribute("class").contains("disabled")) {
                driver.findElement(SeleniumEasyConstants.nextButton).click();
            } else {
                tableEnd = true;
            }
        }
        return employees;
    }

    public int convertSalary(String salaryFullString) {
        String salaryString = salaryFullString.substring(1, salaryFullString.length() - 2).replace(",", "");
        return Integer.parseInt(salaryString);
    }


}