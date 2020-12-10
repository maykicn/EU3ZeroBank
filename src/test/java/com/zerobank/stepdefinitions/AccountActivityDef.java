package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class AccountActivityDef {

    @When("the user click on {string}")
    public void the_user_click_on(String string) {

        AccountActivityPage accountActivityPage= new AccountActivityPage();
        BrowserUtils.waitForPresenceOfElement(By.xpath("//li[@id='account_activity_tab']/a"),2);
        accountActivityPage.accountActivityTab.click();

    }


}
