package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactionsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;


public class FindTransactionsDefs {



    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        findTransactionsPage.findTransactionsTab.click();
        System.out.println("\"bitti\" = " + "bitti");
    }





    @When("^the user enters date range from (.*) to (.*)$")
    public void the_user_enters_date_range_from_to(@Format("yyyy-MM-dd") Date from, @Format("yyyy-MM-dd") Date to) {

        System.out.println("calisti");
    }

    @When("clicks search")
    public void clicks_search() {

    }

    @Then("results table should only show transactions dates between “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void results_table_should_only_show_transactions_dates_between_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {


    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {


    }

    @Then("the results table should only not contain transactions dated “{int}-{int}-{int}”")
    public void the_results_table_should_only_not_contain_transactions_dated(Integer int1, Integer int2, Integer int3) {


    }





}
