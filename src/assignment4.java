import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		//driver.findElement(By.cssSelector("a[href='/windows']")).click();
				
		//here no new window is opened.It is in the same page itself.
		//just view got refreshed so as to go to new view.
		
		driver.findElement(By.linkText("Click Here")).click();
		//now a new window opened.

		
		Set<String>  w = driver.getWindowHandles();
		//this will get all windows opened using automation
		
		Iterator<String> it = w.iterator();
		//this will iterates through all elements in the set 
		
		String parentID = it.next();
		
		String childID = it.next();
		
		driver.switchTo().window(childID);
				
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		driver.switchTo().window(parentID);
		
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		driver.close();
		
				
				

}
}
