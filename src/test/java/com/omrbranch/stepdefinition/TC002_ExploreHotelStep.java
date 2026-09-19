package com.omrbranch.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC002_ExploreHotelStep {


	@When("User search hotel {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userSearchHotelAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {

	}
	@Then("User should verify after search hotel success message {string}")
	public void userShouldVerifyAfterSearchHotelSuccessMessage(String string) {

	}
	

	@When("User search hotel {string}, {string}, {string}, {string}, {string} and {string}")
	public void userSearchHotelAnd(String string, String string2, String string3, String string4, String string5, String string6) {
	}


	@Then("User click Search button")
	public void userClickSearchButton() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("User should verify after search hotel error message {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyAfterSearchHotelErrorMessageAnd(String string, String string2, String string3, String string4, String string5, String string6) {
	    // Write code here that turns the phrase above into concrete actions
	}


	
	@When("User click sort from low to high")
	public void userClickSortFromLowToHigh() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("User should verify after sorting that prices are listed from low to high")
	public void userShouldVerifyAfterSortingThatPricesAreListedFromLowToHigh() {
	    // Write code here that turns the phrase above into concrete actions
	}
	

	
	@When("User click sort from descending order")
	public void userClickSortFromDescendingOrder() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("User should verify after sorting that names are listed in descending order")
	public void userShouldVerifyAfterSortingThatNamesAreListedInDescendingOrder() {
	    // Write code here that turns the phrase above into concrete actions
	}
	


	@When("User click Suite room type")
	public void userClickSuiteRoomType() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("User should verify after filtering that Suite room type is listed")
	public void userShouldVerifyAfterFilteringThatSuiteRoomTypeIsListed() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	
	@Then("User should verify the header contains {string}")
	public void userShouldVerifyTheHeaderContains(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}




















}
