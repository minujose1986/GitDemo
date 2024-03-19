import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		   WebDriver driver = new ChromeDriver();  //driver object
			
		   driver.manage().window().maximize();
		   driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		   driver.findElement(By.id("autosuggest")).sendKeys("ind");
		   Thread.sleep(3000);
		   
		   //since we are getting 3 webelements we give FINDELEMENTSBY and also store in List.WebElement is returntype
		   //Import List and WebElement Utilities
		   
		   List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		   
		   
		   //now we need to iterate through for loop and find which option matches india
		   //enhanced for loop
		   
		   for (WebElement option : options)
		   {
			   if (option.getText().equalsIgnoreCase("India")) // ignores the case.sometimes user gives in small case
			   {
				   option.click();// click the option if it is india
				   break;// exit the loop
			   }
		   }
	}

}
