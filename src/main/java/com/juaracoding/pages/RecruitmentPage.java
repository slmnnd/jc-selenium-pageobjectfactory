package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
    private WebDriver driver;

    public RecruitmentPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment'")
    private WebElement menuRecruitment;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAddCandidate;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placehoder='Middle Name']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement vacancy;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    private WebElement contactNumber;

    @FindBy(xpath = "//div[@class='oxd-file-input-div']")
    private WebElement resume;

    @FindBy(xpath = "//input[@placeholder='Enter coma seperated words...']")
    private WebElement keywords;
    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    private WebElement dateOfApplication;
    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    private WebElement notes;

    @FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    private WebElement checklistConsent;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;

    @FindBy(xpath = "//h6[normalize-space()='Application Stage']")
    private WebElement txtSuccess;
    @FindBy(xpath = "//div[@class='oxd-input-group']//div[1]//span[1]")
    private WebElement txtRequired;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']")
    private WebElement btnRecruitment;

    //scroll
    JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,600)");
//        System.out.println("scroll vertical 600px");

    //step action add candidate
    public void btnRecruitment(){
        btnRecruitment.click();

    }
    public void addCandidate(){
       btnAddCandidate.click();
    }

    public void formRecruitment(String fName, String lName, String emailHere){
        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
//        js.executeScript("window.scrollBy(0,600)");
        this.email.sendKeys(emailHere);
        js.executeScript("window.scrollBy(0,600)");
        btnSave.click();
    }

    //step validation
    public String getTxtSuccess(){
        return txtSuccess.getText();
    }
    public String getTxtRequired(){
        return txtRequired.getText();
    }


}
