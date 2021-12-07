package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetTitle {
	WebDriver wd;

	@BeforeMethod
	public void opneBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		//wd.get("http://automationpractice.com/index.php");
		wd.get("https://demoqa.com/checkbox");
		wd.manage().window().maximize();

	}

	@Test
	public void getTitlePage() {
		//System.out.println("Page title is : " + wd.getTitle());
WebElement elemt=wd.findElement(By.cssSelector(" #tree-node > ol > li > span > button > svg"));
elemt.click();
	}
	@AfterMethod
	public void tearDown()
	{
	//	wd.quit();
	}
}
