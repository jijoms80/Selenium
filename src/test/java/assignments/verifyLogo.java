package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class verifyLogo {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://www.rogers.com/");
		wd.manage().window().maximize();
	}

	@Test
	public void isLogoDisplayed() {
		WebElement logo = wd.findElement(By.cssSelector("img.rcl-icon-logo"));
		System.out.println(logo.isDisplayed());

	}
}
