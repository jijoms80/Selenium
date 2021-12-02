package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxAndRadioButton {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		// wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		wd.get("https://jqueryui.com/checkboxradio/");
		wd.manage().window().maximize();
	}

	@Test
	public void selectRadioButton() {
		wd.switchTo().frame(0);
		WebElement parisRadioButton = wd.findElement(By.cssSelector("label[for='radio-2']"));
		parisRadioButton.click();
		WebElement threeStarCheckBox = wd.findElement(By.cssSelector("fieldset:nth-child(5) > label:nth-child(4)"));
		threeStarCheckBox.click();
		WebElement fourStarCheckBox = wd.findElement(By.cssSelector(" fieldset:nth-child(5)>label:nth-child(6)"));
		fourStarCheckBox.click();

	}
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
