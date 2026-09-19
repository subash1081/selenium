package com.omrbranch.utitity;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.time.Duration;

import java.util.ArrayList;

import java.util.List;

import java.util.Properties;

import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.jspecify.annotations.Nullable;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	Select select;

	TakesScreenshot takesScreenshot;

	Actions actions;

	Alert alert;

	public byte[] screenshot() {

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		return screenshot;

	}

	public static void browserLaunch(String browserType) {

		switch (browserType) {

		case "CHROME":

			driver = new ChromeDriver();

			break;

		case "FIREFOX":

			driver = new FirefoxDriver();

			break;

		case "EDGE":

			driver = new EdgeDriver();

			break;

		case "SAFARI":

			driver = new SafariDriver();

			break;

		default:

			break;

		}

	}

	public static String getProjectPath() {

		String property = System.getProperty("user.dir");

		return property;

	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		properties.load(new FileInputStream(getProjectPath() + "\\src\\test\\resources\\config\\config.properties"));

		Object object = properties.get(key);

		String value = (String) object;

		return value;

	}

	public void sendKeysElementJS(WebElement element, String data) {

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	public void dismissAlert() {

		alert = driver.switchTo().alert();

		alert.dismiss();

	}

	public void acceptAlert() {

		alert = driver.switchTo().alert();

		alert.accept();

	}

	public void dragAndDropElement(WebElement sourceElement, WebElement destElement) {

		actions = new Actions(driver);

		actions.dragAndDrop(sourceElement, destElement).perform();

	}

	public void screenshot(File destFile, WebElement element) throws IOException {

		File sourceFile = element.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(sourceFile, destFile);

	}

	public void screenshot(File destFile) throws IOException {

		takesScreenshot = (TakesScreenshot) driver;

		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(sourceFile, destFile);

	}

	public void visibilityOfElement(WebElement element) {

		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driverWait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void implicitWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public void implicitWait(int secs) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));

	}

	public void switchToChildWindo() {

		String windowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String eachWindowId : windowHandles) {

			if (!windowHandle.equals(eachWindowId)) {

				driver.switchTo().window(eachWindowId);

				break;

			}

		}

	}

	public List<String> getAllOptionsTextFromDropdown(WebElement element) {

		List<String> allOptionsText = new ArrayList<String>();

		select = new Select(element);

		List<WebElement> options = select.getOptions();

		for (WebElement webElement : options) {

			String text = webElement.getText();

			allOptionsText.add(text);

		}

		return allOptionsText;

	}

	public String getTextElement(WebElement element) {

		String text = element.getText();

		return text;

	}

	public void selectOptionByIndex(WebElement element, int index) {

		select = new Select(element);

		select.selectByIndex(index);

	}

	public void selectOptionByValue(WebElement element, String text) {

		select = new Select(element);

		select.selectByValue(text);

	}

	public void selectOptionByText(WebElement element, String text) {

		select = new Select(element);

		select.selectByVisibleText(text);

	}

	public static void enterApplicationUrl(String url) {

		driver.get(url);

	}

	public static void maximizeWindow() {

		driver.manage().window().maximize();

	}

	public void sendKeysElement(WebElement element, String data) {

		if (isEnabledElement(element) && isDisplayedElement(element)) {

			clearTextBoxElement(element);

			element.sendKeys(data);

		}

	}

	public void sendKeysElementEnter(WebElement element, String data) {

		element.sendKeys(data, Keys.ENTER);

	}

	public void clickElement(WebElement element) {

		visibilityOfElement(element);

		if (isEnabledElement(element) && isDisplayedElement(element)) {

			element.click();

		}

	}

	public static void closeAllBrowser() {

		driver.quit();

	}

	public String getApplicationTitle() {

		@Nullable

		String title = driver.getTitle();

		return title;

	}

	public String getApplicationUrl() {

		@Nullable

		String currentUrl = driver.getCurrentUrl();

		return currentUrl;

	}

	public void clearTextBoxElement(WebElement element) {

		element.clear();

	}

	public WebElement findLocatorById(String attributeValue) {

		WebElement element = driver.findElement(By.id(attributeValue));

		return element;

	}

	public WebElement findLocatorByName(String attributeValue) {

		WebElement element = driver.findElement(By.name(attributeValue));

		return element;

	}

	public WebElement findLocatorByClassName(String attributeValue) {

		WebElement element = driver.findElement(By.className(attributeValue));

		return element;

	}

	public WebElement findLocatorByXpath(String exp) {

		WebElement element = driver.findElement(By.xpath(exp));

		return element;

	}

	public boolean isDisplayedElement(WebElement element) {

		boolean displayed = element.isDisplayed();

		return displayed;

	}

	public boolean isEnabledElement(WebElement element) {

		boolean displayed = element.isEnabled();

		return displayed;

	}

	public boolean isSelectedElement(WebElement element) {

		boolean displayed = element.isSelected();

		return displayed;

	}

	public String getDomPropertyValue(WebElement element) {

		@Nullable

		String domProperty = element.getDomProperty("value");

		return domProperty;

	}

	public String getDomPropertyValue(WebElement element, String attributeName) {

		@Nullable

		String domProperty = element.getDomProperty(attributeName);

		return domProperty;

	}

	public void orange() {
		System.out.println("orange is tasty");
	}

	public void apple() {
		System.out.println("apple is tasty");
	}

	public void pinapple() {
		System.out.println("pinapple is tasty");
	}

}
