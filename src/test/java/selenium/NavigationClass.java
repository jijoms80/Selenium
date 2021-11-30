package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationClass {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
	}

	@Test
	public void navigation() {
		WebElement contactUs = driver.findElement(By.id("contact-link"));
		contactUs.click();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().refresh();
		driver.navigate().to("https://www.google.ae/?gfe_rd=cr&ei=wBxQV-iLMKXS8AeZk5SABQ");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
