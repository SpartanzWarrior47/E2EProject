package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.LandingPage;

import resources.base;

public class ValidateTitle extends base{
	
	//public 	WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver = initializedriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		
	}
	
	@Test

	public void TitleCheck() throws IOException {

		
		LandingPage LP=new LandingPage(driver);
		Assert.assertEquals((LP.getAbout().getText()), "About Us");
		System.out.println(LP.getAbout().getText());
		
		Assert.assertEquals((LP.getTitle().getText()), "Featured Courses");
		log.info("Title is validated successfully");
		System.out.println("Hi Naveen");
	}
	
	@AfterTest
	
	public void TearDown()
	{
		driver.close();
	}
		
}
