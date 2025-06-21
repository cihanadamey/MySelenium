package lesson10;

import java.awt.Frame;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Lesson10HW1 extends BaseClass{


	
    /*
      Open chrome browser
      Go to https://www.aa.com/homePage.do
      Enter From and To
      Select departure as December 14 of 2024
      Select arrival as December 22 of 2024
      Click on search
      Close browser
     */
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//div[@class='row-form normalLayout']//span[@class='icon icon-search'][1]")).click();
		
		Select Cselect=new Select(driver.findElement(By.id("countryCode")));
		
		Cselect.selectByValue("TR");
		
		driver.findElement(By.xpath("//table[@id='airportsSection']//tr[23]/td[3]")).click();
		
		driver.findElement(By.xpath("//div[@class='row-form normalLayout']//a[@data-for='reservationFlightSearchForm.destinationAirport']")).click();
		
		Select rSelect=new Select(driver.findElement(By.id("countryCode")));
		
		rSelect.selectByValue("US");
		
		Select sSelect=new Select(driver.findElement(By.id("stateCode")));
		
		sSelect.selectByValue("AZ");
		
		driver.findElement(By.xpath("//a[@id='airport_PHX']")).click();
		
		driver.findElement(By.xpath("//div[@class='js-date-picker-wrapper position-relative']/button[1]")).click();
		
		String currentM=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']")).getText();
		String currentY=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year'][1]")).getText();
		
		
		while(!currentM.equals("December")) {
			
			driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
			currentM=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'][1]")).getText();
			currentY=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year'][1]")).getText();
			
			
		}
		
		Thread.sleep(4000);
		
		List<WebElement> days=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody[1]"));
		
		String expectedDay="14";
		
		for(WebElement day:days) {
			if(day.getText().equals(expectedDay)) {
				day.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@for='aa-returningFrom']/button")).click();
		
		String currentM2=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'][1]")).getText();
		String currentY2=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year'][1]")).getText();
		
		while(!currentM2.equals("December")) {
			
			driver.findElement(By.xpath("//a[@data-event='click']")).click();
			currentM2=driver.findElement(By.xpath("//span[@class='ui-datepicker-month'][1]")).getText();
			
		}
		Thread.sleep(4000);
		
		List<WebElement> days2=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody[1]"));
		
		for(WebElement days3:days2) {
			String daytext=days3.getText();
			
			if(daytext.equals("22")) {
				days3.click();
				break;
			}
		}
		Thread.sleep(2000);
		
		driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
		
		
		
		tearDown();
		
		
	}
}
