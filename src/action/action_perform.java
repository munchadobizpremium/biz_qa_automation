package action;

import java.io.IOException;

import global_utility.global_variables;

public class action_perform extends global_variables{
	
	action_execute act_execute=new action_execute();
	int Status;
	
	public int Perform_OpenBrowser(String Environment,String BrowserName) throws IOException, InterruptedException
	{		
		Status=act_execute.OpenBrowser(Environment,BrowserName);
		return Status;
				
	}
	
	public int Perform_GetURL(String url) throws Exception
	{
		log_system.info("Perform Action: Get URL");
		Status=act_execute.URL(url);
		return Status;
	}
	
	public int Perform_VerifySSL() throws Exception
	{
		log_system.info("Perform Action: Verify SSL");
		Status=act_execute.VerifySSL();
		return Status;
	}
	
	public int Perform_VerifyURL(String url) throws Exception
	{
		log_system.info("Perform Action: Verify URL");
		Status=act_execute.VerifyURL(url);
		return Status;
	}
	
	public int Perform_VerifyText(String ElementKey,String ElementSelector,String text) throws Exception
	{
		log_system.info("Perform Action: Verify text");
		Status=act_execute.VerifyText(ElementKey,ElementSelector, text);
		return Status;
	}
	
	public int Perform_VerifyTitle(String title,String WindowType) throws Exception
	{
		log_system.info("Perform Action: verify Title");
		Status=act_execute.VerfyTitle(title,WindowType);
		return Status;
	}
	
	public int Perform_VerifyElement(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: verify Element");
		Status=act_execute.VerifyElement(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyFavicon(String ElementKey, String ElementSelector)
	{
		log_system.info("Perform Action: Verfy Favicon");
		Status=act_execute.VerifyFavicon(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_ConsolError()
	{
		log_system.info("Perform Action: Verfy Favicon");
		Status=act_execute.ConsolError();
		return Status;
	}
	
	public int Perform_VerifyNoElement(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: verify No Element");
		Status=act_execute.VerifyNoElement(ElementKey,ElementSelector);
		return Status;
	}
	
	
	public int Perform_SetText(String ElementKey, String ElementSelector,String InputString) throws Exception
	{
		log_system.info("Perform Action: SetText");
		Status=act_execute.SetText(ElementKey,ElementSelector,InputString);
		return Status;
	}
	
	public int Perform_AddProduct(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: Add Product");
		Status=act_execute.AddProduct(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyMenuItem(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: Add Product");
		Status=act_execute.VerifyMenuItem(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_AddEditProduct() throws Exception
	{
		log_system.info("Perform Action: Edit Product");
		Status=act_execute.AddEditProduct();
		return Status;
	}
	
	public int Perform_DeleteProduct(String Instruction) throws Exception
	{
		log_system.info("Perform Action: Delete Product");
		Status=act_execute.DeleteProduct(Instruction);
		return Status;
	}
	
	public int Perform_RemoveEditProduct() throws Exception
	{
		log_system.info("Perform Action: Remove Product");
		Status=act_execute.RemoveEditProduct();
		return Status;
	}
	
	public int Perform_VerifySummary(String ElementKey, String ElementSelector,String Tax) throws Exception
	{
		log_system.info("Perform Action: Verify Summary");
		Status=act_execute.VerifySummary(ElementKey,ElementSelector,Tax);
		return Status;
	}
	
	public int Perform_wait(String WaitTime) throws Exception
	{
		log_system.info("Perform Action: Wait");
		Status=act_execute.wait(Integer.parseInt(WaitTime));
		return Status;
	}
	
	
	
	public int Perform_ClearText(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: ClearText");
		Status=act_execute.ClearText(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_Click(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: Click");
		Status=act_execute.Click(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_SelectDropdown(String ElementKey, String ElementSelector)
	{
		log_system.info("Perform Action: SelectDropdown");
		Status=act_execute.SelectDropdown(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_SelectDate(String ElementKey, String ElementSelector) throws InterruptedException
	{
		log_system.info("Perform Action: SelectDate");
		Status=act_execute.SelectDate(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_SelectTimeSlot(String ElementKey, String ElementSelector) throws InterruptedException
	{
		log_system.info("Perform Action: SelectDate");
		Status=act_execute.SelectTimeSlot(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_CloseBrowser(String Browser_type) throws Exception 
	{
		log_system.info("Perform Action: Close Browser");
		Status=act_execute.CloseBrowser(Browser_type);		
		return Status; 
	}
	
	public void Perform_QuitDriver() throws Exception
	{
		log_system.info("Perform Action: Quit Driver");
		act_execute.QuitDriver();		
		
	}
}
