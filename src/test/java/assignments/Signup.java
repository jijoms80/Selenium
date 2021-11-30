package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signup {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://www.phptravels.net/signup");
		wd.manage().window().maximize();
	}

	@Test
	public void signup() {
		WebElement firstName = wd.findElement(By.cssSelector("input[name='first_name']"));
		WebElement lastName = wd.findElement(By.cssSelector("input[name='last_name']"));
		WebElement phone = wd.findElement(By.cssSelector("input[name='phone']"));
		WebElement password = wd.findElement(By.cssSelector("input[name='password']"));
		WebElement emailAddress = wd.findElement(By.cssSelector("input[name='email']"));
		WebElement dropAccount = wd.findElement(By.id("account_type"));
		WebElement signUpButton = wd.findElement(By.cssSelector("div.form-group.mt-3 button"));
		WebElement acceptCookieButton=wd.findElement(By.cssSelector("div.cc-compliance button"));
		acceptCookieButton.click();
		firstName.sendKeys("Jijo");
		lastName.sendKeys("Sebastian");
		phone.sendKeys("4376886767");
		emailAddress.sendKeys("mssjijo@gmail.com");
		password.sendKeys("Psw@123");
		Select select = new Select(dropAccount);
		select.selectByIndex(2);
		signUpButton.submit();
		
		WebElement inputEmail = wd.findElement(By.xpath("//input[@type='email' and @placeholder='Email']"));
		WebElement inputPassword = wd.findElement(By.xpath("//input[@type='password' and @placeholder='Password']"));
		WebElement loginButton = wd.findElement(By.cssSelector("button[type='submit']"));
		inputEmail.sendKeys("mssjijo@gmail.com");
		inputPassword.sendKeys("Psw@123");
		loginButton.click();
	}

	@AfterMethod
	public void tearDown() {
		//wd.quit();
	}
}
