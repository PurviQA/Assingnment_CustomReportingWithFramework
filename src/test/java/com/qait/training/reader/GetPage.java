package com.qait.training.reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.qait.training.reader.SpecReader.getElementfromFile;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class GetPage {
	WebDriver driver;
	String FileName;

	public GetPage(WebDriver driver, String fileName) {
		this.driver = driver;
		this.FileName = fileName;

	}

	public WebElement element(String token) {
		String[] fileElements = getElementfromFile(FileName, token);
		return driver.findElement(getLocator(fileElements));
		
	}

	public List<WebElement> elements(String token) {
		String[] fileElements = getElementfromFile(FileName, token);
		List<WebElement> list = driver.findElements(getLocator(fileElements));
		return list;
	}

    protected boolean isElementDisplayed(String elementName
                                        ) {
      
        boolean result = element(elementName).isDisplayed();
        assertTrue(result, "TEST FAILED: element '" + elementName+ "' is not displayed.");
               return result;
    }

	public enum Locators {
		id, css, xpath, linkText, className;
	}

	public By getLocator(String[] fileElement) {
		String locatorType = fileElement[1];
		String locatorValue = fileElement[2];
		switch (Locators.valueOf(locatorType)) {
		case id:
			return By.id(locatorValue);
		case css:
			return By.cssSelector(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case linkText:
			return By.linkText(locatorValue);
		case className:
			return By.className(locatorValue);
		default:
			return null;

		}

	}

}
