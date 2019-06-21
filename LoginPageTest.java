package com.onlinestock.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPageTest {

	public static WebDriver d;
	public static void chrome(){
	System.setProperty("webdriver.chrome.driver", "/Users/mackbookpankaj/eclipse-workspace/WebDriver/chromedriver");
	d=new ChromeDriver();
	d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	d.get("http://localhost:8080/OnlineStockAuction/");
	d.manage().window().maximize();
   }
	
	public static void login() throws InterruptedException {
		d.findElement(By.name("username")).sendKeys("sulthan");
		d.findElement(By.name("password")).sendKeys("sulthan123");
		
		d.findElement(By.xpath("id('submitButton')")).click();
		
		d.findElement(By.xpath("//button[contains(.,'logout')]")).click();	
		
	}
	
	
	public static void RegisterRetailer() throws InterruptedException {
		
		d.findElement(By.xpath("//a[(@href='view/register/registerRetailer.jsp')]")).click();
		d.findElement(By.name("username")).sendKeys("testing3");
		d.findElement(By.xpath("id('password')")).sendKeys("Selenium1");
		d.findElement(By.xpath("id('confirm_password')")).sendKeys("Selenium1");
		d.findElement(By.name("business_name")).sendKeys("RetailerTest");
		d.findElement(By.name("business_tel")).sendKeys("89898989");
		d.findElement(By.name("business_fax")).sendKeys("123456");
		d.findElement(By.xpath("id('submitButton')")).click();
		d.switchTo().alert().accept();
		
		
		//d.close();
	}
	
	
public static void RegisterFarmer() throws InterruptedException {
	
	
		d.findElement(By.xpath("//a[(@href='view/register/registerFarmer.jsp')]")).click();
		d.findElement(By.name("username")).sendKeys("testing4");
		d.findElement(By.xpath("id('password')")).sendKeys("Selenium1");
		d.findElement(By.xpath("id('confirm_password')")).sendKeys("Selenium1");
		d.findElement(By.name("farmAddress")).sendKeys("RetailerTest");
		d.findElement(By.name("telephone")).sendKeys("89898989");
		
		d.findElement(By.xpath("id('submitButton')")).click();
		d.switchTo().alert().accept();
			
		//d.close();
	}


public static void AddProducts() throws InterruptedException {
	
	
	d.findElement(By.name("username")).sendKeys("farmer");
	d.findElement(By.name("password")).sendKeys("farmer123");
	
	d.findElement(By.xpath("id('submitButton')")).click();
	//d.findElement(By.cssSelector("tablinks:nth-child(2)")).click();
	d.findElement(By.xpath("//button[@onclick=\"openCity(event, 'Add Products')\"]")).click();
	d.findElement(By.xpath("//select[@id='product-dropdown']")).sendKeys("Carrot");
	d.findElement(By.xpath("//select[@id='frequency-dropdown']")).sendKeys("Daily");
	d.findElement(By.xpath("//input[@id='quantity']")).sendKeys("10000");
	d.findElement(By.xpath("//input[@id='price']")).sendKeys("50");
	d.findElement(By.xpath("//input[@id='submitProductStock']")).click();
	d.switchTo().alert().accept();
	d.findElement(By.xpath("//button[contains(.,'logout')]")).click();
	
		
	//d.close();	
}


public static void ViewProducts() throws InterruptedException {
	
	
	d.findElement(By.name("username")).sendKeys("sulthan");
	d.findElement(By.name("password")).sendKeys("sulthan123");
	
	d.findElement(By.xpath("id('submitButton')")).click();
	
	d.findElement(By.xpath("//button[@onclick=\"openCity(event, 'View Product Catalogue')\"]")).click();
	d.findElement(By.xpath("//select[@id='product-dropdown']")).sendKeys("Carrot");
	d.findElement(By.xpath("//select[@id='frequency-dropdown']")).sendKeys("Daily");
	d.findElement(By.xpath("//input[@id='quantity']")).sendKeys("10000");
	d.findElement(By.xpath("//input[@id='submitSearchProductStock']")).click();
	d.findElement(By.xpath("//input[@id='retailerPrice0']")).sendKeys("570000");
	d.findElement(By.xpath("//input[@id='submitRetailerBid_0']")).click();
	d.switchTo().alert().accept();
	
	d.findElement(By.xpath("//button[contains(.,'logout')]")).click();
	
		
	//d.close();
}

	public static void main(String[] args) throws InterruptedException  {
		
		LoginPageTest.chrome();
		
		LoginPageTest.RegisterRetailer();
		System.out.println("Doing Retailer Registration");
		LoginPageTest.RegisterFarmer();
		System.out.println("Doing Farmer Registration"); 
		LoginPageTest.login(); 
		System.out.println("Login successfull");
		LoginPageTest.AddProducts();
		System.out.println("Add products successful");
		LoginPageTest.ViewProducts();
		System.out.println("View products is successful");
		
	 }
}