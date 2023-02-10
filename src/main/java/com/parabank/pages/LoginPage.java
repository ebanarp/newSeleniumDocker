package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[1]/input")
    private WebElement loginUser;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[2]/input")
    private WebElement loginPassword;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void userLogin(String loginUser, String loginPassword){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPortal();
        this.loginUser.sendKeys(loginUser);
        this.loginPassword.sendKeys(loginPassword);
        this.loginButton.click();
        CustomerHomePage customerHomePage = new CustomerHomePage(driver);
        customerHomePage.accountOverview();
    }
}
