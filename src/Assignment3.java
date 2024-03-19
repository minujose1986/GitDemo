import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("learning");
		driver.findElement(By.cssSelector("label.customradio:nth-child(2)")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-content")));
		
		//Thread.sleep(3000);
	
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
		
		WebElement staticDropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByValue("consult");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.nav-link.btn")));
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
		  
		  for(int i=0; i < products.size(); i++)
		  {
	  
			driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();

		  }
		
		 Thread.sleep(3000);
	
		driver.findElement(By.cssSelector("a.nav-link.btn")).click();
		
		
		
	}
}
	
	