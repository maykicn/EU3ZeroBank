package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityNavigationPage;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(1);

        LoginPage loginPage=new LoginPage();
        loginPage.signinButton.click();

        BrowserUtils.waitFor(1);

        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        loginPage.login(username,password);

    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        if(link.equalsIgnoreCase("Savings")){
            AccountActivityNavigationPage accountActivityNavigationPage=new AccountActivityNavigationPage();
            accountActivityNavigationPage.saving.click();
        }else if(link.equalsIgnoreCase("Brokerage")){
            AccountActivityNavigationPage accountActivityNavigationPage=new AccountActivityNavigationPage();
            accountActivityNavigationPage.brokerage.click();

        }else if(link.equalsIgnoreCase("Checking")){
            AccountActivityNavigationPage accountActivityNavigationPage=new AccountActivityNavigationPage();
            accountActivityNavigationPage.checking.click();

        }else if(link.equalsIgnoreCase("Loan")){
            AccountActivityNavigationPage accountActivityNavigationPage=new AccountActivityNavigationPage();
            accountActivityNavigationPage.loan.click();

        }else if(link.equalsIgnoreCase("credit card")){
            AccountActivityNavigationPage accountActivityNavigationPage=new AccountActivityNavigationPage();
            accountActivityNavigationPage.creditCard.click();

        }


    }



    @Then("the {string} should be displayed")
    public void the_should_be_displayed(String expectedPage) {
        BrowserUtils.waitForPageToLoad(3);
        String key=Driver.get().getCurrentUrl();

        String main="http://zero.webappsecurity.com/bank/";
        int firstIndex=main.length();
        int lastIndex=key.indexOf(".html");
        String actualPage=key.substring(firstIndex, lastIndex);

        String[] list=expectedPage.toLowerCase().split(" ");
        expectedPage=list[0]+"-"+list[1];

        Assert.assertEquals(expectedPage,actualPage);

    }


    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {

        AccountActivityNavigationPage accountActivityNavigationPage=new AccountActivityNavigationPage();
        Select accountOptions=new Select(accountActivityNavigationPage.accountDropdown);
        String actualOption=accountOptions.getFirstSelectedOption().getText();
        System.out.println("expectedOption = " + expectedOption);
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(expectedOption,actualOption);


    }


    }







