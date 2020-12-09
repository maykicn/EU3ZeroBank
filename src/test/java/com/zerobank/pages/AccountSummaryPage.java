package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public  class AccountSummaryPage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//div[@class='offset2 span8']")
    public WebElement accountTypes;


    @FindBy(xpath = "(//h2[@class='board-header'])[1]")
    public WebElement cashAccounts;

    @FindBy(xpath = "(//h2[@class='board-header'])[2]")
    public WebElement investmentAccounts;

    @FindBy(xpath = "(//h2[@class='board-header'])[3]")
    public WebElement creditAccounts;

    @FindBy(xpath = "(//h2[@class='board-header'])[4]")
    public WebElement loanAccounts;






}
