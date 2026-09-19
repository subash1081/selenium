package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.omrbranch.utitity.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {

		PageFactory.initElements(driver, this);

		}

		@FindBy(id = "email")

		private WebElement txtEmailId;
		@FindBy(id = "pass")

		private WebElement txtPassword;

		@FindBy(xpath = "//button[@value='login']")

		private WebElement btnLogin;

		@FindBy(id = "errorMessage")

		private WebElement textLoginErrorMessage;




		public void login(String emailId, String password) {
			sendKeysElement(txtEmailId, emailId);
			sendKeysElement(txtPassword, password);
			clickElement(btnLogin);
			
		}




		public void loginUsingEnterKey(String emailId, String password) {
			sendKeysElement(txtEmailId, emailId);
			sendKeysElementEnter(txtPassword, password);

		}

		public String getLoginErrorMessageText() {
			String textElement = getTextElement(textLoginErrorMessage);
			return textElement;

		//return String

		}




		}
	

