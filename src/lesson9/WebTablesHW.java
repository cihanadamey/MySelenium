package lesson9;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class WebTablesHW extends BaseClass {
	/*
	 * TC: Update Customer Information
	 * 
	 * 1) Open chrome browser 2) Go to
	 * "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
	 * 3) Login to the application 4) Verify customer "Susan McLaren" is present in
	 * the table 5) Click on customer details 6) Update customers last name and
	 * credit card info 7) Verify updated customers name and credit card number is
	 * displayed in table 8) Close browser
	 */

	public static void main(String[] args) throws InterruptedException {

		setUp();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

		String tableContent = driver.findElement(By.id("ctl00_MainContent_orderGrid")).getText();
		System.out.println(tableContent.contains("Susan McLaren"));
		System.out.println(tableContent);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tr"));

		int rowNumber = -1;

		for (int i = 1; i < rows.size(); i++) {
			String rowText = rows.get(i).getText();
			if (rowText.contains("Susan Mclaren")) {

				System.out.println("Finding element i ---> " + i);

				rowNumber = i + 1;

				String path = "//table[@id='ctl00_MainContent_orderGrid']//tr[" + rowNumber + "]/td[13]";
				System.out.println("Path: " + path);

				driver.findElement(By.xpath(path)).click();

				Thread.sleep(2000);

				break;
			}
		}

		Thread.sleep(2000);

		WebElement cName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));

		String currentName = cName.getText();
		System.out.println("GetText: " + currentName);
		String currentNameValue = cName.getDomAttribute("value");
		System.out.println("Get Value: " + currentNameValue);

		cName.clear();
		cName.sendKeys("Susan Doe");

		WebElement cardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));

		cardNumber.clear();
		cardNumber.sendKeys("1111222233334444");

		Thread.sleep(4000);

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

		Thread.sleep(4000);

		// verify updated values in the table:

		String newValues = "//table[@id='ctl00_MainContent_orderGrid']//tr[" + rowNumber + "]";
		System.out.println("New Path: " + newValues);

		String newRecord = driver.findElement(By.xpath(newValues)).getText();

		System.out.println("New row: " + newRecord);

		tearDown();
	}
}
