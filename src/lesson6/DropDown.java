package lesson6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class DropDown extends BaseClass {
	/*
	selectByVisibleText("Text")
	selectByIndex(3)
	selectByValue("val")
	isMultiple()
	*/
	public static void main(String[] args) throws InterruptedException {
		

		setUp();
		
		WebElement info=driver.findElement(By.id("ddlAcademicYear"));
		
		Select s=new Select(info);
		
		s.selectByIndex(3);
		
		Thread.sleep(2000);
		
		s.selectByIndex(4);
		
		Thread.sleep(2000);
		
		s.selectByVisibleText("2016-17");
		
		Thread.sleep(2000);
		
		s.selectByValue("2009");
		
		Thread.sleep(2000);
		
		List<WebElement> list=s.getOptions();
		
		for(WebElement lists:list) {
			System.out.println(lists.getText());
			Thread.sleep(2000);
		}
		
		
		tearDown();
		
	}

}
