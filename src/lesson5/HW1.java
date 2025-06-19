package lesson5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class HW1 {

	/*
	 * HW1: Orange HRM Application Login: Open Chrome browser Go to
	 * https://hrm.neotechacademy.com/ Enter valid username and password Click on
	 * login button Then verify that "span with id account-name" has the text
	 * "Jacqueline White". Quit the browser
	 */

	public static void main(String[] args) throws InterruptedException {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String url=ConfigsReader.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Neotech@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement input=driver.findElement(By.xpath("//span[@id='account-name']"));
		
		if(input.isDisplayed()) {
			
			System.out.println("Correct id "+input.getText());
			Thread.sleep(2000);
			driver.close();
		}else {
			System.out.println("Invalid ID");
			Thread.sleep(2000);
			driver.close();
		}
		
	
		
		
		
	}

}
