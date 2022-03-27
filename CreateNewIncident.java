package week5.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateNewIncident extends ServiceNowProjectSpecifics {
	@Test (invocationCount = 2)
	public void createTC() throws InterruptedException{

		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@class='selected_action action_context btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowSelection = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowSelection.get(1));
		driver.findElement(By.className("glide_ref_item_link")).click();
		
		driver.switchTo().window(windowSelection.get(0));
		driver.switchTo().frame("gsft_main");
		Thread.sleep(3000);
		
		driver.findElement(By.id("incident.short_description")).sendKeys("Issue");
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident Number: "+incidentNumber);
		driver.findElement(By.xpath("//button[@class='form_action_button header  action_context btn btn-default']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//span[@class='input-group-addon-transparent icon-search sysparm-search-icon']")).click();
		driver.findElement(By.id("sysparm_search")).sendKeys(incidentNumber, Keys.ENTER);
	}
}
