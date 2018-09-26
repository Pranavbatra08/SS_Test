package Functionalities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
class Window_switch {

	
	public void windowSwitch() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	WebDriver driver = new ChromeDriver();   
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get("http://toolsqa.com/automation-practice-switch-windows/");
	driver.manage().window().maximize();
	String Parent_window = driver.getWindowHandle();
	System.out.println("Parent window = "+driver.getTitle());
	
	driver.findElement(By.xpath("//button[@id='button1']")).click();
	
	Set<String> W = driver.getWindowHandles();
	
	Iterator<String> it = W.iterator();
	
	while(it.hasNext())
	{
		String Child_window = it.next();
		if(!Parent_window.equals(Child_window))
		{
			driver.switchTo().window(Child_window);
			System.out.println("Child window = "+driver.getTitle());
			Thread.sleep(6000);
			
		}
	}
	driver.manage().window().maximize();
	driver.findElement(By.xpath("(//span[contains(text(),'HOME')])[1]")).click();
	driver.close();
	driver.switchTo().window(Parent_window);
	
	
	}
}
