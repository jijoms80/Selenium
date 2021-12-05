package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UplaodImage {
	WebDriver wd;

	@BeforeMethod
	public void opneBrowser() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/upload-download");
		wd.manage().window().maximize();
	}

	@Test
	public void uploadPicture() {
		WebElement imagePath = wd.findElement(By.id("uploadFile"));
		imagePath.sendKeys("C:\\Users\\Jiji\\Desktop\\EVAN\\dc8xrBLki.png");
		WebElement downloadButton = wd.findElement(By.id("downloadButton"));
		downloadButton.click();

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
