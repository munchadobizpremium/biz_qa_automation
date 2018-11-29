package action;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements_ui.element_locator;
import global_utility.global_variables;
import global_utility.handle_ajax_call;
import global_utility.video_capture;
import gs_utilities.productdetails;


public class action_execute extends global_variables{
	
	video_capture recorder=new video_capture();
	int Status=0;
	element_locator element_loc=new element_locator();
	By element_locator=null;
	
	public int OpenBrowser(String Environment,String BrowserName) throws IOException, InterruptedException
	{		
		Properties prop=new Properties();
		InputStream in=new FileInputStream(path_lib_properties+"config_webdriver.properties");
		prop.load(in);
		log_system.info("Open Env: "+ Environment );
		log_system.info("Open Browser: "+ BrowserName );
		switch(Environment)
		{
			case "Window":
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
				    DesiredCapabilities cap = DesiredCapabilities.chrome();
				    cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    cap.setCapability(ChromeOptions.CAPABILITY, options);
				    log_system.info("Creating object for browser"+ BrowserName );
				    Driver = new ChromeDriver(cap);				    
				    Driver.manage().deleteAllCookies();
				    Status=1;
				    mainwindow=Driver.getWindowHandle();
				    log_system.info("Browser Opened successfully: "+ BrowserName );
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
				    log_system.info("Browser Opened successfully: "+ BrowserName );
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
				    log_system.info("Browser Opened successfully: "+ BrowserName );
				    mainwindow=Driver.getWindowHandle();
				    break;
				}
				}
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
			}
		}
		
		log_system.info("Status of Open Browser: "+Status);
		return Status;

	}
	
	public int URL(String url) throws Exception
	{				
		Driver.get(url);
		Status=1;
		log_system.info("URL opened Successfully: "+ url);
		log_system.info("Status of Get URL: "+Status);
		return Status;
	}
	
	public int VerifySSL() throws Exception
	{				
		if(Driver.getCurrentUrl().toLowerCase().contains("https"))
		Status=1;
		log_system.info("Site should be Secure: "+ Driver.getCurrentUrl());
		log_system.info("Status of Verify SSL: "+Status);
		return Status;
	}
	
	public int VerifyURL(String url) throws Exception
	{				
		if(Driver.getCurrentUrl().contains(url))Status=1;		
		log_system.info("URL verification Done: "+ url);
		log_system.info("Status of verify URL: "+Status);
		return Status;
	}
	
	
	public int VerifyText(String ElementKey,String ElementSelector,String text) throws Exception
	{
		Thread.sleep(2000);
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		System.out.println(Driver.findElement(element_locator).getText().trim().toLowerCase().replace("\"", ""));
		System.out.println(text);
		if(Driver.findElement(element_locator).getText().trim().toLowerCase().replace("\"", "").contains(text.toString().trim().toLowerCase()))
		{			
			Status=1;
			log_system.info("Verify Element");
			log_system.info("Status of verify Element: "+Status);
		}				
		
		return Status;
	}
	
	public int VerfyTitle(String title,String WindowType) throws Exception
	{
		if(WindowType.contains("Child"))
		{
			 for (String winHandle : Driver.getWindowHandles()) {
				 if(!winHandle.equals(mainwindow))
				 {		
					 Driver.switchTo().window(winHandle);			 
					 if(Driver.switchTo().window(winHandle).getTitle().toString().equals(title.toString()))Status=1;
						log_system.info("title verified: "+ title);
						log_system.info("Status of verify Title: "+Status);				
				 }
			        
			    }
			
		}
		else
		{
			if(Driver.getTitle().toString().equals(title.toString()))Status=1;
			log_system.info("title verified: "+ title);
			log_system.info("Status of verify Title: "+Status);
		}
		
		return Status;
	}
	
	public int VerifyFavicon(String ElementKey, String ElementSelector) 
	{		
		try
		{		
			element_locator=element_loc.getElement(ElementKey, ElementSelector);						
			Driver.findElement(element_locator);
			Status=1;				
			
		}
		catch(Exception e)
		{
			Status=0;
		}
		log_system.info("Verify Favicon");
		log_system.info("Status of Verfy Favicon: "+Status);
		return Status;
	}
	
	public int ConsolError() 
	{		
		ArrayList<String> error=new ArrayList<String>();
		try
		{		
			 Logs logs = Driver.manage().logs();
		        LogEntries logEntries = logs.get(LogType.BROWSER);
		        for(LogEntry logEntry :logEntries)
		        {
		            
		            if (logEntry.getMessage().toLowerCase().contains("[error]")) {
		            	error.add(logEntry.getMessage());
		                System.out.println("Error Message in Console:"+logEntry.getMessage());
		            } else if (logEntry.getMessage().toLowerCase().contains("[warning]")){
		                System.out.println("Warning Message in Console:"+logEntry.getMessage());
		            }else{
		                System.out.println("Information Message in Console:"+logEntry.getMessage());
		            }
		        }
		        if(error.size()==0)
		        {
		        	Status=1;			
		        }
				
			
		}
		catch(Exception e)
		{
			Status=0;
		}
		log_system.info("Verify Favicon");
		log_system.info("Status of Verfy Favicon: "+Status);
		return Status;
	}

	
	public int VerifyElement(String ElementKey, String ElementSelector) 
	{		
		try
		{		
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			Actions act=new Actions(Driver);
			WebDriverWait wait = new WebDriverWait(Driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
			act.moveToElement(Driver.findElement(element_locator)).build().perform();
			if(Driver.findElement(element_locator).isDisplayed())
				Status=1;	
			else
				Status=0;
			
		}
		catch(Exception e)
		{
			Status=0;
		}
		log_system.info("Verify Element");
		log_system.info("Status of verify Element: "+Status);
		return Status;
	}
	
	public int VerifyNoElement(String ElementKey, String ElementSelector) throws InterruptedException 
	{	
		Thread.sleep(2000);
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		try
		{
			Driver.findElement(element_locator);
			Status=0;
		}
		catch(Exception e)
		{
			Status=1;
		}
				
		log_system.info("Verify No Element");
		log_system.info("Status of verify No Element: "+Status);
		return Status;
	}
	
	
	public int Click(String ElementKey, String ElementSelector)  throws Exception
	{				
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Driver.findElement(element_locator).click();
		Status=1;
		log_system.info("click perfomed");
		log_system.info("Status of Click: "+Status);
		return Status;
	}
	
	public int SelectDropdown(String ElementKey, String ElementSelector)
	{				
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Select oSelect = new Select(Driver.findElement(element_locator));
		List<WebElement> OptionList=oSelect.getOptions();
		Random rdm=new Random();
		int Optionindex=rdm.nextInt(OptionList.size());
		oSelect.selectByIndex(Optionindex);
		Status=1;
		log_system.info("Select Dropdown perfomed");
		log_system.info("Status of Select Dropdown: "+Status);
		return Status;
	}
	
	public int SelectDate(String ElementKey, String ElementSelector) throws InterruptedException
	{				
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Driver.findElement(element_locator).click();
		Thread.sleep(2000);
		WebElement dateselector=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'xdsoft_calendar']/table"));
		List<WebElement> dates_list=dateselector.findElements(By.tagName("td"));
		ArrayList<WebElement> activeDates=new ArrayList<WebElement>();
		for(WebElement all_dates:dates_list)
		{
			if(!all_dates.getAttribute("class").contains("disable"))
			{
				activeDates.add(all_dates);
			}
		}
		
		Random rdm=new Random();
		int index=rdm.nextInt(activeDates.size());		
		WebElement selectableDate=activeDates.get(index);		
		act.moveToElement(selectableDate).build().perform();
		selectableDate.click();				
		Status=1;
		log_system.info("Select Select date perfomed");
		log_system.info("Status of Select Date: "+Status);
		return Status;
	}
	
	
	public int SelectTimeSlot(String ElementKey, String ElementSelector) throws InterruptedException
	{				
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Driver.findElement(element_locator).click();
		Thread.sleep(2000);
		WebElement dateselector=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 't_timepicker unstyled clearfix']"));
		List<WebElement> dates_list=dateselector.findElements(By.tagName("li"));
		ArrayList<WebElement> activeTimeSlot=new ArrayList<WebElement>();
		for(WebElement all_dates:dates_list)
		{			
				activeTimeSlot.add(all_dates);			
		}
		
		Random rdm=new Random();
		int index=rdm.nextInt(activeTimeSlot.size());		
		WebElement selectableTimeSlot=activeTimeSlot.get(index);		
		act.moveToElement(selectableTimeSlot).build().perform();
		selectableTimeSlot.click();				
		Status=1;
		log_system.info("Select Select date perfomed");
		log_system.info("Status of Select Date: "+Status);
		return Status;
	}
	
	public int SetText(String ElementKey, String ElementSelector,String InputString)  throws Exception
	{		
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Driver.findElement(element_locator).sendKeys(Keys.CONTROL+"a");
		Driver.findElement(element_locator).sendKeys(Keys.BACK_SPACE);
		Driver.findElement(element_locator).sendKeys(InputString);
		Status=1;
		log_system.info("Text Entered");
		log_system.info("Status of SetText: "+Status);
		return Status;
	}
	
	
	
	public int AddProduct(String ElementKey, String ElementSelector)  throws Exception
	{	
		productdetails gs_productdetails=new productdetails();
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		
		WebElement category_container=Driver.findElement(element_locator);
		category_container=category_container.findElement(By.xpath(".//ul[normalize-space(@class) = 'unstyled navbar nav md-hide']"));
		List<WebElement> category_list=category_container.findElements(By.tagName("li"));
		ArrayList<WebElement> category_List_ele=new ArrayList<WebElement>();
		for(WebElement category:category_list)
		{
			category_List_ele.add(category);
		}
		
		Random rdm=new Random();
		int category_index=rdm.nextInt(category_List_ele.size());
		WebElement Category_ele=category_List_ele.get(category_index);
		act.moveToElement(Category_ele);
		Category_ele.click();
		Thread.sleep(2000);
		String category_attribute=Category_ele.getAttribute("class").toString();
		category_attribute=category_attribute.replaceAll("[^0-9]", "");	
		WebElement Subcategoty_Container=Driver.findElement(By.xpath("//div[starts-with(@class,'menu_"+category_attribute+"')]"));
		Subcategoty_Container=Subcategoty_Container.findElement(By.xpath(".//div[normalize-space(@class) = 'item_menupanel']"));
		List<WebElement> Subcategoty_List=Subcategoty_Container.findElements(By.xpath(".//div[normalize-space(@class) = 'item_contentpanel']"));
		ArrayList<WebElement> Subcategoty_List_ele=new ArrayList<WebElement>();
		
		for(WebElement Subcategoty_details:Subcategoty_List)
		{
			Subcategoty_List_ele.add(Subcategoty_details);
		}
		
		category_index=rdm.nextInt(Subcategoty_List_ele.size());
		WebElement subcategory_random=Subcategoty_List_ele.get(category_index);
		act.moveToElement(subcategory_random).build().perform();		
		
		subcategory_random.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn btn_addtocard btn_addtoorder']")).click();
		handle_ajax_call.HandleAjaxCall();
		handle_ajax_call.HandleAjaxCall();
		Thread.sleep(6000);
		String prtoduct_type=null;
		try
		{
			if(Driver.findElement(By.xpath("//select[normalize-space(@class) = 'price-select y_price_select']")).isDisplayed())
			{				
				Select drpwn=new Select(Driver.findElement(By.xpath("//select[normalize-space(@class) = 'price-select y_price_select']")));
				List<WebElement> options= drpwn.getOptions();
				int index=rdm.nextInt(options.size());
				drpwn.selectByVisibleText(options.get(index).getText());
				prtoduct_type=options.get(index).getText();
			}
		}
		catch(Exception e)
		{
			System.out.println("not option to select");
		}
		Thread.sleep(3000);
		WebElement product_popup=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'a_modal']"));
		String ProductName=product_popup.findElement(By.xpath(".//p[normalize-space(@class) = 'title_popupitem item_title']")).getText();
		
		if(prtoduct_type!=null)
		{
			String temp = "";
			String[] s= prtoduct_type.split(" ");
			for(int i=1;i<s.length;i++)
			{
				temp=temp+s[i]+" ";
			}
			ProductName = ProductName +" "+temp;
			ProductName=ProductName.trim().toLowerCase();
		}
		gs_productdetails.setProductName(ProductName.toLowerCase());
		String ProductPrice=product_popup.findElement(By.xpath(".//span[normalize-space(@class) = 'sub-total']")).getText();
		gs_productdetails.setProduct_actual_price(Float.parseFloat(ProductPrice));
		try
		{
			if(product_popup.findElement(By.xpath(".//div[normalize-space(@class) = 'addons']")).isDisplayed())
			{
				ArrayList<String> toppings=new ArrayList<String>();
				WebElement Subcategory_addons=product_popup.findElement(By.xpath(".//div[normalize-space(@class) = 'addons']"));
				List<WebElement> Subcategory_addon_list=Subcategory_addons.findElements(By.xpath(".//div[normalize-space(@class) = 'panel_chooseyourtoppings addon-collection']"));
				for(WebElement Subcategory_addon_ele:Subcategory_addon_list)
				{
					act.moveToElement(Subcategory_addon_ele).build().perform();					
					WebElement subcategory_addon_choose=Subcategory_addon_ele.findElement(By.xpath(".//ul[normalize-space(@class) = 'unstyled box panel_popupaddon txt_addonradio clearfix']"));
					act.moveToElement(subcategory_addon_choose).build().perform();
					List<WebElement> subcategory_addon_choose_list=subcategory_addon_choose.findElements(By.tagName("li"));
					ArrayList<WebElement> subcategory_addon_choose_list_ele_list=new ArrayList<WebElement>();
					for(WebElement subcategory_addon_choose_list_ele:subcategory_addon_choose_list)
					{
						subcategory_addon_choose_list_ele_list.add(subcategory_addon_choose_list_ele);
					}
					int index=rdm.nextInt(subcategory_addon_choose_list_ele_list.size());
					WebElement 	subcategory_addon_choose_list_ele_select=subcategory_addon_choose_list_ele_list.get(index);					
					String toppingName=null;
					String toppingPrice=null;
					WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele_select.findElement(By.tagName("span"));
					WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele_select.findElement(By.tagName("input"));
					toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name");
					toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
					toppings.add(toppingName.toLowerCase()+","+"1"+","+toppingPrice);
					subcategory_addon_choose_list_ele_select_click.click();					
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					handle_ajax_call.HandleAjaxCall();
				}
				gs_productdetails.setTopping_details(toppings);
			}
			else
			{
				ArrayList<String> toppings=new ArrayList<String>();
				gs_productdetails.setTopping_details(toppings);
			}
		}
		catch(Exception e)
		{
			System.out.println("no option to choose");
		}
		String Product_Id=product_popup.findElement(By.id("uid")).getAttribute("value");
		product_popup.findElement(By.xpath(".//textarea[normalize-space(@class) = 'menu_special_instruction_item special_instruction']")).sendKeys("hello add instructions here");
		gs_productdetails.setInstructions(("hello add instructions here").toLowerCase());
		product_popup.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn blackbtn btn_popupaddtoorder add-to-order']")).click();
		
		Thread.sleep(2000);
		gs_productdetails.setProduct_count(1);		
		ProductDetails.put(Product_Id, gs_productdetails);				
		Status=1;
		log_system.info("Text Entered");
		log_system.info("Status of SetText: "+Status);
		return Status;
	}
	
	
	public int VerifyMenuItem(String ElementKey, String ElementSelector)  throws Exception
	{			
		int counter=0;		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		
		WebElement category_container=Driver.findElement(element_locator);
		category_container=category_container.findElement(By.xpath(".//ul[normalize-space(@class) = 'unstyled navbar nav md-hide']"));
		List<WebElement> category_list=category_container.findElements(By.tagName("li"));
		
		for(WebElement category:category_list)
		{
			act.moveToElement(category);
			category.click();
			String category_attribute=category.getAttribute("class").toString();
			category_attribute=category_attribute.replaceAll("[^0-9]", "");
			WebElement Subcategoty_Container=Driver.findElement(By.xpath("//div[starts-with(@class,'menu_"+category_attribute+"')]"));
			Subcategoty_Container=Subcategoty_Container.findElement(By.xpath(".//div[normalize-space(@class) = 'item_menupanel']"));
			List<WebElement> Subcategoty_List=Subcategoty_Container.findElements(By.xpath(".//div[normalize-space(@class) = 'item_contentpanel']"));
			if(Subcategoty_List.size()<=0)
				counter++;
		}
		
		if(counter<=0)
			Status=1;
		
		log_system.info("Text Entered");
		log_system.info("Status of SetText: "+Status);
		return Status;
	}
	
	
	public int AddEditProduct()  throws Exception
	{				
				
		String Product_Item="";
		if(ProductDetails.isEmpty())
		{
			System.out.println("not product added");
			Status=1;
		}
		else
		{
			ArrayList<String> Product_item_list=new ArrayList<String>();
			for(String Keyset:ProductDetails.keySet())
			{
				Product_item_list.add(Keyset);
			}
			
			Random rdm=new Random();
			int index=rdm.nextInt(Product_item_list.size());
			Product_Item=Product_item_list.get(index);
			
			WebElement ele_Editbutton=Driver.findElement(By.xpath("//a[normalize-space(@class)='t-edit-order edit_"+Product_Item+" ubtn']"));
			ele_Editbutton.click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(3000);
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(3000);
			Actions act=new Actions(Driver);
			WebElement product_popup=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'a_modal']"));
			if(!ProductDetails.get(Product_Item).getTopping_details().isEmpty())
			{		
				int count=0;
				WebElement Subcategory_addons=product_popup.findElement(By.xpath(".//div[normalize-space(@class) = 'addons']"));
				List<WebElement> Subcategory_addon_list=Subcategory_addons.findElements(By.xpath(".//div[normalize-space(@class) = 'panel_chooseyourtoppings addon-collection']"));
				for(WebElement Subcategory_addon_ele:Subcategory_addon_list)
				{
					act.moveToElement(Subcategory_addon_ele).build().perform();
					WebElement addon_type=Subcategory_addon_ele.findElement(By.xpath(".//p[normalize-space(@class) = 'txt_chooseyourtoppings txt_addonq']"));
					WebElement subcategory_addon_choose=Subcategory_addon_ele.findElement(By.xpath(".//ul[normalize-space(@class) = 'unstyled box panel_popupaddon txt_addonradio clearfix']"));
					act.moveToElement(subcategory_addon_choose).build().perform();
					String addon_topping_type=addon_type.getText();
					String toppingName=null;
					String toppingPrice=null;
					List<WebElement> subcategory_addon_choose_list=subcategory_addon_choose.findElements(By.tagName("li"));
					ArrayList<WebElement> subcategory_addon_choose_list_ele_list=new ArrayList<WebElement>();
					if(addon_topping_type.contains("Choose any one"))
					{												
						for(WebElement subcategory_addon_choose_list_ele:subcategory_addon_choose_list)
						{							
							String topping_selected=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[0];
							WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele.findElement(By.tagName("span"));
							WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele.findElement(By.tagName("input"));
							toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name").toLowerCase();
							toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
							if(!toppingName.contains(topping_selected))
							{
								subcategory_addon_choose_list_ele_select_click.click();
								Thread.sleep(2000);
								break;
							}														
						}
						
						
						String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
						toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));						
						String updated_Topping=toppingName.toLowerCase()+","+toppingcount+","+toppingPrice;
						ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);									
						handle_ajax_call.HandleAjaxCall();
						Thread.sleep(2000);
						handle_ajax_call.HandleAjaxCall();
					}					
					else
					{
						if(subcategory_addon_choose_list.size()>1)
						{
							for(WebElement subcategory_addon_choose_list_ele:subcategory_addon_choose_list)
							{		
								
								String topping_selected=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[0];
								WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele.findElement(By.tagName("span"));
								WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele.findElement(By.tagName("input"));
								toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name").toLowerCase().trim();
								
								if(toppingName.equals(topping_selected.trim()))
								{
									Thread.sleep(2000);
									subcategory_addon_choose_list_ele_select_click.click();
									
								}
								else
								{
									subcategory_addon_choose_list_ele_list.add(subcategory_addon_choose_list_ele);
								}
								
							}
							
							int index1=rdm.nextInt(subcategory_addon_choose_list_ele_list.size());
							WebElement 	subcategory_addon_choose_list_ele_select=subcategory_addon_choose_list_ele_list.get(index1);
							WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele_select.findElement(By.tagName("span"));
							WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele_select.findElement(By.tagName("input"));
							subcategory_addon_choose_list_ele_select_click.click();
							toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name");
							toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
							String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
							toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));
							String updated_Topping=toppingName.toLowerCase()+","+toppingcount+","+toppingPrice;
							ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);
													
							handle_ajax_call.HandleAjaxCall();
							Thread.sleep(2000);
							handle_ajax_call.HandleAjaxCall();
						}
						
					}					
					count++;
				}
			}
			
			WebElement ele_Instruction=product_popup.findElement(By.xpath(".//textarea[normalize-space(@class) = 'menu_special_instruction_item special_instruction']"));
			WebElement ele_AddEdit=product_popup.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn btn_addtocard add-multiplier']"));
			WebElement ele_EditOrder=product_popup.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn blackbtn btn_popupaddtoorder add-to-order']"));
			ele_Instruction.sendKeys(Keys.CONTROL+"a");
			ele_Instruction.sendKeys(Keys.BACK_SPACE);
			String updated_Instruction="Updated Instructions for product item: "+ Product_Item;
			ele_Instruction.sendKeys(updated_Instruction);
			ele_AddEdit.click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(2000);
			ele_EditOrder.click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(3000);
			handle_ajax_call.HandleAjaxCall();						
			ProductDetails.get(Product_Item).setInstructions(updated_Instruction.toLowerCase());
			int productcount=ProductDetails.get(Product_Item).getProduct_count();
			float ProductPrice_actual=ProductDetails.get(Product_Item).getProduct_actual_price();
			ProductPrice_actual=ProductPrice_actual/productcount;
			productcount=productcount+1;			
			ProductDetails.get(Product_Item).setProduct_count(productcount);
			ProductPrice_actual=ProductPrice_actual*productcount;
			BigDecimal bg=new BigDecimal(ProductPrice_actual).setScale(3, BigDecimal.ROUND_HALF_UP);
			bg=bg.setScale(2, BigDecimal.ROUND_HALF_UP);
			ProductPrice_actual=Float.parseFloat(bg.toString());
			ProductDetails.get(Product_Item).setProduct_actual_price(ProductPrice_actual);
			
			for(int i=0;i<ProductDetails.get(Product_Item).getTopping_details().size();i++)
			{
				String toppingname=ProductDetails.get(Product_Item).getTopping_details().get(i).split(",")[0];
				String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(i).split(",")[1];
				String toppingprice=ProductDetails.get(Product_Item).getTopping_details().get(i).split(",")[2];
				toppingprice=String.valueOf(Float.parseFloat(toppingprice)/Integer.parseInt(toppingcount));
				BigDecimal bg1=new BigDecimal(toppingprice).setScale(3, BigDecimal.ROUND_HALF_UP);
				bg1=bg1.setScale(2, BigDecimal.ROUND_HALF_UP);
				toppingprice=bg1.toString();
				toppingcount=String.valueOf(productcount);
				toppingprice=String.valueOf(Float.parseFloat(toppingprice)*productcount);
				BigDecimal bg2=new BigDecimal(toppingprice).setScale(3, BigDecimal.ROUND_HALF_UP);
				bg2=bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
				toppingprice=bg2.toString();
				
				ProductDetails.get(Product_Item).getTopping_details().set(i, toppingname+","+toppingcount+","+toppingprice);
				
			}
			Status=1;
		}
		
		log_system.info("Product Edit successfully");
		log_system.info("Status of Product Edit: "+Status);
		return Status;
	}
	
	
	public int RemoveEditProduct()  throws Exception
	{				
		String Product_Item="";
		if(ProductDetails.isEmpty())
		{
			System.out.println("not product added");
			Status=1;
		}
		else
		{
			ArrayList<String> Product_item_list=new ArrayList<String>();
			for(String Keyset:ProductDetails.keySet())
			{
				Product_item_list.add(Keyset);
			}
			
			Random rdm=new Random();
			int index=rdm.nextInt(Product_item_list.size());
			Product_Item=Product_item_list.get(index);
			
			WebElement ele_Editbutton=Driver.findElement(By.xpath("//a[normalize-space(@class)='t-edit-order edit_"+Product_Item+" ubtn']"));
			ele_Editbutton.click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(3000);
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(3000);
			Actions act=new Actions(Driver);
			WebElement product_popup=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'a_modal']"));
			if(!ProductDetails.get(Product_Item).getTopping_details().isEmpty())
			{		
				int count=0;
				WebElement Subcategory_addons=product_popup.findElement(By.xpath(".//div[normalize-space(@class) = 'addons']"));
				List<WebElement> Subcategory_addon_list=Subcategory_addons.findElements(By.xpath(".//div[normalize-space(@class) = 'panel_chooseyourtoppings addon-collection']"));
				for(WebElement Subcategory_addon_ele:Subcategory_addon_list)
				{
					act.moveToElement(Subcategory_addon_ele).build().perform();
					WebElement addon_type=Subcategory_addon_ele.findElement(By.xpath(".//p[normalize-space(@class) = 'txt_chooseyourtoppings txt_addonq']"));
					WebElement subcategory_addon_choose=Subcategory_addon_ele.findElement(By.xpath(".//ul[normalize-space(@class) = 'unstyled box panel_popupaddon txt_addonradio clearfix']"));
					act.moveToElement(subcategory_addon_choose).build().perform();
					String addon_topping_type=addon_type.getText();
					String toppingName=null;
					String toppingPrice=null;
					List<WebElement> subcategory_addon_choose_list=subcategory_addon_choose.findElements(By.tagName("li"));
					ArrayList<WebElement> subcategory_addon_choose_list_ele_list=new ArrayList<WebElement>();
					if(addon_topping_type.contains("Choose any one"))
					{												
						for(WebElement subcategory_addon_choose_list_ele:subcategory_addon_choose_list)
						{							
							String topping_selected=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[0];
							WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele.findElement(By.tagName("span"));
							WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele.findElement(By.tagName("input"));
							toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name").toLowerCase();
							toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
							if(!toppingName.contains(topping_selected))
							{
								subcategory_addon_choose_list_ele_select_click.click();
								Thread.sleep(2000);
								break;
							}														
						}
						
						
						String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
						toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));						
						String updated_Topping=toppingName.toLowerCase()+","+toppingcount+","+toppingPrice;
						ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);									
						handle_ajax_call.HandleAjaxCall();
						Thread.sleep(2000);
						handle_ajax_call.HandleAjaxCall();
					}					
					else
					{
						if(subcategory_addon_choose_list.size()>1)
						{
							for(WebElement subcategory_addon_choose_list_ele:subcategory_addon_choose_list)
							{		
								
								String topping_selected=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[0];
								WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele.findElement(By.tagName("span"));
								WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele.findElement(By.tagName("input"));
								toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name").toLowerCase().trim();
								
								if(toppingName.equals(topping_selected.trim()))
								{
									Thread.sleep(2000);
									subcategory_addon_choose_list_ele_select_click.click();
									
								}
								else
								{
									subcategory_addon_choose_list_ele_list.add(subcategory_addon_choose_list_ele);
								}
								
							}
							
							int index1=rdm.nextInt(subcategory_addon_choose_list_ele_list.size());
							WebElement 	subcategory_addon_choose_list_ele_select=subcategory_addon_choose_list_ele_list.get(index1);
							WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele_select.findElement(By.tagName("span"));
							WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele_select.findElement(By.tagName("input"));
							subcategory_addon_choose_list_ele_select_click.click();
							toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name");
							toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
							String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
							toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));
							String updated_Topping=toppingName.toLowerCase()+","+toppingcount+","+toppingPrice;
							ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);
													
							handle_ajax_call.HandleAjaxCall();
							Thread.sleep(2000);
							handle_ajax_call.HandleAjaxCall();
						}
						
					}					
					count++;
				}
			}
			
			WebElement ele_Instruction=product_popup.findElement(By.xpath(".//textarea[normalize-space(@class) = 'menu_special_instruction_item special_instruction']"));
			WebElement ele_RemoveEdit=product_popup.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn btn_addtocard decrease subtract-multiplier']"));
			WebElement ele_EditOrder=product_popup.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn blackbtn btn_popupaddtoorder add-to-order']"));
			ele_Instruction.sendKeys(Keys.CONTROL+"a");
			ele_Instruction.sendKeys(Keys.BACK_SPACE);
			String updated_Instruction="Updated Instructions for product item: "+ Product_Item;
			ele_Instruction.sendKeys(updated_Instruction);
			ele_RemoveEdit.click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(2000);
			ele_EditOrder.click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(3000);
			handle_ajax_call.HandleAjaxCall();						
			ProductDetails.get(Product_Item).setInstructions(updated_Instruction.toLowerCase());
			int productcount=ProductDetails.get(Product_Item).getProduct_count();
			float ProductPrice_actual=ProductDetails.get(Product_Item).getProduct_actual_price();
			ProductPrice_actual=ProductPrice_actual/productcount;
			productcount=productcount-1;
			if(productcount==0)
			{
				productcount=1;
			}
			ProductDetails.get(Product_Item).setProduct_count(productcount);
			ProductPrice_actual=ProductPrice_actual*productcount;
			BigDecimal bg=new BigDecimal(ProductPrice_actual).setScale(3, BigDecimal.ROUND_HALF_UP);
			bg=bg.setScale(2, BigDecimal.ROUND_HALF_UP);
			ProductPrice_actual=Float.parseFloat(bg.toString());
			ProductDetails.get(Product_Item).setProduct_actual_price(ProductPrice_actual);
			
			for(int i=0;i<ProductDetails.get(Product_Item).getTopping_details().size();i++)
			{
				String toppingname=ProductDetails.get(Product_Item).getTopping_details().get(i).split(",")[0];
				String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(i).split(",")[1];
				String toppingprice=ProductDetails.get(Product_Item).getTopping_details().get(i).split(",")[2];
				toppingprice=String.valueOf(Float.parseFloat(toppingprice)/Integer.parseInt(toppingcount));
				BigDecimal bg1=new BigDecimal(toppingprice).setScale(3, BigDecimal.ROUND_HALF_UP);
				bg1=bg1.setScale(2, BigDecimal.ROUND_HALF_UP);
				toppingprice=bg1.toString();
				toppingcount=String.valueOf(productcount);
				toppingprice=String.valueOf(Float.parseFloat(toppingprice)*productcount);
				BigDecimal bg2=new BigDecimal(toppingprice).setScale(3, BigDecimal.ROUND_HALF_UP);
				bg2=bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
				toppingprice=bg2.toString();
				
				ProductDetails.get(Product_Item).getTopping_details().set(i, toppingname+","+toppingcount+","+toppingprice);
				
			}
			Status=1;
		}
		
		log_system.info("Product Edit successfully");
		log_system.info("Status of Product Edit: "+Status);
		return Status;

	}


	public int DeleteProduct(String Instruction)  throws Exception
	{				
		String Product_Item="";
		if(ProductDetails.isEmpty())
		{
			System.out.println("not product added");
			Status=1;
		}
		else
		{
			if(Instruction.toLowerCase().contains("all"))
			{		
				ArrayList<String> Product_Item_key=new  ArrayList<String>(); 
				for(String Keyset:ProductDetails.keySet())
				{
					Product_Item_key.add(Keyset);
				
				}
				for(String Item_Key:Product_Item_key)
				{
					Product_Item=Item_Key;
					WebElement delete_Product=Driver.findElement(By.xpath(".//a[normalize-space(@class) = 't-delete-order ubtn'][normalize-space(@data-id) = '"+Product_Item+"']"));
					delete_Product.click();
					Thread.sleep(2000);
					WebElement cnfrm_delete_Product=Driver.findElement(By.xpath(".//span[normalize-space(@class) = 'ubtn blackbtn t-confirm-delete-order'][normalize-space(@data-id) = '"+Product_Item+"']"));
					cnfrm_delete_Product.click();
					Thread.sleep(2000);
					ProductDetails.remove(Product_Item);
				}				
				Status=1;
			}
			else
			{
				ArrayList<String> Product_item_list=new ArrayList<String>();
				for(String Keyset:ProductDetails.keySet())
				{
					Product_item_list.add(Keyset);
				}
				
				Random rdm=new Random();
				int index=rdm.nextInt(Product_item_list.size());
				Product_Item=Product_item_list.get(index);
				WebElement delete_Product=Driver.findElement(By.xpath(".//a[normalize-space(@class) = 't-delete-order ubtn'][normalize-space(@data-id) = '"+Product_Item+"']"));
				delete_Product.click();
				WebElement cnfrm_delete_Product=Driver.findElement(By.xpath(".//span[normalize-space(@class) = 'ubtn blackbtn t-confirm-delete-order'][normalize-space(@data-id) = '"+Product_Item+"']"));
				cnfrm_delete_Product.click();
				ProductDetails.remove(Product_Item);
				Status=1;
			}			
		}
		
		log_system.info("Product Edit successfully");
		log_system.info("Status of Product Edit: "+Status);
		return Status;

	}

	
	public int VerifySummary(String ElementKey, String ElementSelector,String Tax)  throws Exception
	{
		Thread.sleep(3000);
		LinkedHashMap<String, gs_utilities.productdetails> ProductDetails_current=new LinkedHashMap<String, gs_utilities.productdetails>();
		

		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
		WebElement SummaryContainer=Driver.findElement(element_locator);						
		WebElement SummaryContainer_ProductContainer=SummaryContainer.findElement(By.xpath(".//div[normalize-space(@class) = 'container']"));
		WebElement SummaryContainer_ProductContainer_info=SummaryContainer_ProductContainer.findElement(By.xpath(".//div[starts-with(@class,'yourorder_box')]"));
		List<WebElement> SummaryContainer_ProductContainer_Instruction=SummaryContainer_ProductContainer.findElements(By.xpath(".//p[starts-with(@class,'t-item-instructions')]"));
		ArrayList<String> Instruction_current=new ArrayList<String>();
		for(WebElement instruction_ele:SummaryContainer_ProductContainer_Instruction)
		{
			Instruction_current.add(instruction_ele.getText());
		}
		if(ProductDetails.isEmpty())
		{
			System.out.println("not product added");
		}
		else
		{			
			List<WebElement> SummaryContainer_ProductContainer_info_details_list=SummaryContainer_ProductContainer_info.findElements(By.xpath(".//div[starts-with(@class,'row')]"));
			int productcount=0;
			String Product_item=null;
			for(WebElement SummaryContainer_ProductContainer_info_details:SummaryContainer_ProductContainer_info_details_list)
			{				
				String Product_item_attribute=SummaryContainer_ProductContainer_info_details.getAttribute("class");
				
				
				
				if(!SummaryContainer_ProductContainer_info_details.getText().contains("+"))
				{	
					gs_utilities.productdetails gs_ProductDetails=new gs_utilities.productdetails();										
					String ProductPrice_current=SummaryContainer_ProductContainer_info_details.getText().split("\\$")[1];
					String ProductCount_current=SummaryContainer_ProductContainer_info_details.getText().split("\\$")[0].trim();
					ProductCount_current=ProductCount_current.substring(ProductCount_current.length()-1, ProductCount_current.length());
					String ProductName_current=SummaryContainer_ProductContainer_info_details.getText().split("\\$")[0];
					ProductName_current=ProductName_current.substring(0, ProductName_current.length()-2);									
					gs_ProductDetails.setProductName(ProductName_current.replace("\n", "").trim().toLowerCase());
					gs_ProductDetails.setProduct_actual_price(Float.parseFloat(ProductPrice_current));
					gs_ProductDetails.setProduct_count(Integer.parseInt(ProductCount_current));
					ArrayList<String> toppings=new ArrayList<String>();
					Product_item=Product_item_attribute.replace(" ", ",");
					Product_item=Product_item.split(",")[2];
					Product_item=Product_item.replace("item_", "");
					gs_ProductDetails.setTopping_details(toppings);
					try {
						gs_ProductDetails.setInstructions(Instruction_current.get(productcount).trim().toLowerCase());
					}
					catch(Exception e)
					{
						System.out.println("instruction is missing for product item");
					}
					ProductDetails_current.put(Product_item, gs_ProductDetails);
					productcount++;
				}
				else if (SummaryContainer_ProductContainer_info_details.getText().contains("+"))
				{					
					
					String[] s=SummaryContainer_ProductContainer_info_details.getText().split("\n");
					String topping_data=s[0].replace("+", "").trim().toLowerCase()+","+s[1].trim()+","+s[2].replace("$", "").trim();
					ProductDetails_current.get(Product_item).getTopping_details().add(topping_data);
								
				}
			}
			
		}
		
		int errorcount=0;
		for(String Compair:ProductDetails.keySet())
		{
			if(!ProductDetails.get(Compair).equals(ProductDetails_current.get(Compair)))					
			{
				if(!ProductDetails.get(Compair).getProductName().equals(ProductDetails_current.get(Compair).getProductName()))
				{
					System.out.println("Product name not mapped "+ ProductDetails.get(Compair).getProductName());
					errorcount++;
				}
				else
				{
					if(!ProductDetails.get(Compair).getInstructions().equals(ProductDetails_current.get(Compair).getInstructions()))
					{
						System.out.println("Instruction not mapped "+ ProductDetails.get(Compair).getProductName());
						errorcount++;
					}
					else
					{
						if(ProductDetails.get(Compair).getProduct_actual_price()!=(ProductDetails_current.get(Compair).getProduct_actual_price()))
						{
							System.out.println("Price not mapped "+ ProductDetails.get(Compair).getProductName());
							errorcount++;
						}
						else
						{
							if(ProductDetails.get(Compair).getProduct_count()!=(ProductDetails_current.get(Compair).getProduct_count()))
							{
								System.out.println("Count not mapped "+ ProductDetails.get(Compair).getProductName());
								errorcount++;
							}
							else
							{
								if(!ProductDetails.get(Compair).getTopping_details().equals(ProductDetails_current.get(Compair).getTopping_details()))
								{
									System.out.println("Toppings not mapped "+ ProductDetails.get(Compair).getProductName());
									errorcount++;
								}																
							}
						}
					}
				}
				
			}
		}
		float Product_price_calculate=0;
		float order_subtotal=0;
		float order_tax=0;
		if(errorcount==0)
		{
			order_subtotal=Float.parseFloat(Driver.findElement(By.xpath("//span[normalize-space(@class) = 'order_subtotal']")).getText());
			order_tax=Float.parseFloat(Driver.findElement(By.xpath("//span[normalize-space(@class) = 'order_tax']")).getText());			
			for(String Product_item:ProductDetails_current.keySet())
			{
				
				Product_price_calculate=Product_price_calculate+ProductDetails_current.get(Product_item).getProduct_actual_price();				
				ArrayList<String> Topping_cal=ProductDetails_current.get(Product_item).getTopping_details();
				for(String toppingDetails:Topping_cal)
				{
					float toppingprice=Float.parseFloat(toppingDetails.split(",")[2]);
					Product_price_calculate=Product_price_calculate+toppingprice;					
				}				
			}
			
		}
		Product_price_calculate=Float.parseFloat(new BigDecimal(Product_price_calculate).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		float order_total=Float.parseFloat(Driver.findElement(By.xpath("//span[normalize-space(@class) = 'order_total']")).getText());
		if(order_subtotal==Product_price_calculate)
		{
			
			
			float tax_calculation=(Product_price_calculate*Float.parseFloat(Tax))/100;
			BigDecimal bg=new BigDecimal(tax_calculation).setScale(3, BigDecimal.ROUND_HALF_UP);
			bg=bg.setScale(2, BigDecimal.ROUND_HALF_UP);
			tax_calculation=Float.parseFloat(bg.toString());
			if(order_tax==tax_calculation)
			{
				float total_calculate=Product_price_calculate+order_tax;
				BigDecimal bg1=new BigDecimal(total_calculate).setScale(3, BigDecimal.ROUND_HALF_UP);
				bg1=bg1.setScale(2, BigDecimal.ROUND_HALF_UP);
				total_calculate=Float.parseFloat(bg1.toString());
				if(order_total==total_calculate)
				{
					Status=1;
				}
				else
				{
					System.out.println("incorrect order total");
				}
			}
			
		}
		else
		{
			System.out.println("Incorrect product sub total");
		}
		if(Status==0)
		{
			System.out.println();
		}
		
		log_system.info("Summary verified");
		log_system.info("Status of Verify Summary: "+Status);
		return Status;
	}

	
	public int wait(int waittime) throws InterruptedException
	{
		Thread.sleep(waittime);
		Status=1;
		return Status;
	}
	
	public int ClearText(String ElementKey, String ElementSelector)  throws Exception
	{				
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		Driver.findElement(element_locator).sendKeys(Keys.CONTROL+"a");
		Driver.findElement(element_locator).sendKeys(Keys.BACK_SPACE);
		Status=1;
		log_system.info("Text Cleared");
		log_system.info("Status of ClearText: "+Status);
		return Status;
	}
	
	
	public int CloseBrowser(String Browser_type) throws Exception
	{				
		if(Browser_type.contains("All"))
		{
			
			Driver.quit();
			Status=1;
			log_system.info("Browser Closed successfully");
			log_system.info("Status of Close Browser: "+Status);
		}
		else if (Browser_type.contains("Child"))
		{
			
			 for (String winHandle : Driver.getWindowHandles()) {
				 if(!winHandle.equals(mainwindow))
				 {
					 Driver.close();
					 Driver.switchTo().window(mainwindow);
					 Status=1;
				 }
			        
			    }
		}
		return Status;
	}
	
	public void QuitDriver() throws Exception
	{					
		log_system.info("Execution Done");
		System.exit(0);
		
	}
}
