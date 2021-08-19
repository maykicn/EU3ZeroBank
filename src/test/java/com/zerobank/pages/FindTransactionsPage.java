package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindTransactionsPage extends BasePage {
    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//a[contains(.,'Find')]")
    public WebElement findTransactionsTab;



    @FindBy(xpath="//input[@id='aa_fromDate']")
    public WebElement dateFromInput;

    @FindBy(xpath="//input[@id='aa_toDate']")
    public WebElement dateToInput;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement findButton;


    @FindBy(xpath="//div[@id='filtered_transactions_for_account']/table/tbody/tr")
    public List<WebElement> tableRow;

    @FindBy(xpath=" //input[@id='aa_description']")
    public WebElement descriptionInput;

    @FindBy(xpath="//option[@value='DEPOSIT']")
    public WebElement optionDeposit;

    @FindBy(xpath="//option[@value='WITHDRAWAL']")
    public WebElement optionWithdrawal;




















}
