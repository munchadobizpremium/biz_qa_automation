package action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import global_utility.global_variables;

public class action_checkout extends global_variables{

	action_common common_action=new action_common();
	action_product product_action =new action_product();
	public int CheckoutforTakeout(String city,String timeslot,String Address,String Tax) throws Exception
	{
		ArrayList<String> errorLog=new ArrayList<String>();
		int Status=0;
		Actions act =new Actions(Driver);
		
		if(ProductDetails.size()>0)
		{
			WebElement DeliveryTime=Driver.findElement(By.xpath("//span[normalize-space(@class) = 't-operation-hours']"));
			String TimeZone=DeliveryTime.getText();
			ArrayList<String> TimeSlot=getTimeSlot(TimeZone, timeslot, city);
			Calendar actualtime=timeSelect(city);
			WebElement checkoutfortakeout=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn y-checkoutBtn']"));
			act.moveToElement(checkoutfortakeout);
			checkoutfortakeout.click();
			Thread.sleep(2000);

			WebElement checkout_section=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'menu_checkout clearfix']"));
			List<WebElement> all_input=checkout_section.findElements(By.tagName("input"));
			
			int count =0;
			for(WebElement inputs: all_input)
			{
				if(!inputs.getAttribute("name").contains("instructions[]") && inputs.isEnabled())				
				inputs.clear();
				count++;
			}
			
						
			if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'checkoutDiv']")==1)
			{
				if(common_action.VerifyElement("ByXPath", "//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")==1)
				{					
					if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
					{
						if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message']", "Sorry, We don't talk to strangers")!=1)
						{
							errorLog.add("Incorrect message for Name 'Sorry, We don't talk to strangers'");
							log_system.error("Incorrect message for Name 'Sorry, We don't talk to strangers'");
						}
						
						if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message error-phoneNo']", "We promise; No prank calls")!=1)
						{
							errorLog.add("Incorrect message for Phone 'We promise; No prank calls'");
							log_system.error("Incorrect message for Phone 'We promise; No prank calls'");
						}
						
						if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Hey, you forgot something')]", "Hey, you forgot something")!=1)
						{
							errorLog.add("Incorrect message for Email 'Hey, you forgot something'");
							log_system.error("Incorrect message for Email 'Hey, you forgot something'");
						}
						
						if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'first_name']")==1)
						{
							if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'first_name']", "Akash")==1)
							{
								if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'last_name']")==1)
								{
									if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'last_name']", "Sangal")==1)
									{
										if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'phone_no']")==1)
										{
											if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'phone_no']", "1234")==1)
											{
												if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
												{
													
													if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message error-phoneNo']", "You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx")!=1)
													{
														errorLog.add("Incorrect message for Phone 'You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx'");
														log_system.error("Incorrect message for Phone 'You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx'");
													}
													
													if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Hey, you forgot something')]", "Hey, you forgot something")!=1)
													{
														errorLog.add("Incorrect message for Email 'Hey, you forgot something'");
														log_system.error("Incorrect message for Email 'Hey, you forgot something'");
													}
													
													if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'phone_no']", "1234567890")==1)
													{
														if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'email']", "a")==1)
														{
															if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
															{
																if(common_action.VerifyText("ByXPath", "//p[contains(text(),'look like any e-mail I ever seen.')]", "That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!")!=1)
																{
																	errorLog.add("Incorrect message for Email 'That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!'");
																	log_system.error("Incorrect message for Email 'That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!'");
																}
																
																if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'email']", "a@a.com")==1)
																{
																	if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																	{
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'And whose card is this?')]", "And whose card is this?")!=1)
																		{
																			errorLog.add("message should appear on the screen for Name on card: 'And whose card is this?' ");	
																			log_system.error("message should appear on the screen for Name on card: 'And whose card is this?' ");
																		}
																		
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Try rubbing your fingers over the numbers, that helps us get')]", "Try rubbing your fingers over the numbers, that helps us get 'em right")!=1)
																		{
																			errorLog.add("message should appear on the screen for card number: 'Try rubbing your fingers over the numbers, that helps us get 'em right' ");	
																			log_system.error("message should appear on the screen for card number: 'Try rubbing your fingers over the numbers, that helps us get 'em right' ");
																		}
																		
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'It would be irresponsible of us not to require this.')]", "It would be irresponsible of us not to require this.")!=1)
																		{
																			errorLog.add("message should appear on the screen for Name on card: 'It would be irresponsible of us not to require this.' ");	
																			log_system.error("message should appear on the screen for Name on card: 'It would be irresponsible of us not to require this.' ");
																		}
																		
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Come on, you gave us all the other info. Why you holding out?')]", "Come on, you gave us all the other info. Why you holding out?")!=1)
																		{
																			if(count==0)
																			{
																				errorLog.add("message should appear on the screen for Name on card: 'Come on, you gave us all the other info. Why you holding out?' ");	
																				log_system.error("message should appear on the screen for Name on card: 'Come on, you gave us all the other info. Why you holding out?' ");
																			}
																			
																		}
																		
																		if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'card_name']")==1)
																		{
																			if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_name']", "Akash sangal")==1)
																			{
																				if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_number']", "1234")==1)
																				{
																					if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																					{
																						if(common_action.VerifyText("ByXPath", "//p[contains(text(),'We need all of the numbers on the card. All of')]", "We need all of the numbers on the card. All of 'em")!=1)
																						{
																							errorLog.add("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");	
																							log_system.error("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");
																						}
																						
																						if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_number']", "4111111111111111")==1)
																						{
																							if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'cvv_code']")==1)
																							{
																								if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'cvv_code']", "4")==1)
																								{
																									if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																									{
																										if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Try looking a little closer at the card  or maybe your card  number is wrong.')]", "Hmm, that's not it. Try looking a little closer at the card  or maybe your card  number is wrong.")!=1)
																										{
																											errorLog.add("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");	
																											log_system.error("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");
																										}
																										
																										if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'cvv_code']", "123")==1)
																										{
																											if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'zip']")==1)
																											{
																												if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'zip']", "1")==1)
																												{
																													if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																													{
																														if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Billing zip should be 5 digits.')]", "Billing zip should be 5 digits.")!=1)
																														{
																															errorLog.add("message should appear on the screen for zip: 'Billing zip should be 5 digits. ");	
																															log_system.error("message should appear on the screen for zip: 'Billing zip should be 5 digits. ");
																														}
																														if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'zip']", "12345")==1)
																														{
																															
																															if(product_action.VerifySummary("ByXPath", "//div[normalize-space(@class) = 'box_ordersummary ordersummarystep2']", Tax)!=1)
																															{
																																errorLog.add("Incorrect Summary is appearing on checkout screen for takeout");
																																log_system.error("Incorrect Summary is appearing on checkout screen for takeout");
																															}
																															
																															if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'subtitle_first text-capitalize y-orderType']", "takeout")!=1)
																															{
																																errorLog.add("Incorrect Order Type");
																																log_system.error("Incorrect Order Type");
																															}
																															if(!TimeSlot.isEmpty())
																															{
																																TimeSlot.remove(0);
																																String ActiveTimeSlot=ActiveTimeSlot(TimeSlot,actualtime,city);
																																String DisplayedTime=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'subtitle_first y-expectedTime']")).getText().split("at")[1].trim();
																																if(ActiveTimeSlot!=null)
																																{
																																	if(!ActiveTimeSlot.contains(DisplayedTime))
																																	{
																																		errorLog.add("Incorrect takeout time is appearing on the screen");
																																		log_system.error("Incorrect takeout time is appearing on the screen");
																																	}																																	
																																}
																																
																															}
																															
																															if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																															{
																																Thread.sleep(4000);
																																if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'res_menu']")==1)
																																{
																																	Status=1;
																																	ProductDetails.clear();
																																}
																																else
																																{
																																	if(!Driver.getCurrentUrl().contains("https://qc"))
																																	{
																																		ProductDetails.clear();
																																		errorLog.add("Checkout message is not appearing on the screen");
																																		log_system.error("Checkout message is not appearing on the screen");
																																	}
																																	else
																																	{
																																		
																																	}
																																	
																																}
																															}
																															else
																															{
																																errorLog.add("User is not able to click on Place my order button");
																																log_system.error("User is not able to click on Place my order button");
																															}
																														}
																														else
																														{
																															errorLog.add("user is not able to enter zip code");
																															log_system.error("user is not able to enter zip code");
																														}
																													}
																													else
																													{
																														errorLog.add("user is not able to click on place my oder button");
																														log_system.error("user is not able to click on place my oder button");
																													}
																												}
																												else
																												{
																													errorLog.add("user is not able to enter zip code");
																													log_system.error("user is not able to enter zip code");
																												}
																											}
																											else
																											{
																												errorLog.add("zip code textbox is not appearing on the screen");
																												log_system.error("zip code textbox is not appearing on the screen");
																											}
																										}
																										else
																										{
																											errorLog.add("user is not able to enter cvv code");
																											log_system.error("user is not able to enter cvv code");
																										}
																									}
																									else
																									{
																										errorLog.add("user is not able to click on place my oder button");
																										log_system.error("user is not able to click on place my oder button");
																									}
																									
																								}
																								else
																								{
																									errorLog.add("user is not able to enter cvv code");
																									log_system.error("user is not able to enter cvv code");
																								}
																							}
																							else
																							{
																								errorLog.add("CVV code textbox is not appearing on the screen");
																								log_system.error("CVV code textbox is not appearing on the screen");
																							}
																						}
																						else
																						{
																							errorLog.add("user is not able to enter card number");
																							log_system.error("user is not able to enter card number");
																						}
																						
																						
																					}
																					else
																					{
																						errorLog.add("user is not able to click on place my order button");
																						log_system.error("user is not able to click on place my order button");
																					}
																				}
																				else
																				{
																					errorLog.add("user is not able to enter card number");
																					log_system.error("user is not able to enter card number");
																				}
																			}
																			else
																			{
																				errorLog.add("user is not able to enter name on card");
																				log_system.error("user is not able to enter name on card");
																			}
																		}
																		else
																		{
																			errorLog.add("Name on card textbox is not appearing on the screen");
																			log_system.error("Name on card textbox is not appearing on the screen");
																		}
																	}
																	else
																	{
																		errorLog.add("user is not able to click on place my order button");
																		log_system.error("user is not able to click on place my order button");
																	}
																																		
																	
																}
																else
																{
																	errorLog.add("user is not able to enter email id");
																	log_system.error("user is not able to enter email id");
																}
																
																
															}
															else
															{
																errorLog.add("user is not able to click on place my order button");
																log_system.error("user is not able to click on place my order button");
															}
														}
														else
														{
															errorLog.add("user is not able to enter email id");
															log_system.error("user is not able to enter email id");
														}
													}
													else
													{
														errorLog.add("user is not able to enter PhoneNumber");
														log_system.error("user is not able to enter PhoneNumber");
													}
													
												}
												else
												{
													errorLog.add("user is not able to click on place my order button");
													log_system.error("user is not able to click on place my order button");
												}
											}
											else
											{
												errorLog.add("user is not able to enter PhoneNumber");
												log_system.error("user is not able to enter PhoneNumber");
											}
										}
										else
										{
											errorLog.add("Phone number text box is not appearing on the screen");
											log_system.error("Phone number text box is not appearing on the screen");
										}
									}
									else
									{
										errorLog.add("user is not able to enter Last name");
										log_system.error("user is not able to enter Last name");
									}
								}
								else
								{
									errorLog.add("Last name text box is not appearing on the screen");
									log_system.error("Last name text box is not appearing on the screen");
								}
							}
							else
							{
								errorLog.add("user is not able to enter first name");
								log_system.error("user is not able to enter first name");
							}
						}
						else
						{
							errorLog.add("First name text box is not appearing on the screen");
							log_system.error("First name text box is not appearing on the screen");
						}
						
					}
					else
					{
						errorLog.add("User is not able to click on Place my order buttn");
						log_system.error("User is not able to click on Place my order buttn");
					}
				}
				else
				{
					errorLog.add("Place my order button is not appearing on the screen");
					log_system.error("Place my order button is not appearing on the screen");
				}
			}
			else
			{
				errorLog.add("user is not able to navigate to checkout page");
				log_system.error("user is not able to navigate to checkout page");
			}
		}
		else
		{
			Status=2;
		}
		
		
		if(errorLog.size()>0)
		{
			try {
				if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
				{
					Thread.sleep(4000);
					if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'res_menu']")==1)
					{
						Status=1;
						ProductDetails.clear();
					}
					else
					{
						if(!Driver.getCurrentUrl().contains("https://qc"))
						{
							ProductDetails.clear();
							errorLog.add("Checkout message is not appearing on the screen");
							log_system.error("Checkout message is not appearing on the screen");
						}
						else
						{
							
						}
						
					}
				}
				else
				{
					errorLog.add("User is not able to click on Place my order button");
					log_system.error("User is not able to click on Place my order button");
				}
			} catch (Exception e) {
				
				
			}
			Status=0;
		}
		else
		{
			
		}
		
		return Status;
	}
	

	public int CheckoutforTakeoutWithEdit(String city,String timeslot,String Address,String Tax) throws Exception
	{
		ArrayList<String> errorLog=new ArrayList<String>();
		int Status=0;
		Actions act =new Actions(Driver);
		
		if(ProductDetails.size()>0)
		{
			WebElement DeliveryTime=Driver.findElement(By.xpath("//span[normalize-space(@class) = 't-operation-hours']"));
			String TimeZone=DeliveryTime.getText();
			ArrayList<String> TimeSlot=getTimeSlot(TimeZone, timeslot, city);
			int preorder=0;
			if(!TimeZone.contains("Today"))
			{
				preorder++;
			}
			
			Calendar actualtime=timeSelect(city);
			WebElement checkoutfortakeout=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn y-checkoutBtn']"));
			act.moveToElement(checkoutfortakeout);
			checkoutfortakeout.click();
			Thread.sleep(2000);

			if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'checkoutDiv']")==1)
			{
				if(common_action.VerifyElement("ByXPath", "//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")==1)
				{					
					if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
					{
						if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message']", "Sorry, We don't talk to strangers")!=1)
						{
							errorLog.add("Incorrect message for Name 'Sorry, We don't talk to strangers'");
							log_system.error("Incorrect message for Name 'Sorry, We don't talk to strangers'");
						}
						
						if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message error-phoneNo']", "We promise; No prank calls")!=1)
						{
							errorLog.add("Incorrect message for Phone 'We promise; No prank calls'");
							log_system.error("Incorrect message for Phone 'We promise; No prank calls'");
						}
						
						if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Hey, you forgot something')]", "Hey, you forgot something")!=1)
						{
							errorLog.add("Incorrect message for Email 'Hey, you forgot something'");
							log_system.error("Incorrect message for Email 'Hey, you forgot something'");
						}
						
						if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'first_name']")==1)
						{
							if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'first_name']", "Akash")==1)
							{
								if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'last_name']")==1)
								{
									if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'last_name']", "Sangal")==1)
									{
										if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'phone_no']")==1)
										{
											if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'phone_no']", "1234")==1)
											{
												if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
												{
													
													if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message error-phoneNo']", "You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx")!=1)
													{
														errorLog.add("Incorrect message for Phone 'You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx'");
														log_system.error("Incorrect message for Phone 'You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx'");
													}
													
													if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Hey, you forgot something')]", "Hey, you forgot something")!=1)
													{
														errorLog.add("Incorrect message for Email 'Hey, you forgot something'");
														log_system.error("Incorrect message for Email 'Hey, you forgot something'");
													}
													
													if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'phone_no']", "1234567890")==1)
													{
														if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'email']", "a")==1)
														{
															if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
															{
																if(common_action.VerifyText("ByXPath", "//p[contains(text(),'look like any e-mail I ever seen.')]", "That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!")!=1)
																{
																	errorLog.add("Incorrect message for Email 'That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!'");
																	log_system.error("Incorrect message for Email 'That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!'");
																}
																
																if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'email']", "a@a.com")==1)
																{
																	if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																	{
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'And whose card is this?')]", "And whose card is this?")!=1)
																		{
																			errorLog.add("message should appear on the screen for Name on card: 'And whose card is this?' ");	
																			log_system.error("message should appear on the screen for Name on card: 'And whose card is this?' ");
																		}
																		
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Try rubbing your fingers over the numbers, that helps us get')]", "Try rubbing your fingers over the numbers, that helps us get 'em right")!=1)
																		{
																			errorLog.add("message should appear on the screen for card number: 'Try rubbing your fingers over the numbers, that helps us get 'em right' ");	
																			log_system.error("message should appear on the screen for card number: 'Try rubbing your fingers over the numbers, that helps us get 'em right' ");
																		}
																		
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'It would be irresponsible of us not to require this.')]", "It would be irresponsible of us not to require this.")!=1)
																		{
																			errorLog.add("message should appear on the screen for Name on card: 'It would be irresponsible of us not to require this.' ");	
																			log_system.error("message should appear on the screen for Name on card: 'It would be irresponsible of us not to require this.' ");
																		}
																		
																		if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Come on, you gave us all the other info. Why you holding out?')]", "Come on, you gave us all the other info. Why you holding out?")!=1)
																		{
																			errorLog.add("message should appear on the screen for Name on card: 'Come on, you gave us all the other info. Why you holding out?' ");	
																			log_system.error("message should appear on the screen for Name on card: 'Come on, you gave us all the other info. Why you holding out?' ");
																		}
																		
																		if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'card_name']")==1)
																		{
																			if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_name']", "Akash sangal")==1)
																			{
																				if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_number']", "1234")==1)
																				{
																					if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																					{
																						if(common_action.VerifyText("ByXPath", "//p[contains(text(),'We need all of the numbers on the card. All of')]", "We need all of the numbers on the card. All of 'em")!=1)
																						{
																							errorLog.add("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");	
																							log_system.error("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");
																						}
																						
																						if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_number']", "4111111111111111")==1)
																						{
																							if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'cvv_code']")==1)
																							{
																								if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'cvv_code']", "4")==1)
																								{
																									if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																									{
																										if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Try looking a little closer at the card  or maybe your card  number is wrong.')]", "Hmm, that's not it. Try looking a little closer at the card  or maybe your card  number is wrong.")!=1)
																										{
																											errorLog.add("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");	
																											log_system.error("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");
																										}
																										
																										if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'cvv_code']", "123")==1)
																										{
																											if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'zip']")==1)
																											{
																												if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'zip']", "1")==1)
																												{
																													if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																													{
																														if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Billing zip should be 5 digits.')]", "Billing zip should be 5 digits.")!=1)
																														{
																															errorLog.add("message should appear on the screen for zip: 'Billing zip should be 5 digits. ");	
																															log_system.error("message should appear on the screen for zip: 'Billing zip should be 5 digits. ");
																														}
																														if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'zip']", "12345")==1)
																														{
																															
																															
																															if(product_action.VerifySummary("ByXPath", "//div[normalize-space(@class) = 'box_ordersummary ordersummarystep2']", Tax)==1)
																															{
																																if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'subtitle_first text-capitalize y-orderType']", "takeout")!=1)
																																{
																																	errorLog.add("Incorrect Order Type");
																																	log_system.error("Incorrect Order Type");
																																}
																																if(!TimeSlot.isEmpty())
																																{
																																	TimeSlot.remove(0);
																																	String ActiveTimeSlot=null;
																																	if(preorder>0)
																																	{
																																		JavascriptExecutor js = (JavascriptExecutor)Driver;
																																		js.executeScript("window.scrollTo(0,500)");
																																		if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn'] | //a[normalize-space(@class) = 't-edit_order_link ubtn blackbtn']")))==1)
																																		{
																																			Status=1;
																																		}
																																		else
																																		{
																																			errorLog.add("Edit button is not working");
																																			log_system.error("Edit button is not working");
																																			
																																		}
																																	}
																																	else
																																	{
																																		ActiveTimeSlot=ActiveTimeSlot(TimeSlot,actualtime,city);
																																		
																																		if(ActiveTimeSlot!=null)
																																		{
																																			String DisplayedTime=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'subtitle_first y-expectedTime']")).getText().split("at")[1].trim();				
																																			if(ActiveTimeSlot.contains(DisplayedTime))
																																			{
																																				JavascriptExecutor js = (JavascriptExecutor)Driver;
																																				js.executeScript("window.scrollTo(0,500)");
																																				if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn'] | //a[normalize-space(@class) = 't-edit_order_link ubtn blackbtn']")))==1)
																																				{
																																					Status=1;
																																				}
																																				else
																																				{
																																					errorLog.add("Edit button is not working");
																																					log_system.error("Edit button is not working");
																																					
																																				}
																																			}
																																			else
																																			{
																																				errorLog.add("Incorrect takeout time is appearing on the screen");
																																				log_system.error("Incorrect takeout time is appearing on the screen");
																																			}
																																		}
																																		else
																																		{
																																			JavascriptExecutor js = (JavascriptExecutor)Driver;
																																			js.executeScript("window.scrollTo(0,500)");
																																			if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn'] | //a[normalize-space(@class) = 't-edit_order_link ubtn blackbtn']")))==1)
																																			{
																																				Status=1;
																																			}
																																			else
																																			{
																																				errorLog.add("Edit button is not working");
																																				log_system.error("Edit button is not working");
																																				
																																			}
																																		}
																																		
																																	}
																																}
																																else
																																{
																																	JavascriptExecutor js = (JavascriptExecutor)Driver;
																																	js.executeScript("window.scrollTo(0,500)");
																																	if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn'] | //a[normalize-space(@class) = 't-edit_order_link ubtn blackbtn']")))==1)
																																	{
																																		Status=1;
																																	}
																																	else
																																	{
																																		errorLog.add("Edit button is not working");
																																		log_system.error("Edit button is not working");
																																		
																																	}
																																}
																															}
																															else
																															{
																																errorLog.add("Incorrect Summary is appearing on checkout screen for takeout");
																																log_system.error("Incorrect Summary is appearing on checkout screen for takeout");
																																JavascriptExecutor js = (JavascriptExecutor)Driver;
																																js.executeScript("window.scrollTo(0,500)");
																																if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn'] | //a[normalize-space(@class) = 't-edit_order_link ubtn blackbtn']")))==1)
																																{																																	
																																}
																																else
																																{
																																	errorLog.add("Edit button is not working");
																																	log_system.error("Edit button is not working");
																																	
																																}
																															}
																														}
																														else
																														{
																															errorLog.add("user is not able to enter zip code");
																															log_system.error("user is not able to enter zip code");
																														}
																													}
																													else
																													{
																														errorLog.add("user is not able to click on place my oder button");
																														log_system.error("user is not able to click on place my oder button");
																													}
																												}
																												else
																												{
																													errorLog.add("user is not able to enter zip code");
																													log_system.error("user is not able to enter zip code");
																												}
																											}
																											else
																											{
																												errorLog.add("zip code textbox is not appearing on the screen");
																												log_system.error("zip code textbox is not appearing on the screen");
																											}
																										}
																										else
																										{
																											errorLog.add("user is not able to enter cvv code");
																											log_system.error("user is not able to enter cvv code");
																										}
																									}
																									else
																									{
																										errorLog.add("user is not able to click on place my oder button");
																										log_system.error("user is not able to click on place my oder button");
																									}
																									
																								}
																								else
																								{
																									errorLog.add("user is not able to enter cvv code");
																									log_system.error("user is not able to enter cvv code");
																								}
																							}
																							else
																							{
																								errorLog.add("CVV code textbox is not appearing on the screen");
																								log_system.error("CVV code textbox is not appearing on the screen");
																							}
																						}
																						else
																						{
																							errorLog.add("user is not able to enter card number");
																							log_system.error("user is not able to enter card number");
																						}
																						
																						
																					}
																					else
																					{
																						errorLog.add("user is not able to click on place my order button");
																						log_system.error("user is not able to click on place my order button");
																					}
																				}
																				else
																				{
																					errorLog.add("user is not able to enter card number");
																					log_system.error("user is not able to enter card number");
																				}
																			}
																			else
																			{
																				errorLog.add("user is not able to enter name on card");
																				log_system.error("user is not able to enter name on card");
																			}
																		}
																		else
																		{
																			errorLog.add("Name on card textbox is not appearing on the screen");
																			log_system.error("Name on card textbox is not appearing on the screen");
																		}
																	}
																	else
																	{
																		errorLog.add("user is not able to click on place my order button");
																		log_system.error("user is not able to click on place my order button");
																	}
																																		
																	
																}
																else
																{
																	errorLog.add("user is not able to enter email id");
																	log_system.error("user is not able to enter email id");
																}
																
																
															}
															else
															{
																errorLog.add("user is not able to click on place my order button");
																log_system.error("user is not able to click on place my order button");
															}
														}
														else
														{
															errorLog.add("user is not able to enter email id");
															log_system.error("user is not able to enter email id");
														}
													}
													else
													{
														errorLog.add("user is not able to enter PhoneNumber");
														log_system.error("user is not able to enter PhoneNumber");
													}
													
												}
												else
												{
													errorLog.add("user is not able to click on place my order button");
													log_system.error("user is not able to click on place my order button");
												}
											}
											else
											{
												errorLog.add("user is not able to enter PhoneNumber");
												log_system.error("user is not able to enter PhoneNumber");
											}
										}
										else
										{
											errorLog.add("Phone number text box is not appearing on the screen");
											log_system.error("Phone number text box is not appearing on the screen");
										}
									}
									else
									{
										errorLog.add("user is not able to enter Last name");
										log_system.error("user is not able to enter Last name");
									}
								}
								else
								{
									errorLog.add("Last name text box is not appearing on the screen");
									log_system.error("Last name text box is not appearing on the screen");
								}
							}
							else
							{
								errorLog.add("user is not able to enter first name");
								log_system.error("user is not able to enter first name");
							}
						}
						else
						{
							errorLog.add("First name text box is not appearing on the screen");
							log_system.error("First name text box is not appearing on the screen");
						}
						
					}
					else
					{
						errorLog.add("User is not able to click on Place my order buttn");
						log_system.error("User is not able to click on Place my order buttn");
					}
				}
				else
				{
					errorLog.add("Place my order button is not appearing on the screen");
					log_system.error("Place my order button is not appearing on the screen");
				}
			}
			else
			{
				errorLog.add("user is not able to navigate to checkout page");
				log_system.error("user is not able to navigate to checkout page");
			}
		}
		else
		{
			Status=2;
		}
		
		
		if(errorLog.size()>0)
		{
			try {
				JavascriptExecutor js = (JavascriptExecutor)Driver;
				js.executeScript("window.scrollTo(0,500)");
				common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn']")));
			} catch (Exception e) {
				
			}			
			Status=0;
		}
		else
		{
			
		}
		
		return Status;
	}
	

	
	
	@SuppressWarnings("unused")
	public int CheckoutforDelivery(String city,String timeslot,String Address,String Tax) throws Exception
	{
		ArrayList<String> errorLog=new ArrayList<String>();
		int Status=0;
		Actions act =new Actions(Driver);
		WebElement delivery=null;
		try {
			delivery = Driver.findElement(By.xpath("//label[normalize-space(@class) = 'ubtn btn_service'][normalize-space(@for) = 't_delivery'] | //label[normalize-space(@class) = 'ubtn blackbtn btn_service'][normalize-space(@for) = 't_delivery']"));
		} catch (Exception e) {
			Status=2;		
			}
		
		try {
			if(!Driver.findElement(By.xpath("//p[normalize-space(@class) = 'txt_upper']")).getText().contains("Today"))
			{
				Status=2;
			}
		} catch (Exception e1) {
			
		}
		
		if(Status!=2)
		{
			if(ProductDetails.size()>0)
			{
				WebElement DeliveryTime=Driver.findElement(By.xpath("//span[normalize-space(@class) = 't-operation-hours']"));
				String TimeZone=DeliveryTime.getText();
				ArrayList<String> TimeSlot=getTimeSlot(TimeZone, timeslot, city);
				Calendar actualtime=timeSelect(city);
				WebElement checkoutfortakeout=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'gi i_cart y-no-item']"));
				act.moveToElement(checkoutfortakeout);
				checkoutfortakeout.click();
				Thread.sleep(2000);

				if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'checkoutDiv']")==1)
				{
					if(common_action.VerifyElement("ByXPath", "//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")==1)
					{					
						if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
						{
							if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message']", "Sorry, We don't talk to strangers")!=1)
							{
								errorLog.add("Incorrect message for Name 'Sorry, We don't talk to strangers'");
								log_system.error("Incorrect message for Name 'Sorry, We don't talk to strangers'");
							}
							
							if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message error-phoneNo']", "We promise; No prank calls")!=1)
							{
								errorLog.add("Incorrect message for Phone 'We promise; No prank calls'");
								log_system.error("Incorrect message for Phone 'We promise; No prank calls'");
							}
							
							if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Hey, you forgot something')]", "Hey, you forgot something")!=1)
							{
								errorLog.add("Incorrect message for Email 'Hey, you forgot something'");
								log_system.error("Incorrect message for Email 'Hey, you forgot something'");
							}
							
							if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'first_name']")==1)
							{
								if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'first_name']", "Akash")==1)
								{
									if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'last_name']")==1)
									{
										if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'last_name']", "Sangal")==1)
										{
											try
											{
												common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'address_2']", "B17");
											}
											catch(Exception e)
											{
												log_system.error("User is not able to set Address 2");
											}
											
											if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'phone_no']")==1)
											{
												if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'phone_no']", "1234")==1)
												{
													if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
													{
														
														if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message error-phoneNo']", "You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx")!=1)
														{
															errorLog.add("Incorrect message for Phone 'You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx'");
															log_system.error("Incorrect message for Phone 'You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx'");
														}
														
														if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Hey, you forgot something')]", "Hey, you forgot something")!=1)
														{
															errorLog.add("Incorrect message for Email 'Hey, you forgot something'");
															log_system.error("Incorrect message for Email 'Hey, you forgot something'");
														}
														
														if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'phone_no']", "1234567890")==1)
														{
															if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'email']", "a")==1)
															{
																if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																{
																	if(common_action.VerifyText("ByXPath", "//p[contains(text(),'look like any e-mail I ever seen.')]", "That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!")!=1)
																	{
																		errorLog.add("Incorrect message for Email 'That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!'");
																		log_system.error("Incorrect message for Email 'That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!'");
																	}
																	
																	if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'email']", "a@a.com")==1)
																	{
																		if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																		{
																			if(common_action.VerifyText("ByXPath", "//p[contains(text(),'And whose card is this?')]", "And whose card is this?")!=1)
																			{
																				errorLog.add("message should appear on the screen for Name on card: 'And whose card is this?' ");	
																				log_system.error("message should appear on the screen for Name on card: 'And whose card is this?' ");
																			}
																			
																			if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Try rubbing your fingers over the numbers, that helps us get')]", "Try rubbing your fingers over the numbers, that helps us get 'em right")!=1)
																			{
																				errorLog.add("message should appear on the screen for card number: 'Try rubbing your fingers over the numbers, that helps us get 'em right' ");	
																				log_system.error("message should appear on the screen for card number: 'Try rubbing your fingers over the numbers, that helps us get 'em right' ");
																			}
																			
																			if(common_action.VerifyText("ByXPath", "//p[contains(text(),'It would be irresponsible of us not to require this.')]", "It would be irresponsible of us not to require this.")!=1)
																			{
																				errorLog.add("message should appear on the screen for Name on card: 'It would be irresponsible of us not to require this.' ");	
																				log_system.error("message should appear on the screen for Name on card: 'It would be irresponsible of us not to require this.' ");
																			}
																			
																			if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Come on, you gave us all the other info. Why you holding out?')]", "Come on, you gave us all the other info. Why you holding out?")!=1)
																			{
																				errorLog.add("message should appear on the screen for Name on card: 'Come on, you gave us all the other info. Why you holding out?' ");	
																				log_system.error("message should appear on the screen for Name on card: 'Come on, you gave us all the other info. Why you holding out?' ");
																			}
																			
																			if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'card_name']")==1)
																			{
																				if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_name']", "Akash sangal")==1)
																				{
																					if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_number']", "1234")==1)
																					{
																						if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																						{
																							if(common_action.VerifyText("ByXPath", "//p[contains(text(),'We need all of the numbers on the card. All of')]", "We need all of the numbers on the card. All of 'em")!=1)
																							{
																								errorLog.add("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");	
																								log_system.error("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");
																							}
																							
																							if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'card_number']", "4111111111111111")==1)
																							{
																								if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'cvv_code']")==1)
																								{
																									if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'cvv_code']", "4")==1)
																									{
																										if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																										{
																											if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Try looking a little closer at the card  or maybe your card  number is wrong.')]", "Hmm, that's not it. Try looking a little closer at the card  or maybe your card  number is wrong.")!=1)
																											{
																												errorLog.add("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");	
																												log_system.error("message should appear on the screen for card Number: 'We need all of the numbers on the card. All of 'em' ");
																											}
																											
																											if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'cvv_code']", "123")==1)
																											{
																												if(common_action.VerifyElement("ByXPath", "//input[normalize-space(@name) = 'zip']")==1)
																												{
																													if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'zip']", "1")==1)
																													{
																														if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																														{
																															if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Billing zip should be 5 digits.')]", "Billing zip should be 5 digits.")!=1)
																															{
																																errorLog.add("message should appear on the screen for zip: 'Billing zip should be 5 digits. ");	
																																log_system.error("message should appear on the screen for zip: 'Billing zip should be 5 digits. ");
																															}
																															if(common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'zip']", "12345")==1)
																															{
																																																															
																																if(product_action.VerifySummaryDelivery("ByXPath", "//div[normalize-space(@class) = 'box_ordersummary ordersummarystep2']", Tax)==1)
																																{
																																	if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'subtitle_first text-capitalize y-orderType']", "delivery")!=1)
																																	{
																																		errorLog.add("Incorrect Order Type");
																																		log_system.error("Incorrect Order Type");
																																	}
																																	TimeSlot.remove(0);
																																	String ActiveTimeSlot=ActiveTimeSlot(TimeSlot,actualtime,city);
																																	String DisplayedTime=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'subtitle_first y-expectedTime']")).getText().split("at")[1].trim();				
																																	if(ActiveTimeSlot.contains(DisplayedTime))
																																	{
																																		String Address1=Driver.findElement(By.xpath("//input[normalize-space(@name) = 'address_1']")).getAttribute("value").trim()+", "+"B17, "+Driver.findElement(By.xpath("//input[normalize-space(@name) = 'city']")).getAttribute("value").trim();
																																		Address1=Address1.toLowerCase().trim();
																																		if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
																																		{
																																			Thread.sleep(4000);																																		
																																			if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'res_menu']")==1)
																																			{
																																				
																																				String Address_confirmed=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'subtitle_first text-capitalize y-deliveryAddress']")).getText().toLowerCase();
																																				if(!Address_confirmed.contains(Address1))
																																				{
																																					log_system.error("Address is not mapping");
																																				}
																																				ProductDetails.clear();
																																			}
																																			else
																																			{
																																				if(!Driver.getCurrentUrl().contains("https://qc"))
																																				{
																																					ProductDetails.clear();
																																					errorLog.add("Checkout message is not appearing on the screen");
																																					log_system.error("Checkout message is not appearing on the screen");
																																				}
																																				else
																																				{
																																					
																																				}
																																			}
																																		}
																																		else
																																		{
																																			errorLog.add("User is not able to click on Place my order button");
																																			log_system.error("User is not able to click on Place my order button");
																																		}
																																	}
																																	else
																																	{
																																		errorLog.add("Incorrect takeout time is appearing on the screen");
																																		log_system.error("Incorrect takeout time is appearing on the screen");
																																	}
																																}
																																else
																																{
																																	errorLog.add("Incorrect Summary is appearing on checkout screen for takeout");
																																	log_system.error("Incorrect Summary is appearing on checkout screen for takeout");
																																}
																															}
																															else
																															{
																																errorLog.add("user is not able to enter zip code");
																																log_system.error("user is not able to enter zip code");
																															}
																														}
																														else
																														{
																															errorLog.add("user is not able to click on place my oder button");
																															log_system.error("user is not able to click on place my oder button");
																														}
																													}
																													else
																													{
																														errorLog.add("user is not able to enter zip code");
																														log_system.error("user is not able to enter zip code");
																													}
																												}
																												else
																												{
																													errorLog.add("zip code textbox is not appearing on the screen");
																													log_system.error("zip code textbox is not appearing on the screen");
																												}
																											}
																											else
																											{
																												errorLog.add("user is not able to enter cvv code");
																												log_system.error("user is not able to enter cvv code");
																											}
																										}
																										else
																										{
																											errorLog.add("user is not able to click on place my oder button");
																											log_system.error("user is not able to click on place my oder button");
																										}
																										
																									}
																									else
																									{
																										errorLog.add("user is not able to enter cvv code");
																										log_system.error("user is not able to enter cvv code");
																									}
																								}
																								else
																								{
																									errorLog.add("CVV code textbox is not appearing on the screen");
																									log_system.error("CVV code textbox is not appearing on the screen");
																								}
																							}
																							else
																							{
																								errorLog.add("user is not able to enter card number");
																								log_system.error("user is not able to enter card number");
																							}
																							
																							
																						}
																						else
																						{
																							errorLog.add("user is not able to click on place my order button");
																							log_system.error("user is not able to click on place my order button");
																						}
																					}
																					else
																					{
																						errorLog.add("user is not able to enter card number");
																						log_system.error("user is not able to enter card number");
																					}
																				}
																				else
																				{
																					errorLog.add("user is not able to enter name on card");
																					log_system.error("user is not able to enter name on card");
																				}
																			}
																			else
																			{
																				errorLog.add("Name on card textbox is not appearing on the screen");
																				log_system.error("Name on card textbox is not appearing on the screen");
																			}
																		}
																		else
																		{
																			errorLog.add("user is not able to click on place my order button");
																			log_system.error("user is not able to click on place my order button");
																		}
																																			
																		
																	}
																	else
																	{
																		errorLog.add("user is not able to enter email id");
																		log_system.error("user is not able to enter email id");
																	}
																	
																	
																}
																else
																{
																	errorLog.add("user is not able to click on place my order button");
																	log_system.error("user is not able to click on place my order button");
																}
															}
															else
															{
																errorLog.add("user is not able to enter email id");
																log_system.error("user is not able to enter email id");
															}
														}
														else
														{
															errorLog.add("user is not able to enter PhoneNumber");
															log_system.error("user is not able to enter PhoneNumber");
														}
														
													}
													else
													{
														errorLog.add("user is not able to click on place my order button");
														log_system.error("user is not able to click on place my order button");
													}
												}
												else
												{
													errorLog.add("user is not able to enter PhoneNumber");
													log_system.error("user is not able to enter PhoneNumber");
												}
											}
											else
											{
												errorLog.add("Phone number text box is not appearing on the screen");
												log_system.error("Phone number text box is not appearing on the screen");
											}
										}
										else
										{
											errorLog.add("user is not able to enter Last name");
											log_system.error("user is not able to enter Last name");
										}
									}
									else
									{
										errorLog.add("Last name text box is not appearing on the screen");
										log_system.error("Last name text box is not appearing on the screen");
									}
								}
								else
								{
									errorLog.add("user is not able to enter first name");
									log_system.error("user is not able to enter first name");
								}
							}
							else
							{
								errorLog.add("First name text box is not appearing on the screen");
								log_system.error("First name text box is not appearing on the screen");
							}
							
						}
						else
						{
							errorLog.add("User is not able to click on Place my order buttn");
							log_system.error("User is not able to click on Place my order buttn");
						}
					}
					else
					{
						errorLog.add("Place my order button is not appearing on the screen");
						log_system.error("Place my order button is not appearing on the screen");
					}
				}
				else
				{
					errorLog.add("user is not able to navigate to checkout page");
					log_system.error("user is not able to navigate to checkout page");
				}
			}
			else
			{
				Status=2;
			}
		}
		
		
		
		if(errorLog.size()>0)
		{
			Status=0;
		}
		else if (Status!=2)
		{
			Status=1;
		}
		
		return Status;
	}
	
	
	@SuppressWarnings("unused")
	public int CheckoutforDeliveryEdit(String city,String timeslot,String Address,String Tax) throws Exception
	{
		ArrayList<String> errorLog=new ArrayList<String>();
		int Status=0;
		Actions act =new Actions(Driver);
		WebElement delivery=null;
		try {
			delivery = Driver.findElement(By.xpath("//label[normalize-space(@class) = 'ubtn btn_service'][normalize-space(@for) = 't_delivery'] | //label[normalize-space(@class) = 'ubtn blackbtn btn_service'][normalize-space(@for) = 't_delivery']"));
		} catch (Exception e) {
			Status=3;		
			}
		
		try {
			if(!Driver.findElement(By.xpath("//p[normalize-space(@class) = 'txt_upper']")).getText().contains("Today"))
			{
				Status=2;
			}
		} catch (Exception e1) {
			
		}
		
		if(Status!=2 && Status!=3)
		{
			if(ProductDetails.size()>0)
			{
				WebElement DeliveryTime=Driver.findElement(By.xpath("//span[normalize-space(@class) = 't-operation-hours']"));
				String TimeZone=DeliveryTime.getText();
				ArrayList<String> TimeSlot=getTimeSlot(TimeZone, timeslot, city);
				Calendar actualtime=timeSelect(city);
				WebElement checkoutfortakeout=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'gi i_cart y-no-item']"));
				act.moveToElement(checkoutfortakeout);
				checkoutfortakeout.click();
				Thread.sleep(4000);
				
				
				try
				{
					common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'address_2']", "B17");
				}
				catch(Exception e)
				{
					log_system.error("User is not able to set Address 2");
				}
				
				if(product_action.VerifySummaryDelivery("ByXPath", "//div[normalize-space(@class) = 'box_ordersummary ordersummarystep2']", Tax)!=1)
				{
					errorLog.add("Incorrect Summary is appearing on checkout screen for takeout");
					log_system.error("Incorrect Summary is appearing on checkout screen for takeout");
				}
				
				if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'subtitle_first text-capitalize y-orderType']", "delivery")!=1)
				{
					errorLog.add("Incorrect Order Type");
					log_system.error("Incorrect Order Type");
				}
				TimeSlot.remove(0);
				String ActiveTimeSlot=ActiveTimeSlot(TimeSlot,actualtime,city);
				String DisplayedTime=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'subtitle_first y-expectedTime']")).getText().split("at")[1].trim();				
				if(!ActiveTimeSlot.contains(DisplayedTime))
				{
					errorLog.add("Incorrect takeout time is appearing on the screen");
					log_system.error("Incorrect takeout time is appearing on the screen");
				}
				
				String Address1=Driver.findElement(By.xpath("//input[normalize-space(@name) = 'address_1']")).getAttribute("value").trim()+", "+"B17, "+Driver.findElement(By.xpath("//input[normalize-space(@name) = 'city']")).getAttribute("value").trim();
				Address1=Address1.toLowerCase().trim();
				if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
				{
					Thread.sleep(4000);																																		
					if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'res_menu']")==1)
					{
						
						String Address_confirmed=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'subtitle_first text-capitalize y-deliveryAddress']")).getText().toLowerCase();
						if(!Address_confirmed.contains(Address1))
						{
							log_system.error("Address is not mapping");
						}
						ProductDetails.clear();
					}
					else
					{
						if(!Driver.getCurrentUrl().contains("https://qc"))
						{
							ProductDetails.clear();
							errorLog.add("Checkout message is not appearing on the screen");
							log_system.error("Checkout message is not appearing on the screen");
						}
						else
						{
							
						}
					}
				}
				else
				{
					errorLog.add("User is not able to click on Place my order button");
					log_system.error("User is not able to click on Place my order button");
				}	
				
				
				
			}
			else
			{
				Status=2;
			}
		}
		else if (Status !=3 && Status ==2)
		{
			if(ProductDetails.size()>0)
			{
				WebElement DeliveryTime=Driver.findElement(By.xpath("//span[normalize-space(@class) = 't-operation-hours']"));
				String TimeZone=DeliveryTime.getText();
				ArrayList<String> TimeSlot=getTimeSlot(TimeZone, timeslot, city);
				Calendar actualtime=timeSelect(city);
				WebElement checkoutfortakeout=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'gi i_cart y-no-item']"));
				act.moveToElement(checkoutfortakeout);
				checkoutfortakeout.click();
				Thread.sleep(4000);
				
				
				try
				{
					common_action.SetText("ByXPath", "//input[normalize-space(@name) = 'address_2']", "B17");
				}
				catch(Exception e)
				{
					log_system.error("User is not able to set Address 2");
				}
				
				if(product_action.VerifySummaryDelivery("ByXPath", "//div[normalize-space(@class) = 'box_ordersummary ordersummarystep2']", Tax)!=1)
				{
					errorLog.add("Incorrect Summary is appearing on checkout screen for takeout");
					log_system.error("Incorrect Summary is appearing on checkout screen for takeout");
				}
				
				if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'subtitle_first text-capitalize y-orderType']", "delivery")!=1)
				{
					errorLog.add("Incorrect Order Type");
					log_system.error("Incorrect Order Type");
				}
								
				String Address1=Driver.findElement(By.xpath("//input[normalize-space(@name) = 'address_1']")).getAttribute("value").trim()+", "+"B17, "+Driver.findElement(By.xpath("//input[normalize-space(@name) = 'city']")).getAttribute("value").trim();
				Address1=Address1.toLowerCase().trim();
				if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn placemyorder']")))==1)
				{
					Thread.sleep(4000);																																		
					if(common_action.VerifyElement("ByXPath", "//div[normalize-space(@class) = 'res_menu']")==1)
					{
						
						String Address_confirmed=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'subtitle_first text-capitalize y-deliveryAddress']")).getText().toLowerCase();
						if(!Address_confirmed.contains(Address1))
						{
							log_system.error("Address is not mapping");
						}
						ProductDetails.clear();
					}
					else
					{
						if(!Driver.getCurrentUrl().contains("https://qc"))
						{
							ProductDetails.clear();
							errorLog.add("Checkout message is not appearing on the screen");
							log_system.error("Checkout message is not appearing on the screen");
						}
						else
						{
							
						}
					}
				}
				else
				{
					errorLog.add("User is not able to click on Place my order button");
					log_system.error("User is not able to click on Place my order button");
				}	
				
				
				
			}
			else
			{
				Status=2;
			}
		}
		
		
		if(errorLog.size()>0)
		{
			Status=0;
		}
		else if (Status!=2)
		{
			Status=1;
		}
		else if (Status==3)
		{
			Status=2;
		}
			
		return Status;
	}
	
	
	public ArrayList<String> getTimeSlot(String TimeZone, String timeslot,String City) throws ParseException
	{
		ArrayList<String> timeslotlist=new ArrayList<String>();
		if(TimeZone!=null)
		{
			if(TimeZone.contains(","))
			{
				String[] timeZoneCollection=TimeZone.split(",");
				for(String timeZone_tmp:timeZoneCollection)
				{
					TimeZone=timeZone_tmp.trim();
					String startTime=TimeZone.split("-")[0].trim();	
					int StartHour=Integer.parseInt(TimeZone.split("-")[0].trim().split(" ")[0].trim().split(":")[0].trim());
					int StartMin=Integer.parseInt(TimeZone.split("-")[0].trim().split(" ")[0].trim().split(":")[1].trim());
					String endTime=TimeZone.split("-")[1].trim();
					int endHour=Integer.parseInt(TimeZone.split("-")[1].trim().split(" ")[0].trim().split(":")[0].trim());
					int endMin=Integer.parseInt(TimeZone.split("-")[1].trim().split(" ")[0].trim().split(":")[1].trim());
					Calendar cal_Start=Calendar.getInstance();
					Calendar cal_end=Calendar.getInstance();
					if(startTime.contains("AM"))
					{
						cal_Start.set(Calendar.HOUR, StartHour);
						cal_Start.set(Calendar.MINUTE, StartMin);
						cal_Start.set(Calendar.SECOND, 0);
						cal_Start.set(Calendar.AM_PM,Calendar.AM);			
					}
					else
					{
						cal_Start.set(Calendar.HOUR, StartHour);
						cal_Start.set(Calendar.MINUTE, StartMin);
						cal_Start.set(Calendar.SECOND, 0);
						cal_Start.set(Calendar.AM_PM,Calendar.PM);
					}
					
					if(endTime.contains("AM"))
					{
						cal_end.set(Calendar.HOUR, endHour);
						cal_end.set(Calendar.MINUTE, endMin);
						cal_end.set(Calendar.SECOND, 0);
						cal_end.set(Calendar.AM_PM,Calendar.AM);
					}
					else
					{
						cal_end.set(Calendar.HOUR, endHour);
						cal_end.set(Calendar.MINUTE, endMin);
						cal_end.set(Calendar.SECOND, 0);
						cal_end.set(Calendar.AM_PM,Calendar.PM);
					}
					
					Calendar currenttime=timeSelect(City);
					
					
					do
					{
						if(currenttime.before(cal_Start))
						{
							String Hours=String.valueOf(cal_Start.get(Calendar.HOUR));
							String min=String.valueOf(cal_Start.get(Calendar.MINUTE));
							int DayNightFormat=cal_Start.get(Calendar.AM_PM);
							
							String AM_PM=null;
							if(DayNightFormat!=1)
								AM_PM="AM";
							else
								AM_PM="PM";
							
							if(min.equals("0"))
							min="00";
							
							if(Hours.equals("0"))
							{
								Hours="12";
							}
							
							if(Hours.length()==1)
							{
								Hours="0"+Hours;
							}
							timeslotlist.add(Hours+":"+min+" "+AM_PM);
							
						}
						
						cal_Start.add(Calendar.MINUTE, Integer.parseInt(timeslot));
						System.out.println(cal_Start.getTime());
						System.out.println(cal_end.getTime());
					}while(!cal_end.before(cal_Start));
				}
			}
			else
			{
				String startTime=TimeZone.split("-")[0].trim();	
				int StartHour=Integer.parseInt(TimeZone.split("-")[0].trim().split(" ")[0].trim().split(":")[0].trim());
				int StartMin=Integer.parseInt(TimeZone.split("-")[0].trim().split(" ")[0].trim().split(":")[1].trim());
				String endTime=TimeZone.split("-")[1].trim();
				int endHour=Integer.parseInt(TimeZone.split("-")[1].trim().split(" ")[0].trim().split(":")[0].trim());
				int endMin=Integer.parseInt(TimeZone.split("-")[1].trim().split(" ")[0].trim().split(":")[1].trim());
				Calendar cal_Start=Calendar.getInstance();
				Calendar cal_end=Calendar.getInstance();
				if(startTime.contains("12:00 AM"))
				{
					StartHour=0;
				}
				if(startTime.contains("AM"))
				{
					cal_Start.set(Calendar.HOUR, StartHour);
					cal_Start.set(Calendar.MINUTE, StartMin);
					cal_Start.set(Calendar.SECOND, 0);
					cal_Start.set(Calendar.AM_PM,Calendar.AM);	
				}
				else
				{
					cal_Start.set(Calendar.HOUR, StartHour);
					cal_Start.set(Calendar.MINUTE, StartMin);
					cal_Start.set(Calendar.SECOND, 0);
					cal_Start.set(Calendar.AM_PM,Calendar.PM);
				}
				
				if(endTime.contains("AM"))
				{
					cal_end.set(Calendar.HOUR, endHour);
					cal_end.set(Calendar.MINUTE, endMin);
					cal_end.set(Calendar.SECOND, 0);
					cal_end.set(Calendar.AM_PM,Calendar.AM);
				}
				else
				{
					cal_end.set(Calendar.HOUR, endHour);
					cal_end.set(Calendar.MINUTE, endMin);
					cal_end.set(Calendar.SECOND, 0);
					cal_end.set(Calendar.AM_PM,Calendar.PM);
				}
				
				Calendar currenttime=timeSelect(City);
				
				
				do
				{
					if(currenttime.before(cal_Start))
					{
						String Hours=String.valueOf(cal_Start.get(Calendar.HOUR));
						String min=String.valueOf(cal_Start.get(Calendar.MINUTE));
						int DayNightFormat=cal_Start.get(Calendar.AM_PM);
						
						String AM_PM=null;
						if(DayNightFormat!=1)
							AM_PM="AM";
						else
							AM_PM="PM";
						
						if(min.equals("0"))
						min="00";
						
						if(Hours.equals("0"))
						{
							Hours="12";
						}
						
						if(Hours.length()==1)
						{
							Hours="0"+Hours;
						}
						timeslotlist.add(Hours+":"+min+" "+AM_PM);
						
					}
					
					cal_Start.add(Calendar.MINUTE, Integer.parseInt(timeslot));
					System.out.println(cal_Start.getTime());
					System.out.println(cal_end.getTime());
				}while(!cal_end.before(cal_Start));
			}
			
			
		}
		return timeslotlist;				
	}

	
	public Calendar timeSelect(String City)
	{
		Calendar calendar = Calendar.getInstance();
		switch(City)
		{
		case "New York":
		{
			calendar.add(Calendar.HOUR,-10);
			calendar.add(Calendar.MINUTE,-30);
			break;
		}
		case "Chicago":
		{
			calendar.add(Calendar.HOUR,-10);
			calendar.add(Calendar.MINUTE,-30);
			break;
		}
		case "li":
		{
			calendar.add(Calendar.HOUR,-10);
			calendar.add(Calendar.MINUTE,-30);
			break;
		}
		}
		System.out.println(calendar.getTime());
		return calendar;
	}

	
	public String ActiveTimeSlot(ArrayList<String> TimeSlot,Calendar actualtime,String City)
	{		
		actualtime.add(Calendar.MINUTE, 30);
		String ActiveTimeSlot=null;
		for(String timeslot:TimeSlot)
		{
			int StartHour=Integer.parseInt(timeslot.split(" ")[0].split(":")[0]);
			int StartMin=Integer.parseInt(timeslot.split(" ")[0].split(":")[1]);;
			Calendar updatetime=timeSelect(City);			
			if(timeslot.contains("AM"))		
			{
				updatetime.set(Calendar.HOUR, StartHour);
				updatetime.set(Calendar.MINUTE, StartMin);
				updatetime.set(Calendar.SECOND, 0);
				updatetime.set(Calendar.AM_PM,Calendar.AM);			
			}
			else
			{
				updatetime.set(Calendar.HOUR, StartHour);
				updatetime.set(Calendar.MINUTE, StartMin);
				updatetime.set(Calendar.SECOND, 0);
				updatetime.set(Calendar.AM_PM,Calendar.PM);
			}
			
			System.out.println(updatetime.getTime());
			System.out.println(actualtime.getTime());
			if(actualtime.before(updatetime))
			{
				ActiveTimeSlot=timeslot;
				break;
			}
		}
		
		return ActiveTimeSlot;
	}
	
}
