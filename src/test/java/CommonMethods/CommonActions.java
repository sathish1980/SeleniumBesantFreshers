package CommonMethods;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions 
{

	public void Textboxwithclear(WebElement elementtoenter,String texttoenter)
	{
		elementtoenter.clear();
		elementtoenter.sendKeys(texttoenter);
	}
	
	public void Textboxwithoutclear(WebElement elementtoenter,String texttoenter)
	{
		elementtoenter.sendKeys(texttoenter);
	}
	
	public void Buttonclick(WebElement elementtoenter)
	{
		if(elementtoenter.isEnabled() == true)
		{
			elementtoenter.click();
		}
	
	}
	
	public String getText(WebElement elementtoenter)
	{
		if(elementtoenter.isDisplayed() == true);
		
			return elementtoenter.getText();
		
	
	}
	
	public void Radiobuttonclick(WebElement elementtoenter)
	{
		if(elementtoenter.isDisplayed()==true)
		{
			if(elementtoenter.isSelected() == false)
			{
				elementtoenter.click();
			}
		}
	
	}
	
	public void Checkbox(WebElement elementtoenter)
	{
		if(elementtoenter.isSelected() == false)
		{
			elementtoenter.click();
		}
	
	}
	
	public void implictwait(WebDriver driver,int timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
	}
	
	public void explicitwaitbyelementtobeclickable(WebDriver driver,WebElement elementotbewait)
	{
		WebDriverWait wait= new WebDriverWait( driver,60);
				wait.until(ExpectedConditions.elementToBeClickable(elementotbewait));
	}
	
	public void explicitwaitbyelementtobepresent(WebDriver driver,By elementotbewait)
	{
		WebDriverWait wait= new WebDriverWait( driver,60);
				wait.until(ExpectedConditions.presenceOfElementLocated(elementotbewait));
	}
	
	public void dropdownselectbyindex(WebElement element,int indexposition)
	{
		Select dropdown=new Select(element);
		dropdown.selectByIndex(indexposition);
	}
	
	public void dropdownselectbyvalue(WebElement element,String Value)
	{
		Select dropdown=new Select(element);
		dropdown.selectByValue(Value);
	}
	
	public void dropdownselectbyvisibletext(WebElement element,String visibletext)
	{
		Select dropdown=new Select(element);
		dropdown.selectByVisibleText(visibletext);
	}
	
	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
	      //This method returns the time in millis
	    long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//Testcase_1_"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Destinationfile.toString();
	}
}
