package lesson10;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Lesson9HWex extends BaseClass{
/*
	TC: Update Customer Information

	1) Open chrome browser
	2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
	3) Login to the application
	4) Verify customer "Susan McLaren" is present in the table
	5) Click on customer details
	6) Update customers last name and credit card info
	7) Verify updated customers name and credit card number is displayed in table
	8) Close browser
	*/
	public static void main(String[] args) throws InterruptedException {
		
		
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
		
		int rowNumber=-1;
		
		for(int i=1; i<rows.size(); i++) {
			String rowText=rows.get(i).getText();
			
			if (rowText.contains("Susan McLaren")) {
				
				rowNumber= i+1;
				
				String Path="//table[@id='ctl00_MainContent_orderGrid']//tr["+rowNumber+"]/td[13]";
				System.out.println("Path : "+Path);
				
				driver.findElement(By.xpath(Path)).click();
				Thread.sleep(2000);
				break;  //suraya break koymadim diye yarim saat ugrastim resmen
				
			}
		}
		
		WebElement name=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
		name.clear();
		name.sendKeys("Susan Obama");
		//String newName=name.getDomAttribute("value");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).clear();
		WebElement cNumber=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
		cNumber.sendKeys("123456789");
	
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		
	
		
		
		tearDown();
		
	}
}
