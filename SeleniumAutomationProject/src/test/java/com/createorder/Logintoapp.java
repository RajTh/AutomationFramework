package com.createorder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logintoapp extends SetUp {

	//WebDriver driver;
	String casualdressamount;

	@Test(priority = 1)
	public void Selectorders() throws InterruptedException {
		Thread.sleep(2000);
		WebElement accountlist = driver.findElement(By.xpath(prop.getProperty("Selectwomen")));

		Actions act = new Actions(driver);

		act.moveToElement(accountlist).perform();

		Thread.sleep(2000);
		// Click on Casual dresses
		driver.findElement(By.xpath(prop.getProperty("Selectcasualdress"))).click();


		// Printed Dress
		WebElement printeddress = driver.findElement(By.xpath(prop.getProperty("Hoverprintdress")));
		Actions pd = new Actions(driver);
		pd.moveToElement(printeddress).perform();

		Thread.sleep(2000);
		// Store the amount and Add to cart
		casualdressamount = driver.findElement(By.xpath(prop.getProperty("productprice"))).getText();
		System.out.println(casualdressamount);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Addtocart"))).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("proceedtocheckout_1"))).click();

		
		// Verify the amount
		String verifycasualdressamount = driver.findElement(By.id(prop.getProperty("total_price"))).getText();
		System.out.println(verifycasualdressamount);
		
		if(casualdressamount.equals(verifycasualdressamount)){
	        System.out.println("Amount Equal");
	    }
	        else {
	            System.out.println("Amount not equal");
	        }

		driver.findElement(By.xpath(prop.getProperty("proceedtocheckout_2"))).click();

	}

	@Test(priority = 2)
	public void siginapp() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath(prop.getProperty("signinemail"))).sendKeys("thodetirajesh086@gmail.com");
		driver.findElement(By.name(prop.getProperty("signinpassword"))).sendKeys("Test@1234");
		driver.findElement(By.xpath(prop.getProperty("signinsubmit"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("proceedtocheckout_3"))).click();

	}

	@Test(priority = 3)
	public void shipping() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.name(prop.getProperty("agreeterms"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(prop.getProperty("proceedtocheckout_4"))).click();

	}
	@Test(priority = 4)

	public void payment() throws InterruptedException {
		Thread.sleep(1000);
		// Payment
		driver.findElement(By.xpath(prop.getProperty("Paybybankwire"))).click();
		Thread.sleep(1000);
		// Confirm Payment
		driver.findElement(By.xpath(prop.getProperty("confirmmyorder"))).click();
		Thread.sleep(1000);

		// Order complete status

		String ordercompletestatus = driver
				.findElement(By.xpath(prop.getProperty("orderstatus"))).getText();
		System.out.println(ordercompletestatus);

	}

}
