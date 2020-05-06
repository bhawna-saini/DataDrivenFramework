package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass= TestUtil.class, dataProvider="dp" )
	public void addCustomerTest(String firstName, String lastName, String postCode) throws InterruptedException
	{
		
		driver.findElement(By.cssSelector(OR.getProperty("addcustbtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addcustomer"))).click();
		
	Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}
	
}
