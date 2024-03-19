import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowBrowserActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.setProperty("WebDriver.chrome.driver", "C:\\Users\\97155\\Downloads\\chromedriver-win64\\chromedriver-win64.exe");
		WebDriver driver = new ChromeDriver();  //driver object
		
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		driver.get("http://google.com");
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();
 
	}

}
