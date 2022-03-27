package week5.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowProjectSpecifics {
	public static ChromeDriver driver;

	@BeforeMethod
	public void preConditions() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev96011.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Pn3xWJ6nTorA");
		driver.findElement(By.id("sysverb_login")).click();
	}
	@AfterMethod
	public void postConditions()
	{
		driver.close();
	}

}
