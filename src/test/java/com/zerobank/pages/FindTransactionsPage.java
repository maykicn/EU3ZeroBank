package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionsPage {
    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//a[contains(.,'Find')]")
    public WebElement findTransactionsTab;



    @FindBy(xpath="//input[@id='aa_fromDate']")
    public WebElement dateFromInput;







}
