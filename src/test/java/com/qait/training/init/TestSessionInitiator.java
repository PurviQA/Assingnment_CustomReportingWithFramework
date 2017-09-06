package com.qait.training.init;

import com.qait.training.keywords.LoginPage;

import static com.qait.training.reader.YamlReader.getProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSessionInitiator {
	WebDriver driver;
	public LoginPage loginPageAction;

	public TestSessionInitiator()
	{
		getProperty("browser");
		configBrowser();
		init();
	}
	public void init()
	{
		loginPageAction=new LoginPage(driver);
		
	}
	public void configBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get(getProperty("baseUrl"));
	}
	

	
}
