import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class javascriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();				
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1)How to scrolldown Window
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//casting your driver to javascript.So driver knows it can execute javascripts.
		
		js.executeScript("window.scrollBy(0,500)");
		//this makes the screen move up and table will be visible
		//to get window coordinates goto inspect,console part and give
		// window.scrollby(0,500) and press enter
		//Thus by hit and trial method we can identify the coordinates.
		
		Thread.sleep(300);
		
		//2)How to scroll table.
		
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=500");
		//this makes the row move up 
		//to get the executable part goto inspect,console part and give
		// document.querySelector('div.tableFixHead').scrollTop=500 and press enter
		//Thus by hit and trial method we can identify the coordinates.
		
		
		//3)How to calculate sum of all elements in table.div.tableFixHead td:nth-child(4)
		//first we need to retrieve all elememts in 4th column to a list using css locator
		List<WebElement> values = driver.findElements(By.cssSelector("div.tableFixHead td:nth-child(4)"));
		
		int sum =0;
		
		for(int i=0;i<values.size();i++ )
		{
			//Integer.parseInt( values.get(i).getText());
			//this gives the values in the list in string format. we need to convert into integer
			//so we use parseint
			
			sum = sum + Integer.parseInt( values.get(i).getText());
		}
		
		System.out.println(sum);
		
		//4)We need to compare the sum we got with the sum in the webpage.
		//For this, grab the string and cut into 2 pieces.So that we get 296 and convert 
		//into integer and compare.
		//inspect and get the string.
		
		String amt = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		int totamt = Integer.parseInt(amt);
		System.out.println(totamt);
		
		//to compare values in both we can go for assertion.
		
		Assert.assertEquals(sum, totamt);
		
		//if both values are equal,assertion will pass otherwise assertion will fail.
		
		
		
		
		

	}

}
