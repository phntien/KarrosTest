package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pages.web.FilterPage;
import pages.web.HomePage;
import util.Config;

public class FilterStepDefs {
    @Steps
    HomePage homePage;

    @Steps
    FilterPage filterPage;

    @Given("I open Home Page")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Then("I verify Home Page loaded successfully")
    public void verifyHomePageDisplayed() {
        String currentTitle = homePage.getTitle();
        String expectedTitle = Config.getProperty("homePageWindowTitle");
        Assert.assertEquals(currentTitle, expectedTitle);
    }

    @Given("^I enter User Email is \"([^\"]*)\"$")
    public void enterEmail(String email) {
        String Email = "";
        //In Case get data from config.properties
        if (email.equals("$validUserEmail")) {
            Email = Config.getProperty("validUserEmail");
        }
        //In Case not get data from config.properties
        else {
            Email = email;
        }
        homePage.enterUserName(Email);
    }

    @And("^I enter User Password is \"([^\"]*)\"$")
    public void enterUserPassword(String password) {
        String Password = "";
        //In Case get data from config.properties
        if (password.equals("$validPassword")) {
            Password = Config.getProperty("validPassword");
        }
        //In Case not get data from config.properties
        else {
            Password = password;
        }
        homePage.enterPassword(Password);
    }

    @And("I click Sign-In button to go to Filter Page")
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }

    @Then("I verify the Filter Page displayed successfully")
    public void verifyFlightFinderPageLoaded() {
        Assert.assertTrue("Filter Page is displayed successfully", filterPage.isOnPage());
    }

    @And("I click on Filter Search button on top of page")
    public void clickOnFilterSearchButton() {
        filterPage.clickOnFilterButton();
    }

    @And("^I select Request Status on Filter popup is \"([^\"]*)\"$")
    public void selectInactiveStatus(String status) {
        filterPage.selectRequestStatus(status);
    }

    @Then("^I verify filter Student for \"([^\"]*)\" column with status \"([^\"]*)\" are displayed properly")
    public void verifyFilterRequest(String colName, String status) {
        filterPage.verifyCellValueByColumnName(colName, status);
    }

    @And("I click \"([^\"]*)\" header column")
    public void clickFirstNameColumn(String colName) {
        filterPage.clickOnHealerColumnName(colName);
    }

    @Then("^I verify \"([^\"]*)\" column is sorted in Ascending order")
    public void verifySortColumnAsc(String firstName) {
        filterPage.verifyColumnSortAsc(firstName);
    }

    @Then("^I verify \"([^\"]*)\" column is sorted in Descending order")
    public void verifySortColumnDesc(String firstName) {
        filterPage.verifyColumnSortDesc(firstName);
    }

}
