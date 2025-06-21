package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homework2 {

	// HW2: Facebook sign up:
	// Open chrome browser
	// Go to "https://www.facebook.com/"
	// Click on Sign Up link
	// Enter first name
	// Enter last name
	// Enter email address
	// Click on Sign Up button

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		String currentURL = driver.getCurrentUrl();
		String correctURL = driver.getCurrentUrl();

		if (currentURL.equals(correctURL)) {
			System.out.println("Correct Url");
		} else {
			System.out.println("Wrong Url");
		}
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.name("firstname")).sendKeys("Cihan");
		driver.findElement(By.name("lastname")).sendKeys("Adamey");
		driver.findElement(By.name("reg_email__")).sendKeys("cihanadamey1");
		driver.findElement(By.name("websubmit")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	
	}
}
