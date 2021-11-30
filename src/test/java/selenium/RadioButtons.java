package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {
	
		WebDriver driver;

		@BeforeMethod
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demoqa.com/automation-practice-form");
			driver.manage().window().maximize();
	}
		@Test
		public void radioButton()
		
			{
			WebElement secondRadioButton= driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
			WebElement thirdRadioButton=driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
			WebElement firstRadioButton=driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
			firstRadioButton.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			secondRadioButton.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thirdRadioButton.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void tearDown()
		{
			driver.close();
		}
	}

