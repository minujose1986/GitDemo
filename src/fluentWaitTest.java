import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		//fluentwait is a class which implements wait interface.just like how chromedriver implementing
		//webdriver interface
		
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				           .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);	
		//this means a fluent wait of duration 30s with polling of every 3s.so 10 times fluent wait will
		//look for the object in the browser.In 30s,wait time if we are coming across NoSuchElement
		//Exception then ignore it
		
		//customized code to wait for some element during run.
		
		WebElement found = w.until(new Function<WebDriver,WebElement>()
		{					
		  public WebElement apply(WebDriver driver)
		  {
			//return driver.findElement(By.cssSelector("div[id='finish'] h4"));
			//when u give this,it means that when start is pressed,element is already
			//there,but not visible.Beacuse of this it cannot return webelement
			//To avoid this we give condition.When u give IsDisplayed(),it means
			//it is present in the page,but not displayed on the front screen.
			  
			if (driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) 
			{
				return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				//return the element if it is visible
			}
			else
			{
				return null;
			}
			
		  }
		}); 
		
		System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
		//System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed());
		
		//w.until is used to define the condition.In webdriver,we have predefined conditions for until.
		//But fluentwait don't have this.We have to define our own customised wait methods.
		//we have to wait until method displaye the webelement.
		//until webelement is successfully returned,fluentwait will keep on waiting.
		
		//FluentWait & WebDriver wait are classes implementing one common explicit wait under
		//wait interface.
						
		
	}

}
