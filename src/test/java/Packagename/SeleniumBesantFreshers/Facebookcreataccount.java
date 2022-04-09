package Packagename.SeleniumBesantFreshers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebookcreataccount {
	
	WebDriver wd;
	public void launch(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","D:\\Software\\chromedriver_win32_latestVersion\\chromedriver.exe");
		 wd = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
		System.setProperty("webdriver.edge.driver","D:\\Software\\edgedriver_win64\\msedgedriver.exe");
		 wd = new EdgeDriver();
		}
		wd.manage().window().maximize();
		wd.get("https://en-gb.facebook.com/");
		wd.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		wd.findElement(By.name("firstname")).sendKeys("sathishkumar");
		wd.findElement(By.name("lastname")).sendKeys("kumar");
		wd.findElement(By.name("reg_email__")).sendKeys("kumar.sathish189@gmail.com");
		WebDriverWait wait = new WebDriverWait(wd,60);
		wait.until(ExpectedConditions.visibilityOfAllElements(wd.findElement(By.name("reg_email_confirmation__"))));
		wd.findElement(By.name("reg_email_confirmation__")).sendKeys("kumar.sathish189@gmail.com");

		wd.findElement(By.name("reg_passwd__")).sendKeys("9159211184");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facebookcreataccount f= new Facebookcreataccount();
		f.launch("chrome");
	}

}
