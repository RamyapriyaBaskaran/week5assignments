package week5.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateExistingIncident extends ServiceNowProjectSpecifics {
@Test 
	public void updateTC() throws InterruptedException {
	    driver.findElement(By.id("filter")).sendKeys("incident");
	    driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
	    driver.switchTo().frame("gsft_main");
	    driver.findElement(By.xpath("(//button[@class='list_nav  btn btn-icon h_flip_content'])[4]")).click();
	    Thread.sleep(3000);
	    String text = driver.findElement(By.xpath("(//a[@class='linked formlink'])[20]")).getText();
	    driver.findElement(By.xpath("(//a[@class='linked formlink'])[20]")).click();
		
		WebElement urgencyElement = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select dd= new Select(urgencyElement);
		dd.selectByIndex(0);
		String urgencyValue = urgencyElement.getText();
		
		WebElement stateElement = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select dd1= new Select(stateElement);
		dd1.selectByIndex(1);
		String stateValue = urgencyElement.getText();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).sendKeys("Notes");
		driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("sysparm_search")).sendKeys(text, Keys.ENTER);
		driver.switchTo().frame("gsft_main");
		
		String text1 = driver.findElement(By.xpath("//select[@id='incident.urgency']")).getText();
		if(text1.equals(urgencyValue))
			System.out.println("Urgency updated");
		else
			System.out.println("Urgency not updated");
		
		String text2 = driver.findElement(By.xpath("//select[@id='incident.state']")).getText();
		if(text2.equals(stateValue))
			System.out.println("State updated");
		else
			System.out.println("State not updated");
	}
}
