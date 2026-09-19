package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC001_LoginStep {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {
	}

	@When("User enters {string} and {string}")
	public void userEntersAnd(String mailId, String password) {
		pom.getLoginPage().login(mailId, password);
	}

	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expLoginMessage) {
		String actLoginMessageText = pom.getExploreHotelPage().getLoginMessageText();
	
	Assert.assertEquals("Verify After Login", expLoginMessage, actLoginMessageText);
	}

	@When("User enters {string} and {string} with enter key")
	public void userEntersAndWithEnterKey(String mailId, String password) {
		  pom.getLoginPage().loginUsingEnterKey(mailId, password);
	}

	@Then("User should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expErrorMessage) {
		String actErrorMessageText = pom.getLoginPage().getLoginErrorMessageText();
		boolean contains = actErrorMessageText.contains(expErrorMessage);
		Assert.assertTrue("verify error message",contains);
	}

}