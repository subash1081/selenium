package com.omrbranch.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;



import com.omrbranch.utitity.BaseClass;



public class ExploreHotelPage extends BaseClass {

public ExploreHotelPage() {

PageFactory.initElements(driver, this);

}



@FindBy(xpath = "//a[@data-testid='username']")

private WebElement textLoginMessage;



public String getLoginMessageText() {
	String welcomeMessage = getTextElement(textLoginMessage);
	return welcomeMessage;
}


//
//public void loginUsingEnterKey() {
//	// TODO Auto-generated method stub
//	
//}



}