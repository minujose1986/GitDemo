import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//nested frames example
		
		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		

		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		//get into first frame
		
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		//get into required frame
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();

	}

}
