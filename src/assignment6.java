import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
				
		driver.get("http://qaclickacademy.com/practice.php");
		
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		
		String name = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]"))
				.getText();
		
		System.out.println(name);				
		
		WebElement staticdropdown = driver.findElement(By.id("dropdown-class-example"));
		
		//staticdropdown.click();
		
		Select dropdown = new Select(staticdropdown);
		
		dropdown.selectByVisibleText(name);
		dropdown.getFirstSelectedOption().click();
		String option = (dropdown.getFirstSelectedOption().getText());
		System.out.println(option);
		
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		String alert = driver.switchTo().alert().getText();
		
		if(alert.contains(option))
		{
			System.out.println("Alert success");
		    driver.switchTo().alert().accept();
		}
	     
		else
		{
			System.out.println("Alert unsuccess");
		}
	}

}
