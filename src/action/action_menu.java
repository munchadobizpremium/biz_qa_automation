package action;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import global_utility.global_variables;
import global_utility.handle_ajax_call;

public class action_menu extends global_variables {
	
	action_common common_action=new action_common();
	public int VerifyMenu(String url) throws InterruptedException
	{
		int Status=0;
		ArrayList<String> errorlog=new ArrayList<String>();
		Actions act=new Actions(Driver);
		WebElement hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
		/*WebElement hamburger=Driver.findElement(By.cssSelector("i[class='i_hamburger']"));*/
		WebElement menu_container=null;
		List<WebElement> menuList=null;
		
			if(hamburger.isDisplayed() && hamburger.isEnabled())
			{
				
					try {
						hamburger.click();
						menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
						/*menu_container=Driver.findElement(By.cssSelector("ul[class='.unstyled.navbar.nav']"));*/
						menuList=menu_container.findElements(By.tagName("a"));
					} catch (Exception e) {
						menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
						/*menu_container=Driver.findElement(By.cssSelector("ul[class='unstyled navbar nav']"));*/
						menuList=menu_container.findElements(By.tagName("a"));
					}
			}
			else
			{
				menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
				/*menu_container=Driver.findElement(By.cssSelector("ul[class='unstyled navbar nav']"));*/
				menuList=menu_container.findElements(By.tagName("a"));
			}
			
				
			if(!menu_container.isDisplayed() && !hamburger.isDisplayed()) {
				Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_downstyle']")).click();
				/*Driver.findElement(By.cssSelector("i[class='i_downstyle']")).click();*/
			}
			
			ArrayList<String> menuList_collection=new ArrayList<String>();
			for(WebElement menu:menuList)
			{						
				try {
					if(menu.getAttribute("href").contains("javascript"))
						menuList_collection.add(menu.getText().trim().toLowerCase().replace(" ", "_"));
				} catch (Exception e) {
					if(menu.getAttribute("class").contains("dropbtn dropbtn1"))
						menuList_collection.add(menu.getText().trim().toLowerCase().replace(" ", "_"));				}				
			}

		for(String menutxt:menuList_collection)
		{
			if(menutxt.length()>0)
			{
				handle_ajax_call.HandleAjaxCall();
				Thread.sleep(2000);
				WebElement menu = Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
				/*WebElement menu =Driver.findElement(By.cssSelector("ul[class='unstyled navbar nav']"));*/
				menu=menu.findElement(By.xpath(".//a[normalize-space(@data-target) = '"+menutxt+"'] | .//a[normalize-space(@data-gtmd) = '"+menutxt+"'] | .//a[contains(text(),'"+menutxt+"')]"));				
				hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
				try {
					if(hamburger.isDisplayed() && !menu.isDisplayed())
						hamburger.click();
				} catch (Exception e1) {
				}			
				
				act.moveToElement(menu).build().perform();			
				switch(menutxt)
				{
				case "about":
				{									
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!about");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "menu":
				{								
					menu.click();
					Thread.sleep(2000);
					try 
					{
						Driver.findElement(By.xpath("//div[normalize-space(@id) = 'myDropdown']"));
						WebElement menu_click=Driver.findElement(By.xpath("//div[normalize-space(@id) = 'myDropdown']//a[normalize-space(@data-target) = 'menu'] | //div[normalize-space(@id) = 'myDropdown']//a[normalize-space(@data-gtmd) = 'menu']"));
						menu_click.click();
					}
					catch(Exception e)
					{}
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!menu");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "gallery":
				{
					
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!gallery");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "family_style_dining":
				{
					
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!familystylemenu.html");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "newsletter":
				{
					
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!newsletter");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "lab":
				{
					
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!newsletter");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "careers":
				{
					
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					
					try
					{
						Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'career']"));
						Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
					}
					catch(Exception e)
					{
						Status=common_action.VerifyURL(url+"#!catering");
					}
					
					
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "contact":
				{
					
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!contact");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "private_parties":
				{
					
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					Status=common_action.VerifyURL(url+"#!private_parties");
					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				case "catering":
				{
					menu.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);				
					
					try
					{
						Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@class) = 'catering_booking psection'][normalize-space(@id) = 'catering'] | //div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@class) = 'catering_booking psection catering_popup'][normalize-space(@id) = 'catering']"));
						Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
					}
					catch(Exception e)
					{
						Status=common_action.VerifyURL(url+"#!catering");
					}

					if(Status==0)
					{
						errorlog.add("incorrect url for: "+menutxt);
						log_system.error("incorrect url for: "+menutxt);
					}
						
					break;
				}
				}
			}
		}
		
		if(errorlog.size()>0)
			Status=0;
		else
			Status=1;
		return Status;
	}

}
