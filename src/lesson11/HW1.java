package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

public class HW1 extends CommonMethods{

	//  FrameDemo at com.neotech.lesson07 using the CommonMethods.java
	/*
	1) Launch the browser and open the site "https://neotech.vercel.app/iframe/multi2"
	2) Verify on the page header "Not a Friendly Topic" displayed
	3) Click on the Inner Frame Check box
	4) Choose Dog from Animals dropdown
	5) Quit the browser
	*/
	
	public static void main(String[] args) {
		
		setUp();
		
		WebElement header=driver.findElement(By.xpath("//span[text()='Not a Friendly Topic']"));
		
		Boolean head=header.isDisplayed();
		System.out.println("Header is displayed "+ head);
		
		WebElement mFrame=driver.findElement(By.id("nested1"));
		switchToFrame(mFrame);
		
		WebElement cFrame=driver.findElement(By.id("child-frame"));
		switchToFrame(cFrame);
		
		driver.findElement(By.xpath("//input[@id='inner-frame-check-box']")).click();
		
		driver.switchTo().defaultContent();
		
		WebElement aFrame=driver.findElement(By.id("animals"));
		switchToFrame(aFrame);
		
		WebElement ddown=driver.findElement(By.id("animal-select"));
		selectDropdown(ddown, "Dog");
		
		wait(3);
		
		tearDown();
		
		
		
	}
}
