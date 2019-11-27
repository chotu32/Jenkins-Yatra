package com.pageobjects;

//Importing packages
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilities.BaseClass;

public class YatraPageObject extends BaseClass {
	public WebDriver driver;

	public YatraPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Goibibo flights
	public static final By FROM = By.id("gosuggest_inputSrc");
	public static final By TEXT_FROM = By.xpath("(//input[@aria-autocomplete='list'])[position()=1]");
	public static final By TO = By.id("gosuggest_inputDest");
	public static final By TEXT_TO = By.xpath("(//input[@aria-autocomplete='list'])[position()=2]");
	public static final By FROMDATE = By.xpath("(//i[@class = 'icon-calendar1 ico22 widgetCalIcon '])[position()=1]");
	public static final By TEXT_FROMDATE = By
			.xpath("(//input[@class='form-control inputTxtLarge widgetCalenderTxt'])[position()=1]");
	public static final By SELECTFROMDATE = By.id("fare_20181129");
	public static final By TODATE = By.xpath("(//i[@class = 'icon-calendar1 ico22 widgetCalIcon '])[position()=2]");
	public static final By SELECTTODATE = By.id("fare_20181030");
	public static final By SEARCHBUTTON = By.id("gi_search_btn");
	public static final By ALLFLIGHTS = By.id("showAllFlights");
	public static final By PRICELIST = By.xpath("//span[@class='ico22 fr fb']");
	public static final By RIGHT_ARROW_FIRST = By
			.xpath("(//i[@class='fl black ico14 padT1 padL3 icon-arrow-right'])[position()=1]");
	public static final By RIGHT_ARROW_SECOND = By.xpath("(//div[@class='slider-decorator-1'])[position()=2]");
	public static final By BOTTOMSCROLL = By.xpath("(//p[@class='ico14 fb'])[position()=1]");
	public static final By BOOKING_LIST = By.xpath("//input[@class='button orange fr ']");
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

