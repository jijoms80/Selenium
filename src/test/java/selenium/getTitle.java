package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getTitle {
	WebDriver wd;

	@BeforeMethod
	public void opneBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe" );
		wd= new ChromeDriver();
		wd.get("http://automationpractice.com/index.php");
		//wd.get("http://automationpractice.com/index.php");
		wd.manage().window().maximize();
		//System.out.println("Page title is : " + wd.getTitle());
	}
	@Test
	public void getTitlePage() {
		System.out.println("Page title is : " + wd.getTitle());
		
	}

}
