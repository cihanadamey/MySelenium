package lesson12;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;

public class takeSSDEMO extends CommonMethods {

//	go to https://hrm.neotechacademy.com/
//	enter username
//	leave password blank
//	submit the form
//	and take a screenshot of the error page
	
	public static void main(String[] args) {

		setUp();
		
		
		WebElement name=driver.findElement(By.id("txtUsername"));
		sendText(name, "Admin");
		
		//WebElement lname=driver.findElement(By.id("txtPassword"));
		//sendText(lname, "Neotech@123");;
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		wait(4);
		
		TakesScreenshot ssDriver = (TakesScreenshot) driver;

		// lets take the screenshot using the ssDriver object
		File screenShot = ssDriver.getScreenshotAs(OutputType.FILE);

		try {
			File screenShotDir = new File("screenshots/HRM");

			// check if the directory exists
			if (!screenShotDir.exists()) {
				// create the folders
				screenShotDir.mkdirs();
			}

			File screenshotLocation = new File("screenshots/HRM/dashboard.png");
			Files.copy(screenShot, screenshotLocation);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to take the screenshot!");
		}
		
		
		tearDown();
		
		
		
	}

}
