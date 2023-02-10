package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@href=\"register.htm\"]")
    private WebElement Register;

    @FindBy(xpath = "//*[@id=\"customer.firstName\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"customer.lastName\"]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"customer.address.street\"]")
    private WebElement address;

    @FindBy(xpath = "//*[@id=\"customer.address.city\"]")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"customer.address.state\"]")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"customer.address.zipCode\"]")
    private WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"customer.phoneNumber\"]")
    private WebElement phone;

    @FindBy(xpath = "//*[@id=\"customer.ssn\"]")
    private WebElement ssn;

    @FindBy(xpath = "//*[@id=\"customer.username\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"customer.password\"]")
    private WebElement passWord;

    @FindBy(xpath = "//*[@id=\"repeatedPassword\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void openPortal(){
        this.driver.get("https://parabank.parasoft.com/parabank/");
        this.wait.until(ExpectedConditions.visibilityOf(this.Register));
    }

    public void newUserRegistration(String username, String password){
        this.Register.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
        this.firstName.sendKeys("test");
        this.lastName.sendKeys("test");
        this.address.sendKeys("test");
        this.city.sendKeys("test");
        this.state.sendKeys("test");
        this.zipCode.sendKeys("test");
        this.phone.sendKeys("test");
        this.ssn.sendKeys("test");
        this.userName.sendKeys(username);
        this.passWord.sendKeys(password);
        this.confirmPassword.sendKeys(password);
        this.submitButton.click();
    }

}
