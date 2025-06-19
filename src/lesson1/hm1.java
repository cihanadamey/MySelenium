package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hm1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Amazon Page Title Verification: 
		//Open chrome browser
		//Go to “https://www.amazon.com/”
		//Verify Title “Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more” is displayed
		//End the Session (close the browser).
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		String actualURL=driver.getCurrentUrl();
		
		String expectedURL="https://www.amazon.com/";
		
		
		if(actualURL.equals(expectedURL)) {
			System.out.println("Page title :"+driver.getTitle());
			
		}
		else {
			System.out.println("wrong url");
		}
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
	}

}
