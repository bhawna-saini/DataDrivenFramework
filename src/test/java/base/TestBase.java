package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExcelReader;
import utilities.ExtentManager;

public class TestBase {

	/*
	 * things we are going to initialize in this class 
	 * WebDriver 
	 * properties 
	 * logs
	 * Extent Reports 
	 * DB Excel Mail
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getRootLogger();
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public ExtentReports report = ExtentManager.getInstance();
	public ExtentTest test;
	public static WebElement dropdown;


	@BeforeSuite
	public void setUp() throws FileNotFoundException {

		if (driver == null) {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ObjectRep.properties");
			try {
				OR.load(fis);
				log.debug("ObjectRep file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (config.getProperty("browser").equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome Launched");
			}

			driver.get(config.getProperty("testsiteURL"));
			log.debug("Navigated to " + config.getProperty("testsiteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		}

	}

	public boolean isElementPresent(By by) {
		
		try {
		driver.findElement(by);
		return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
		log.debug("Test execution completed");
	}
}
