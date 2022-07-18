package com.smoketest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest extends SetUp {

	@Test(priority = 1)
	public void SelectDropDown() throws InterruptedException {

		// WebDriver driver;
		WebElement seldropbox = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(seldropbox);

		sel.selectByIndex(4); // least priority
		Thread.sleep(2000);
		sel.selectByValue("search-alias=luggage-intl-ship");

		sel.selectByVisibleText("Prime Video");
		

	}

	@Test(priority = 2 , dependsOnMethods ="SelectDropDown" )
	public void AdvanceDropDown() {

		WebElement seldropbox = driver.findElement(By.id(prop.getProperty("SelectDropDownBox_id")));

		Select sel = new Select(seldropbox);

		List<WebElement> li = sel.getOptions();
		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {
			li.get(i).click();
			System.out.println(li.get(i).getText());
		}

	}

}
