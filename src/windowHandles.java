import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//The child window is now open.But the scope of our driver is in the parent window only.
		//So we have to explicitly give knowledge to selenium that we have to move from parent
		//to child window.
		//First we need to know how many windows are open.In this case it is 2.
		//We need to get ID of all the windows opened by automation.getWindowHandles() takes care this.
		//Return type of this is set of strings because it is windowid.
		
		Set<String> w = driver.getWindowHandles();
		
		//We need to import Set package.
		//getWindowHandles gets all windows opened by automation & their ids into a set collection
		//(parent window,child window)
		//parentid in the 0th index and child in the 1st index.
		
		
		//now to go to child page, we need child windowID that we get by iterating through the elements
		//in the set collection.For this we apply iterator method.
		
		Iterator<String> it = w.iterator();
		
		//We need to import Iterator Package.
		//By default,iterator is outside the set collection.
		//so inorder to move to the element in the 0th index that is parent, we give
		
		String ParentID = it.next();  
		//this gives parentid.Again iterate it once more to get child id.
		
		String ChildID = it.next();
		//this gives the childid
		
		//now we need to switch the window from parent to child by giving childid.
		driver.switchTo().window(ChildID);
		
		//now we need to get the emailID from child window so as to post in parent window username field.
		//Go and get the entire text from the page
		
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		
		//to extract emailID,put a toggle break point and move to debug mode.
		//In debug mode,click watch and type the locator over there.In the window down, u can see results
		//Fist split string based on at and take details in the 1st index.Then trim the extra space on left side
		//Again split string based on spaces and take the 0th index to get email.
		String emailID = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];	
		
		//switch back to our parent window
		driver.switchTo().window(ParentID);
		
		//now we can send the email id by using locator.
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		

		
		

	}

}
