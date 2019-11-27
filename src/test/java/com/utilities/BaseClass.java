package com.utilities;

//Importing packages
//import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	// private String frameworkDir = System.getProperty("user.dir");
	// private String webDriverPath = frameworkDir + File.separator +
	// "resources" + File.separator + "chromedriver.exe";
	// create instance for webdriver
	public WebDriver driver;

	// to launch chrome browser
	public void launchBrowser(String url) {
		// declaration and instantiation of objects/variables
		// System.setProperty("webdriver.chrome.driver", webDriverPath);
		WebDriverManager.chromedriver().setup();
		// create the new instance of Chrome drive
		driver = new ChromeDriver();
		// comment the above 2 lines and uncomment below 2 lines to use firefox
		// System.setProperty("webdriver.firefox.marionette","D:\\Centrallibrary\\Drivers\\geckodriver.exe");
		// driver=new FirefoxDriver();
		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// launch chrome and direct it to the Base URL
		driver.get(url);
	}

	// Explicit wait method for element clickable
	public WebElement waitForExpectedElement(WebDriver driver, final By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
