package Sept_2_test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();   
		
		/*String Url = "http://demo.guru99.com/test/newtours/register.php";					
		driver.get(Url);

		Select country = new Select(driver.findElement(By.name("country")));
		
		country.selectByValue("ANGUILLA");
		Thread.sleep(2000);*/
		
		driver.get("http://output.jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		//fruits.isMultiple();
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
		Thread.sleep(2000);
		fruits.selectByIndex(2);
		Thread.sleep(2000);
		fruits.deselectByIndex(2);
		
		
		driver.close();
}}
