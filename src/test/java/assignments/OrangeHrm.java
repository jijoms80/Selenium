package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHrm {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test
	public void LoginPage() {
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();

		Actions action = new Actions(driver);
		WebElement welcomeLabel = driver.findElement(By.id("welcome"));
		welcomeLabel.click();
		WebElement logOutMenu = driver.findElement(By.id("welcome-menu"));
		logOutMenu.click();
	}

}
