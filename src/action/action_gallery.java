package action;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import global_utility.global_variables;
import global_utility.handle_ajax_call;

public class action_gallery extends global_variables{
	
	action_common common_action=new action_common();
	int Status=0;
	public int verifyGallery() throws Exception
	{
		
		
		ArrayList<String> errorlog=new ArrayList<String>();
		Actions act=new Actions(Driver);
		
		if(Driver.getPageSource().contains("gallery"))
		{
			
			
			WebElement hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
			/*WebElement hamburger=Driver.findElement(By.cssSelector("i[class='i_hamburger']"));*/
			WebElement ele_gallery=null;		
			if(hamburger.isDisplayed())
			{
				try {
					hamburger.click();
					
					ele_gallery=Driver.findElement(By.xpath("//a[normalize-space(@data-gtmd) = 'gallery'] | //a[normalize-space(@data-target) = 'gallery']"));
				} catch (Exception e) {
					ele_gallery=Driver.findElement(By.xpath("//a[normalize-space(@data-gtmd) = 'gallery'] | //a[normalize-space(@data-target) = 'gallery']"));
				}			
			}
			else
			{
				ele_gallery=Driver.findElement(By.xpath("//a[normalize-space(@data-gtmd) = 'gallery'] | //a[normalize-space(@data-target) = 'gallery']"));
			}
			
				
			if(!ele_gallery.isDisplayed() && !hamburger.isDisplayed()) {
				Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_downstyle']")).click();
				/*Driver.findElement(By.cssSelector("i[class='i_downstyle']")).click();*/
			}
			act.moveToElement(ele_gallery).build().perform();
			Status=common_action.Click(ele_gallery);
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(1000);
			handle_ajax_call.HandleAjaxCall();
			
			WebElement gallerypop=null;
			if(Status==1)
			{
				try 
				{
					gallerypop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'gallery']"));
				}
				catch(Exception e)
				{
					
				}
				
				WebElement ele_gallery_nxt_btn=Driver.findElement(By.xpath("//div[normalize-space(@id) = 'gallery']"));
				ele_gallery_nxt_btn=ele_gallery_nxt_btn.findElement(By.xpath(".//div[normalize-space(@class) = 'owl-next']"));
				
				act.moveToElement(ele_gallery_nxt_btn).build().perform();
				common_action.Click(ele_gallery_nxt_btn);
				handle_ajax_call.HandleAjaxCall();
				Thread.sleep(1000);
				handle_ajax_call.HandleAjaxCall();
				
				WebElement ele_gallery_pre_btn=Driver.findElement(By.xpath("//div[normalize-space(@id) = 'gallery']"));
				ele_gallery_pre_btn=ele_gallery_pre_btn.findElement(By.xpath(".//div[normalize-space(@class) = 'owl-prev']"));
				act.moveToElement(ele_gallery_pre_btn).build().perform();
				common_action.Click(ele_gallery_pre_btn);
				handle_ajax_call.HandleAjaxCall();
				Thread.sleep(1000);
				handle_ajax_call.HandleAjaxCall();
				
				WebElement ele_gallery_pre_btn1=Driver.findElement(By.xpath("//div[normalize-space(@id) = 'gallery']"));
				ele_gallery_pre_btn1=ele_gallery_pre_btn1.findElement(By.xpath(".//div[normalize-space(@class) = 'owl-prev']"));
				act.moveToElement(ele_gallery_pre_btn1).build().perform();
				common_action.Click(ele_gallery_pre_btn1);
				handle_ajax_call.HandleAjaxCall();
				Thread.sleep(1000);
				handle_ajax_call.HandleAjaxCall();
				
				if(gallerypop!=null)
				{
					Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
										
					try
					{
						gallerypop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'gallery']"));
						gallerypop.isDisplayed();
						errorlog.add("not able to close gallery popup");
					}
					catch(Exception e) {}
				}				
			}
			else
			{
				errorlog.add("user is not able to click on gallery link");
				log_system.error("user is not able to click on gallery link");
			}
			
			
			
		}
		else
		{
			Status=2;
		}
		
		if(errorlog.size()==0 && Status!=2)
		{
			Status=1;
		}
		
		return Status;
	}

}
