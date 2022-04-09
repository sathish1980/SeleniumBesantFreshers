package Testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.Browsers;
import CommonMethods.CommonActions;
import Pages.Login;
import Pages.Logout;
import Utils.ExcelRead;
import Utils.Propertyfileread;

public class Facebooksample extends Browsers
{

	CommonActions CA= new CommonActions();

@BeforeSuite
public void launch()
{
	Blaunch();
}

@AfterSuite
public void closeall()
{
	reportclose();
}

@BeforeTest
public void url()
{
	String url=Propertyfileread.propreaddata().getProperty("URL");
	driver.get(url);
}

@Test(priority=0,dataProvider="exceldatareadforLogin")
public void FaceBookLoginandLogout(String uname, String pwd)
{
	try
	{
	Login l = new Login(driver);
	test.log(LogStatus.INFO, "Url has been launched");
	l.username(uname);
	test.log(LogStatus.INFO, "username  entered: "+uname);
	l.password(pwd);
	test.log(LogStatus.INFO, "password entered: "+pwd);
	l.loginbutton();

	String loginscreenshot=CA.takescreenshot(driver);
	test.log(LogStatus.PASS,  test.addScreenCapture(loginscreenshot));
	logoutfunction();
	String logoutscreenshot=CA.takescreenshot(driver);
	test.log(LogStatus.PASS, test.addScreenCapture(logoutscreenshot));
	}
	catch(Exception e )
	{
		test.log(LogStatus.FAIL, e);
	}
}

@Test(priority=1,dataProvider="exceldatareadforincorrectdate")
public void FaceBookwithinvalidpassword(String un,String pd)
{
	String incorrectpassword="The password that you've entered is incorrect. Forgotten password?";
	try
	{
	Login l = new Login(driver);
	test.log(LogStatus.INFO, "Url has been launched");
	l.username(un);
	test.log(LogStatus.INFO, "username  entered: " +un);
	l.password(pd);
	test.log(LogStatus.INFO, "password entered: "+ pd);
	l.loginbutton();
	System.out.println(l.incorrectpawwordcheck());
	if(l.incorrectpawwordcheck().equalsIgnoreCase(incorrectpassword))
	{
		String loginscreenshot=CA.takescreenshot(driver);
		test.log(LogStatus.PASS,  test.addScreenCapture(loginscreenshot));
		driver.navigate().back();
	}
	//assert.assertEquals(l.incorrectpawwordcheck(),incorrectpassword);
	//assert.assertEquals(l.incorrectpawwordcheck(),incorrectpassword);
	else
	{
	String logoutscreenshot=CA.takescreenshot(driver);
	test.log(LogStatus.FAIL, test.addScreenCapture(logoutscreenshot));
	driver.navigate().back();
	}
	}
	catch(Exception e )
	{
		test.log(LogStatus.FAIL, e);
	}
}


public void logoutfunction() 
{
	Logout l= new Logout(driver);
	l.logoutdropdownmethod();
	l.logoutbuttonmethod();
}

@DataProvider
public Object[][] exceldatareadforLogin() throws IOException
{
	return ExcelRead.read("login");
}

@DataProvider
public Object[][] exceldatareadforincorrectdate() throws IOException
{
	return ExcelRead.read("loginwithinvalid");
}
}
