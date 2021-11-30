package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/radio-button");
		wd.manage().window().maximize();
	}

	@Test
	public void radioButtonClick() {
		WebElement radioButton = wd.findElement(By.cssSelector(".custom-control-label"));
		radioButton.click();
		WebElement buttonClick = wd.findElement(By.cssSelector(".mt-3"));
		String labelText = buttonClick.getText();
		System.out.println(labelText);
	}
	@AfterMethod
	public void tearDown()
	{
		wd.quit();
	}

}
