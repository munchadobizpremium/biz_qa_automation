package elements_ui;

import org.openqa.selenium.By;

public class element_locator {
	
	By obj_element=null;
	public By getElement(String elementtype,String element)
	{
		switch(elementtype)
		{		
		case "ByID":
		{
			obj_element=By.id(element);		
			break;
		}
		case "ByCssSelector":
		{
			obj_element=By.cssSelector(element);		
			break;
		}
		case "ByXPath":
		{
			obj_element=By.xpath(element);		
			break;
		}
		case "ByClassName":
		{
			
			obj_element=By.className(element);		
			break;
		}
		}
		return obj_element;
	}
	

}
