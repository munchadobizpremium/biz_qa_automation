package action;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import global_utility.global_variables;
import global_utility.handle_ajax_call;

public class action_career extends global_variables{
	
	action_common common_action=new action_common();
	int Status=0;
	public int verifyCareer() throws Exception
	{
		ArrayList<String> errorlog=new ArrayList<String>();
		Actions act=new Actions(Driver);
		
		if(Driver.getPageSource().contains("career"))
		{
			
			
			WebElement hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
			WebElement ele_career=null;		
			if(hamburger.isDisplayed())
			{
				try {
					try {
						hamburger.click();
						ele_career=Driver.findElement(By.xpath("//a[normalize-space(@data-gtmd) = 'career']"));
					} catch (Exception e) {
						ele_career=Driver.findElement(By.xpath("//a[normalize-space(@data-gtmd) = 'career']"));					}
				} catch (Exception e) {
					try {
						ele_career=Driver.findElement(By.xpath("//a[normalize-space(@data-gtmd) = 'career']"));
					} catch (Exception e1) {
						Status=2;
					}
				}			
			}
			else
			{
				try {
					ele_career=Driver.findElement(By.xpath("//a[normalize-space(@data-gtmd) = 'career']"));
				} catch (Exception e1) {
					Status=2;
				}
			}
			
			if(Status!=2)
			{
				if(!ele_career.isDisplayed() && !hamburger.isDisplayed())
					Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_downstyle']")).click();
				
				act.moveToElement(ele_career).build().perform();
				Status=common_action.Click(ele_career);
				Thread.sleep(2000);
				WebElement careerpop=null;
				if(Status==1)
				{
					try 
					{
						careerpop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'career']"));
					}
					catch(Exception e)
					{
						
					}
					WebElement ele_submit=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn careersubmit']"));
					if(common_action.Click(ele_submit)!=1)
					{
						errorlog.add("user is not able to click on submit button");
						log_system.error("user is not able to click on submit button");
					}
										
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(3000);
					handle_ajax_call.HandleAjaxCall();
					
					if(common_action.VerifyText("ByXPath", "//input[@id='c_name']/following-sibling::p", "Sorry, We don't talk to strangers")!=1)
					{
						errorlog.add("validation missing: Sorry, We don't talk to strangers");
						log_system.error("validation missing: Sorry, We don't talk to strangers");
					}
						
					
					if(common_action.VerifyText("ByXPath", "//input[@id='c_email']/following-sibling::p", "Hey, you forgot something")!=1)
					{
						errorlog.add("validation missing: Hey, you forgot something");
						log_system.error("validation missing: Hey, you forgot something");
					}
						
					
					if(common_action.VerifyText("ByXPath", "//textarea[@id='c_message']/following-sibling::p", "Hey, you forgot something")!=1)
					{
						errorlog.add("validation missing: Sorry, We don't talk to strangers");
						log_system.error("validation missing: Sorry, We don't talk to strangers");
					}
						
									
					
					if(common_action.SetText("ByID", "c_name", "Akash Sangal")!=1)
					{
						errorlog.add("user is not able to enter user name");
						log_system.error("user is not able to enter user name");
					}
						
					
					if(common_action.SetText("ByID", "c_email", "a@")!=1)
					{
						errorlog.add("user is not able to enter email id");
						log_system.error("user is not able to enter email id");
					}
						
					
					if(common_action.Click(ele_submit)!=1)
					{
						errorlog.add("user is not able to click on submit button");
						log_system.error("user is not able to click on submit button");
					}
						
					
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(1000);
					handle_ajax_call.HandleAjaxCall();
					
					if(common_action.VerifyText("ByXPath", "//input[@id='c_email']/following-sibling::p", "That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!")!=1)
					{
						errorlog.add("validation missing: That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!");
						log_system.error("validation missing: That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!");
					}
						
					
					if(common_action.SetText("ByID", "c_name", "Akash Sangal")!=1)
					{
						errorlog.add("user is not able to enter user name");
						log_system.error("user is not able to enter user name");
					}
						
					
					if(common_action.SetText("ByID", "c_email", "a@a.com")!=1)
					{
						errorlog.add("user is not able to enter email id");
						log_system.error("user is not able to enter email id");
					}
						
					
					if(common_action.SetText("ByID", "c_message", "demo")!=1)
					{
						errorlog.add("user is not able to enter instruction");
						log_system.error("user is not able to enter instruction");
					}
						
					
					if(common_action.Click(ele_submit)!=1)
					{
						errorlog.add("user is not able to click on submit button");
						log_system.error("user is not able to click on submit button");
					}
						
					
					
					Thread.sleep(3000);
					
					
					if(common_action.VerifyText("ByXPath", "//div[normalize-space(@class) = 'application-success']", "Thank you for your message. We will try to answer as soon as possible.")!=1)
					{
						errorlog.add("validation missing: Thank you for your message. We will try to answer as soon as possible.");
						log_system.error("validation missing: Thank you for your message. We will try to answer as soon as possible.");
					}
						
					
					if(careerpop!=null)
					{
						Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
						
						handle_ajax_call.HandleAjaxCall();
						Thread.sleep(1000);
						handle_ajax_call.HandleAjaxCall();
						
						
						try
						{
							careerpop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'career']"));
							careerpop.isDisplayed();
							errorlog.add("not able to close career popup");
							log_system.error("not able to close career popup");
						}
						catch(Exception e)
						{
							
						}
							
					}
					
				}
				else
				{
					errorlog.add("user is not able to click on Career link");
					log_system.error("user is not able to click on Career link");
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
			}
		else
		{
			Status=2;
		}
		
		return Status;
	}

}
