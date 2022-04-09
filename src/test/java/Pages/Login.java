package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonActions;

public class Login extends CommonActions
{
	WebDriver driver;
	
	//WebElement username1=driver.findElement(By.id("email"));
	@FindBy (id="email")
	WebElement username1;
	@FindBy (id="pass")
	WebElement pass;
	@FindBy (name="login")
	WebElement loginbut;
	@FindBy (xpath="//div[@class='_9ay7']")
	WebElement incpwrd;


	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void username(String uname)
	{
		//WebElement username1=driver.findElement(By.id("email"));
		Textboxwithclear(username1,uname);
	}
	
	public void password(String pwrd)
	{
		//WebElement pass=driver.findElement(By.id("pass"));
		Textboxwithclear(pass,pwrd);
	}
	
	public void loginbutton()
	{
		//WebElement loginbut=driver.findElement(By.name("login"));
		Buttonclick(loginbut);
	}
	
	public String incorrectpawwordcheck()
	{
		//(By.name("login"));
		explicitwaitbyelementtobepresent(driver,By.xpath("//div[@class='_9ay7']"));
		return getText(incpwrd);
	}
	
	/*---------------------OR--------------*/
	
	public void loginmethod(String unm,String pss)
	{
		//WebElement username1=driver.findElement(By.id("email"));
		Textboxwithclear(username1,unm);
		//WebElement pass=driver.findElement(By.id("pass"));
		Textboxwithclear(pass,pss);
		//WebElement loginbut=driver.findElement(By.name("login"));
		Buttonclick(loginbut);
	}
}
