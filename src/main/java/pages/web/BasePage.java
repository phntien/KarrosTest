package pages.web;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.SetUp;

import java.util.ArrayList;
import java.util.List;

public class BasePage extends PageObject {
    public static int defaultTimeout = 60;

    public WebDriver driver = SetUp.driver;

    @Override
    public <T extends PageObject> T setDriver(WebDriver driver) {
        return super.setDriver(this.driver);
    }

    public void waitForPageLoaded(long timeout) {
        ExpectedCondition<Boolean> expectation = waitDriver -> {
            assert waitDriver != null;
            return ((JavascriptExecutor) waitDriver).executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(expectation);
        } catch (Exception e) {
            System.out.println("Timeout waiting for Page Load Request to complete. {}" + e.getMessage());
        }
    }

    //Select a option of dropdown box by label
    public void selectOptionByLabel(WebElement element, String label) {
        Select select = new Select(element);
        select.selectByVisibleText(label);
    }


    // Get list of column name on table
    public List<WebElement> getColumnNames() {
        return driver.findElements(By.xpath("//thead//th"));
    }

    // Get list of row by WebElement
    public List<WebElement> getRows() {
        return driver.findElements(By.xpath("//tbody/tr"));
    }

    //Get index of column based on column name
    public int getColumnIndex(String columnName) {
        for (int i = 0; i < getColumnNames().size(); i++) {
            if (columnName.equalsIgnoreCase(getColumnNames().get(i).getText().trim())) {
                return i;
            }
        }
        return -1;
    }

    // Get the value based on column name
    public List<String> getCellValueByColumnName(String columnName) {
        String value;
        List<String> cellValuesByColumnName = new ArrayList<>();
        List<WebElement> rows = getRows();
        int colIndex = getColumnIndex(columnName);
        for (int i = 0; i < rows.size(); i++) {
            value = rows.get(i).findElements(By.cssSelector("td")).get(colIndex).getText().trim();
            cellValuesByColumnName.add(value);
        }
        return cellValuesByColumnName;
    }

    //get WebElement column header by name
    public WebElement getColumnHeaderByName(String colName) {
        int columnIndex = getColumnIndex(colName);
        return getColumnNames().get(columnIndex);
    }

}
