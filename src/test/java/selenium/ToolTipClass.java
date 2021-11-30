 package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipClass {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://www.globalsqa.com/demo-site/tooltip/");
		wd.manage().window().maximize();
	}

	@Test
	public void tooolTip() throws InterruptedException {
		String expectedText = "ui-id-36";
		Actions action = new Actions(wd);
		WebElement element = wd.findElement(By.cssSelector("div.ui-widget-header a"));
		action.moveToElement(element).perform();

		Thread.sleep(3000);

		String attributeValue = element.getAttribute("aria-describedby");
		Assert.assertEquals(attributeValue, expectedText);

	}
}