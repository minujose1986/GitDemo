import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();				
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		
		//To print the total number of rows in the table
		
		int rowcount = driver.findElements(By.cssSelector("table.table-display tr")).size();
		System.out.println("row:-" + rowcount);
		
		//To print total number of columns in table
		int colcount = driver.findElements(By.cssSelector("table.table-display th")).size();
		System.out.println("col:-" + colcount);
		
		//To print the second row in the table.
		

		List <WebElement> row2 = driver.findElements(By.cssSelector("table.table-display tr:nth-child(3)"));
		System.out.println(row2.get(0).getText());
	
		
	}

}
