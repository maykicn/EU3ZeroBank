package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.security.auth.login.LoginContext;
import java.util.Map;

public class LoginStepDefs {


    @Given("the user  is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
        LoginPage loginPage=new LoginPage();
        loginPage.signinButton.click();

    }

    @When("user logs in  with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }

    @Then("Account summary page should be displayed.")
    public void account_summary_page_should_be_displayed() {
        BrowserUtils.waitFor(2);

        String  title=Driver.get().getTitle();

        String actualTitle=title.substring(title.indexOf('A'));
        String expectedTitle="Account Summary";
        Assert.assertEquals(expectedTitle,actualTitle);
    }



    @When("user logs in following wrong credential {string} {string}")
    public void user_logs_in_following_wrong_credential(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);


    }


    @Then("error message {string} should be displayed.")
    public void error_message_should_be_displayed(String expectedError) {
        LoginPage loginPage=new LoginPage();
        String actualError=loginPage.alertError.getText();
        Assert.assertEquals(expectedError,actualError);
        System.out.println("PASSES");


    }







}
