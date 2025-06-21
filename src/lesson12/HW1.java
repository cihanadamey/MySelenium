package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

import lesson3.xPathHW;

public class HW1 extends CommonMethods{
	/*
	Homework 1:
		Open chrome browser
		Go to https://demo.guru99.com/test/drag_drop.html
		Drag the following blocks in different ways
		Drag BANK to DEBIT SIDE
		Drag SALES to CREDIT SIDE
		Drag 5000 to DEBIT SIDE
		Drag 5000 to CREDIT SIDE
		Close the browser
     */
	
	public static void main(String[] args) {
		
		setUp();
		
		Actions action=new Actions(driver);
		
		WebElement bank=driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement bankDrop=driver.findElement(By.xpath("//ol[@id='bank']"));
		
		action.dragAndDrop(bank, bankDrop).perform();
		wait(2);
		
		WebElement sales=driver.findElement(By.xpath("//li[@id='credit1']"));
		WebElement salesDrop=driver.findElement(By.xpath("//ol[@id='loan']/li"));
		
		action.dragAndDrop(sales, salesDrop).perform();
		wait(2);
		
		WebElement fifeT=driver.findElement(By.xpath("//a[text()=' 5000 ']"));
		WebElement fifDrop=driver.findElement(By.xpath("//ol[@id='amt7']/li"));
		
		action.dragAndDrop(fifeT, fifDrop).perform();
		wait(2);
		
		WebElement fifeT2=driver.findElement(By.xpath("//a[text()=' 5000']"));
		WebElement fifDrop2=driver.findElement(By.xpath("//ol[@id='amt8']/li"));
		
		action.dragAndDrop(fifeT2, fifDrop2).perform();
		wait(5);
		
		
		
		
		
		
		tearDown();
		
	}

}
