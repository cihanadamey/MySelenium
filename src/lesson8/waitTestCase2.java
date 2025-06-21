package lesson8;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class waitTestCase2 extends BaseClass {
	/*
	TC 2: Verify element is clickable

	1. Open chrome browser
	2. Go to "https://the-internet.herokuapp.com/"
	3. Click on the “Dynamic Controls” link
	4. Select checkbox and click Remove

	5. Click on Add button and verify “It's back!” text is displayed
	6. Close the browser
*/
	
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		String original=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
		Thread.sleep(2000);
		
		Set<String> newPage=driver.getWindowHandles();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(14));
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
				
		if(element.isDisplayed()) {
			System.out.println("Yes it is displayed");
		}else {
			System.out.println("NO");
		}
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']/p")));
		
		
		tearDown();
		
		
	}
}
