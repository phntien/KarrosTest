package pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Config;

public class HomePage extends BasePage{
    @FindBy(xpath = "//input[@id='formHorizontalEmail']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='formHorizontalPassword']")
    private WebElement txtPassword;

    @FindBy(xpath = "//a[text()='LOG IN']")
    private WebElement btnLogin;

    //Selenium Actions
    public void openHomePage(){
        openUrl(Config.getProperty("homePageURL"));
        waitForPageLoaded(defaultTimeout);
    }

    public void enterUserName(String email){
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickSignInButton(){
        btnLogin.click();
        waitForPageLoaded(defaultTimeout);
    }
}
