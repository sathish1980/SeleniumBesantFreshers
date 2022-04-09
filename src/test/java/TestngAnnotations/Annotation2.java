package TestngAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation2 
{
	@BeforeClass(alwaysRun=true)
	public void brforeclass()
	{
		System.out.println("before class in annotation 2");
	}
	
	@AfterClass(alwaysRun=true)
	public void afterclass()
	{
		System.out.println("after class in annotation 2");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void brforemethod()
	{
		System.out.println("before method in annotation 2");
	}
	
	@AfterMethod(alwaysRun=true)
	public void Aftermethod()
	{
		System.out.println("after method in annotation 2");
	}
	
	@Test(groups="SIT")
	public void Testcase1()
	{
		System.out.println("Testcase1  in annotation 2");
	}
	
}
