package lesson9;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.neotech.utils.BaseClass;

public class waitHW2 extends BaseClass {

	/*
	 * Homework 2: Same as Homework1 -> Use FluentWait Open chrome browser Go to
	 * "https://the-internet.herokuapp.com/" Click on the "Dynamic Controls" link
	 * Click on enable button Enter "Hello" and verify text is entered successfully
	 * Close the browser
	 */
	
	public static void main(String[] args) throws NoSuchElementException, InterruptedException {

		setUp();
		
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
		FluentWait <WebDriver> wait=new FluentWait<>(driver);
		
		wait.withTimeout(Duration.ofSeconds(15));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		
		wait.until(driver -> driver.findElement(By.xpath("//input[@type='text']")));
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");


		tearDown();

	}

}
