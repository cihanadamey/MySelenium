package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	
	// go to https://facebook.com/
	// fill out the username
	// fill out the password
	// click on login
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver(); //open the browser
		
		driver.get("http://facebook.com"); //navigate to facebook.com
		
		//Locate the username box
		//Create a WebElement object
		WebElement usernamebox=driver.findElement(By.id("email"));
		
		//send the username to username box
		usernamebox.sendKeys("neotech@.com");
		
		Thread.sleep(2000);
		
		//locate the password box
		driver.findElement(By.id("pass")).sendKeys("p@ssword!");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
		
		
		
	}

}
