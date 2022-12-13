package com.herokupp.login.testsuite;

import com.herokupp.login.customlisteners.CustomListeners;
import com.herokupp.login.pages.HomePage;
import com.herokupp.login.pages.LoginPage;
import com.herokupp.login.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }


    //LoginPage loginPage = new LoginPage();
    @Test (groups = {"sanity","regression"})
    public void UserShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLogin();
        Assert.assertEquals(loginPage.getTextToVerify(),"Welcome to the Secure Area. When you are done click logout below.","not verify");
    }
    @Test (groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLogin();
        Assert.assertEquals(loginPage.getErrorMessage(),"Your username is invalid!\n" +
                "×","not verify");

    }
    @Test (groups = {"regression","regression"})
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLogin();
        Assert.assertEquals(loginPage.getErrorPasswordMessage(),"Your password is invalid!\n" +
                "×","not verify");

    }

}
