package lesson8;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class waitTestCase1 extends BaseClass {
	/*
	 * TC 1: Verify element is present
	 * 
	 * 1. Open chrome browser 2. Go to "https://the-internet.herokuapp.com/" 3.
	 * Click on the “Dynamic Loading” link 4. Click on “Example 1...” and click on
	 * “Start” 5. Verify element with text “Hello World!” is displayed 6. Close the
	 * browser
	 */

	public static void main(String[] args) throws InterruptedException {

		setUp();

		String original = driver.getWindowHandle();

		WebElement dynamic = driver.findElement(By.xpath("//a[text()='Dynamic Loading']"));

		dynamic.click();

		Set<String> allWindows = driver.getWindowHandles();

		driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

		if (element.isDisplayed()) {
			System.out.println("It is appeared");
		} else {
			System.out.println("No");
		}

		tearDown();

	}
}