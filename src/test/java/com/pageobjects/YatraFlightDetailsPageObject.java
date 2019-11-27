package com.pageobjects;
//Importing packages
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.BaseClass;

public class YatraFlightDetailsPageObject extends BaseClass {
	public WebDriver driver;

	public YatraFlightDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Goibibo flights
	public static final By ALLFLIGHTS = By.id("showAllFlights");
	public static final By PRICE_BTN = By.id("sortByPriceOnw");
	public static final By PRICELIST = By.xpath("//span[@class='ico22 fr fb']");
	public static final By RIGHT_ARROW_FIRST = By
			.xpath("(//i[@class='fl black ico14 padT1 padL3 icon-arrow-right'])[position()=1]");
	public static final By RIGHT_ARROW_SECOND = By.xpath("(//div[@class='slider-decorator-1'])[position()=2]");
	public static final By BOTTOMSCROLL = By.xpath("(//p[@class='ico14 fb'])[position()=1]");
	public static final By BOOKING_LIST = By.xpath("//input[@class='button orange fr ']");
	public static final By SET_GO_BTN_VALIDATION = By.xpath("//label[@class='fl']");
	public static final By BOOKING_VALIDATION = By
			.xpath("(//span[@class='blue fl padLR10 padT5 ico18'])[position()=1]");
	public static final By PROCEED_PAYMENT_VALIDATION = By.xpath("//span[@class='fl padLR10']");

	// to click on all flights button
	public void clickViewAllFightsBtn(WebDriver driver) {
		try {
			waitForExpectedElement(driver, ALLFLIGHTS);
			WebElement element = driver.findElement(ALLFLIGHTS);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView();", element);
			//Wait for 5 Seconds
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

			/*
			 * ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);",
			 * element);
			 */
			//Wait for 5 Sec
			Thread.sleep(5000);
			element.click();
			//Wait for 5 Sec
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
			//Wait for 5 Sec
			Thread.sleep(5000);
			element.click();
			//Wait for 5 Sec
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

	// to click on price
	public void clickOnPrice(WebDriver driver) {
		try {
			waitForExpectedElement(driver, PRICE_BTN);
			WebElement element = driver.findElement(PRICE_BTN);
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

			// System.out.println();
			// System.out.println();
			String[] string = new String[drop.size()];
			// System.out.println("Original Array Size : " + string.length);
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

			// System.out.println("Count Value : " + count);

			String[] trimString = new String[drop.size() - count];

			// System.out.println("Trim String Size : " + trimString.length);
			// to store without null values
			for (int i = 0; i < trimString.length; i++) {
				trimString[i] = string[i];
				// System.out.println("Trim String " + i + " Position Value : "
				// + trimString[i]);
			}

			int intrArray[] = new int[trimString.length];

			// System.out.println("Size Of numArray : " + intrArray.length);
			// to convert string values into integer value and assigned that
			// value into intArray
			for (int i = 0; i < intrArray.length; i++) {
				intrArray[i] = Integer.parseInt(trimString[i]);
				// System.out.println(intrArray[i]);
			}

			// System.out.printf("Unsorted arr[] : %s",
			// Arrays.toString(intrArray));
			System.out.println();
			// to sort intrArray values in ascending order
			Arrays.sort(intrArray);

			// System.out.printf("Sorted arr[] : %s",
			// Arrays.toString(intrArray));
			System.out.println();
			System.out.println("Lowest Flight Rate is : " + intrArray[0]);
			ar[0] = intrArray[0];
			ar[1] = intrArray[intrArray.length - 1];
			// int x = intrArray[ intrArray.length - 1 ];
			System.out.println("Highest Flight Rate is : " + intrArray[intrArray.length - 1]);
			System.out.println();
			System.out.println();
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
			// WebElement e = drop.get(drop.size() - 1);
			WebElement e = drop.get(0);
			e.click();
			// System.out.println("Highest ticket : " + e.getText());
		} catch (Exception e) {
			e.getMessage();
		}
		return max;
	}
	// to select title

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