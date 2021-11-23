package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class search {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php");
		wd.manage().window().maximize();
	}

	@Test
	public void searchText() {
		WebElement text = wd.findElement(By.cssSelector("#search_query_top"));
		text.sendKeys("Dress");
		text.clear();
		text.sendKeys("top");
		WebElement searchTop = wd.findElement(By.cssSelector("button.btn.btn-default.button-search"));
		searchTop.click();
	}
}
