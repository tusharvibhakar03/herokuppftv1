package com.herokupp.login.pages;

import com.herokupp.login.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    @CacheLookup

    @FindBy(id = "username")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginField;

     @FindBy(xpath = "//h4[@class='subheader']")
      WebElement verifyText;

    @FindBy(xpath="//div[contains(text(),'Your username is invalid!')]")
            WebElement errorText;

    @FindBy(xpath="//div[contains(text(),'Your password is invalid!')]")
            WebElement errorPassword;

  //  By emailField = By.id("username");
    //By passwordField = By.id("password");
   // By loginField = By.xpath("//i[contains(text(),'Login')]");
    // By verifyText = By.xpath("//h4[@class='subheader']");
    // By errorText = By.xpath("//div[contains(text(),'Your username is invalid!')]");
    // By errorPassword = By.xpath("//div[contains(text(),'Your password is invalid!')]");
    public void enterUserName(String name){
        sendTextToElement(emailField,name);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }
    public void clickOnLogin(){
        clickOnElement(loginField);
    }
    public String getTextToVerify(){
        return getTextFromElement(verifyText);
    }
    public String getErrorMessage(){
        return getTextFromElement(errorText);
    }
    public String getErrorPasswordMessage(){
        return getTextFromElement(errorPassword);
    }
}
