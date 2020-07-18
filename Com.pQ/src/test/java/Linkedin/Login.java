package Linkedin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;

	@Test(priority = 1)
	public void Log() {
		
		driver.findElement(By.id("username")).sendKeys("harika.pharm87@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Vam@1989");
		driver.findElement(By.tagName("button")).click();
	}

	@Test(priority = 2)
	public void Likes() throws Exception {
		
		driver.findElement(By.xpath("//span[text()='Notifications']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Home']")).click();
		
		for (int i = 1; i < 50; i++) {
			driver.findElement(By.xpath("(//button[contains(@class,'react-button__trigger artdeco-button')])["+i+"]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='share-reshare-button ember-view']//button)["+i+"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(@class,'share-actions__primary-action artdeco-button')]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(@class,'artdeco-toast-item__dismiss artdeco-button')]"))
					.click();
		}
		
		
	}

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void afterSuite() {
	}

}
