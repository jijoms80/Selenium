package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyToolTipClass {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		 wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get("https://jqueryui.com/tooltip/");
		wd.manage().window().maximize();
		wd.switchTo().frame(0);
	}

	@Test
	public void verifyToolTip() throws InterruptedException {
		Actions action = new Actions(wd);
		
		WebElement firstToolTip = wd.findElement(By.cssSelector("body>p:nth-child(1)>a"));
		action.moveToElement(firstToolTip).perform();
		Thread.sleep(3000);
		String attributeValue=firstToolTip.getAttribute("aria-describedby");
		Assert.assertTrue(attributeValue.contains("ui-id"));
				
		
		WebElement secondToolTip = wd.findElement(By.cssSelector("body>p:nth-child(2)>a"));
		action.moveToElement(secondToolTip).perform();
		Thread.sleep(3000);
		String toolTipText=secondToolTip.getAttribute("aria-describedby");
		Assert.assertTrue(toolTipText.contains("ui-id"));
				
		WebElement thirdToolTip = wd.findElement(By.cssSelector("#age"));
		action.moveToElement(thirdToolTip).perform();
		Thread.sleep(3000);
		String thirdToolTipText=thirdToolTip.getAttribute("aria-describedby");
		Assert.assertTrue(thirdToolTipText.contains("ui-id"));
	}

	@AfterMethod
	public void tearDown() {
		 wd.quit();
	}

}
