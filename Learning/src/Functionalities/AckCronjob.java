package Functionalities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AckCronjob {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();   

		driver.get("https://store-admin-staging.macmillan-learning.com/hmc/hybris");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='Main_user']")).clear();
		driver.findElement(By.xpath("//input[@id='Main_user']")).sendKeys("naman.arora");
		driver.findElement(By.xpath("//input[@id='Main_password']")).sendKeys("d3d86c");
		driver.findElement(By.xpath("//span[@id='Main_label']")).click();

		System.out.println("Logged IN");

		driver.findElement(By.xpath("//a[@id='Tree/GenericExplorerMenuTreeNode[system]_label']")).click();
		driver.findElement(By.xpath("//a[@id='Tree/GenericLeafNode[CronJob]_label']")).click();
		driver.findElement(By.xpath("//input[@id='Content/StringEditor[in Content/GenericCondition[CronJob.code]]_input']")).sendKeys("saveAcknowledgementFromVistaCronJob");
		driver.findElement(By.xpath("//span[@id='Content/OrganizerSearch[CronJob]_searchbutton']")).click();
		driver.findElement(By.xpath("//img[@id='Content/OrganizerListEntry[saveAcknowledgementFromVistaCronJob][search 2]_img']")).click();
		
		String Parent_Window = driver.getWindowHandle();
		System.out.println("Parent window"+driver.getTitle());
		
		driver.findElement(By.xpath("//div[@id='Content/GenericItemChip$1[action.performcronjob]_label']")).click();
		System.out.println("cronjob started");

		Set<String> w = driver.getWindowHandles();
		Iterator<String> it = w.iterator();
		
		while (it.hasNext())
		{
			String Child_Window =  it.next();
			if(!Parent_Window.equals(Child_Window))
			{
				driver.switchTo().window(Child_Window);
				System.out.println("Child window"+driver.getTitle());
			}
			
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span")).click();
		driver.switchTo().window(Parent_Window);
		System.out.println("Cronjob Run successfully");
		driver.close();
		
		
	}
}
