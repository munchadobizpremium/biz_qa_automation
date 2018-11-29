package global_utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class takescreenshot extends global_variables 
{
	
	public void screenshot(String screenpath,String Filename)
	{
		File src=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		try {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
			   LocalDateTime now = LocalDateTime.now();
			
			 Path path = FileSystems.getDefault().getPath(screenpath, Filename+".png");
				if(Files.deleteIfExists(path));
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File(screenpath+"\\"+Filename+"_"+dtf.format(now).toString()+".png"));
			path_lib_screenshotfull=screenpath+"\\"+Filename+"_"+dtf.format(now)+".png";
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
	}

}
