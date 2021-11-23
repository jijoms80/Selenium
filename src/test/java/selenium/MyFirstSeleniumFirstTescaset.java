package selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumFirstTescaset {
	// declare a Reference varibale of the webdriver interface
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		// set up and install the latest version of the chrome driver
		WebDriverManager.chromedriver().setup();
		// intilize the ref.varible wd with chrome class object
		wd = new ChromeDriver();
		// using the get method ,open the browser
		wd.get("https://demoqa.com/login");
		// maximize the window
		wd.manage().window().maximize();

	}

	@Test
	public void loginToolsQA() {
		// way to identify the
		WebElement userName = wd.findElement(By.cssSelector("#userName"));
		WebElement password = wd.findElement(By.cssSelector("#password"));
		WebElement login = wd.findElement(By.cssSelector("#login"));
		userName.sendKeys("testuser");
		password.sendKeys("Password@123");

		login.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement logOutButton=wd.findElement(By.cssSelector("#submit"));
		Assert.assertTrue(logOutButton.isDisplayed());
		WebElement userNameLoggedInPage=wd.findElement(By.cssSelector("#userName-value"));
		String userNameText=userNameLoggedInPage.getText();
		Assert.assertEquals("testuser", userNameText);
		//Assert.assertEquals("testuser1", userNameText,"user name does not match");
	}
	@AfterMethod
	public void tearDown()
	{
		wd.quit();
	}
}
