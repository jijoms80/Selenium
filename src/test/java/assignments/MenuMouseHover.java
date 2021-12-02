package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuMouseHover {
	WebDriver driver;

	@BeforeMethod
	public void openBrwser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/menu/");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void menuElectronic()  {
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		WebElement menuElectronics = driver.findElement(By.cssSelector("#ui-id-4"));
		action.moveToElement(menuElectronics).perform();
		String attributeValue =  menuElectronics.getAttribute("class");
		 Assert.assertEquals(attributeValue, "ui-menu-item-wrapper ui-state-active");
				
	}
	@Test(priority = 2)
	public void menuMusic()
	{
		driver.switchTo().frame(0);
		Actions action =new Actions(driver);
		WebElement menuMusic=driver.findElement(By.id("ui-id-9"));
		action.moveToElement(menuMusic).perform();
		//WebElement menuList=driver.findElement(By.cssSelector("#ui-id-17"));
		
		String attributeValue =  menuMusic.getAttribute("class");
		 Assert.assertEquals(attributeValue, "ui-menu-item-wrapper ui-state-active");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
