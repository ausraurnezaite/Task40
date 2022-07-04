package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TableSortSearchDemoPage {
    private final WebDriver driver;

    public TableSortSearchDemoPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public List<Employee> filterEmployees(int ageMoreThanFilter, int salaryLessThanFilter) {
        List<Employee> employees = new ArrayList<>();

        Select selection = new Select(driver.findElement(By.xpath("//select[@name = 'example_length']")));
        selection.selectByVisibleText("10");


        Boolean tableEnd = false;
        By next = By.xpath("//a[contains(@class, 'next')]");

        while (!tableEnd) {

            List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                String name = cells.get(0).getText();
                String position = cells.get(1).getText();
                String office = cells.get(2).getText();
                String ageString = cells.get(3).getText();
                int age = Integer.parseInt(ageString);
                String salaryFullString = cells.get(5).getText();
                String salaryString = salaryFullString.substring(1, salaryFullString.length() - 2).replace(",", "");
                int salary = Integer.parseInt(salaryString);

                if (age > ageMoreThanFilter && salary <= salaryLessThanFilter) {
//                    System.out.println(String.format("name: %s, position: %s, office: %s, age: %d, salary: %d", name, position, office, age, salary));
                    employees.add(new Employee(name, position, office));
                }
            }

            if (!driver.findElement(next).getAttribute("class").contains("disabled")) {
                driver.findElement(next).click();
            } else {
                tableEnd = true;
            }
        }
        return employees;
    }


    public class Employee {
        @Override
        public String toString() {
            return "name: " + name +
                    ",\t position: " + position +
                    ",\t office: " + office;
        }

        public String name;
        public String position;
        public String office;

        public Employee(String name, String position, String office) {
            this.name = name;
            this.position = position;
            this.office = office;
        }
    }
}


/*
9.	Create automated script for the following task:
a)	Go to https://demo.seleniumeasy.com/table-sort-search-demo.html
b)	Select “10” option in dropdown “Show () entries”
c)	Create method, which returns list of your custom objects (class fields: Name, Position, Office) with age > x and salary <= y for all pages
 */