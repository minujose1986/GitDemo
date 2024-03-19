import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/droppable/");
		
		//Consider the case when we need to know how many frames in a page
		//we know that all frames start with iframe tagname.
				
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//since there can be multiple elements we need to give ByElements
		
		//there are multiple ways to switch from selenium to frames.
		//frame(int) - indexing
		//frame(string name) - we need to give frame id.very few developers give frame-id
		//frame(webelement) - here we need to give webelement/locators 
		
		//first we try indexing method of switching
		
		//driver.switchTo().frame(0);
		
		//since we know that we have only one frame here we can give arg as 0.
		//that is 1st frame will be at 0th index.
		//but not good practice as in future if more frames are added it is an issue
		
		//second, we try by webelement method			
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//we need to switch from selenium to iframe as frames are independent of selenium.
				
		
		//now Action Class helps us to drag and drop elements inside frame
		
		Actions a = new Actions(driver);
		//import the actions package
		
		//this function drags and drop the element into the target.
		//we need to give the source target and destination target.
		//we will define it as separate webelements
		
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement tar = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(src, tar).build().perform();
		//drags and drops inside the frame
		
		driver.switchTo().defaultContent();
		//automatically comes out of Frame.so that we can continue with rest of browser activities
	
		
	}

}
