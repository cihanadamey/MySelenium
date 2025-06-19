package lesson12;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;

public class HW2 extends CommonMethods {

	/*
	 * Homework 2: Go to https://hrm.neotechacademy.com/ Log in using our custom
	 * methods Go to PIM menu Add an employee Go to Employee List Get the list of
	 * the employees (Using tables - tr and td) Loop to search for the employee you
	 * added When you find the employee - click on it. Take a screenshot
	 */

	public static void main(String[] args) {

		setUp();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement Uname = driver.findElement(By.id("txtUsername"));
		sendText(Uname, "Admin");

		WebElement Ulname = driver.findElement(By.id("txtPassword"));
		sendText(Ulname, "Neotech@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();

		WebElement fname = driver.findElement(By.xpath("//input[@id='first-name-box']"));

		sendText(fname, "Cihan");

		WebElement lname = driver.findElement(By.xpath("//input[@id='last-name-box']"));

		sendText(lname, "Adamey");

		//WebElement dDown = driver.findElement(By.xpath("//select[@id='location']"));

		//dDown.click();
		//selectDropdown(dDown, "Canadian Regional HQ");
		
		//driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		
		Select select = new Select(driver.findElement(By.id("location")));

		select.deselectByVisibleText("Canadian Regional HQ");
		
		driver.findElement(By.xpath("//div[@ng-if='vm.showFooter']")).click();
		
		WebElement click=driver.findElement(By.id("modal-save-button"));
		
		click.click();
		
		//action.doubleClick(click).perform();

		//WebElement click=driver.findElement(By.id("modal-save-button"));

		List<WebElement> listofEmp = driver.findElements(By.xpath("//table[@id='employeeListTable']"));

		String Added = "Cihan Adamey";

		for (int i = 0; i < listofEmp.size(); i++) {
			String empL = listofEmp.get(i).getText();
			{
				if (empL.contains(Added)) {
					listofEmp.get(i).click();
				}
			}
		}

		TakesScreenshot ssDriver = (TakesScreenshot) driver;

		File screenshot = ssDriver.getScreenshotAs(OutputType.FILE);

		try {
			File screenShotDir = new File("screenshots/HRM");

			if (!screenShotDir.exists()) {

				screenShotDir.mkdirs();
			}

			File screenshotLocation = new File("screenshots/HRM/dashboard.png");
			Files.copy(screenshot, screenshotLocation);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to take the screenshot!");
		}

		wait(2);

		tearDown();

	}

}
