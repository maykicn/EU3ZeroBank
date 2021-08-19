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
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {

        String date;
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        for(int i=1;i<=findTransactionsPage.tableRow.size();i++){

            WebElement dateColoumn=Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr["+i+"]/td[1]"));
            date=dateColoumn.getText();
            Assert.assertTrue(findTransactionsPage.dateIsBetween(date,from,to));
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
        findTransactionsPage.isContainInTable(date);

    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();

        findTransactionsPage.descriptionInput.sendKeys(string);
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        boolean flag=true;
        String key;
        int size;
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        size=findTransactionsPage.tableRow.size();
        if(size==0){
            flag=false;
        }

        for (int i = 1; i <= size; i++) {
           key= Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr["+i+"]/td[2]")).getText();
           key=key.substring(0,string.length());
           System.out.println("key = " + key);
            if(!key.equals(string)){
               flag=false;

           }

        }
         Assert.assertTrue(flag);

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        int size = findTransactionsPage.tableRow.size();
        boolean flag = false;
        String key;

        for (int i = 1; i <= size; i++) {
            key = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr[" + i + "]/td[2]")).getText();
            key = key.substring(0, string.length());
            if (key.equals(string)) {
                flag = true;

            }

        }
        Assert.assertFalse(flag);


    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        int size;

        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        size=findTransactionsPage.tableRow.size();

        /*for (int i = 1; i <= size; i++) {
            key = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr[" + i + "]/td[2]")).getText();
            key = key.substring(0, string.length());
            if (key.equals(string)) {
                flag = true;

            }

        }*/









        if(Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr[2]/td[3]")).getText().equals("")){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        /*




        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        findTransactionsPage.optionDeposit.click();
        System.out.println("\"secildi\" = " + "secildi");*/


    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
