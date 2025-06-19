package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class hw2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Opening Page on Firefox Browser
		//Open Firefox browser
		//Navigate to “https://www.redfin.com/”
		//Verify that you have navigated to (https://www.redfin.com/)
		//End the Session (close the browser).
		
		
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.redfin.com/");
		
		String actualURL=driver.getCurrentUrl();
		
		String expectedURL="https://www.redfin.com/";
		
		if(actualURL.equals(expectedURL)) {
			System.out.println("Correct URL");
		}else {
			System.out.println("Wrong URL");
		}
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
