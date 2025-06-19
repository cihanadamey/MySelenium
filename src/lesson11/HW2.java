package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

public class HW2 extends CommonMethods{
	
    /*
       Launch the browser and open the site "https://neotech.vercel.app/email"
       Click on link "Click Here". When the user clicks on the "Click Here" link, new child window opens.
       On the Child Window, Enter your email ID and submit.
       Then Access Credentials will be Displayed on submitted page. You will see the child window is open in new tab.
       Close the Child window on which credentials are displayed. Switch to the parent window.
       Quit all browsers
	*/
	
	public static void main(String[] args) {
		
		
		setUp();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		switchToChildWindow();
		
		WebElement email=driver.findElement(By.id("emailid"));
		
		sendText(email, "cihanadamey1@gmail.com");
		
		driver.findElement(By.id("btnLogin")).click();
		
		wait(3);
		
		switchToChildWindow();
		
		wait(3);
		
		tearDown();
		
		
	}

}
