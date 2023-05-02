package com.selenium_with_java_testNG.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	@Test
	public void login_with_valid_cerdentials() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys("tt5820724@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("azerty@@123");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		driver.quit();
		}
	@Test
	public void login_with_invalid_cerdentials() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.nopcommerce.com/");
			driver.findElement(By.xpath("//a[@class='ico-login']")).click();
			driver.findElement(By.id("Email")).sendKeys("tt5820724@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("azerty@@");
			driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
			
			String warningMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
			String expectedWornigMessage = "Login was unsuccessful. Please correct the errors and try again.";
			Assert.assertTrue(warningMessage.contains(expectedWornigMessage),"Expected Worning message is not displayed");				
			driver.quit();
	
	}
	
}
