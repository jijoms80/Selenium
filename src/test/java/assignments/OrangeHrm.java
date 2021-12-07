package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHrm {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jiji\\Desktop\\Assignments\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test
	public void LoginPage() {
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();

		Actions action = new Actions(driver);
		WebElement welcomeLabel = driver.findElement(By.xpath("//a[@id='welcome']"));
		action.moveToElement(welcomeLabel).perform();
		welcomeLabel.click();
		WebElement logOutMenu = driver.findElement(By.cssSelector("#welcome-menu>ul>li:nth-child(3)>a"));
		action.moveToElement(logOutMenu).perform();

		WebElement userAttribute = driver.findElement(By.id("welcome"));
		String userNameText = userAttribute.getText();
		Assert.assertEquals("Welcome Paul",userNameText, "sucessfully logged");
		logOutMenu.click();

	}
	@Test
	public void recruitmentTab() {
		
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();
		WebElement recuritment=driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule > b"));
		recuritment.click();
		WebElement vacancyTab=driver.findElement(By.id("menu_recruitment_viewJobVacancy"));
		Actions action = new Actions(driver);
		action.moveToElement(vacancyTab).perform();
		
		vacancyTab.click();
	WebElement jobTitle=driver.findElement(By.id("vacancySearch_jobTitle"));
	Select select= new Select(jobTitle);
	select.selectByVisibleText("IT Manager");
	WebElement vacancyTitle=driver.findElement(By.cssSelector("#vacancySearch_jobVacancy"));
	Select selectvacancy = new Select(vacancyTitle);
	selectvacancy.selectByVisibleText("Associate IT Manager");
	WebElement hiringManger =driver.findElement(By.id("vacancySearch_hiringManager"));
	Select selectHManager= new  Select(hiringManger);
	selectHManager.selectByVisibleText("Odis Adalwin");
	
	
	}

	@AfterMethod
	public void tearDown() {
		 //driver.quit();

	}

}
