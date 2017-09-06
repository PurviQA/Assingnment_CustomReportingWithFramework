package com.qait.training.keywords;
import org.openqa.selenium.WebDriver;

import com.qait.training.reader.YamlReader;
import com.qait.training.reader.GetPage;

public class LoginPage extends GetPage {
	
	public LoginPage(WebDriver driver) {
		super(driver, "SearchPage.spec");
		// TODO Auto-generated constructor stub
	}

	

	public void submitLoginDetails() throws InterruptedException
	{
		
		isElementDisplayed("text_user");
		element("text_user").clear();
		element("text_user").sendKeys(YamlReader.getProperty("usename"));
		element("submit_next").click();
		Thread.sleep(2000);
		isElementDisplayed("text_password");
		element("text_password").clear();
		
		element("text_password").sendKeys(YamlReader.getProperty("password"));
		
		element("submit_next").click();
		
		
	}
}
