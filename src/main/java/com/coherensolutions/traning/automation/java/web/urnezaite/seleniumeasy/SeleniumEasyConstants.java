package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.openqa.selenium.By;

public class SeleniumEasyConstants {

    public static final String alertBoxLink = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    public static final By comfirmBox = By.cssSelector("button[onclick='myConfirmFunction()']");
    public static final By comfirmBoxOnConfirmCancelText = By.cssSelector("p#confirm-demo");
    public static final By alertBox = By.cssSelector("button[onclick='myAlertFunction()']");

    public static final String selectDropdownLink = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    public static final By multiSelect = By.cssSelector("select#multi-select");
    public static final String downloadProgressLink = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    public static final By downloadButton = By.cssSelector("button#cricle-btn");
    public static final By downloadProgress = By.cssSelector("div.percenttext");
    public static final String tableSortSearchLink = "https://demo.seleniumeasy.com/table-sort-search-demo.html";

    public static final By tr =By.xpath("//tbody/tr");
    public static final By td =By.tagName("td");
    public static final By rowsQuantityDisplayed = By.xpath("//select[@name = 'example_length']");

    public static final By nextButton = By.xpath("//a[contains(@class, 'next')]");
}