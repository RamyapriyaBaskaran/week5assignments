package week5.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends ServiceNowProjectSpecifics{
@Test (invocationCount = 2)
	public void deleteTC() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//button[@class='list_nav  btn btn-icon h_flip_content'])[4]")).click();
		Thread.sleep(3000);
	    String text = driver.findElement(By.xpath("(//a[@class='linked formlink'])[20]")).getText();
	    driver.findElement(By.xpath("(//a[@class='linked formlink'])[20]")).click();
		
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//span[@class='input-group-addon-transparent icon-search sysparm-search-icon']")).click();
		driver.findElement(By.id("sysparm_search")).sendKeys(text, Keys.ENTER);
		driver.switchTo().frame("gsft_main");
		String text1 = driver.findElement(By.xpath("//div[@class='info-bar-left']")).getText();
		if (text1.contains("0 results")) 
			System.out.println("Incident deleted successfully");
		else 
			System.out.println("Incident not deleted");
	}

}
