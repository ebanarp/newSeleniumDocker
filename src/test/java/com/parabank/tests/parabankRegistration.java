package com.parabank.tests;

import com.parabank.pages.CustomerHomePage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class parabankRegistration {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        String completeUrl= "http://10.0.0.108:4444/wd/hub";
        ChromeOptions chromeOptions = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL(completeUrl), chromeOptions);
        /*System.setProperty("webdriver.chrome.driver", "/Users/akashlinasayed/Downloads/chromedriver_mac64/chromedriver");
        this.driver = new ChromeDriver();*/
    }

    @Test
    public void newUserRegistration(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPortal();
        registrationPage.newUserRegistration("18", "7");
        CustomerHomePage customerHomePage = new CustomerHomePage(driver);
        customerHomePage.accountOverview();
        customerHomePage.userLogout();
    }

    @Test
    public void existingUserLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin("18","7");
        CustomerHomePage customerHomePage = new CustomerHomePage(driver);
        customerHomePage.userLogout();
    }

    @Test
    public void openNewAccount(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin("18","7");
        CustomerHomePage customerHomePage = new CustomerHomePage(driver);
        customerHomePage.openNewCheckingAccount();
    }

    @AfterTest
    public void closePortal(){
        this.driver.close();
    }
}
