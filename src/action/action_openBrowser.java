package action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import global_utility.global_variables;

public class action_openBrowser extends global_variables{

	
	public int OpenBrowser(String Environment, String BrowserName) throws IOException
	{
		int Status=0;
		Properties prop=new Properties();
		InputStream in=new FileInputStream(path_lib_properties+"config_webdriver.properties");
		prop.load(in);
		switch(Environment)
		{
			case "Window":
			{				
				switch(BrowserName)
				{			
				case "Chrome":
				{						
					System.setProperty(prop.getProperty("property_chromeDriver"),path_lib_driver+ prop.getProperty("Path_chromeDriver"));
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
				    chromePrefs.put("download.default_directory", path_lib_download);
				    ChromeOptions options = new ChromeOptions();
				    HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				    options.setExperimentalOption("prefs", chromePrefs);
				    options.addArguments("start-maximized");
				    DesiredCapabilities cap = DesiredCapabilities.chrome();
				    cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    cap.setCapability(ChromeOptions.CAPABILITY, options);				    
				    Driver = new ChromeDriver(cap);				    
				    Driver.manage().deleteAllCookies();
				    Status=1;
				    mainwindow=Driver.getWindowHandle();
				    log_system.info("Browser Open Successful");
				    break;
				}
				case "FireFox":
				{
					System.setProperty(prop.getProperty("property_firefoxDriver"),path_lib_driver+ prop.getProperty("Path_firefoxDriver"));
					DesiredCapabilities capabilities=DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
				    Driver = new FirefoxDriver(capabilities);
				    Driver.manage().deleteAllCookies();
				    mainwindow=Driver.getWindowHandle();
				    Status=1;
				    break;
				}
				case "IE11":
				{
					System.setProperty(prop.getProperty("property_IEDriver"),path_lib_driver+ prop.getProperty("Path_IEDriver"));
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					capabilities.setCapability("requireWindowFocus", true);
					capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
					capabilities.setCapability(CapabilityType.VERSION, "11");
					capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
					Driver = new InternetExplorerDriver(capabilities);
					Driver = new InternetExplorerDriver();
					Driver.manage().deleteAllCookies();
				    Status=1;
				    mainwindow=Driver.getWindowHandle();
				    break;
				}
				}
				break;
			}
			case "Android":
			{
				switch(BrowserName)
				{			
				case "Chrome":
				{
					
					log_system.info("Set Configuration for Browser: "+ BrowserName );					
					System.setProperty(prop.getProperty("property_chromeDriver"),path_lib_driver+ prop.getProperty("Path_chromeDriver"));
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
				    chromePrefs.put("download.default_directory", path_lib_download);
				    ChromeOptions options = new ChromeOptions();
				    HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				    options.setExperimentalOption("prefs", chromePrefs);
				    options.addArguments("start-maximized");
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				    caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    caps.setCapability(ChromeOptions.CAPABILITY, options);
				    log_system.info("Creating object for browser"+ BrowserName );
				    caps.setCapability("app-wait-activity", "activity-to-wait-for");
					/*caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi111");
					caps.setCapability(MobileCapabilityType.UDID, "5a0c7cb7d140"); //Give Device ID of your mobile phone
					caps.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
					caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");	
					caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
					caps.setCapability(MobileCapabilityType.NO_RESET, true);
					caps.setCapability(MobileCapabilityType.FULL_RESET, false);
					caps.setCapability("appPackage", "com.android.chrome");*/
					caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
					/*caps.setCapability("noReset", "true");*/
				/*	Driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);*/
					
					 
					log_system.info("Browser Opened successfully: "+ BrowserName );
				    log_system.info("Deleting all cookies for: "+ BrowserName );
				  //  driver.manage().deleteAllCookies();
				    Status=1;
				  //  mainwindow=driver.getWindowHandle();
				    break;
				}
				
				}
				break;
			}
		}
		
		return Status;
	}
	
	
}
