package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryDefs {



    @Then("page should have the title {string}")
    public void page_should_have_the_title(String string) {
        String actualTitle=string;
        String expectedTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account types should be {string}")
    public void account_types_should_be(String expectedType) {


        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        String actualType;
        switch (expectedType){
            case "Cash Accounts":
                BrowserUtils.waitFor(2);
                actualType=accountSummaryPage.cashAccounts.getText();
                Assert.assertEquals(expectedType,actualType);
                System.out.println("expectedType = " + expectedType);
                break;


            case "Credit Accounts":
                BrowserUtils.waitFor(2);
                actualType=accountSummaryPage.creditAccounts.getText();
                Assert.assertEquals(expectedType,actualType);
                System.out.println("expectedType = " + expectedType);
                break;

            case "Investment Accounts":
                BrowserUtils.waitFor(2);
                actualType=accountSummaryPage.investmentAccounts.getText();
                Assert.assertEquals(expectedType,actualType);
                System.out.println("expectedType = " + expectedType);
                break;


            case "Loan Accounts":
                BrowserUtils.waitFor(2);
                actualType=accountSummaryPage.loanAccounts.getText();
                Assert.assertEquals(expectedType,actualType);
                System.out.println("expectedType = " + expectedType);
                break;


        }
        





    }




}
