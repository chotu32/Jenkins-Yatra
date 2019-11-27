package com.pageobjects;

//Importing packages
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilities.BaseClass;

public class YatraTravellerDetailsPageObject extends BaseClass {
	public WebDriver driver;

	public YatraTravellerDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Goibibo flights
	public static final By TITLE = By.id("Adulttitle1");
	public static final By FIRST_NAME = By.id("AdultfirstName1");
	public static final By LAST_NAME = By.id("AdultlastName1");
	public static final By EMAIL = By.id("email");
	public static final By MOBILE_NUMBER = By.id("mobile");
	public static final By PROCEED_PAYMENT_BTN = By.xpath("//button[@class='button orange col-md-3 fr large']");
	public static final By CONTACT_DETAILS = By
			.xpath("//span[@class='fl dib ico12 grey marginR5 borderAll brRadius5 padLR10 padTB5']");
	public static final By FROM_DATE_VALIDATION = By.id("fare_20180929");
	public static final By SET_GO_BTN_VALIDATION = By.xpath("//label[@class='fl']");
	public static final By BOOKING_VALIDATION = By
			.xpath("(//span[@class='blue fl padLR10 padT5 ico18'])[position()=1]");
	public static final By PROCEED_PAYMENT_VALIDATION = By.xpath("//span[@class='fl padLR10']");

	// to switch window
	public void swithWindow(WebDriver driver) {
		try {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to select title
	public void selectTitle(String title, WebDriver driver) {
		try {
			waitForExpectedElement(driver, TITLE);
			Select titleName = new Select(driver.findElement(TITLE));
			titleName.selectByVisibleText(title);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to enter first name
	public void sendFirstName(String firstName, WebDriver driver) {
		try {
			waitForExpectedElement(driver, FIRST_NAME);
			driver.findElement(FIRST_NAME).sendKeys(firstName);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to enter last name
	public void sendLastName(String lastName, WebDriver driver) {
		try {
			waitForExpectedElement(driver, LAST_NAME);
			driver.findElement(LAST_NAME).sendKeys(lastName);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to enter email
	public void sendEmail(String email, WebDriver driver) {
		try {
			waitForExpectedElement(driver, EMAIL);
			driver.findElement(EMAIL).sendKeys(email);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to enter mobile number
	public void sendMobileNumber(String mobileNumber, WebDriver driver) {
		try {
			waitForExpectedElement(driver, MOBILE_NUMBER);
			driver.findElement(MOBILE_NUMBER).sendKeys(mobileNumber);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to click proceed button
	public void clickProceedBtn(WebDriver driver) {
		try {
			waitForExpectedElement(driver, PROCEED_PAYMENT_BTN);
			driver.findElement(PROCEED_PAYMENT_BTN).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to display contact details on console
	public String[] getContactDetails(WebDriver driver) {
		//Declaration of string array
		String travellerDetails[] = new String[5];
		try {
			waitForExpectedElement(driver, CONTACT_DETAILS);
			List<WebElement> drop = driver.findElements(CONTACT_DETAILS);
			// List<WebElement> myElements = driver.findElements(mySelector);
			System.out.println();
			System.out.println("Contact Details Of Traveller : ");
			for (WebElement e : drop) {
				System.out.println(e.getText());
			}
			String str = driver.findElement(CONTACT_DETAILS).getText();
			System.out.println();
			System.out.println();
			// System.out.println(str);
			travellerDetails = str.split("[, ]+");
		} catch (Exception e) {
			e.getMessage();
		}
		return travellerDetails;
	}

	// to validate From Date
	public String fromDateValidation(WebDriver driver) {
		//Declaration of string variable
		String getText = null;
		try {
			waitForExpectedElement(driver, FROM_DATE_VALIDATION);
			getText = driver.findElement(FROM_DATE_VALIDATION).getText();
			// System.out.println("getting string : " + getText);
		} catch (Exception e) {
			e.getMessage();
		}
		return getText;
	}

	// to validate SetGo Button
	public String getSetGoBtnValidation(WebDriver driver) {
		//Declaration of string variable
		String getText = null;
		try {
			waitForExpectedElement(driver, SET_GO_BTN_VALIDATION);
			getText = driver.findElement(SET_GO_BTN_VALIDATION).getText();
			// System.out.println("getting string : " + getText);
		} catch (Exception e) {
			e.getMessage();
		}
		return getText;
	}

	// to validate Ticket Booking
	public String bookingValidation(WebDriver driver) {
		//Declaration of string variable
		String getText = null;
		try {
			waitForExpectedElement(driver, BOOKING_VALIDATION);
			getText = driver.findElement(BOOKING_VALIDATION).getText();
			// System.out.println("getting string : " + getText);
		} catch (Exception e) {
			e.getMessage();
		}
		return getText;
	}

	// to proceed button validation
	public String proceedBtnValidation(WebDriver driver) {
		//Declaration of string variable
		String getText = null;
		try {
			waitForExpectedElement(driver, PROCEED_PAYMENT_VALIDATION);
			getText = driver.findElement(PROCEED_PAYMENT_VALIDATION).getText();
			// System.out.println("getting string : " + getText);
		} catch (Exception e) {
			e.getMessage();
		}
		return getText;
	}

}