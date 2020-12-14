package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityDefs {

    @When("the user click on {string}")
    public void the_user_click_on(String tab) {
        if(tab.equalsIgnoreCase("Account Activity")){

            AccountActivityPage accountActivityPage= new AccountActivityPage();
            BrowserUtils.waitForPresenceOfElement(By.xpath("//li[@id='account_activity_tab']/a"),2);
            accountActivityPage.accountActivityTab.click();

        }



    }

    @Then("Account dropdown default option should be {string}")
    public void account_dropdown_default_option_should_be(String expectedOption) {
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        Select accountOptions=new Select(accountActivityPage.accountDropdown);
        String actualOption=accountOptions.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption);
    }

    @Then("Account drop down should have")
    public void account_drop_down_should_have(List<String> expectedOptions) {
        List<String> actualList = new ArrayList<String>();
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        Select accountOptions=new Select(accountActivityPage.accountDropdown);
        List<WebElement> options = accountOptions.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            actualList.add(option.getText());
        }
        Assert.assertEquals(expectedOptions,actualList);

    }


    @Then("Transactions table should have")
    public void transactions_table_should_have(List<String> expectedTransactionsTableHeader) {
        List<String> actualTransactionsTableHeader=new ArrayList<>();
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        List<WebElement> headerList=Driver.get().findElements(By.xpath("//div[@id='all_transactions_for_account']/table//th"));
        for (WebElement header : headerList) {

            actualTransactionsTableHeader.add(header.getText());
        }

        Assert.assertEquals(expectedTransactionsTableHeader,actualTransactionsTableHeader);




        /*




        for (String expectedTableHeader : expectedTransactionsTableHeader) {
            System.out.println("expectedTableHeader = " + expectedTableHeader);




        System.out.println("**************************************");
        for (String actualTableHeader : actualTransactionsTableHeader) {
            System.out.println("actualTableHeader = " + actualTableHeader);
        }*/


        /* */




    }





}
