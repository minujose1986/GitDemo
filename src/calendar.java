import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();				
				
		driver.get("https://www.path2usa.com/travel-companions");
		
		//it is always better to use cssSelector for Calendar selection.
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");
		//to scroll down screen to see the date field which remains hidden at loading of page
		
		Thread.sleep(3000);
		//we need to wait until all elements are loaded
		//if we don't give the above 2 steps,we get ElementClickInterceptedException	
			
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
        //to click the element
        
        //MONTH- first we need to select the month and then date
        //consider month as april 2024
        
        while (! driver.findElement(By.cssSelector("[class='flatpickr-month']")).getText().contains("April"))
        {
        	//! is known as negator
        	//while executes until condition is false
        	//at first time it is january,so i need to keep on clicking until we get april
        	driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click(); 
        	
        }
             
        Thread.sleep(3000);
        
        //DATE- now consider 23rd is our input date
        //Grab the common attribute.Put it in a list and iterate.
        
        List<WebElement> date = driver.findElements(By.className("flatpickr-day"));
        //we will take all dates into a list date.this is because all dates have same classname
        //flatpickr-day
        
        int count = driver.findElements(By.className("flatpickr-day")).size();
        //this gives total number of elements in the list
        
       for(int i=0; i< count;i++)
        {
        	String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
       	    if (text.contains("23"))
        	{
        		driver.findElements(By.className("flatpickr-day")).get(i).click();
        		//this selects date
        		break;
        	}
       }
       
       //thus based on common attribute flatpickr-day we have selected 23.
	}

}
