package lesson9;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class waitHW1 extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		/*
		Homework 1: Use WebDriverWait
        Verify element is enabled
        
        Open chrome browser
        Go to "https://the-internet.herokuapp.com/"
        Click on the "Dynamic Controls" link
        Click on enable button
        Enter "Hello" and verify text is entered successfully
        Close the browser
		*/
		
		setUp();
		
		String original=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
		
		Set<String> allWindows=driver.getWindowHandles();
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement element=wait.until
		(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='input-example']/p")));
		
		if(element.isDisplayed()) {
			System.out.println("Yes it is displayed");
			
		}else {
			System.out.println("No it is not");
		}
		
		WebElement hello=driver.findElement(By.xpath("//form[@id='input-example']/input"));
		hello.sendKeys("Hello");
		
		if(hello.isDisplayed()) {
			System.out.println("Yes Hello is displayed");
		}else {
			System.out.println("NO");
		}
		Thread.sleep(2000);
		
		
		
		tearDown();
		
		
	}

}
