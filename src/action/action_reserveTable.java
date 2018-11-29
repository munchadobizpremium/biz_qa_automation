package action;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements_ui.element_locator;
import global_utility.global_variables;

public class action_reserveTable extends global_variables{
	
	
	action_common common_action=new action_common();
	int Status=0;
	public int ReserveATable() throws Exception
	{		
		
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		
		element_locator element_loc=new element_locator();
		By element_locator=null;		
		
		ArrayList<String> errorlog=new ArrayList<String>();
		Actions act=new Actions(Driver);
		WebElement ele_reserveATable=null;
		if(Driver.getPageSource().contains("reserve a table"))
		{
			WebElement hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
					
			if(hamburger.isDisplayed())
			{
				try {
					hamburger.click();
					ele_reserveATable=Driver.findElement(By.xpath("//a[normalize-space(@data-popup) = 'reserve_a_table'][normalize-space(@class) = 'hl y-reserveTable']"));
				} catch (Exception e) {
					try {
						ele_reserveATable=Driver.findElement(By.xpath("//a[normalize-space(@data-popup) = 'reserve_a_table'][normalize-space(@class) = 'hl y-reserveTable']"));
					} catch (Exception e1) {
						Status=2;
					}				}			
			}
			else
			{
				try {
					ele_reserveATable=Driver.findElement(By.xpath("//a[normalize-space(@data-popup) = 'reserve_a_table'][normalize-space(@class) = 'hl y-reserveTable']"));
				} catch (Exception e) {
					Status=2;
				}
			}
			
				
			if(Status!=2)
			{
				if(!ele_reserveATable.isDisplayed() && !hamburger.isDisplayed())
					Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_downstyle']")).click();
				
				Thread.sleep(4000);
				if(ele_reserveATable.isDisplayed())
				{
					act.moveToElement(ele_reserveATable).build().perform();
					Status=common_action.Click(ele_reserveATable);
					Thread.sleep(2000);
					if(Status==1)
					{
						try {					
							
							if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'sectiontitle _mb40']", "reserve a table")!=1)
							{
								errorlog.add("Incorrect Header: reserve a table");
								log_system.error("Incorrect Header: reserve a table");
							}
							
							if(common_action.VerifyElement("ByID", "people")!=1)
							{
								errorlog.add("Dropdown missing for select people");
								log_system.error("Dropdown missing for select people");
							}
							else
							{
								Thread.sleep(2000);
								if(SelectPeople("ByID", "people")!=1)
								{
									errorlog.add("User is not able to select People from dropdown");
									log_system.error("User is not able to select People from dropdown");
								}
								else
								{
									if(common_action.VerifyElement("ByID", "datepicker1")!=1)
									{
										errorlog.add("Date Picker is missing");
										log_system.error("Date Picker is missing");
									}
									else
									{
										Thread.sleep(2000);
										if(SelectDate("ByID", "datepicker1",null)!=1)
										{
											errorlog.add("user is not able to select date");
											log_system.error("user is not able to select date");
										}
										else
										{
											if(common_action.VerifyElement("ByID", "timepicker1")!=1)
											{
												errorlog.add("Time Picker is missing from the screen");
												log_system.error("Time Picker is missing from the screen");
											}
											else
											{
												Thread.sleep(2000);
												if(SelectTimeSlot("ByID", "timepicker1")!=1 && SelectTimeSlot("ByID", "timepicker1")!=2)
												{
													
													errorlog.add("User is not able to select time slot");
													log_system.error("User is not able to select time slot");
												}
												else if(SelectTimeSlot("ByID", "timepicker1")!=2 && SelectTimeSlot("ByID", "timepicker1")!=0)
												{
													if(common_action.VerifyElement("ByID","btnbook")!=1)
													{
														errorlog.add("Reservation button is missing");
														log_system.error("Reservation button is missing");
													}
													else
													{
														
														element_locator=element_loc.getElement("ByID", "btnbook");													
														act.moveToElement(Driver.findElement(element_locator)).build().perform();													
														wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
														if(common_action.Click(Driver.findElement(By.id("btnbook")))!=1)
														{
															errorlog.add("User is not able to click on reservation button");
															log_system.error("User is not able to click on reservation button");
														}
														else
														{
															if(common_action.VerifyText("ByXPath", "//div[normalize-space(@class) = 'formstep2 forreserve']", "reserve a table")!=1)
															{
																errorlog.add("Incorret header is appearing on the screen: reserve a table");
																log_system.error("Incorret header is appearing on the screen: reserve a table");
															}
															
															if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'msgreservation _mb15']", "Your reservation is almost complete")!=1)
															{
																errorlog.add("Incorret message is appearing on the screen: Your reservation is almost complete");
																log_system.error("Incorret ,message is appearing on the screen: Your reservation is almost complete");
															}
															
															if(common_action.VerifyElement("ByID", "btnconfirm")!=1)
															{
																errorlog.add("Request Reservaion button is not appaering on the screen");
																log_system.error("Request Reservaion button is not appaering on the screen");
															}
															else
															{
																element_locator=element_loc.getElement("ByID", "btnconfirm");													
																act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																if(common_action.Click(Driver.findElement(By.id("btnconfirm")))!=1)
																{
																	errorlog.add("user is not able to click on request reservation button");
																	log_system.error("user is not able to click on request reservation button");
																}
																else
																{
																	if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message new-location-msg']", "Sorry, We don't talk to strangers")!=1)
																	{
																		errorlog.add("Message is not appearing on the screen: Sorry, We don't talk to strangers");
																		log_system.error("Message is not appearing on the screen: Sorry, We don't talk to strangers");
																	}
																	
																	if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message new-location-msg y_error_phone']", "We promise; No prank calls")!=1)
																	{
																		errorlog.add("Message is not appearing on the screen: We promise; No prank calls");
																		log_system.error("Message is not appearing on the screen: We promise; No prank calls");
																	}
																	
																	if(common_action.VerifyText("ByXPath", "//p[contains(text(),'Hey, you forgot something')]", "Hey, you forgot something")!=1)
																	{
																		errorlog.add("Message is not appearing on the screen: Hey, you forgot something");
																		log_system.error("Message is not appearing on the screen: Hey, you forgot something");
																	}
																	
																	if(common_action.VerifyElement("ByID", "first_name_r")!=1)
																	{
																		errorlog.add("First Name text box is missing from the screen");
																		log_system.error("First Name text box is missing from the screen");
																	}
																	else
																	{
																		if(common_action.SetText("ByID", "first_name_r", "Akash")!=1)
																		{
																			errorlog.add("user is not able to enter first name");
																			log_system.error("user is not able to enter first name");
																		}
																		else
																		{
																			if(common_action.VerifyElement("ByID", "last_name_r")!=1)
																			{
																				errorlog.add("Last Name text box is missing from the screen");
																				log_system.error("Last Name text box is missing from the screen");
																			}
																			else
																			{
																				if(common_action.SetText("ByID", "last_name_r", "Sangal")!=1)
																				{
																					errorlog.add("user is not able to enter Last name");
																					log_system.error("user is not able to enter Last name");
																				}
																				else
																				{
																					if(common_action.VerifyElement("ByID", "phone_no_r")!=1)
																					{
																						errorlog.add("Phone number text box is missing from the screen");
																						log_system.error("Phone number text box is missing from the screen");
																					}
																					else
																					{
																						if(common_action.SetText("ByID", "phone_no_r", "232323")!=1)
																						{
																							errorlog.add("user is not able to enter Phone Number");
																							log_system.error("user is not able to enter Phone Number");
																						}
																						else
																						{
																							element_locator=element_loc.getElement("ByID", "btnconfirm");													
																							act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																							wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																							if(common_action.Click(Driver.findElement(By.id("btnconfirm")))!=1)
																							{
																								errorlog.add("user is not able click on request reservation button");
																								log_system.error("user is not able click on request reservation button");
																							}
																							else
																							{
																								if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message new-location-msg y_error_phone']", "You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx")!=1)
																								{
																									errorlog.add("message is not appearing on the screen: You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx");
																									log_system.error("message is not appearing on the screen: You know, there's a cadence to phone numbers. They usually go xxx-xxx-xxxx");
																								}
																								else
																								{
																									if(common_action.SetText("ByID", "phone_no_r", "1234567890")!=1)
																									{
																										errorlog.add("user is not able to enter Phone Number");
																										log_system.error("user is not able to enter Phone Number");
																									}
																									else
																									{
																										if(common_action.VerifyElement("ByID", "email_r")!=1)
																										{
																											errorlog.add("email id textbox is not appearing on the screen");
																											log_system.error("email id textbox is not appearing on the screen");
																										}
																										else
																										{
																											if(common_action.SetText("ByID", "email_r", "asdasda")!=1)
																											{
																												errorlog.add("user is not able to enter email id");
																												log_system.error("user is not able to enter email id");
																											}
																											else
																											{
																												element_locator=element_loc.getElement("ByID", "btnconfirm");													
																												act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																												wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																												if(common_action.Click(Driver.findElement(By.id("btnconfirm")))!=1)
																												{
																													errorlog.add("user is not able click on request reservation button");
																													log_system.error("user is not able click on request reservation button");
																												}
																												else
																												{
																													if(common_action.VerifyText("ByXPath", "//p[normalize-space(@class) = 'error-message new-location-msg']", "That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!")!=1)
																													{
																														errorlog.add("message is not apeparing on the scrreen: That don't look like any e-mail I ever seen. Maybe the \"@\" or the \".\" are in the wrong spot. This isn't cubism, put things where they belong!");
																														log_system.error("message is not apeparing on the scrreen: That don't look like any e-mail I ever seen. Maybe the \\\"@\\\" or the \\\".\\\" are in the wrong spot. This isn't cubism, put things where they belong!");
																													}
																													
																													if(common_action.SetText("ByID", "email_r", "asangal@bravvura.in")!=1)
																													{
																														errorlog.add("user is not able to enter email id");
																														log_system.error("user is not able to enter email id");
																													}
																													else
																													{
																														try {
																															element_locator=element_loc.getElement("ByID", "req_boothID");													
																															act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																															wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																															if(common_action.Click(Driver.findElement(By.id("req_boothID")))!=1)
																															{
																																errorlog.add("user is not able to click on booth checkbox");
																																log_system.error("user is not able to click on booth checkbox");
																															}
																															element_locator=element_loc.getElement("ByID", "req_kidplaceID");										
																															act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																															wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																															if(common_action.Click(Driver.findElement(By.id("req_kidplaceID")))!=1)
																															{
																																errorlog.add("user is not able to click on Request kid's place settings checkbox");
																																log_system.error("user is not able to click on Request kid's place settings checkbox");
																															}
																															element_locator=element_loc.getElement("ByID", "req_nocenterpieceID");										
																															act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																															wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																															if(common_action.Click(Driver.findElement(By.id("req_nocenterpieceID")))!=1)
																															{
																																errorlog.add("user is not able to click on Request no centerpiece checkbox");
																																log_system.error("user is not able to click on Request no centerpiece checkbox");
																															}
																															element_locator=element_loc.getElement("ByID", "req_boothID");										
																															act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																															wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																															if(common_action.Click(Driver.findElement(By.id("req_boothID")))!=1)
																															{
																																errorlog.add("user is not able to click on booth checkbox");
																																log_system.error("user is not able to click on booth checkbox");
																															}
																														} catch (Exception e) {
																														}
																														
																														
																														if(common_action.VerifyElement("ByID", "comment")!=1)
																														{
																															errorlog.add("request for booth checkbox is missing from the screen");
																															log_system.error("request for booth checkbox is missing from the screen");
																														}
																														else
																														{
																																																													
																															if(common_action.VerifyElement("ByID", "comment")!=1)
																															{
																																errorlog.add("Instruction textbox is misisng from the screen");
																																log_system.error("Instruction textbox is misisng from the screen");
																															}
																															else
																															{
																																if(common_action.SetText("ByID", "comment", "Instruction entered")!=1)
																																{
																																	errorlog.add("user is not able to enter instruction");
																																	log_system.error("user is not able to enter instruction");
																																}
																															}
																															if(common_action.VerifyText("ByXPath", "//p[contains(@class, 'txt_ordersummary') and text()='Thank you for your reservation.']", "Thank you for your reservation.")!=1)																															
																															{
																																errorlog.add("message is not apeparing on the screen: Thank you for your reservation.");
																																log_system.error("message is not apeparing on the screen: Thank you for your reservation.");
																															}
																															
																															if(common_action.VerifyElement("ByXPath", "//a[normalize-space(@class) = 'i_close close']")!=1)
																															{
																																errorlog.add("close button is not appearing on the screen");
																																log_system.error("close button is not appearing on the screen");
																															}
																															else
																															{
																																element_locator=element_loc.getElement("ByXPath", "//a[normalize-space(@class) = 'i_close close']");										
																																act.moveToElement(Driver.findElement(element_locator)).build().perform();													
																																wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
																																if(common_action.Click(Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")))!=1)
																																{
																																	errorlog.add("user is not able to click on close button");
																																	log_system.error("user is not able to click on close button");
																																}
																																else
																																{
																																	if(common_action.VerifyNoElement("ByID", "bookform")!=1)
																																	{
																																		errorlog.add("close button is not working for reserve a table. reserve a table form still appearing on the screen");
																																		log_system.error("close button is not working for reserve a table. reserve a table form still appearing on the screen");
																																		Driver.get(Driver.getCurrentUrl());
																																	}
																																}
																															}																														
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																	
																}
															}
														}
													}
												}
											}
										}	
									}
								}
							}
							
						} catch (Exception e) {
							errorlog.add("Reserve a table pop up is not appearing on the screen");
							log_system.error("Reserve a table pop up is not appearing on the screen");
						}
						
						
					}
					else
					{
						errorlog.add("user is not able to click on Reserve A Table Link");
						log_system.error("user is not able to click on Reserve A Table Link");
					}
				}
				else
				{
					Status=2;
				}
				
			}
			
			
			
				
		}
		else
		{
			Status=2;
		}
		
		if(errorlog.size()<=0 && Status!=2)
		{
			Status=1;
		}
		else
		{
			try {
				if(ele_reserveATable.isDisplayed())
				{
					Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
				}
			} catch (Exception e) {
			}
		}
		return Status;		
	}

	
	public int SelectPeople(String ElementKey, String ElementSelector)
	{		
		try {
			element_locator element_loc=new element_locator();
			By element_locator=null;
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
		} catch (Exception e) {
			Status=0;
		}		
		return Status;
	}
	
	public int SelectDate(String ElementKey, String ElementSelector,String Date)
	{				
		try {
			ArrayList<String> errorlog=new ArrayList<String>();
			element_locator element_loc=new element_locator();
			By element_locator=null;
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			Actions act=new Actions(Driver);
			act.moveToElement(Driver.findElement(element_locator)).build().perform();
			WebDriverWait wait = new WebDriverWait(Driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
			Driver.findElement(element_locator).click();
			Thread.sleep(2000);
			WebElement dateselector=null;
			List<WebElement> dateselectors=Driver.findElements(By.xpath("//div[normalize-space(@class) = 'xdsoft_datetimepicker xdsoft_noselect xdsoft_']"));
			for(WebElement dateselectors_itr:dateselectors)
			{
				if(dateselectors_itr.getAttribute("style").toString().contains("display: block;"))
				{
					dateselector=dateselectors_itr;
				}
			}
			dateselector=dateselector.findElement(By.className("xdsoft_calendar"));
			List<WebElement> dates_list=dateselector.findElements(By.tagName("td"));
			ArrayList<WebElement> activeDates=new ArrayList<WebElement>();
			
			if(Date==null)
			{
				for(WebElement all_dates:dates_list)
				{
					if(!all_dates.getAttribute("class").contains("disable"))
					{
						activeDates.add(all_dates);
					}
				}
			}
			else
			{
				for(WebElement all_dates:dates_list)
				{
					if(!all_dates.getAttribute("class").contains("disable"))
					{
						if(all_dates.getText().contains(Date))
						{
							activeDates.add(all_dates);
							break;
						}
						
					}
				}
			}
			
			
						
			
			Random rdm=new Random();
			int index=rdm.nextInt(activeDates.size());		
			WebElement selectableDate=activeDates.get(index);		
			act.moveToElement(selectableDate).build().perform();
			selectableDate.click();	
			
						
				
			if(errorlog.size()<=0)
			{
				Status=1;
			}			
		} catch (Exception e) {
			Status=0;
		}
		
		return Status;
	}

	
	public int SelectTimeSlot(String ElementKey, String ElementSelector)
	{				
		
			element_locator element_loc=new element_locator();
			By element_locator=null;
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			Actions act=new Actions(Driver);
			act.moveToElement(Driver.findElement(element_locator)).build().perform();
			WebDriverWait wait = new WebDriverWait(Driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
			try {
				Driver.findElement(element_locator).click();
			} catch (Exception e) {
				Status=2;
			}
			if(Status!=2)
			{
				try {
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
				} catch (Exception e) {
					Status=0;				
					}
			}
			
		
		return Status;
	}
	
	public int verifyTimeforReserveATable(String City,String TimeSlot) throws Exception
	{
		Thread.sleep(2000);
		ArrayList<String> errorlog=new ArrayList<String>();
		Actions act=new Actions(Driver);
		Calendar actualtime=timeSelect(City);
		String TimeZone=getTimeZone(actualtime);
		String date=getcurrentDate(actualtime);
		
		if(Driver.getPageSource().contains("reserve a table"))
		{
			WebElement hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
			WebElement ele_reserveATable=null;		
			if(hamburger.isDisplayed())
			{
				try {
					hamburger.click();
					ele_reserveATable=Driver.findElement(By.xpath("//a[normalize-space(@data-popup) = 'reserve_a_table'][normalize-space(@class) = 'hl y-reserveTable']"));
				} catch (Exception e) {
					try {
						ele_reserveATable=Driver.findElement(By.xpath("//a[normalize-space(@data-popup) = 'reserve_a_table'][normalize-space(@class) = 'hl y-reserveTable']"));
					} catch (Exception e1) {
						Status=2;
					}				}			
			}
			else
			{
				try {
					ele_reserveATable=Driver.findElement(By.xpath("//a[normalize-space(@data-popup) = 'reserve_a_table'][normalize-space(@class) = 'hl y-reserveTable']"));
				} catch (Exception e) {
					Status=2;
				}
			}
			
				
			if(Status!=2)
			{
				if(!ele_reserveATable.isDisplayed() && !hamburger.isDisplayed())
					Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_downstyle']")).click();
				
				Thread.sleep(4000);
				if(ele_reserveATable.isDisplayed())
				{					
					act.moveToElement(ele_reserveATable).build().perform();
					Status=common_action.Click(ele_reserveATable);
					Thread.sleep(2000);
					if(Status==1)
					{
						try {					
																					
							if(common_action.VerifyElement("ByID", "people")!=1)
							{
								errorlog.add("Dropdown missing for select people");
								log_system.error("Dropdown missing for select people");
							}
							else
							{
								Thread.sleep(2000);
								if(SelectPeople("ByID", "people")!=1)
								{
									errorlog.add("User is not able to select People from dropdown");
									log_system.error("User is not able to select People from dropdown");
								}
								else
								{
									if(common_action.VerifyElement("ByID", "datepicker1")!=1)
									{
										errorlog.add("Date Picker is missing");
										log_system.error("Date Picker is missing");
									}
									else
									{
										Thread.sleep(2000);	
										if(SelectDate("ByID", "datepicker1",date)!=1)
										{
											errorlog.add("Incorrect date is apeparing for City: "+ City+ " or user is not able to pick date");
											log_system.error("Incorrect date is apeparing for City: "+ City+ " or user is not able to pick date");
										}
										else
										{
											
											if(common_action.VerifyElement("ByID", "timepicker1")!=1)
											{
												errorlog.add("Time Picker is missing from the screen");
												log_system.error("Time Picker is missing from the screen");
											}
											else
											{
												
												Thread.sleep(2000);
												ArrayList<String> TimeSlotList=getTimeSlot(TimeZone, TimeSlot,City);
												if(VerifyTimeSlot("ByID", "timepicker1",TimeSlotList)!=1)
												{
													errorlog.add("Incorrect time slot is apeparing for reserve a table");
													log_system.error("Incorrect time slot is apeparing for reserve a table");
												}												
											}
										}	
									}
								}
							}
							
						} catch (Exception e) {
							errorlog.add("Reserve a table pop up is not appearing on the screen");
							log_system.error("Reserve a table pop up is not appearing on the screen");
						}
						
						
					}
					else
					{
						errorlog.add("user is not able to click on Reserve A Table Link");
						log_system.error("user is not able to click on Reserve A Table Link");
					}
				}
				else
				{
					Status=2;
				}
				
			}
			
			
			
				
		}
		else
		{
			Status=2;
		}
		
		if(errorlog.size()<=0 && Status!=2)
		{
			Status=1;
		}
		try {
			Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
		} catch (Exception e) {
		}
		return Status;
	}
	
	public Calendar timeSelect(String City)
	{
		Calendar calendar = Calendar.getInstance();
		switch(City)
		{
		case "New York":
		{
			calendar.add(Calendar.HOUR,-9);
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
		return calendar;
	}
	
	
	public int VerifyDate(String ElementKey, String ElementSelector, String Time)
	{
		try {
			element_locator element_loc=new element_locator();
			By element_locator=null;
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			Actions act=new Actions(Driver);
			act.moveToElement(Driver.findElement(element_locator)).build().perform();
			WebDriverWait wait = new WebDriverWait(Driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
			Driver.findElement(element_locator).click();
			Thread.sleep(2000);
			WebElement dateselector=null;
			List<WebElement> dateselectors=Driver.findElements(By.xpath("//div[normalize-space(@class) = 'xdsoft_datetimepicker xdsoft_noselect xdsoft_']"));
			for(WebElement dateselectors_itr:dateselectors)
			{
				if(dateselectors_itr.getAttribute("style").toString().contains("display: block;"))
				{
					dateselector=dateselectors_itr;
				}
			}
			dateselector=dateselector.findElement(By.className("xdsoft_calendar"));
			List<WebElement> dates_list=dateselector.findElements(By.tagName("td"));
			ArrayList<WebElement> activeDates=new ArrayList<WebElement>();
			for(WebElement all_dates:dates_list)
			{
				if(all_dates.getAttribute("class").contains("disable"))
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
		} catch (Exception e) {
			Status=0;
		}
		
		return Status;
	}
	
	
	
	public int VerifyTimeSlot(String ElementKey, String ElementSelector,ArrayList<String> timeavail) throws ParseException
	{				
		element_locator element_loc=new element_locator();
		By element_locator=null;
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		try {
			Driver.findElement(element_locator).click();
			Thread.sleep(2000);
			WebElement dateselector=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 't_timepicker unstyled clearfix']"));
			List<WebElement> dates_list=dateselector.findElements(By.tagName("li"));
			ArrayList<String> activeTimeSlot=new ArrayList<String>();
			for(WebElement all_dates:dates_list)
			{	
				activeTimeSlot.add(all_dates.getText().trim());
			}
			
			if(activeTimeSlot.equals(timeavail))
			{
				Status=1;
			}
		} catch (Exception e) {
			Status=1;		}
		return Status;
	}
	
	
	
	public String getTimeZone(Calendar Time)
	{
		
		String[] monthName = {"Saturday","Sunday", "Monday",
                "Tuesday", "Wednesday", "Thursday", "Friday", };
		
		 String month = monthName[Time.get(Calendar.DAY_OF_WEEK)];
		 
		String TimeZone=null; 
		WebElement times=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'txt_contactdetail y-resCalender']"));
		List<WebElement> timeZone=times.findElements(By.xpath(".//div[normalize-space(@class) = 'row borderdotted']"));
		for(WebElement timeZne_itr:timeZone)
		{
			
			if(timeZne_itr.getText().contains(month))
			{
				TimeZone=timeZne_itr.getText();
				break;				
			}
		}
		if(TimeZone!=null)
		TimeZone=TimeZone.split(month)[1];
		
		
		 return TimeZone;
	}
	
	
	public String getcurrentDate(Calendar Time)
	{
		return String.valueOf(Time.get(Calendar.DATE));
		
	}
	
	public ArrayList<String> getTimeSlot(String TimeZone, String timeslot,String City) throws ParseException
	{
		ArrayList<String> timeslotlist=new ArrayList<String>();
		if(TimeZone!=null)
		{
			
			String startTime=TimeZone.split("to")[0].trim();	
			int StartHour=Integer.parseInt(TimeZone.split("to")[0].trim().split(" ")[0].trim().split(":")[0].trim());
			int StartMin=Integer.parseInt(TimeZone.split("to")[0].trim().split(" ")[0].trim().split(":")[1].trim());
			String endTime=TimeZone.split("to")[1].trim();
			int endHour=Integer.parseInt(TimeZone.split("to")[1].trim().split(" ")[0].trim().split(":")[0].trim());
			int endMin=Integer.parseInt(TimeZone.split("to")[1].trim().split(" ")[0].trim().split(":")[1].trim());
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
			}while(!cal_end.before(cal_Start));
			int index=timeslotlist.size()-1;
			timeslotlist.remove(index);
		}
		return timeslotlist;
				
	}
}
