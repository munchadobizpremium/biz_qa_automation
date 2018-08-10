package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.pages.OredrOnlinePage;
import com.crm.qa.testcases.ExtentFactory;
import com.crm.qa.util.MicroBizTestUtil;
import com.crm.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentReports report;
	public static ExtentTest test;

	public TestBase() {
		try {

			// report = new ExtentReports("C:\\MicroBiz Reports Extent\\MicroBizTest.html");
			// this.test=report.startTest("MicroBiz Sanity Test");
			//
			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void checkPageIsReady() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}

		// This loop will rotate for 36 times to check If page Is ready after every 1
		// second.
		// You can replace your value with 36 If you wants to Increase or decrease wait
		// time.
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}


	

	public static void initialization() {
		// report = new ExtentReports("c:\\MicroBiz Reports Extent\\MicroBizTest.html");
		// test=report.startTest("MicroBiz Sanity Test");
		// report = ExtentFactory.getInstance();
		// test = report.startTest("MicroBiz Sanity Test");
		// orderonlinepage = new OredrOnlinePage(test);

		String browserName = prop.getProperty("browser");
		

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver Exe\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\chromedriverwin32\\chromedriver.exe");
			
			// ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
			// ChromeDriverService srvc = builder.usingDriverExecutable(new
			// File("C:\\ChromeDriver Exe\\chromedriver.exe\"")).usingPort(9515).build();

			// try {
			// srvc.start();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			 driver = new ChromeDriver();
//			 String userProfile= "C:\\Users\\IT\\AppData\\Local\\Google\\Chrome\\Automation Profile";
			 
//		        ChromeOptions options = new ChromeOptions();
//		        options.addArguments("user-data-dir="+userProfile);
//		        options.addArguments("--start-maximized");

//		        driver = new ChromeDriver(options);
//			driver = new ChromeDriver(options);
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\01 Gecko Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
//	

		e_driver = new EventFiringWebDriver(driver);
		
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(MicroBizTestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MicroBizTestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		checkPageIsReady();
		
		
		
//		System.out.println(isElementPresent("//div[@class='entrypopup']"));
		
//		if(isElementPresent("//div[@class='entrypopup']")&& (isElementPresent( "//html/body/div[3]/div/a"))){
//			WebElement entryPopup = driver.findElement(By.xpath("//div[@class='entrypopup']"));
//			WebElement clsPopup = driver.findElement(By.xpath("//html/body/div[3]/div/a"));
//			
//			 JavascriptExecutor executor = (JavascriptExecutor)driver;
////				
//				 executor.executeScript("arguments[0].click()",clsPopup);
//				 System.out.println("The Popup is Closed: ");
//		}
//		else {
//			System.out.println("Entry Popup is not present");
//		}
//		WebElement entryPopup = driver.findElement(By.xpath("//div[@class='entrypopup']"));
//		
////		System.out.println(isElementPresent("//div[@class='entrypopup']"));
//		
//		WebElement clsPopup = driver.findElement(By.xpath("//html/body/div[3]/div/a"));
////        System.out.println("The Size of Entry PopUp   "+entryPopup.getSize());
//		
	}




		
//		try {
//			
//		if(entryPopup) {
//			
//			if (entryPopup.isDisplayed()) {
//			// Point loc= clsPopup.getLocation();
//			// System.out.println("Location is: "+loc);
//			// System.out.println("Executed");
//			 JavascriptExecutor executor = (JavascriptExecutor)driver;
//			
//			 executor.executeScript("arguments[0].click()",clsPopup);
//			 System.out.println("The Popup is Closed: ");
//		}
//		}
//		}catch (RuntimeException e)
//			 {
//		   
//		    	System.out.println("There is No Such Element");
//		    
//			 }
//	}
//	}
public static boolean isElementPresent(String locator){
	
	try {
	driver.findElement(By.xpath(locator));
	return true;
	
	}catch(Throwable t){
		
		return false;
		
	}
	
}
}




