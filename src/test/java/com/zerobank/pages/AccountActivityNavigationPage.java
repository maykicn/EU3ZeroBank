package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountActivityNavigationPage {

    public AccountActivityNavigationPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//a[contains(.,'Savings')]")
    public WebElement saving;

    @FindBy(xpath = "//a[contains(.,'Brokerage')]")
    public WebElement brokerage;

    @FindBy(xpath = "//a[contains(.,'Checking')]")
    public WebElement checking;

    @FindBy(xpath = "//a[contains(.,'Loan')]")
    public WebElement loan;








    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountDropdown;







}
