package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonActions;

public class Logout extends CommonActions
{
	WebDriver driver;
	@FindBy (xpath="//div[@role='banner']//div[@aria-label='Account']//*[name()='svg']")
	WebElement logoutdropdown;
	@FindBy (xpath="//span[text()='Log Out']")
	WebElement logoutbutton;
	
	
	
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logoutdropdownmethod()
	{
		explicitwaitbyelementtobeclickable(driver,logoutdropdown);
		Buttonclick(logoutdropdown);
	}
	
	public void logoutbuttonmethod()
	{
		explicitwaitbyelementtobeclickable(driver,logoutbutton);
		Buttonclick(logoutbutton);
	}

}
