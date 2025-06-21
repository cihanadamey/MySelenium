package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPathHW {
	
	       // Using xPath ONLY
	       // TC 2: Mercury Tours Registration: 
	       // Open chrome browser
	       // Go to “http://demo.guru99.com/test/newtours/”
	       // Click on Register Link
	       // Fill out all required info
	       // Click Submit
	       // User successfully registered

	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(@href,'register')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Cihan");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Adamey");
		driver.findElement(By.name("phone")).sendKeys("123456789");
		driver.findElement(By.name("userName")).sendKeys("cihanadamey1@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("123 st apt 1");
		driver.findElement(By.xpath("//select[@name='country']")).click();
		driver.findElement(By.xpath("//option[@value='TURKEY']")).click();
		driver.findElement(By.name("email")).sendKeys("cihanadamey1");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.name("confirmPassword")).sendKeys("123456789");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='submit' and @type='submit']")).click();
		
		driver.close();
		driver.quit();
		
		
	}

}
