package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
public WebDriver driver;
By signin=By.xpath("//a[contains(@href,'sign_in')]");
By aboutus=By.xpath("//a[contains(text(),'About Us')]");
By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
By navbar=By.xpath("//header/div[3]/div[1]/div[1]/div[2]/nav[1]/div[2]/ul[1]");

public LandingPage(WebDriver driver)
{
	this.driver=driver;
}



public WebElement getLogin()
{
	return driver.findElement(signin);
	
}

public WebElement getAbout()
{
	return driver.findElement(aboutus);
	
}

public WebElement getTitle()
{
	return driver.findElement(title);
	
}

public WebElement getNavigationBar()
{
	return driver.findElement(navbar);
	
}

}
