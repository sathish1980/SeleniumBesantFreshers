package Packagename.SeleniumBesantFreshers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTestcase {
	
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
		/*wd.navigate().to("https://mail.google.com/mail/u/0/#inbox");
		wd.navigate().back();
		wd.navigate().forward();
		wd.navigate().refresh();*/
		WebElement username =wd.findElement(By.cssSelector("input[name=email]"));
		username.sendKeys("kumar.sathish189@gmail.com");
		username.clear();
		wd.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("Admin@123");
		wd.findElement(By.xpath("//input[contains(@class,'_9npi')]")).clear();
		wd.findElement(By.xpath("//button[text()='Log In']")).click();
		//wd.findElement(By.linkText("Forgotten password?")).click();
		//wd.findElement(By.partialLinkText("Forgo")).click();
		//wd.close();
		//wd.quit();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstTestcase F= new FirstTestcase();
		F.launch("edge");
	}

}
