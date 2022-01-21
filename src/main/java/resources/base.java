package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.paulhammant.ngwebdriver.NgWebDriver;


public class base {

	public 	WebDriver driver;
	public Properties prop;
	public NgWebDriver ngWebDriver;
	public JavascriptExecutor jsdriver;

@SuppressWarnings("deprecation")
public WebDriver initializedriver() throws IOException
{
	 prop=new Properties();
	FileInputStream fis=new FileInputStream("//Users//naveenpavithran//eclipse-SeleniumFramework//E2EProject//src//main//java//resources//data.properties");
	prop.load(fis);
	
	String browsername = prop.getProperty("browser");
	
	System.out.println(browsername);
	
	
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "//Users//naveenpavithran//chromedriverfile//chromedriver");
		 driver=new ChromeDriver();
		 jsdriver=(JavascriptExecutor)driver;
		 ngWebDriver=new NgWebDriver(jsdriver);
	}
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	return driver;
	
}

public void takeScreenshot(String testCaseName, WebDriver driver)
{
String screenName= testCaseName+ ".png";
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try
{
FileUtils.copyFile(src, new File(System.getProperty("/Users/naveenpavithran/eclipse-SeleniumFramework/E2EProject/target/Screenshots"+screenName)));
}
catch(IOException e)
{
System.out.println(e.getMessage());
}
}

public static void EmailReport() throws EmailException
{

	Email email = new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("username", "7y@35"));
	email.setSSLOnConnect(true);
	email.setFrom("naveenpavithran45@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("midhunpavithran@gmail.com");
	email.send();
}

}
