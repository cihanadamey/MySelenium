package lesson7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class hw1 extends BaseClass{
	/*
	    Homework 1:
        Amazon Department List Verification
        Open chrome browser
        Go to "http://amazon.com/"
        Verify how many department options available.
        Print each department 
        Select Computers
        Quit browser
       */ 
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		Thread.sleep(2000);
		
		WebElement click=driver.findElement(By.xpath("//a[@onclick='window.location.reload()']"));
		click.click();
		
		Select options=new Select(driver.findElement(By.id("searchDropdownBox")));
		
		System.out.println("Total number of departmant options are "+options.getOptions().size());
		
		Thread.sleep(2000);
		
		List<WebElement> depList=driver.findElements(By.id("searchDropdownBox"));	
		
		for (WebElement nums:depList) {
			System.out.println(nums.getText());
			
		}
		
		
		
		
		
		Thread.sleep(2000);
		
		
		tearDown();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}


























