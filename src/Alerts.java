import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text="minu";
		
	    WebDriver driver = new ChromeDriver();  //driver object
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//PRESS ALERT BUTTON
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("input[onclick='displayAlert()']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		//To see the message in the alert in the output.
		
		driver.switchTo().alert().accept();
		//This will switch the context from browser to alerts.When u give this, selenium gets a knowledge
		//to see any alerts on the current webpage.Once u get the alerts, u can just press ok only.
		//That is we need to accept the alert.so accept.
		
		//PRESS CONFIRM BUTTON
		
		driver.findElement(By.cssSelector("input[onclick='displayConfirm()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		//if we want to click on ok/YES we give accept alert.When we want to clickon CANCEL/NO we give dismiss.
		
		
		

	}

}
