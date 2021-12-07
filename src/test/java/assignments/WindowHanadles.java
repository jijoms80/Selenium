package assignments;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHanadles {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login\"");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
	}

	@Test
	public void Login() throws InterruptedException {
		WebElement userName = wd.findElement(By.id("txtUsername"));
		WebElement password = wd.findElement(By.id("txtPassword"));
		WebElement loginButton = wd.findElement(By.id("btnLogin"));
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();
		String parent = wd.getWindowHandle();
		System.out.println("Main window handle is " + parent);
		WebElement nextpage = wd.findElement(By.cssSelector("a.help-icon-div>span>svg"));
		nextpage.click();
		Set<String> allWindows = wd.getWindowHandles();
		for (String child : allWindows) {
			if (!parent.equals(child));
			{
				wd.switchTo().window(child);
				System.out.println(child);
			}
		}
		WebElement adminUserGuide = wd.findElement(By.cssSelector("li:nth-child(1)>a>span.blocks-item-title "));
		System.out.println("Text inside the new window is : " + adminUserGuide.getText());
		wd.switchTo().window(parent);

		Actions action = new Actions(wd);
		WebElement welcomeLabel = wd.findElement(By.xpath("//a[@id='welcome']"));
		action.moveToElement(welcomeLabel).perform();
		welcomeLabel.click();
		WebElement logOutMenu = wd.findElement(By.cssSelector("#welcome-menu>ul>li:nth-child(3)>a"));
		action.moveToElement(logOutMenu).perform();
		logOutMenu.click();
	}

}
