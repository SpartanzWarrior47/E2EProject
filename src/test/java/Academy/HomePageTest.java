package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base {
	
	public static Logger log= LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
		//ngWebDriver.waitForAngularRequestsToFinish();
	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String username, String password, String text) throws IOException {

		
		LandingPage LP = new LandingPage(driver);
		LP.getLogin().click();

		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(username);
		l.getPasword().sendKeys(password);
		//System.out.println(text);
		log.info(text);
		l.getLoginBtn().click();
		log.info("Login button validated successfully");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "Naveen";
		data[0][1] = "555";
		data[0][2] = "Hi Naveen";
		data[1][0] = "Midhun";
		data[1][1] = "42449";
		data[1][2] = "Hi Midhun";

		return data;

	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
//	@AfterSuite
//	public void SendEmailReport() throws EmailException
//	{
//		base.EmailReport();
//	}

}
