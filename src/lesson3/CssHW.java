package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssHW {

	public static void main(String[] args) throws InterruptedException {

		// Using Css ONLY
		// TC 2: Mercury Tours Registration:
		// Open chrome browser
		// Go to “http://demo.guru99.com/test/newtours/”
		// Click on Register Link
		// Fill out all required info
		// Click Submit
		// User successfully registered

		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("a[href*='register.php']")).click();
		driver.findElement(By.cssSelector("input[name*='firstName']")).sendKeys("Cihan");
		driver.findElement(By.cssSelector("input[name*='lastName']")).sendKeys("Adamey");
		driver.findElement(By.cssSelector("input[name*='phone']")).sendKeys("13245985");
		driver.findElement(By.cssSelector("input[name='userName'][id='userName']")).sendKeys("cihanadamey1@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#email")).sendKeys("cihanadamey1");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345678");
		driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("12345678");
		
		driver.findElement(By.cssSelector("input[name='submit']")).click();

		Thread.sleep(2000);

		
		driver.quit();
		driver.close();
	
	}

}
