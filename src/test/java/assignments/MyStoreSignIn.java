package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyStoreSignIn {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void myStoresignIn() {
		WebElement signInEmail = wd.findElement(By.id("email_create"));
		signInEmail.sendKeys("jojo@gmail.com");
		WebElement crateAccountButton = wd.findElement(By.id("SubmitCreate"));
		crateAccountButton.submit();
		WebElement gender = wd.findElement(By.id("id_gender1"));
		gender.click();
		WebElement firstName = wd.findElement(By.id("customer_firstname"));
		firstName.sendKeys("jojoo");
		WebElement lastName = wd.findElement(By.id("customer_lastname"));
		lastName.sendKeys("ms");
		WebElement password = wd.findElement(By.id("passwd"));
		password.sendKeys("passcode");
		WebElement days = wd.findElement(By.id("days"));
		Select selectDay = new Select(days);
		selectDay.selectByIndex(5);
		WebElement months = wd.findElement(By.id("months"));
		Select selectMonth = new Select(months);
		selectMonth.selectByIndex(6);
		WebElement year = wd.findElement(By.id("years"));
		Select selectYear = new Select(year);
		selectYear.selectByIndex(2);
		WebElement newsLetter = wd.findElement(By.id("uniform-newsletter"));
		newsLetter.click();
		WebElement customerFirstName = wd.findElement(By.id("firstname"));
		customerFirstName.sendKeys("jojo");
		WebElement customerLastName = wd.findElement(By.id("lastname"));
		customerLastName.sendKeys("mathew");
		WebElement company = wd.findElement(By.id("company"));
		company.sendKeys("ABC Inc");
		WebElement address1 = wd.findElement(By.id("address1"));
		address1.sendKeys(" 39 nevilles csrt ");
		WebElement address2 = wd.findElement(By.id("address2"));
		address2.sendKeys(" 39 nevilles csrt Barampton");
		WebElement city = wd.findElement(By.id("city"));
		city.sendKeys("Brampton");
		WebElement state = wd.findElement(By.id("id_state"));
		Select selectSate = new Select(state);
		selectSate.selectByIndex(3);
		WebElement postcode = wd.findElement(By.id("postcode"));
		postcode.sendKeys("L5G6F3");
		WebElement country = wd.findElement(By.id("id_country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByIndex(1);
		WebElement addtionalInfo = wd.findElement(By.id("other"));
		addtionalInfo.sendKeys(" sign up form ");
		WebElement homePhone = wd.findElement(By.id("phone"));
		homePhone.sendKeys("5457891212");
		WebElement mobileNumber = wd.findElement(By.id("phone_mobile"));
		mobileNumber.sendKeys("454564654");
		WebElement addressAlias = wd.findElement(By.id("alias"));
		addressAlias.sendKeys("JKJ");
		WebElement registerButton = wd.findElement(By.id("submitAccount"));
		registerButton.submit();
		WebElement loginButton = wd.findElement(By.id("SubmitLogin"));
		loginButton.submit();
		WebElement pageHeading = wd.findElement(By.cssSelector("#center_column > h1"));
		String heading = pageHeading.getText();
		System.out.println(heading);
		Assert.assertEquals("AUTHENTICATION", heading);
	}

}
