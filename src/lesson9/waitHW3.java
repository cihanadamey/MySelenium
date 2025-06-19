package lesson9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class waitHW3 extends BaseClass {

	/*
	 * Add Employee Open chrome browser Go to "https://hrm.neotechacademy.com/"
	 * Login into the application Click on PIM > Add Employee Add Employee Log out
	 * Quit the browser
	 */

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		driver.findElement(By.id("txtPassword")).sendKeys("Neotech@123");

		driver.findElement(By.xpath("//div[@class='button-holder']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.titleContains("Dashboard"));

		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Employee']")));

		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name-box")));

		driver.findElement(By.id("first-name-box")).sendKeys("Barack");
		driver.findElement(By.id("last-name-box")).sendKeys("Obama");

		Thread.sleep(2000);

		Select select = new Select(driver.findElement(By.id("location")));

		select.selectByVisibleText("Chinese Development Center");

		driver.findElement(By.id("employeeId")).clear();

		driver.findElement(By.id("employeeId")).sendKeys("4572");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@ng-if='vm.showFooter']")).click();
		
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("modal-save-button")));

		saveButton.click();

		//WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='user-dropdown']")));
		
		//button.click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//a[@id='user-dropdown']")).click();
		
		Thread.sleep(2000);

		driver.findElement(By.id("logoutLink")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='button-holder']")));

		tearDown();

	}

}
