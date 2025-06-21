package lesson6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class MultiSelectDropDown extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// https://neotech.vercel.app/select

		setUp();
		// locate the dropdown webelement
		WebElement multiselectElement = driver.findElement(By.id("multi-select"));
		// create a select object from the dropdown web element
		Select multiSelect = new Select(multiselectElement);

		// check if the dropdown is multiselect

		boolean isMultiSelect = multiSelect.isMultiple();
		System.out.println("is multiselect? " + isMultiSelect);

		if (isMultiSelect) {
			List<WebElement> options = multiSelect.getOptions();

			for (WebElement option : options) {
				String text = option.getText();
				System.out.println("The visible text is " + text);

				multiSelect.selectByVisibleText(text);
				Thread.sleep(1000);

			}

		}

		// deselect the items

		multiSelect.deselectByIndex(0);
		Thread.sleep(2000);
		multiSelect.deselectAll();
		Thread.sleep(2000);

		tearDown();

	}

}
