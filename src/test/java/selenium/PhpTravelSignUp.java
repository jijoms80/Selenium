package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhpTravelSignUp {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/signup");

	}

	@Test
	public void clickSignUpButton() throws InterruptedException {

		// Find all webelement
		WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[name='last_name']"));
		WebElement phoneNumber = driver.findElement(By.cssSelector("input[name='phone']"));
		WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
		WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
		WebElement acceptCookieButton = driver.findElement(By.cssSelector("div.cc-compliance button"));
		WebElement signUpButton = driver.findElement(By.cssSelector("div.form-group.mt-3 button"));
		WebElement dropAccount = driver.findElement(By.id("account_type"));
		// action on webelement

		// accept the cookie pop up
		acceptCookieButton.click();

		firstName.sendKeys("Manvir");
		lastName.sendKeys("Singh");
		phoneNumber.sendKeys("6472152994");
		email.sendKeys("amsp@itm.com");
		password.sendKeys("Password@123");
		Select select = new Select(dropAccount);
		select.selectByIndex(2);
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", signUpButton);

		//Thread.sleep(2000);
//		Actions action = new Actions(driver);
//		action.moveToElement(signUpButton).perform();
		signUpButton.submit();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
