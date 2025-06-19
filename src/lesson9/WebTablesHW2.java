package lesson9;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class WebTablesHW2 extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		/*
		1) Open chrome browser
        2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
        3) Login to the application
        4) Click on the checkbox of all orders with product FamilyAlbum
        5) Delete Selected orders
        6) Verify the orders have been deleted
        7) Quit the browser
		
		*/
		
		setUp();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
		
		List<WebElement> pName=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[3]"));
		String product="FamilyAlbum";
		
		Thread.sleep(2000);
		
		for(int i=0;i<pName.size();i++) {
			
			String text=pName.get(i).getText();
			
			if(text.equals(product)) {
				String path="//table[@id='ctl00_MainContent_orderGrid']//tr["+(i+2)+"]//td[1]";
				driver.findElement(By.xpath(path)).click();
				Thread.sleep(2000);
			}
		}
				driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
		
				Thread.sleep(2000);
		
		
		tearDown();
	}

}
