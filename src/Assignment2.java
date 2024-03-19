import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Name Field
		Thread.sleep(1000);
		driver.findElement(By.name("name")).sendKeys("Minu Jose");
		
		//Email
		driver.findElement(By.name("email")).sendKeys("minujose1986@gmail.com");
		
		//Password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("hello123");
		
		//Checkbox
		driver.findElement(By.cssSelector("input[id='exampleCheck1']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='exampleCheck1']")).isSelected());   //validation
		
		//gender
		
		WebElement staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByVisibleText("Female");
	
		//System.out.println(driver.findElement(By.id("exampleFormControlSelect1")).get;
		//Assert.assertEquals(driver.findElement(By.id("exampleFormControlSelect1")).getText(), "Female");
		
		//employment status
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='inlineRadio1']")).isSelected());//validation
		
		//date of birth
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("03/30/1986");
		
		//submit
		driver.findElement(By.cssSelector("input.btn-success")).click();
		
		//message in output
		System.out.println(driver.findElement(By.cssSelector("div.alert-success")).getText());
		
		
		
		
		
		

	}

}
