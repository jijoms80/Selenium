package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToolQa {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/login");
		wd.manage().window().maximize();
	}

	@Test
	public void loginPage() {
		WebElement username=wd.findElement(By.cssSelector("#userName"));
		username.sendKeys("pivot_academy");
		WebElement password=wd.findElement(By.cssSelector("#password"));
		password.sendKeys("Password@123");
		WebElement button=wd.findElement(By.cssSelector("#login"));
		button.click();
	}
}
