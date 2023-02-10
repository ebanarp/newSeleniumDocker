package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[2]/a")
    private WebElement accountOverviewLink;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[1]/a")
    private WebElement openNewAccLink;

    @FindBy(xpath = "//*[@id=\"type\"]")
    private WebElement accountType;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/div/input")
    private WebElement openNewAccSubmit;

    public CustomerHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void accountOverview(){
        this.wait.until(ExpectedConditions.visibilityOf(this.accountOverviewLink));
        this.accountOverviewLink.click();
    }

    public void openNewCheckingAccount(){
        this.wait.until(ExpectedConditions.visibilityOf(this.openNewAccLink));
        this.openNewAccLink.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.accountType));
        this.openNewAccLink.sendKeys("CHECKING");
        this.wait.until(ExpectedConditions.visibilityOf(this.openNewAccSubmit));
        this.openNewAccSubmit.click();
    }

    public void userLogout(){
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
        this.logoutLink.click();
    }
}
