package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class DropDown2 extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		//locate the webelement
		WebElement colorDDElement=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		//create the select object
		Select s=new Select(colorDDElement);
		s.selectByIndex(3);
		
		Thread.sleep(2000);
		
		
		tearDown();
		
		
	}

}
