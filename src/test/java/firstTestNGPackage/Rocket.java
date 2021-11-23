package firstTestNGPackage;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Rocket {

	@BeforeMethod
	public void rocketLaunge() {
		System.out.println("Rocket Launged");
	}
	@Test(priority  =1)
	public void rocketInspace()
	{
		System.out.println("Rocket in space");
	}
	@Test(priority = 2)
	public void satelliteDetached()
	{
		System.out.println("satellite deatched");
	}
	@Test(priority = 3)
	public void satelliteFunctioning()
	{
		System.out.println("Rocket Functioning");
	}
	

	@AfterMethod
	public void rocketDestory()
	{
		System.out.println("Rocket destoryed");
	}
	
	
}



