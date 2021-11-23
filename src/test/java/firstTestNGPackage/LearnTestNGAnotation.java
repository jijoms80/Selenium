package firstTestNGPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearnTestNGAnotation {
	@Test(priority = 1)
	public void test()
	{
	System.out.println("This is the first test from Jijo");
	}
	
	@Test(priority = 2)
	public void test11()
	{
	System.out.println("This is the second test from Jijo");
	}
	
	@BeforeMethod
	public void Test1()
	{
		System.out.println("test run first");
	}
}
