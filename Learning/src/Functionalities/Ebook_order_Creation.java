package Functionalities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Ebook_order_Creation {

	public static void main(String[] args) throws InterruptedException, Exception {

		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();   

		driver.get("https://store-staging.macmillan-learning.com/ca/");
		driver.manage().window().maximize();
		Sc.captureAScreenshot(driver, "URL launched");


		//	Sc.captureAScreenshot(driver);

		/*TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("./Screenshots/1.png"));
		System.out.println("Screenshot taken");*/

		//Basic method to capture a screenshot

		//driver.get("https://store-staging.macmillan-learning.com/ca");
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		//driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@class='close policy']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();
		driver.findElement(By.id("username")).sendKeys("pranavbatra_5sept@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("Qait@1234");
		
		Sc.captureAScreenshot(driver, "SignIn page");
		driver.findElement(By.id("signin")).click();
		System.out.println("Logged IN");

		Thread.sleep(2000);
		driver.findElement(By.id("js-site-search-input")).sendKeys("9781457651717");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//ul[contains(@class,'search-results')])[1]")).click();
		driver.findElement(By.xpath("//p[@class='small li-ui-menu-item-p']")).click();
		System.out.println("Navigated to PDP page");
		Sc.captureAScreenshot(driver, "PDP page");
		
		

		Thread.sleep(2000);
		
		Assert.assertEquals("Add to Cart", driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-block js-add-to-cart js-enable-btn glyphicon-shopping-cart add-to-cart-btn'])[2]")).getText(), "Assertion");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-block js-add-to-cart js-enable-btn glyphicon-shopping-cart add-to-cart-btn'])[2]")).click();
		//driver.findElement(By.id("addToCartButton1")).click();
		System.out.println("Added product to cart");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='pull-left']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/ca/cart']")).click();
		System.out.println("Naviagted to checkout page");
		Thread.sleep(2000);
		
		Sc.captureAScreenshot(driver, "Checkout page");
		driver.findElement(By.xpath("//button[@id='js-checkout-button']")).click();

		if(driver.findElement(By.xpath("//input[@id='addressSelected']")).isDisplayed()) {

			driver.findElement(By.xpath("//button[@id='addressSubmitCA']")).click();

		}else {
			
			driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block btn-large js-continue-checkout-button']")).click();
			driver.findElement(By.xpath("//input[@id='addressFormEnabled']")).click();
			driver.findElement(By.xpath("//input[@id='address.line1']")).sendKeys("4715 rue Levy");
			driver.findElement(By.xpath("//input[@id='address.postcode']")).sendKeys("H3C 5K4");
			driver.findElement(By.xpath("//input[@id='address.townCity']")).sendKeys("Montreal");

			Select province = new Select(driver.findElement(By.xpath("//select[@id='address.region']")));
			province.selectByVisibleText("Alberta");

			driver.findElement(By.xpath("//input[@id='address.phone']")).sendKeys("5146021305");
			driver.findElement(By.xpath("//button[@id='addressSubmitCA']")).click();
		}
		
		driver.findElement(By.xpath("//button[@id='deliveryMethodSubmit']")).click();
		System.out.println("Delivery method selected");
		
	
		driver.switchTo().frame("braintree-hosted-field-number");
		
		driver.findElement(By.xpath("//input[@placeholder='Card Number']")).sendKeys("4111111111111111");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		driver.findElement(By.xpath("//input[@placeholder='MM/YY']")).sendKeys("123");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("braintree-hosted-field-cvv");
		driver.findElement(By.xpath("//input[@placeholder='CVV']")).sendKeys("123");
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//button[@id='submit_silentOrderPostForm']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='TermsAndConditions']")).click();
		driver.findElement(By.xpath("//button[@id='placeOrder']")).click();
		System.out.println("Order created");
		
		String orderID = driver.findElement(By.xpath("(//div/p/b)[1]")).getText();
		String userID = driver.findElement(By.xpath("(//div/p/b)[2]")).getText();
		System.out.println("Order ID - "+  orderID);
		System.out.println("User ID - "+  userID);
		
		driver.close();
	}}
