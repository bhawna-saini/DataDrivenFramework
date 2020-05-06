package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;


public class OpenAccountTest extends TestBase {
	


	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void openAccountTest(String customer, String curreny)
	{
	
		driver.findElement(By.cssSelector(OR.getProperty("openaccount_CSS"))).click();
		dropdown = driver.findElement(By.cssSelector(OR.getProperty("customer_CSS")));
		Select select = new Select(dropdown);
		select.selectByVisibleText(customer);
		dropdown = driver.findElement(By.cssSelector(OR.getProperty("currency_CSS")));
		Select select1 = new Select(dropdown);
		select1.selectByVisibleText(curreny);
		driver.findElement(By.cssSelector(OR.getProperty("process_CSS"))).click();
		
		driver.switchTo().alert().accept();
		
	}	
}