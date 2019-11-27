package com.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public ExtentTest test;
	public ExtentReports reports;
	// store current working directory path with "user.dir"
	public static String projectPath = System.getProperty("user.dir");
	public String reportFilePath;

	public ExtentTest reportsFile(String testCaseName) {
		reportFilePath = projectPath + "/Reports/GoibiboExtentReport.html";
		// "false" parameter is for generate newly .html file
		reports = new ExtentReports(reportFilePath, false); // "true" parameter is for override on same .html file
		test = reports.startTest(testCaseName);
		return test;
	}
	// to end the report
	public void endReport() {
		reports.endTest(test);
		// flush() - to write or update test information to your report.
		reports.flush();
	}
	// to take the screenshot
	public static String captureScreenshot(WebDriver driver, String screenshotname) {

		try {
			// Set the Current Date and Time
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			System.out.println(dateFormat.format(dt));

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// The below method will save the screen shot in given path with
			// name "screenshotname.png"
			FileUtils.copyFile(source, new File(
					projectPath + "/ScreenShots/" + dateFormat.format(dt) + "_" + screenshotname + ".png"));
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("exception while taking screenshot" + e.getMessage());
		}
		return screenshotname;
	}
}