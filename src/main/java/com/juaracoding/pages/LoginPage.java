package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator use page facetory
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//h6[contains(@class, topbar-header)]")
    private WebElement txtDashboard;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement btnProfile;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogout;

    @FindBy(xpath = "//p[contains(@class, 'alert-content-text')]")
    private WebElement txtInvalidLogin;

    @FindBy(xpath = "//span[contains(@class, 'input-field-error-message')]")
    private WebElement txtRequired;

    //step action
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    //logout
    public void logout (){
        btnProfile.click();
        btnLogout.click();
    }

    //step validation
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtInvalidLogin(){
        return txtInvalidLogin.getText();
    }

    public String getTxtRequired(){
        return txtRequired.getText();
    }

}
