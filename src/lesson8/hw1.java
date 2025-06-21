package lesson8;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.utils.BaseClass;

public class hw1 extends BaseClass{
	
	/*
	1) Launch the browser and open the site "https://neotech.vercel.app/email"
	2) Click on link "Click Here". When the user clicks on the "Click Here" link, new child window opens.
	3) On the Child Window, Enter your email ID and submit.
	4) Then Access Credentials will be Displayed on submitted page. You will see the child window is open in new tab.
	5) Close the Child window on which credentials are displayed. Switch to the parent window.
	6) Quit all browsers
	*/
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		String original=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String id:allWindows) {
			if(!id.equals(original)) {
				driver.switchTo().window(id);
			}
		}	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='emailid']")).sendKeys("cihanadamey1@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().window(original);
		Thread.sleep(2000);
		
		tearDown();
		
	}

}
