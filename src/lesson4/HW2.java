package lesson4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {

	/*
	 * Radio Button Practice Open chrome browser Go to
	 * "https://demoqa.com/radio-button" Verify if all radio buttons are displayed
	 * and clickable Click on all radio buttons Verify radio buttons has been
	 * clicked successfully Quit browser
	 */

	public static String url = "https://demoqa.com/radio-button";

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		List<WebElement> RadioButton = driver.findElements(By.cssSelector("div[class*='custom-control custom-radio custom-control-inline']"));
						
		for (WebElement buttons : RadioButton) {
			
			if (buttons.isDisplayed()) {
				System.out.println(buttons.getText()+" -- Displayed");
				
				if(buttons.isEnabled()) {
					buttons.click();
					System.out.println("I clicked "+buttons.getText());
					Thread.sleep(1000);
				}
			} else {
				System.out.println("No");
			}

		}
		
		Thread.sleep(2000);
		
		driver.quit();

	}
}