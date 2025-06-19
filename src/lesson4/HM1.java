package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM1 {
	

	//Open chrome browser
	//Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
	//Enter valid username
	//Clear username and enter again valid username
	//Leave password field empty
	//Click on login button
	//Verify error message with text "Invalid Login or Password." is displayed.
	

	public static final String url="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("cihanadamey");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='ctl00_MainContent_username']")).sendKeys("cihanadamey");
		
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
		
		Thread.sleep(4000);
		
		WebElement label =driver.findElement(By.xpath("//span[@id='ctl00_MainContent_status']"));
			
		if(label.isDisplayed()) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
		
		
	}

}

