package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomerTest1 extends TestBase{
	
	@Test
	public void addCustomer1() throws InterruptedException
	{
		
		log.debug("Inside Addcustomer1 Test");
		
		driver.findElement(By.cssSelector(OR.getProperty("addcustbtn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys("Bhawna");
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys("Saini");
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys("A3A4A6");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(OR.getProperty("addcustomer"))).click();
	
		driver.switchTo().alert().accept();
		
		log.debug("Addcustomer1 executed successfully");
	}
	

}
