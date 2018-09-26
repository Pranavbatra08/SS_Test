package Functionalities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Sc {
	
	public static void captureAScreenshot(WebDriver driver, String screenshotName)
	{
	
		
		
	try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./Screenshots/"+screenshotName+".png"));
		System.out.println("Screenshot taken");
	} 
	catch (Exception e) {

		System.out.println("Exception handle");
		
	} 

	}
}
