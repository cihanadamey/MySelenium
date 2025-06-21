package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class homework1 {
	
	// Open chrome browser
	// Go to "https://demo.guru99.com/test/newtours/"
	// Click on Register Link
	// Fill out ALL required info
	// Click Submit
	// User successfully registered
	// (Create the script using different locators)
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.linkText("REGISTER"))	.click();
		driver.findElement(By.name("firstName")).sendKeys("Cihan");
		driver.findElement(By.name("lastName")).sendKeys("Adamey");
		driver.findElement(By.name("phone")).sendKeys("123456789");
		driver.findElement(By.name("userName")).sendKeys("cihanadamey1@gmail.com");
		driver.findElement(By.name("email")).sendKeys("cihanadamey1");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.name("confirmPassword")).sendKeys("123456789");
		
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
		
		WebDriver fdriver = new FirefoxDriver();
		
        fdriver.get("https://demo.guru99.com/test/newtours/");
		
		Thread.sleep(3000);
		
		fdriver.manage().window().maximize();
		
		
		fdriver.findElement(By.linkText("REGISTER"))	.click();
		fdriver.findElement(By.name("firstName")).sendKeys("Cihan");
		fdriver.findElement(By.name("lastName")).sendKeys("Adamey");
		fdriver.findElement(By.name("phone")).sendKeys("123456789");
		fdriver.findElement(By.name("userName")).sendKeys("cihanadamey1@gmail.com");
		fdriver.findElement(By.name("email")).sendKeys("cihanadamey1");
		fdriver.findElement(By.name("password")).sendKeys("123456789");
		fdriver.findElement(By.name("confirmPassword")).sendKeys("123456789");
		
		fdriver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		
		fdriver.quit();

		
		
        WebDriver edriver = new EdgeDriver();
		
        edriver.get("https://demo.guru99.com/test/newtours/");
		
		Thread.sleep(3000);
		
		edriver.manage().window().maximize();
		
		edriver.findElement(By.linkText("REGISTER"))	.click();
		edriver.findElement(By.name("firstName")).sendKeys("Cihan");
		edriver.findElement(By.name("lastName")).sendKeys("Adamey");
		edriver.findElement(By.name("phone")).sendKeys("123456789");
		edriver.findElement(By.name("userName")).sendKeys("cihanadamey1@gmail.com");
		edriver.findElement(By.name("email")).sendKeys("cihanadamey1");
		edriver.findElement(By.name("password")).sendKeys("123456789");
		edriver.findElement(By.name("confirmPassword")).sendKeys("123456789");
		
		edriver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		
		edriver.quit();

	}
}