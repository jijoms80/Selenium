package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
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
		WebElement username = wd.findElement(By.cssSelector(" #userName "));
		WebElement password = wd.findElement(By.cssSelector(" #password "));
		WebElement button = wd.findElement(By.cssSelector(" #login"));
		username.sendKeys("pivot_academy");
		password.sendKeys("Password@123");
		button.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement getUserName = wd.findElement(By.cssSelector("#userName-value"));
		System.out.println("User Name is :" + getUserName.getText());
		WebElement logOutButton = wd.findElement(By.id("submit"));
		logOutButton.click();
		WebElement getLabel = wd.findElement(By.cssSelector("div>h2"));
		WebElement getLabelTwo = wd.findElement(By.cssSelector("div>h5"));
		System.out.println(getLabel.getText() + getLabelTwo.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
