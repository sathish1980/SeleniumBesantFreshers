package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.Propertyfileread;

public class Browsers 
{

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	private static String reportpath=System.getProperty("user.dir")+"\\Reports\\";

public void Blaunch()
{

	String browser=Propertyfileread.propreaddata().getProperty("Browser");
	if(browser.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions c=new ChromeOptions();
	c.addArguments("--disable-notifications");
	driver= new ChromeDriver(c);

	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver", 
				"D:\\Software\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	extreport();


}

public static void extreport()
{
	report = new ExtentReports(reportpath+"extentreport.html",true);
	test= report.startTest("Facebook Automation");
	
}

public static void reportclose()
{
	driver.quit();
	report.flush();
	
}

}
