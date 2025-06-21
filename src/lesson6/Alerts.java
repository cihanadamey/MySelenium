package lesson6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Alerts extends BaseClass {

	// https://neotech.vercel.app/alerts
	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.findElement(By.id("customerId")).sendKeys("123");
		WebElement click = driver.findElement(By.id("btnDeleteCustomer"));
		click.click();

		Thread.sleep(2000);

		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println(alertText);
		simpleAlert.dismiss();
		Thread.sleep(2000);
		click.click();
		Alert secondAlert = driver.switchTo().alert();
		secondAlert.accept();
		Thread.sleep(2000);
		Alert lastAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		lastAlert.dismiss();

		Thread.sleep(2000);

		tearDown();
	}
}
