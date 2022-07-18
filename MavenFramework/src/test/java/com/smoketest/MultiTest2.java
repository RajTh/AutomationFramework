package com.smoketest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MultiTest2 extends SetUp {
	
	

	@Test
	public void MouseHovering() throws InterruptedException
	{

		
		
		
		
		WebElement accountlist = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(accountlist).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Account']")).click();
		
	}
	
	@Test
	public void AmazonList() throws InterruptedException
	{

       
		
		
		WebDriverWait myWaitVar = new WebDriverWait(driver,Duration.ofSeconds(20));
	       
	    myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchDropdownBox")));
	       
	    
        driver.findElement(By.id("searchDropdownBox")).click();

        WebElement accountlist = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(accountlist).perform();
		
		Thread.sleep(2000);
		List<WebElement> li =driver.findElements(By.xpath("//a[@class='nav-link nav-item']"));
		
		for(int i = 0 ; i<li.size();i++)
		{ 
			System.out.println(li.get(i).getText());
		}
		
		
	}

}
