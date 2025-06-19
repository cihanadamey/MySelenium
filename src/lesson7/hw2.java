package lesson7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

import lesson6.Alerts;

public class hw2 extends BaseClass{
	
	/* Alert text verification
    Open chrome browser
    Go to https://demoqa.com/
    Click on "Alerts, Frame & Windows" link
    Click on "Alerts" links on the left side
    Click on button to see Alert
    Verify alert box with text "You clicked a button" is present
    Click on 3rd button in the page
    Verify alert box with text "Do you confirm action?" is present and click "confirm"
    Click on 4 th button in the page and enter your name and click ok.
    Quit browser
     */
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Alerts']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Thread.sleep(2000);
		Alert simpleAlert=driver.switchTo().alert();
		
		System.out.println(simpleAlert.getText());
		simpleAlert.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		System.out.println(simpleAlert.getText());
		simpleAlert.accept();
		Thread.sleep(2000);
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(2000);
		simpleAlert.sendKeys("cihan");
		simpleAlert.accept();
		Thread.sleep(2000);

		
		tearDown();
	}
}
