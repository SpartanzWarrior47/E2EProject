package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base {
	
	public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException   
	{
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test

	public void NavigationBarCheck() throws IOException {

		
		LandingPage LP = new LandingPage(driver);
		
		Assert.assertTrue(LP.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
		

}
