package pages.web;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Parent Portal')]")
    private WebElement titleFilterPage;

    @FindBy(xpath = "//button[contains(@class,'btn-filter')]")
    private WebElement btnFilter;

    @FindBy(xpath = "//*[@id='formControlsSelect']")
    private WebElement ddlRequestStatus;

    @FindBy(xpath = "//button[text()='Apply Filters']")
    private WebElement btnApplyFilters;

    public boolean isOnPage() {
        return titleFilterPage.isDisplayed();
    }

    public void clickOnFilterButton() {
        btnFilter.click();
        waitForPageLoaded(defaultTimeout);
    }

    public void selectRequestStatus(String status) {
        selectOptionByLabel(ddlRequestStatus, status);
        btnApplyFilters.click();
        waitForPageLoaded(defaultTimeout);
    }

    public void verifyCellValueByColumnName(String colName, String value) {
        List<String> cellValue = getCellValueByColumnName(colName);
        for (int i = 0; i < cellValue.size(); i++) {
            Assert.assertEquals("The value is not matched", value, cellValue.get(i).trim());
        }
    }

    public void clickOnHealerColumnName(String colName) {
        getColumnHeaderByName(colName).click();
    }

    public void verifyColumnSortDesc(String colName) {
        List<String> cellValuesBefore = getCellValueByColumnName(colName);
        List<String> cellValuesAfter = new ArrayList<>();
        for (int i = 0; i < cellValuesBefore.size(); i++) {
            cellValuesAfter.add(cellValuesBefore.get(i));
        }
        Collections.sort(cellValuesAfter, Collections.reverseOrder());
        Assert.assertEquals("The " + colName + " column is not sorted in Descending", cellValuesAfter, cellValuesBefore);
    }

    public void verifyColumnSortAsc(String colName) {
        List<String> cellValuesBefore = getCellValueByColumnName(colName);
        List<String> cellValuesAfter = new ArrayList<>();
        for (int i = 0; i < cellValuesBefore.size(); i++) {
            cellValuesAfter.add(cellValuesBefore.get(i));
        }
        Collections.sort(cellValuesAfter);
        Assert.assertEquals("The " + colName + " column is not sorted in Ascending", cellValuesAfter, cellValuesBefore);
    }
}
