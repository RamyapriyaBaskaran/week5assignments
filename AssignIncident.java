package week5.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AssignIncident extends ServiceNowProjectSpecifics{
@Test (invocationCount = 2, timeOut = 50000)
	public void assignTC() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//button[@class='list_nav  btn btn-icon h_flip_content'])[4]")).click();	
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("(//a[@class='linked formlink'])[20]")).getText();
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[20]")).click();
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[5]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listwindow.get(1));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Software", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(listwindow.get(0));
		driver.switchTo().frame("gsft_main");
		String assigneeGroup = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getText();
		Thread.sleep(5000);
	
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Notes added");
		String updatedNotes = driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).getText();
		driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("sysparm_search")).sendKeys(text,Keys.ENTER);
		driver.switchTo().frame("gsft_main");
		
		String text1 = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getText();
		if(text1.equals(assigneeGroup))
			System.out.println("Assignee group updated");
		else
			System.out.println("Assignee group not updated");
		
		String text2 = driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).getText();
		if(text2.equals(updatedNotes))
			System.out.println("Notes updated");
		else
			System.out.println("Notes not updated");
	}
}