	public void sendSourcePlace(String sourcePlace, WebDriver driver) {

		try {
			waitForExpectedElement(driver, FROM);
			driver.findElement(FROM).sendKeys(sourcePlace);
			WebElement textbox = driver.findElement(FROM);
			// Wait for 2 Seconds
			Thread.sleep(2000);
			textbox.sendKeys(Keys.ARROW_DOWN);
			// driver.findElement(FROM).sendKeys(sourcePlace, Keys.ARROW_DOWN,
			// Keys.ENTER);
			// Wait for 2 Seconds
			Thread.sleep(2000);
			textbox.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String getTextFromsource(WebDriver driver) {
		String source = null;
		try {
			waitForExpectedElement(driver, TEXT_FROM);
			WebElement textbox = driver.findElement(TEXT_FROM);
			source = textbox.getAttribute("value");
		} catch (Exception e) {
			e.getMessage();
		}
		return source;
	}

	public void sendDestinationPlace(String destinationPlace, WebDriver driver) {
		try {
			waitForExpectedElement(driver, TO);
			// driver.findElement(TO).click();
			driver.findElement(TO).sendKeys(destinationPlace);
			WebElement textbox = driver.findElement(TO);
			// Wait for 2 Seconds
			Thread.sleep(2000);
			textbox.sendKeys(Keys.ARROW_DOWN);
			// Wait for 2 Seconds
			Thread.sleep(2000);
			textbox.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to get destination place
	public String getTextFromDestination(WebDriver driver) {
		String source = null;
		try {
			waitForExpectedElement(driver, TEXT_TO);
			WebElement textbox = driver.findElement(TEXT_TO);
			source = textbox.getAttribute("value");
		} catch (Exception e) {
			e.getMessage();
		}
		return source;
	}

	// to click from date
	public void clickFromDate(WebDriver driver) {
		try {
			waitForExpectedElement(driver, FROMDATE);
			driver.findElement(FROMDATE).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to get from date
	public String getTextFromDate(WebDriver driver) {
		String fromDate = null;
		try {
			waitForExpectedElement(driver, TEXT_FROMDATE);
			WebElement textbox = driver.findElement(TEXT_FROMDATE);
			Thread.sleep(2000);
			fromDate = textbox.getAttribute("value");
		} catch (Exception e) {
			e.getMessage();
		}
		return fromDate;
	}

	// to select from date
	public String selectFromDate(WebDriver driver) {
		String getDate = null;
		try {
			waitForExpectedElement(driver, SELECTFROMDATE);
			driver.findElement(SELECTFROMDATE).click();
			Thread.sleep(2000);
			getDate = driver.findElement(SELECTFROMDATE).getText();
		} catch (Exception e) {
			e.getMessage();
		}
		return getDate;
	}

	// to click To Date
	public void clickToDate(WebDriver driver) {
		try {
			waitForExpectedElement(driver, TODATE);
			driver.findElement(TODATE).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to select To Date
	public void selectToDate(WebDriver driver) {
		try {
			waitForExpectedElement(driver, SELECTTODATE);
			driver.findElement(SELECTTODATE).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to click search button
	public void clickSearchBtn(WebDriver driver) {
		try {
			waitForExpectedElement(driver, SEARCHBUTTON);
			driver.findElement(SEARCHBUTTON).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to click on all flights button
	public void clickViewAllFightsBtn(WebDriver driver) {
		try {
			waitForExpectedElement(driver, ALLFLIGHTS);

			WebElement element = driver.findElement(ALLFLIGHTS);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(5000);
			driver.findElement(ALLFLIGHTS).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to click on arrow button
	public void clickFirstArrow(WebDriver driver) {
		try {
			waitForExpectedElement(driver, RIGHT_ARROW_FIRST);

			WebElement element = driver.findElement(RIGHT_ARROW_FIRST);
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// element);
			Thread.sleep(5000);
			element.click();
			Thread.sleep(5000);
			element.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to click on arrow button
	public void clickSecondtArrow(WebDriver driver) {
		try {
			waitForExpectedElement(driver, RIGHT_ARROW_SECOND);
			WebElement element = driver.findElement(RIGHT_ARROW_SECOND);
			Thread.sleep(5000);
			element.click();
			Thread.sleep(5000);
			element.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to scroll upto element found
	public void bottomScroll(WebDriver driver) {
		try {
			waitForExpectedElement(driver, BOTTOMSCROLL);
			WebElement element = driver.findElement(BOTTOMSCROLL);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to get price list
	public int[] getPriceList(WebDriver driver) {
		int ar[] = new int[2];
		try {
			waitForExpectedElement(driver, PRICELIST);
			List<WebElement> drop = driver.findElements(PRICELIST);

			System.out.println();
			System.out.println();
			String[] string = new String[drop.size()];
			System.out.println("Original Array Size : " + string.length);
			int j = 0;
			String temp;
			String emptyStr = "";
			int count = 0;
			// Storing List of text elements into String array
			for (WebElement a : drop) {
				temp = a.getText();
				if (temp.equals(emptyStr)) {
					count++;
					continue;
				} else {
					string[j] = temp.replace(",", "");
					j++;
				}
			}
			System.out.println("Count Value : " + count);
			String[] trimString = new String[drop.size() - count];
			System.out.println("Trim String Size : " + trimString.length);
			// to store without null values
			for (int i = 0; i < trimString.length; i++) {
				trimString[i] = string[i];
				// System.out.println("Trim String " + i + " Position Value : "
				// + trimString[i]);
			}
			int intrArray[] = new int[trimString.length];
			System.out.println("Size Of numArray : " + intrArray.length);
			// to convert string values into integer value and assigned that
			// value into intArray
			for (int i = 0; i < intrArray.length; i++) {
				intrArray[i] = Integer.parseInt(trimString[i]);
				// System.out.println(intrArray[i]);
			}
			System.out.printf("Unsorted arr[] : %s", Arrays.toString(intrArray));
			System.out.println();
			// to sort intrArray values in ascending order
			Arrays.sort(intrArray);
			System.out.printf("Sorted arr[] : %s", Arrays.toString(intrArray));
			System.out.println();
			System.out.println("Lowest Flight Rate is : " + intrArray[0]);
			ar[0] = intrArray[0];
			ar[1] = intrArray[intrArray.length - 1];
			// int x = intrArray[ intrArray.length - 1 ];
			System.out.println("Highest Flight Rate is : " + intrArray[intrArray.length - 1]);
		} catch (Exception e) {
			e.getMessage();
		}
		return ar;
	}

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

	// to select highest flight ticket
	public String highestFlightTicketSelect(WebDriver driver) {
		String max = null;
		try {
			waitForExpectedElement(driver, BOOKING_LIST);
			List<WebElement> drop = driver.findElements(BOOKING_LIST);
			WebElement e = drop.get(drop.size() - 1);
			e.click();
			// System.out.println("Highest ticket : " + e.getText());
		} catch (Exception e) {
			e.getMessage();
		}
		return max;
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
	public void getContactDetails(WebDriver driver) {
		try {
			waitForExpectedElement(driver, CONTACT_DETAILS);
			List<WebElement> drop = driver.findElements(CONTACT_DETAILS);
			// List<WebElement> myElements = driver.findElements(mySelector);
			System.out.println();
			System.out.println("Contact Details Of Traveller : ");
			for (WebElement e : drop) {
				System.out.println(e.getText());
			}
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// to validate From Date
	public String fromDateValidation(WebDriver driver) {
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