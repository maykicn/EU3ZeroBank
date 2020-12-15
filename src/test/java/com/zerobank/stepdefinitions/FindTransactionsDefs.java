package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FindTransactionsDefs {



    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        findTransactionsPage.findTransactionsTab.click();

            }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        findTransactionsPage.dateFromInput.sendKeys(from);
        findTransactionsPage.dateToInput.sendKeys(to);


    }

    @When("clicks search")
    public void clicks_search() {
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        findTransactionsPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {

        String date;
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        for(int i=1;i<=findTransactionsPage.tableRow.size();i++){

            WebElement dateColoumn=Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr["+i+"]/td[1]"));
            date=dateColoumn.getText();
            Assert.assertTrue(findTransactionsPage.isBetween(date,from,to));
        }



    }



    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {


     FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
     findTransactionsPage.mostRecentDate();

    }





    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {


        BrowserUtils.waitFor(2);

        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        findTransactionsPage.isContain(date);

    }






}
