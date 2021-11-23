package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/checkbox");
		wd.manage().window().maximize();

	}

	@Test
	public void sendKeys() {
		WebElement fullName = wd.findElement(By.cssSelector("#userName"));
		fullName.sendKeys("Manvir");

		WebElement email = wd.findElement(By.cssSelector("#userEmail"));
		email.sendKeys("abc@gmail.com");
		
		WebElement currentAddress= wd.findElement(By.cssSelector("#currentAddress"));
		currentAddress.sendKeys("Canada");

		WebElement permanaentAddres=wd.findElement(By.cssSelector("#permanentAddress"));
		permanaentAddres.sendKeys("India");
		
		WebElement submitButton=wd.findElement(By.cssSelector("#submit"));
		submitButton.click();
		
	}
	@Test
	public void clickChat()
	
	{
		WebElement checkbox=wd.findElement(By.cssSelector(".rct-checkbox"));
		checkbox.click();
		WebElement text=wd.findElement(By.cssSelector("#result"));
		String labelText=text.getText();
		System.out.println(labelText);
	
	}
	
	
	

	@AfterMethod
	public void quit() {
		 wd.quit();
	}
}
