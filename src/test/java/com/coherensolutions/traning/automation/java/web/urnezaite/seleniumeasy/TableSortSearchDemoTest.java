package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 9.	Create automated script for the following task:
 * a)	Go to https://demo.seleniumeasy.com/table-sort-search-demo.html
 * b)	Select “10” option in dropdown “Show () entries”
 * c)	Create method, which returns list of your custom objects (class fields: Name, Position, Office) with age > x and salary <= y for all pages
 */
public class TableSortSearchDemoTest extends BaseTest {
    public final int ageMoreThan = 30;
    public final int salaryLessThan = 200000;

    @Test
    public void testTable() {
        driver.get(SeleniumEasyConstants.TABLE_SORT_SEARCH_LINK);
        TableSortSearchDemoPage tablePage = new TableSortSearchDemoPage(driver);
        List<Employee> employees = tablePage.filterEmployees(ageMoreThan, salaryLessThan);
        employees.forEach(System.out::println);
    }
}