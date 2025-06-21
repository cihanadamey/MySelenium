package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class HW2 {

	/*
	 * TC 2: Orange HRM Application Negative Login: 
	 * Open Chrome browser Go to https://hrm.neotechacademy.com/ Enter valid username Leave password field
	 * empty Verify error message with text "Password cannot be empty" is displayed.
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String url=ConfigsReader.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("Admin");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		
		WebElement input=driver.findElement(By.cssSelector("span[id='txtPassword-error']"));
		String text=input.getText();
		if(text.equals("Password cannot be empty")) {
			System.out.println("Correct");
		}else {
			System.out.println("Invalid");
		}
		
		driver.quit();
		
	}
	
	
}
