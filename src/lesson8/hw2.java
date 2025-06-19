package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class hw2 extends BaseClass{
	
	
	public static void main(String[] args) throws InterruptedException {
	/*	
	1) Launch the browser and open the site "https://neotech.vercel.app/iframe/multi2"
	2) Verify on the page header "Not a Friendly Topic" displayed
	3) Click on the Inner Frame Check box
	4) Choose Dog from Animals dropdown
	5) Quit the browser
	*/
		
		setUp();
		
		WebElement header=driver.findElement(By.xpath("//span[text()='Not a Friendly Topic']"));
		
		if(header.isDisplayed()) {
			System.out.println("Yes,its displayed");
		}else {
			System.out.println("NO");
		}
		
		driver.switchTo().frame("nested1");
		
		driver.switchTo().frame("child-frame");
		
		driver.findElement(By.id("inner-frame-check-box")).click();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		WebElement animalFrame=driver.findElement(By.xpath("//iframe[@title='animals']"));
		
		driver.switchTo().frame(animalFrame);
		
		Select dropdown=new Select(driver.findElement(By.id("animal-select")));
		
		dropdown.selectByValue("dog");
		
		Thread.sleep(2000);
		
		tearDown();
		
		
		
	}

}
