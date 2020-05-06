package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
  @Test
  public void bankManagerLoginTest() throws InterruptedException{
	  
	  log.debug("Inside Login Test");
	  driver.findElement(By.cssSelector(OR.getProperty("bmlbtn"))).click();
	  Thread.sleep(3000);
	  
	  Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addcustbtn"))), "Login not successful");
	  
	  log.debug("Login successfully executed");
	  Reporter.log("Login successfully executed"); //now this message will appear in reportNG
	  
	  //Assert.fail("Loginfail");
	  
  }
}
