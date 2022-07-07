package com.coherensolutions.traning.automation.java.web.urnezaite.seleniumeasy;

import org.openqa.selenium.By;

public class SeleniumEasyConstants {

    public static final String ALERT_BOX_LINK = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    public static final By COMFIRM_BOX = By.cssSelector("button[onclick='myConfirmFunction()']");
    public static final By COMFIRM_BOX_ON_CONFIRM_CANCEL_TEXT = By.cssSelector("p#confirm-demo");
    public static final By ALERT_BOX = By.cssSelector("button[onclick='myAlertFunction()']");

    public static final String SELECT_DROPDOWN_LINK = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    public static final By MULTI_SELECT = By.cssSelector("select#multi-select");

    public static final String DOWNLOAD_PROGRESS_LINK = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    public static final By DOWNLOAD_BUTTON = By.cssSelector("button#cricle-btn");
    public static final By DOWNLOAD_PROGRESS = By.cssSelector("div.percenttext");

    public static final String TABLE_SORT_SEARCH_LINK = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    public static final By TABLE_ROW = By.xpath("//tbody/tr");
    public static final By TABLE_DATA = By.tagName("td");
    public static final By ROWS_QUANTITY_DISPLAYED = By.xpath("//select[@name = 'example_length']");
    public static final By NEXT_BUTTON = By.xpath("//a[contains(@class, 'next')]");
}