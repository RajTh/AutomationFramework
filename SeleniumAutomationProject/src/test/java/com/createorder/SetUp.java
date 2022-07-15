package com.createorder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetUp {
	WebDriver driver;
	FileInputStream fis;
	Properties prop =  new Properties();
	
	@BeforeClass
	public void Initalization() throws IOException
	{
		fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
		
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get(prop.getProperty("QA_URL"));
		
		driver.manage().window().maximize(); //maximize the window
		
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void CleanUp()
	{
		driver.quit();
	}

}
