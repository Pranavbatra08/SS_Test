package Functionalities;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Newuser_Creation {

	 
	public static void main(String[] args) throws Exception {
		
	

		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://store-staging.macmillan-learning.com/ca/");
		driver.manage().window().maximize();
		//Sc.captureAScreenshot(driver, "URL launched");
		
		driver.findElement(By.xpath("//button[@class='close policy']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("createAccount")).click();
		String fn = driver.findElement(By.xpath("//label[@for='firstName']")).getText();
		System.out.println("Verifying 1st name");
        //Assert.assertEquals(fn, "First Name");
		
        Assert.assertEquals(fn, "First Name", "Assertion failed");
        System.out.println("verified");
        
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Pranav");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Batra");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pranavbatra_26sept@yopmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Qait@123");
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("Qait@123");
        driver.findElement(By.xpath("//select[@id='Security_Question_1__c']")).click();
        driver.findElement(By.xpath("//option[@value= 'What was your favorite place to visit as a child?']")).click();
        driver.findElement(By.xpath("//input[@id='Security_Question_1_Answer__c']")).sendKeys("Test");
        driver.findElement(By.xpath("//select[@id='Security_Question_2__c']")).click();
        driver.findElement(By.xpath("//option[@value= 'Who is your favorite actor, musician, or artist?']")).click();
        driver.findElement(By.xpath("//input[@id='Security_Question_3_Answer__c']")).sendKeys("Test");
       /* driver.findElement(By.xpath("")).click();
        driver.findElement(By.xpath("")).click();
        driver.findElement(By.xpath("//input[@id='Security_Question_3_Answer__c']")).sendKeys("Test");
        driver.findElement(By.xpath("")).sendKeys("New york");*/
        
       // Select sc1 = new Select(driver.findElement(By.id("Security_Question_1__c")));
        
        //driver.close();
	
	}
}
