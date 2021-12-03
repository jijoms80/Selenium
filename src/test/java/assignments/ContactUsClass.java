package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsClass {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php");
		wd.manage().window().maximize();
	}

	@Test
	public void contactUs() {
		WebElement contactUslink = wd.findElement(By.cssSelector("#contact-link > a"));
		contactUslink.click();
		WebElement emailAddress = wd.findElement(By.id("email"));
		WebElement orderReference = wd.findElement(By.id("id_order"));
		WebElement messageText = wd.findElement(By.id("message"));
		WebElement sendButton = wd.findElement(By.cssSelector("#submitMessage > span"));
		WebElement subjectHeading = wd.findElement(By.id("id_contact"));
		Select select = new Select(subjectHeading);
		select.selectByIndex(1);
		emailAddress.sendKeys("msjijo@gmail.com");
		orderReference.sendKeys("SHT-45681");
		messageText.sendKeys("NA");
		sendButton.click();
		WebElement alertMessage = wd.findElement(By.cssSelector("#center_column > p"));
		String alertText = alertMessage.getText();
		Assert.assertEquals(alertText, "Your message has been successfully sent to our team.");
	}
 @AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
