package com.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//SelFunc = new 

public class LoginStepDef {
	
	SeleniumFunctions sFun =  new SeleniumFunctions() ;
	
	@Given("^user is on Moneycontrol homepage$")
	public void user_is_on_Moneycontrol_homepage() throws Throwable {
		sFun.createDriver();
		sFun.isLoginpageDisplayed();
	}
	
	@When("^user enters the Userid \"(.*?)\"$")
	public void user_enters_the_Userid(String userID) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		sFun.enterUserID(userID);
	}

	@And("^user enters the Password \"(.*?)\"$")
	public void user_enters_the_Password(String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		sFun.enterPassword(password);
	}
	
	@And("^then hits the Login button$")
	public void then_hits_the_Login_button() throws Throwable {
		sFun.clickLoginButton();
	}
	@Then("^user is displayed login screen$")
	public void user_is_displayed_login_screen() throws Throwable {
		sFun.isUserLoggedIn();
		sFun.teardown();
	}

}
