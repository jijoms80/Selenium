package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationToolQa {
	WebDriver wd;

	@BeforeMethod
	public void opneBrowser() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/automation-practice-form");
		wd.manage().window().maximize();
	}

	@Test
	public void studenREgistration() {

		WebElement firstName = wd.findElement(By.id("firstName"));
		firstName.sendKeys("Jijo");
		WebElement lastName = wd.findElement(By.id("lastName"));
		lastName.sendKeys("Sebastian");
		WebElement email = wd.findElement(By.id("userEmail"));
		email.sendKeys("msjijo@gmail.com");
		WebElement mobileNumber = wd.findElement(By.id("userNumber"));
		mobileNumber.sendKeys("4345467878");
		WebElement gender = wd
				.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
		gender.click();

		WebElement currentAddress = wd.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("81 Hanson Road ,Mississauga,ON,Canada");
		WebElement hobbies = wd
				.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
		hobbies.click();
		WebElement uploadPicture = wd.findElement(By.id("uploadPicture"));

		uploadPicture.sendKeys("C:\\Users\\Jiji\\Desktop\\Onam2018\\IMG-20180825-WA0012.jpeg");

		String monthYear = "May 2022";
		WebElement dateOfBirth = wd.findElement(By.id("dateOfBirthInput"));
		dateOfBirth.click();

		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.react-datepicker__month-container")));
		WebElement currentMonth = wd.findElement(By.cssSelector("div.react-datepicker__current-month"));
		WebElement nextMonthButton = wd.findElement(By.cssSelector("button[aria-label='Next Month']"));
		while (!currentMonth.getText().equals(monthYear)) {
			nextMonthButton.click();
		}
		wd.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--012")).click();
		System.out.println("The date in date Picker is  " + dateOfBirth.getAttribute("value"));
		WebElement subject = wd.findElement(By.id("subjectsInput"));
		WebElement state = wd.findElement(By.id("react-select-3-input"));
		WebElement city = wd.findElement(By.id("react-select-4-input"));
		subject.sendKeys("English");
		subject.sendKeys(Keys.ENTER);
		state.sendKeys("N");
		state.sendKeys(Keys.ENTER);
		city.sendKeys("de");
		city.sendKeys(Keys.DOWN);
		city.sendKeys(Keys.ENTER);

		WebElement submitButton = wd.findElement(By.id("submit"));
		//WebElement submitButton = wd.findElement(By.xpath("//*[@id=\"submit\"]"));
//		JavascriptExecutor executor= (JavascriptExecutor) wd;
//		executor.executeScript("arguments[0].click", submitButton);
		submitButton.submit();
	}
	
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
