package TestngAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation 
{

	@BeforeSuite(alwaysRun=true)
	public void brforesuite()
	{
		System.out.println("before suite");
	}
	
	@AfterSuite(alwaysRun=true)
	public void aftersuite()
	{
		System.out.println("After suite");
	}
	
	@BeforeTest(alwaysRun=true)
	public void brforetest()
	{
		System.out.println("before test");
	}
	
	@AfterTest(alwaysRun=true)
	public void aftertest()
	{
		System.out.println("after test");
	}
	
	@BeforeClass(alwaysRun=true)
	public void brforeclass()
	{
		System.out.println("before class");
	}
	
	@AfterClass(alwaysRun=true)
	public void afterclass()
	{
		System.out.println("after class");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void brforemethod()
	{
		System.out.println("before method");
	}
	
	@AfterMethod(alwaysRun=true)
	public void Aftermethod()
	{
		System.out.println("after method");
	}
	
	@Test(priority=0,dependsOnMethods="Testcase1",groups="Sanity")
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}
	
	@Test(priority=2,groups="Sanity")
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}
	
	@Test(priority=1,groups="SIT",invocationCount=4,invocationTimeOut=60)
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}
	
	@Test(priority=3,groups={"Sanity","SIT"})
	public void Testcase4()
	{
		System.out.println("Testcase4");
	}
	
}
