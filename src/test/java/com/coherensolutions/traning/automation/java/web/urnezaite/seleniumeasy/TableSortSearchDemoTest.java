package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

public class TableSortSearchDemoTest {

    public WebDriver driver = new ChromeDriver();

    @Test
    public void testTable() {
        TableSortSearchDemoPage tablePage = new TableSortSearchDemoPage(driver);
        List<TableSortSearchDemoPage.Employee> employees = tablePage.filterEmployees(30, 200000);
        employees.forEach(System.out::println);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

}
/*
9.	Create automated script for the following task:
a)	Go to https://demo.seleniumeasy.com/table-sort-search-demo.html
b)	Select “10” option in dropdown “Show () entries”
c)	Create method, which returns list of your custom objects (class fields: Name, Position, Office) with age > x and salary <= y for all pages
 */