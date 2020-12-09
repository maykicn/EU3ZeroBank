package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//button[@id='signin_button']")
    public WebElement signinButton;

    @FindBy(xpath="//input[@id='user_login']")
    public WebElement login;


    @FindBy(xpath="//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement sign_in;

    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement alertError;


    public void login(String userNameStr, String passwordStr) {
        login.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        BrowserUtils.waitFor(2);
        sign_in.click();
        // verification that we logged
    }


}