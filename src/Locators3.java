import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\97155\\Downloads\\chromedriver-win64\\chromedriver-win64.exe");
			WebDriver driver = new ChromeDriver();  //driver object
					
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			//driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).click();	
			//since login is dummy,we try to get the text in output console
			
		    System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());
			
		    //or
		    
		    System.out.println(driver.findElement(By.xpath("//header/div/button[2]")).getText());	
		    
		    //or
		    
		    System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());	
	}

}
    