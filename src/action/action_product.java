package action;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements_ui.element_locator;
import global_utility.global_variables;
import global_utility.handle_ajax_call;
import gs_utilities.productdetails;

public class action_product extends global_variables{

	action_common common_action=new action_common();
	int Status=0;	
	public int VerifyMenuItem() throws Exception
	{
		int counter=0;
		
		ArrayList<String> errorlog=new ArrayList<String>();
		Actions act=new Actions(Driver);
		
		if(Driver.getPageSource().contains("menu"))
		{
			
			
			WebElement hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
			WebElement menu_container=null;
			WebElement ele_menu=null;
			List<WebElement> menuList=null;
			if(hamburger.isDisplayed())
			{
				try {
					hamburger.click();
					menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
					menuList=menu_container.findElements(By.tagName("a"));
				} catch (Exception e) {
					menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
					menuList=menu_container.findElements(By.tagName("a"));
				}				
			}
			else
			{
				menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
				menuList=menu_container.findElements(By.tagName("a"));
			}
			
				
			if(!menu_container.isDisplayed() && !hamburger.isDisplayed())
				Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_downstyle']")).click();
			
			
			
			
			for(WebElement menu:menuList)
			{
				if(menu.getText().toLowerCase().equals("menu"))
				{
					ele_menu=menu;
					break;
				}
					
			}
			
			
			act.moveToElement(ele_menu).build().perform();
			Status=common_action.Click(ele_menu);
			Thread.sleep(2000);
			try 
			{
				Driver.findElement(By.xpath("//div[normalize-space(@id) = 'myDropdown']"));
				WebElement menu_click=Driver.findElement(By.xpath("//div[normalize-space(@id) = 'myDropdown']//a[normalize-space(@data-target) = 'menu'] | //div[normalize-space(@id) = 'myDropdown']//a[normalize-space(@data-gtmd) = 'menu']"));
				menu_click.click();
			}
			catch(Exception e)
			{
				
			}
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(1000);
			handle_ajax_call.HandleAjaxCall();
			
			WebElement menupop=null;
			WebElement menu_thirdParty=null;
			if(Status==1)
			{
				try 
				{
					menupop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'menu']"));
				}
				catch(Exception e)
				{
					try
					{
						menu_thirdParty=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'menu-link']"));
					}
					catch(Exception e1)
					{
						
					}
					
				}
										
				if(menu_thirdParty==null)
				{
					WebElement ele_menu_list=Driver.findElement(By.xpath("//div[normalize-space(@class) = 't-menu-render menutab']"));
					act.moveToElement(ele_menu_list).build().perform();
					WebDriverWait wait = new WebDriverWait(Driver, 40);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space(@class) = 't-menu-render menutab']")));		
					
					WebElement category_container=ele_menu_list;
					category_container=category_container.findElement(By.xpath(".//ul[normalize-space(@class) = 'unstyled navbar nav md-hide']"));
					List<WebElement> category_list=category_container.findElements(By.tagName("li"));
					
					for(WebElement category:category_list)
					{
						if(!category.findElement(By.tagName("a")).getAttribute("href").contains("javascript"))
						{
							continue;
						}
						else
						{
							act.moveToElement(category);
							category.click();
							handle_ajax_call.HandleAjaxCall();
							Thread.sleep(2000);
							handle_ajax_call.HandleAjaxCall();
							String category_attribute=category.getAttribute("class").toString();
							category_attribute=category_attribute.replaceAll("[^0-9]", "");
							WebElement Subcategoty_Container=Driver.findElement(By.xpath("//div[starts-with(@class,'menu_"+category_attribute+"')]"));
							Subcategoty_Container=Subcategoty_Container.findElement(By.xpath(".//div[normalize-space(@class) = 'item_menupanel']"));
							List<WebElement> Subcategoty_List=Subcategoty_Container.findElements(By.xpath(".//div[normalize-space(@class) = 'item_contentpanel']"));
							if(Subcategoty_List.size()<=0)
								counter++;
						}
						
					}
					
					if(menupop!=null)
					{
						Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
											
						try
						{
							menupop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'menu']"));
							menupop.isDisplayed();
							errorlog.add("not able to close Menu popup");
							log_system.error("not able to close Menu popup");
						}
						catch(Exception e) {}
					}
				}
				else
				{
					
					menu_thirdParty.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(1000);
					handle_ajax_call.HandleAjaxCall();
					 for (String winHandle : Driver.getWindowHandles()) {
						 if(!winHandle.equals(mainwindow))
						 {
							 String url =Driver.getCurrentUrl();
							 handle_ajax_call.HandleAjaxCall();
								Thread.sleep(2000);
								handle_ajax_call.HandleAjaxCall();
							 HttpURLConnection huc=(HttpURLConnection)(new java.net.URL(url).openConnection());
							 huc.setRequestMethod("HEAD");
							 huc.connect();
							 int respCode = huc.getResponseCode();
							 if(respCode >= 400){
							        log_system.error(url+" is a broken link");
							        errorlog.add(url+" is a broken link");
							    }
							 Driver.switchTo().window(winHandle);
							 Driver.close();
							 Driver.switchTo().window(mainwindow);
							 Status=1;
						 }
					        
					    }
				}
			}
			else
			{
				errorlog.add("user is not able to click on menu link");
				log_system.error("user is not able to click on menu link");
			}
			
			
			
		}
		else
		{
			Status=2;
		}
		
		if(errorlog.size()==0 && Status!=2 && counter<=0)
		{
			Status=1;
		}
		
		
		return Status;
	}
	
	
	public int AddProduct()  throws Exception
	{	
		handle_ajax_call.HandleAjaxCall();
		Thread.sleep(2000);
		handle_ajax_call.HandleAjaxCall();
		ArrayList<String> errorlog=new ArrayList<String>();
		Actions act=new Actions(Driver);
		productdetails gs_productdetails=new productdetails();
		
		if(Driver.getPageSource().contains("menu"))
		{
			
			WebElement hamburger=Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_hamburger']"));
			WebElement menu_container=null;
			WebElement ele_menu=null;
			List<WebElement> menuList=null;
			if(hamburger.isDisplayed())
			{
				try {
					hamburger.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(1000);
					handle_ajax_call.HandleAjaxCall();
					menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
					menuList=menu_container.findElements(By.tagName("a"));
				} catch (Exception e) {
					menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
					menuList=menu_container.findElements(By.tagName("a"));
				}
			}
			else
			{
				menu_container=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'unstyled navbar nav']"));
				menuList=menu_container.findElements(By.tagName("a"));
			}
			
				
			if(!menu_container.isDisplayed() && !hamburger.isDisplayed())
			{
				Driver.findElement(By.xpath("//i[normalize-space(@class) = 'i_downstyle']")).click();
				handle_ajax_call.HandleAjaxCall();
				Thread.sleep(1000);
				handle_ajax_call.HandleAjaxCall();
			}
				
			
			
			
			
			for(WebElement menu:menuList)
			{
				if(menu.getText().toLowerCase().equals("menu"))
				{
					ele_menu=menu;
					break;
				}
					
			}
			
			
			act.moveToElement(ele_menu).build().perform();
			Status=common_action.Click(ele_menu);
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(1000);
			handle_ajax_call.HandleAjaxCall();
			
			WebElement menupop=null;
			WebElement menu_thirdParty=null;
			if(Status==1)
			{
				try 
				{
					menupop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'menu']"));
				}
				catch(Exception e)
				{
					try
					{
						menu_thirdParty=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'menu-link']"));
					}
					catch(Exception e1)
					{
						
					}
				}
										
				if(menu_thirdParty==null)
				{
					WebElement ele_menu_list=Driver.findElement(By.xpath("//div[normalize-space(@class) = 't-menu-render menutab']"));
					act.moveToElement(ele_menu_list).build().perform();
					WebDriverWait wait = new WebDriverWait(Driver, 40);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space(@class) = 't-menu-render menutab']")));		
					
					WebElement category_container=ele_menu_list;
					category_container=category_container.findElement(By.xpath(".//ul[normalize-space(@class) = 'unstyled navbar nav md-hide']"));
					List<WebElement> category_list=category_container.findElements(By.tagName("li"));
					ArrayList<WebElement> category_List_ele=new ArrayList<WebElement>();
					for(WebElement category:category_list)
					{
						
						if(!category.findElement(By.tagName("a")).getAttribute("href").contains("javascript"))
						{
							continue;
						}
						else
						{
							category_List_ele.add(category);
						}
						
					}
					
					Random rdm=new Random();
					int category_index=rdm.nextInt(category_List_ele.size());
					WebElement Category_ele=category_List_ele.get(category_index);
					act.moveToElement(Category_ele);
					Category_ele.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					handle_ajax_call.HandleAjaxCall();
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
					
					try
					{
						if(subcategory_random.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn btn_addtocard btn_addtoorder']")).isDisplayed())
						{
							subcategory_random.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn btn_addtocard btn_addtoorder']")).click();
							handle_ajax_call.HandleAjaxCall();
							Thread.sleep(1000);
							handle_ajax_call.HandleAjaxCall();
						}
						else
						{
							Status=2;						
						}
					}catch(Exception e)
					{
						Status=2;
					}
					
					if(Status!=2)
					{
							try
							{
								
								wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']")));
								WebElement ele_delivery_popup=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']"));
								if(ele_delivery_popup.isDisplayed())
								{
									WebElement ele_order_takeout=ele_delivery_popup.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn t_proceed_takeout']"));
									ele_order_takeout.click();
									handle_ajax_call.HandleAjaxCall();
									Thread.sleep(1000);
									handle_ajax_call.HandleAjaxCall();
								}
							}
							catch(Exception e)
							{
								
							}
							handle_ajax_call.HandleAjaxCall();				
							Thread.sleep(2000);
							handle_ajax_call.HandleAjaxCall();
							String prtoduct_type=null;
							String prtoduct_type1=null;
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
								try 
								{
									if(Driver.findElement(By.xpath("//span[normalize-space(@class) = 'capitalize _fs12']")).isDisplayed())
									{				
										
										prtoduct_type1=Driver.findElement(By.xpath("//span[normalize-space(@class) = 'capitalize _fs12']")).getText();
									}	
								}
								catch(Exception e1)
								{
									
								}							
							}
							handle_ajax_call.HandleAjaxCall();
							Thread.sleep(1000);
							handle_ajax_call.HandleAjaxCall();
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
								ProductName=ProductName.replace("( ", "(");
								ProductName=ProductName.replace(" )", ")");
								ProductName=ProductName.trim().toLowerCase();
								
							}
							
							if(prtoduct_type1!=null)
							{							
								prtoduct_type1=prtoduct_type1.replace("( ", "(");
								prtoduct_type1=prtoduct_type1.replace(" )", ")");
								ProductName = ProductName +" "+prtoduct_type1;
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
										toppings.add(toppingName.toLowerCase().trim()+","+"1"+","+toppingPrice);
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
								// if product have no toppings
							}
							int product_id_tmp=ProductDetails.size();
							product_id_tmp++;							
							String Product_Id=product_popup.findElement(By.id("uid")).getAttribute("value");
							Product_Id=Product_Id.split("_")[0]+"_"+String.valueOf(product_id_tmp);
							product_popup.findElement(By.xpath(".//textarea[normalize-space(@class) = 'menu_special_instruction_item special_instruction']")).sendKeys("hello add instructions here");
							gs_productdetails.setInstructions(("hello add instructions here").toLowerCase());
							product_popup.findElement(By.xpath(".//a[normalize-space(@class) = 'ubtn blackbtn btn_popupaddtoorder add-to-order']")).click();
							
							Thread.sleep(2000);
							gs_productdetails.setProduct_count(1);		
							ProductDetails.put(Product_Id, gs_productdetails);
							
							if(menupop!=null)
							{
								Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
													
								try
								{
									menupop=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'bg_grey t-popupdata']//div[normalize-space(@id) = 'menu']"));
									menupop.isDisplayed();
									errorlog.add("not able to close menu pop up");
								}
								catch(Exception e) {}
							}				
						}
						else
						{
							errorlog.add("user is not able to click on menu link");
							log_system.error("user is not able to click on menu link");
						}
				}
				else
				{
					Status=2;
				}
			
			}
			else
			{
				errorlog.add("user is not able to click on menu link");
				log_system.error("user is not able to click on menu link");
			}
		}
		else
		{
			Status=2;
		}
		
		if(errorlog.size()==0 && Status!=2)
		{
			Status=1;
			Driver.get(Driver.getCurrentUrl());
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(2000);
			handle_ajax_call.HandleAjaxCall();
		}
		
		try {
			if(Driver.findElement(By.xpath("//div[normalize-space(@class) = 'a_modal']")).isDisplayed())
			{
				Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
			}
		} catch (Exception e) {

		}
		return Status;
	}

	
	public int AddEditProduct()  throws Exception
	{				
		Actions act=new Actions(Driver);		
		String Product_Item="";
		
		WebElement menu_thirdParty=null;
		try
		{
			menu_thirdParty=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'menu-link']"));
		}
		catch(Exception e)
		{
			
		}
		
		if(menu_thirdParty==null)
		{
			if(ProductDetails.isEmpty())
			{
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
				act.moveToElement(ele_Editbutton).build().perform();
				WebDriverWait wait = new WebDriverWait(Driver, 40);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(@class)='t-edit-order edit_"+Product_Item+" ubtn']")));
				ele_Editbutton.click();
				handle_ajax_call.HandleAjaxCall();
				Thread.sleep(3000);
				handle_ajax_call.HandleAjaxCall();
				Thread.sleep(3000);
				WebElement product_popup=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'a_modal']"));
							
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space(@class) = 'a_modal']")));
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
						int checkbox=0;
						if(addon_topping_type.contains("Choose any one"))
						{												
							for(WebElement subcategory_addon_choose_list_ele:subcategory_addon_choose_list)
							{							
								String topping_selected=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[0];
								WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele.findElement(By.tagName("span"));
								WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele.findElement(By.tagName("input"));
								toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name").toLowerCase();
								toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
								if(subcategory_addon_choose_list_ele_select_details.getAttribute("type").contains("radio"))
								{									
									if(!toppingName.contains(topping_selected))
									{
										
										subcategory_addon_choose_list_ele_select_click.click();
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(1000);
										handle_ajax_call.HandleAjaxCall();
										String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
										toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));						
										String updated_Topping=toppingName.toLowerCase()+","+toppingcount+","+toppingPrice;
										ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);									
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(2000);
										handle_ajax_call.HandleAjaxCall();
										break;
									}	
								}
								else
								{
									if(toppingName.equals(topping_selected.trim()))
									{
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(1000);
										handle_ajax_call.HandleAjaxCall();
										subcategory_addon_choose_list_ele_select_click.click();
										
									}
									else
									{
										subcategory_addon_choose_list_ele_list.add(subcategory_addon_choose_list_ele);
									}
									checkbox++;
								}
							}
							
							if(checkbox>0)
							{
								int index1=rdm.nextInt(subcategory_addon_choose_list_ele_list.size());
								WebElement 	subcategory_addon_choose_list_ele_select=subcategory_addon_choose_list_ele_list.get(index1);
								WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele_select.findElement(By.tagName("span"));
								WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele_select.findElement(By.tagName("input"));
								subcategory_addon_choose_list_ele_select_click.click();
								toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name");
								toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
								String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
								toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));
								String updated_Topping=toppingName.toLowerCase().trim()+","+toppingcount+","+toppingPrice;
								ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);
														
								handle_ajax_call.HandleAjaxCall();
								Thread.sleep(2000);
								handle_ajax_call.HandleAjaxCall();
							}
							
							
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
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(1000);
										handle_ajax_call.HandleAjaxCall();
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
								String updated_Topping=toppingName.toLowerCase().trim()+","+toppingcount+","+toppingPrice;
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
				handle_ajax_call.HandleAjaxCall();
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
		}
		else
		{
			Status=2;
		}
		
		
		
		return Status;
	}
	
	public int RemoveEditProduct()  throws Exception
	{				
		String Product_Item="";
		WebElement menu_thirdParty=null;
		try
		{
			menu_thirdParty=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'menu-link']"));
		}
		catch(Exception e)
		{
			
		}
		
		if(menu_thirdParty==null)
		{
			if(ProductDetails.isEmpty())
			{
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
						int checkbox=0;
						if(addon_topping_type.contains("Choose any one"))
						{												
							for(WebElement subcategory_addon_choose_list_ele:subcategory_addon_choose_list)
							{							
								String topping_selected=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[0];
								WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele.findElement(By.tagName("span"));
								WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele.findElement(By.tagName("input"));
								toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name").toLowerCase();
								toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
								if(subcategory_addon_choose_list_ele_select_details.getAttribute("type").contains("radio"))
								{									
									if(!toppingName.contains(topping_selected))
									{
										
										subcategory_addon_choose_list_ele_select_click.click();
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(1000);
										handle_ajax_call.HandleAjaxCall();
										String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
										toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));						
										String updated_Topping=toppingName.toLowerCase()+","+toppingcount+","+toppingPrice;
										ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);									
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(2000);
										handle_ajax_call.HandleAjaxCall();
										break;
									}	
								}
								else
								{
									if(toppingName.equals(topping_selected.trim()))
									{
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(1000);
										handle_ajax_call.HandleAjaxCall();
										subcategory_addon_choose_list_ele_select_click.click();
										
									}
									else
									{
										subcategory_addon_choose_list_ele_list.add(subcategory_addon_choose_list_ele);
									}
									checkbox++;
								}
							}
							
							if(checkbox>0)
							{
								int index1=rdm.nextInt(subcategory_addon_choose_list_ele_list.size());
								WebElement 	subcategory_addon_choose_list_ele_select=subcategory_addon_choose_list_ele_list.get(index1);
								WebElement subcategory_addon_choose_list_ele_select_click=subcategory_addon_choose_list_ele_select.findElement(By.tagName("span"));
								WebElement subcategory_addon_choose_list_ele_select_details=subcategory_addon_choose_list_ele_select.findElement(By.tagName("input"));
								subcategory_addon_choose_list_ele_select_click.click();
								toppingName=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-name");
								toppingPrice=subcategory_addon_choose_list_ele_select_details.getAttribute("data-option-price");
								String toppingcount=ProductDetails.get(Product_Item).getTopping_details().get(count).split(",")[1];
								toppingPrice=String.valueOf(Float.parseFloat(toppingPrice)*Integer.valueOf(toppingcount));
								String updated_Topping=toppingName.toLowerCase().trim()+","+toppingcount+","+toppingPrice;
								ProductDetails.get(Product_Item).getTopping_details().set(count, updated_Topping);
														
								handle_ajax_call.HandleAjaxCall();
								Thread.sleep(2000);
								handle_ajax_call.HandleAjaxCall();
							}
							
							
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
										handle_ajax_call.HandleAjaxCall();
										Thread.sleep(1000);
										handle_ajax_call.HandleAjaxCall();
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
				handle_ajax_call.HandleAjaxCall();			
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
		}
		else
		{
			Status=2;
		}
		
		
		
		return Status;

	}
	
	

	public int DeleteProduct(String Instruction)  throws Exception
	{		
		handle_ajax_call.HandleAjaxCall();
		Thread.sleep(1000);
		handle_ajax_call.HandleAjaxCall();
		String Product_Item="";
		Actions act=new Actions(Driver);
		
		WebElement menu_thirdParty=null;
		try
		{
			menu_thirdParty=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'menu-link']"));
		}
		catch(Exception e)
		{
			
		}
		if(menu_thirdParty==null)
		{
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
												
						act.moveToElement(delete_Product).build().perform();
						delete_Product.click();
						handle_ajax_call.HandleAjaxCall();
						Thread.sleep(1000);
						handle_ajax_call.HandleAjaxCall();
						WebElement cnfrm_delete_Product=Driver.findElement(By.xpath(".//span[normalize-space(@class) = 'ubtn blackbtn t-confirm-delete-order'][normalize-space(@data-id) = '"+Product_Item+"']"));
						act.moveToElement(cnfrm_delete_Product).build().perform();
						cnfrm_delete_Product.click();
						handle_ajax_call.HandleAjaxCall();
						Thread.sleep(1000);
						handle_ajax_call.HandleAjaxCall();
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
					act.moveToElement(delete_Product).build().perform();
					@SuppressWarnings("unused")
					int indexcount=0;
					for(int i=0;i<ProductDetails.size();i++)
					{
						if(Product_item_list.get(i).contains(Product_Item))
						{
							indexcount=i;
							break;
						}
					}				
					delete_Product.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(1000);
					handle_ajax_call.HandleAjaxCall();
					WebElement cnfrm_delete_Product=Driver.findElement(By.xpath(".//span[normalize-space(@class) = 'ubtn blackbtn t-confirm-delete-order'][normalize-space(@data-id) = '"+Product_Item+"']"));
					act.moveToElement(cnfrm_delete_Product).build().perform();
					cnfrm_delete_Product.click();
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(1000);
					handle_ajax_call.HandleAjaxCall();
					ProductDetails.remove(Product_Item);
					/*int indexcount1=ProductDetails.size()-1;
					if(indexcount1!=indexcount)
					for(int i=indexcount;i<indexcount1;i++)
					{
						int j=i+1;
						System.out.println(Product_item_list.get(i));
						System.out.println(Product_item_list.get(j));
						ProductDetails.put(Product_item_list.get(i), ProductDetails.get(Product_item_list.get(j)));
					}
					indexcount1=ProductDetails.size()-1;
					ProductDetails.remove(Product_item_list.get(indexcount1));
					Driver.get(Driver.getCurrentUrl());
					handle_ajax_call.HandleAjaxCall();
					Thread.sleep(2000);
					handle_ajax_call.HandleAjaxCall();*/
					Status=1;
				}			
			}
		}
		else
		{
			Status=2;
		}
		
		
		
		return Status;

	}
	
	
	public int VerifySummary(String ElementKey, String ElementSelector,String Tax)  throws Exception
	{
		try {
			Status=0;
			/*JavascriptExecutor js = (JavascriptExecutor)Driver;
			js.executeScript("window.scrollTo(0, 500)");*/		
			Thread.sleep(3000);
			handle_ajax_call.HandleAjaxCall();
			LinkedHashMap<String, gs_utilities.productdetails> ProductDetails_current=new LinkedHashMap<String, gs_utilities.productdetails>();
			element_locator element_loc=new element_locator();
			By element_locator=null;
			WebElement menu_thirdParty=null;
			try
			{
				menu_thirdParty=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'menu-link']"));
			}
			catch(Exception e)
			{
				
			}
			
			if(menu_thirdParty==null)
			{
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
					Status=1;
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
							ProductName_current=ProductName_current.substring(0, ProductName_current.length()-2).replace("( ", "(").replace(" )", ")");									
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
								log_system.error("instruction is missing for product item");
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
					
					int errorcount=0;
					for(String Compair:ProductDetails.keySet())
					{
						if(!ProductDetails.get(Compair).equals(ProductDetails_current.get(Compair)))					
						{
							if(!ProductDetails.get(Compair).getProductName().equals(ProductDetails_current.get(Compair).getProductName()))
							{
								
								log_system.error(ProductDetails.get(Compair).getProductName());
								log_system.error(ProductDetails_current.get(Compair).getProductName());
								log_system.error("Product name not mapped "+ ProductDetails.get(Compair).getProductName());
								errorcount++;
							}
							else
							{
								if(!ProductDetails.get(Compair).getInstructions().equals(ProductDetails_current.get(Compair).getInstructions()))
								{
									System.out.println(ProductDetails.get(Compair).getInstructions());
									System.out.println(ProductDetails_current.get(Compair).getInstructions());
									log_system.error("Instruction not mapped "+ ProductDetails.get(Compair).getProductName());
									errorcount++;
								}
								else
								{
									if(ProductDetails.get(Compair).getProduct_actual_price()!=(ProductDetails_current.get(Compair).getProduct_actual_price()))
									{
										log_system.error("Price not mapped "+ ProductDetails.get(Compair).getProductName());
										errorcount++;
									}
									else
									{
										if(ProductDetails.get(Compair).getProduct_count()!=(ProductDetails_current.get(Compair).getProduct_count()))
										{
											log_system.error("Count not mapped "+ ProductDetails.get(Compair).getProductName());
											errorcount++;
										}
										else
										{
											if(!ProductDetails.get(Compair).getTopping_details().equals(ProductDetails_current.get(Compair).getTopping_details()))
											{
												log_system.error("Toppings not mapped "+ ProductDetails_current.get(Compair).getTopping_details());
												log_system.error("Toppings not mapped "+ ProductDetails.get(Compair).getTopping_details());
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
						order_subtotal=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'order_subtotal']")).getText());
						order_tax=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'order_tax']")).getText());			
						for(String Product_item1:ProductDetails_current.keySet())
						{
							
							Product_price_calculate=Product_price_calculate+ProductDetails_current.get(Product_item1).getProduct_actual_price();				
							ArrayList<String> Topping_cal=ProductDetails_current.get(Product_item1).getTopping_details();
							for(String toppingDetails:Topping_cal)
							{
								float toppingprice=Float.parseFloat(toppingDetails.split(",")[2]);
								Product_price_calculate=Product_price_calculate+toppingprice;					
							}				
						}
						
						Product_price_calculate=Float.parseFloat(new BigDecimal(Product_price_calculate).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
						float order_total=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'order_total']")).getText());
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
								
								try
								{
									float discount=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'discount_amount']")).getText());
									total_calculate=total_calculate-discount;
									BigDecimal bg2=new BigDecimal(total_calculate).setScale(3, BigDecimal.ROUND_HALF_UP);
									bg2=bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
									total_calculate=Float.parseFloat(bg2.toString());
								}
								catch(Exception e)
								{
									
								}
								if(order_total==total_calculate)
								{
									Status=1;
								}
								else
								{								
									log_system.error("incorrect order total");
									Status=0;
								}
							}
							
						}
						else
						{
							log_system.error("Incorrect product sub total");
							Status=0;
						}				
					}
					else
					{
						Status=0;
					}
					
				}
			}
			else
			{
				log_system.error("Incorrect product sub total");
				Status=2;
			}
		} catch (Exception e) {
			log_system.error("Incorrect product id is appearing");
			Status=0;
		}
		
		
		return Status;
	}
	
	
	public int VerifySummaryDelivery(String ElementKey, String ElementSelector,String Tax)  throws Exception
	{
		Status=0;
		Thread.sleep(3000);
		LinkedHashMap<String, gs_utilities.productdetails> ProductDetails_current=new LinkedHashMap<String, gs_utilities.productdetails>();
		element_locator element_loc=new element_locator();
		By element_locator=null;
		WebElement menu_thirdParty=null;
		try
		{
			menu_thirdParty=Driver.findElement(By.xpath("//a[normalize-space(@class) = 'menu-link']"));
		}
		catch(Exception e)
		{
			
		}
		
		if(menu_thirdParty==null)
		{
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
				Status=1;
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
						ProductName_current=ProductName_current.substring(0, ProductName_current.length()-2).replace("( ", "(").replace(" )", ")");									
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
				
				int errorcount=0;
				for(String Compair:ProductDetails.keySet())
				{
					if(!ProductDetails.get(Compair).equals(ProductDetails_current.get(Compair)))					
					{
						if(!ProductDetails.get(Compair).getProductName().equals(ProductDetails_current.get(Compair).getProductName()))
						{
							
							log_system.error(ProductDetails.get(Compair).getProductName());
							log_system.error(ProductDetails_current.get(Compair).getProductName());
							log_system.error("Product name not mapped "+ ProductDetails.get(Compair).getProductName());
							errorcount++;
						}
						else
						{
							if(!ProductDetails.get(Compair).getInstructions().equals(ProductDetails_current.get(Compair).getInstructions()))
							{
								log_system.error("Instruction not mapped "+ ProductDetails.get(Compair).getProductName());
								errorcount++;
							}
							else
							{
								if(ProductDetails.get(Compair).getProduct_actual_price()!=(ProductDetails_current.get(Compair).getProduct_actual_price()))
								{
									log_system.error("Price not mapped "+ ProductDetails.get(Compair).getProductName());
									errorcount++;
								}
								else
								{
									if(ProductDetails.get(Compair).getProduct_count()!=(ProductDetails_current.get(Compair).getProduct_count()))
									{
										log_system.error("Count not mapped "+ ProductDetails.get(Compair).getProductName());
										errorcount++;
									}
									else
									{
										if(!ProductDetails.get(Compair).getTopping_details().equals(ProductDetails_current.get(Compair).getTopping_details()))
										{
											System.out.println("Toppings not mapped "+ ProductDetails_current.get(Compair).getTopping_details());
											System.out.println("Toppings not mapped "+ ProductDetails.get(Compair).getTopping_details());
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
					order_subtotal=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'order_subtotal']")).getText());
					order_tax=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'order_tax']")).getText());			
					for(String Product_item1:ProductDetails_current.keySet())
					{
						
						Product_price_calculate=Product_price_calculate+ProductDetails_current.get(Product_item1).getProduct_actual_price();				
						ArrayList<String> Topping_cal=ProductDetails_current.get(Product_item1).getTopping_details();
						for(String toppingDetails:Topping_cal)
						{
							float toppingprice=Float.parseFloat(toppingDetails.split(",")[2]);
							Product_price_calculate=Product_price_calculate+toppingprice;					
						}				
					}
					
					Product_price_calculate=Float.parseFloat(new BigDecimal(Product_price_calculate).setScale(2, BigDecimal.ROUND_HALF_UP).toString());					
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
							
							try
							{
								float discount=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'discount_amount']")).getText());
								total_calculate=total_calculate-discount;
								BigDecimal bg2=new BigDecimal(total_calculate).setScale(3, BigDecimal.ROUND_HALF_UP);
								bg2=bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
								total_calculate=Float.parseFloat(bg2.toString());
							}
							catch(Exception e)
							{
								
							}
							
							
							try
							{
								WebElement deliveryCharge=SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'deliverycharge_amount']"));								
								float deliveryChargeamount=Float.parseFloat(deliveryCharge.getText().trim());								
								total_calculate=total_calculate+deliveryChargeamount;
								BigDecimal bg2=new BigDecimal(total_calculate).setScale(3, BigDecimal.ROUND_HALF_UP);
								bg2=bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
								total_calculate=Float.parseFloat(bg2.toString());
								
							}
							catch(Exception e1)
							{
								
							}
							
							try
							{
								WebElement TipAmount=SummaryContainer.findElement(By.xpath(".//select[normalize-space(@class) = 't-tip-percent']"));
								Select TipAmountOption=new Select(TipAmount);
								Random rdm=new Random();
								int index=rdm.nextInt(TipAmountOption.getOptions().size());
								TipAmountOption.selectByIndex(index);
								String TipSelected=TipAmountOption.getOptions().get(index).getText();
								float Tip=0;
								if(!TipSelected.contains("No Tip"))
								{
									Tip=Float.parseFloat(TipSelected.split("%")[1].trim().replace("(", "").replace(")", "").replace("$", "").trim());
								}
								total_calculate=total_calculate+Tip;
								BigDecimal bg2=new BigDecimal(total_calculate).setScale(3, BigDecimal.ROUND_HALF_UP);
								bg2=bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
								total_calculate=Float.parseFloat(bg2.toString());
								
							}
							catch(Exception e1)
							{
								try {
									WebElement TipAmount=SummaryContainer.findElement(By.xpath(".//div[normalize-space(@class) = 'col-md-4 col-xs-4 text-align-right default_tip']"));
									String TipSelected=TipAmount.getText().trim().replace("$", "").trim();
									float tip=Float.parseFloat(TipSelected);
									total_calculate=total_calculate+tip;
									BigDecimal bg2=new BigDecimal(total_calculate).setScale(3, BigDecimal.ROUND_HALF_UP);
									bg2=bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
									total_calculate=Float.parseFloat(bg2.toString());
								} catch (Exception e) {
								}
							}
							float order_total=Float.parseFloat(SummaryContainer.findElement(By.xpath(".//span[normalize-space(@class) = 'order_total']")).getText());
							if(order_total==total_calculate)
							{
								Status=1;
							}
							else
							{
								System.out.println("incorrect order total");
								Status=0;
							}
						}
						
					}
					else
					{
						System.out.println("Incorrect product sub total");
						Status=0;
					}				
				}
				else
				{
					Status=0;
				}
				
			}
		}
		else
		{
			Status=2;
		}
		
		
		return Status;
	}
	
	public int VerifyDelivery(String Address) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)Driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(5000);
		Status=0;
		Actions act=new Actions(Driver);
		WebElement delivery=null;
		try {
			delivery = Driver.findElement(By.xpath("//label[normalize-space(@class) = 'ubtn btn_service'][normalize-space(@for) = 't_delivery'] | //label[normalize-space(@class) = 'ubtn btn_service hide'][normalize-space(@for) = 't_delivery'] | //label[normalize-space(@class) = 'ubtn blackbtn btn_service'][normalize-space(@for) = 't_delivery'] | //label[normalize-space(@class) = 'ubtn blackbtn btn_service hide'][normalize-space(@for) = 't_delivery']"));
		} catch (Exception e) {
			Status=2;		
			}
		
		if(Status!=2)
		{
			if(!delivery.getAttribute("class").contains("hide"))
			{
				act.moveToElement(delivery);
				delivery.click();
				Thread.sleep(4000);
				WebElement address_txt=Driver.findElement(By.xpath("//input[normalize-space(@id) = 'searchTextField']"));
				address_txt.sendKeys("Miami, FL, USA");
				Thread.sleep(4000);
				List<WebElement> address_list=Driver.findElements(By.xpath("//div[normalize-space(@class) = 'pac-container pac-logo']//div[normalize-space(@class) = 'pac-item']"));
				for(WebElement address_list_irt:address_list)
				{
					act.moveToElement(address_list_irt);
					
					try {
						address_list_irt.click();
						Thread.sleep(2000);						
						break;
					} catch (Exception e) {	
					}					
				}
				
				address_txt.sendKeys(Keys.CONTROL+"a");
				address_txt.sendKeys(Keys.BACK_SPACE);
				address_txt.sendKeys(Address);
				Thread.sleep(2000);
				address_list.clear();
				address_list=Driver.findElements(By.xpath("//div[normalize-space(@class) = 'pac-container pac-logo']//div[normalize-space(@class) = 'pac-item']"));
				for(WebElement address_list_irt:address_list)
				{
					act.moveToElement(address_list_irt);
					
					try {
						address_list_irt.click();
						Thread.sleep(4000);
						Status=1;
						break;
					} catch (Exception e) {						
					}					
				}
				
			}
			else
			{
				Status=2;
			}
		}				
		return Status;
	}
	
	
	public int VerifyDeliveryTime(String City,String timeslot) throws ParseException
	{
		Status=0;								
		try {
			WebElement DeliveryTime=Driver.findElement(By.xpath("//span[normalize-space(@class) = 't-operation-hours']"));
			Calendar actualtime=timeSelect(City);
			
			
			
			String OrderType=null;
			try {
				OrderType=Driver.findElement(By.xpath("//span[normalize-space(@class) = 'text-capitalize']")).getText().toLowerCase().trim();
			} catch (Exception e) {
				
			}
			
			if(OrderType.contains("delivery"))
			{
				if(Driver.findElement(By.xpath("//p[normalize-space(@class) = 'txt_upper']")).getText().contains("Today"))
				{
					String TimeZone=DeliveryTime.getText();
					ArrayList<String> TimeSlot=getTimeSlotDelivery(TimeZone, timeslot, City);
					String ActiveTimeSlot=ActiveTimeSlot(TimeSlot,actualtime,City);
					String DisplayedTime=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'txt_upper']")).getText().split(",")[1].trim();				
					if(ActiveTimeSlot.contains(DisplayedTime))
					{
						Status=1;
					}
				}
				else
				{
					Status=2;
				}
				
			}
			else if(OrderType.contains("takeout"))
			{
				String TimeZone=getTimeZone(actualtime);
				ArrayList<String> TimeSlot=getTimeSlottakeout(TimeZone, timeslot, City);
				TimeSlot.remove(0);
				String ActiveTimeSlot=null;
				String DisplayedTime=null;
				if(TimeZone.contains("incressed Time"))
				{
					ActiveTimeSlot=TimeSlot.get(0);
					DisplayedTime=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'txt_upper']")).getText().split(",")[2].trim();
				}
				else
				{
					ActiveTimeSlot=ActiveTimeSlot(TimeSlot,actualtime,City);
					DisplayedTime=Driver.findElement(By.xpath("//p[normalize-space(@class) = 'txt_upper']")).getText().split(",")[1].trim();
				}
				
								
				if(ActiveTimeSlot.contains(DisplayedTime))
				{
					Status=1;
				}
			}
		} catch (Exception e) {
			Status=2;		
			}
		
		
		return Status;
	}

	
	
	public String getTimeZone(Calendar Time)
	{
		String TimeZone=null; 
		String days=null;
		int count_incressby=0;
		do
		{
			String[] dayName = {"Saturday","Sunday", "Monday",
	                "Tuesday", "Wednesday", "Thursday", "Friday", };
			
			 days = dayName[Time.get(Calendar.DAY_OF_WEEK)];
			 
			
			WebElement times=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'txt_contactdetail y-resCalender']"));
			List<WebElement> timeZone=times.findElements(By.xpath(".//div[normalize-space(@class) = 'row borderdotted']"));
			for(WebElement timeZne_itr:timeZone)
			{
				
				if(timeZne_itr.getText().contains(days))
				{
					TimeZone=timeZne_itr.getText();
					break;				
				}				
			}
			
			if(TimeZone==null)				
			{
				Time.add(Calendar.DAY_OF_WEEK, 1);
				count_incressby++;
			}
			
		}while(TimeZone==null);
		
		if(TimeZone!=null)
		TimeZone=TimeZone.split(days)[1];
		
		if(count_incressby>0)
		{
			TimeZone=TimeZone+" "+"incressed Time";
		}
		
		 return TimeZone;
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
	
	
	public ArrayList<String> getTimeSlottakeout(String TimeZone, String timeslot,String City) throws ParseException
	{
		ArrayList<String> timeslotlist=new ArrayList<String>();
		
		int count_incerssedBy=0;
		
		if(TimeZone.contains("incressed Time"))
		{
			count_incerssedBy++;
			TimeZone=TimeZone.split("incressed Time")[0].trim();
		}
		
		if(TimeZone!=null)
		{
			if(TimeZone.contains(",") || TimeZone.contains("\n"))
			{
				String[] timeZoneCollection=null;
				
				if(TimeZone.contains(","))
					timeZoneCollection=TimeZone.split(",");
				
				if(TimeZone.contains("\n"))
					timeZoneCollection=TimeZone.split("\n");
				
				for(String timeZone_tmp:timeZoneCollection)
				{
					TimeZone=timeZone_tmp.trim();
					if(TimeZone.length()>0)
					{
						String startTime=TimeZone.split("to")[0].trim();	
						int StartHour=Integer.parseInt(TimeZone.split("to")[0].trim().split(" ")[0].trim().split(":")[0].trim());
						int StartMin=Integer.parseInt(TimeZone.split("to")[0].trim().split(" ")[0].trim().split(":")[1].trim());
						String endTime=TimeZone.split("to")[1].trim();
						int endHour=Integer.parseInt(TimeZone.split("to")[1].trim().split(" ")[0].trim().split(":")[0].trim());
						int endMin=Integer.parseInt(TimeZone.split("to")[1].trim().split(" ")[0].trim().split(":")[1].trim());
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
							if(endHour!=12)
								cal_end.set(Calendar.AM_PM,Calendar.PM);
							else
								cal_end.set(Calendar.AM_PM,Calendar.AM);
						}
						
						System.out.println(cal_Start.getTime());
						System.out.println(cal_end.getTime());
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
					}
					
				}
			}
			else
			{
				String startTime=TimeZone.split("to")[0].trim();	
				int StartHour=Integer.parseInt(TimeZone.split("to")[0].trim().split(" ")[0].trim().split(":")[0].trim());
				int StartMin=Integer.parseInt(TimeZone.split("to")[0].trim().split(" ")[0].trim().split(":")[1].trim());
				String endTime=TimeZone.split("to")[1].trim();
				int endHour=Integer.parseInt(TimeZone.split("to")[1].trim().split(" ")[0].trim().split(":")[0].trim());
				int endMin=Integer.parseInt(TimeZone.split("to")[1].trim().split(" ")[0].trim().split(":")[1].trim());
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
					if(endHour!=12)
						cal_end.set(Calendar.AM_PM,Calendar.PM);
					else
						cal_end.set(Calendar.AM_PM,Calendar.AM);
				}
				System.out.println(cal_Start.getTime());
				System.out.println(cal_end.getTime());
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
			}
			
			
		}
		
		ArrayList<String> timeslotlist_temp=new ArrayList<String>();
		
		if(count_incerssedBy>0)
		{
			timeslotlist_temp.add(timeslotlist.get(0));
			timeslotlist_temp.add(timeslotlist.get(1));
			timeslotlist.clear();
			timeslotlist=timeslotlist_temp;
		}
		return timeslotlist;				
	}
	
	
	
	public ArrayList<String> getTimeSlotDelivery(String TimeZone, String timeslot,String City) throws ParseException
	{
		ArrayList<String> timeslotlist=new ArrayList<String>();
		
		int count_incerssedBy=0;
		
		if(TimeZone.contains("incressed Time"))
		{
			count_incerssedBy++;
			TimeZone=TimeZone.split("incressed Time")[0].trim();
		}
		
		if(TimeZone!=null)
		{
			if(TimeZone.contains(",") || TimeZone.contains("\n"))
			{
				String[] timeZoneCollection=null;
				
				if(TimeZone.contains(","))
					timeZoneCollection=TimeZone.split(",");
				
				if(TimeZone.contains("\n"))
					timeZoneCollection=TimeZone.split("\n");
				
				for(String timeZone_tmp:timeZoneCollection)
				{
					TimeZone=timeZone_tmp.trim();
					if(TimeZone.length()>0)
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
							if(endHour!=12)
								cal_end.set(Calendar.AM_PM,Calendar.PM);
							else
								cal_end.set(Calendar.AM_PM,Calendar.AM);
						}
						
						System.out.println(cal_Start.getTime());
						System.out.println(cal_end.getTime());
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
					}
					
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
					if(endHour!=12)
						cal_end.set(Calendar.AM_PM,Calendar.PM);
					else
						cal_end.set(Calendar.AM_PM,Calendar.AM);
				}
				System.out.println(cal_Start.getTime());
				System.out.println(cal_end.getTime());
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
			}
			
			
		}
		
		ArrayList<String> timeslotlist_temp=new ArrayList<String>();
		
		if(count_incerssedBy>0)
		{
			timeslotlist_temp.add(timeslotlist.get(0));
			timeslotlist_temp.add(timeslotlist.get(1));
			timeslotlist.clear();
			timeslotlist=timeslotlist_temp;
		}
		return timeslotlist;					
	}
	
	public String getcurrentDate(Calendar Time)
	{
		return String.valueOf(Time.get(Calendar.DATE));
		
	}
	
}
