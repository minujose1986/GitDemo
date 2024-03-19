import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		String name ="minu";
	//	System.setProperty("WebDriver.chrome.driver", "C:\\Users\\97155\\Downloads\\chromedriver-win64\\chromedriver-win64.exe");
	//	WebDriver driver = new ChromeDriver();  //driver object
		
	//	System.setProperty("WebDriver.gecko.driver", "C:\\Users\\97155\\Downloads\\geckodriver-v0.33.0-win64.exe");
	//  WebDriver driver = new FirefoxDriver();  //driver object	
		
		System.setProperty("WebDriver.edge.driver", "C:\\Users\\97155\\Downloads\\edgedriver-win64.exe");
	    WebDriver driver = new EdgeDriver();  //driver object
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//calling method
		//driver object we created above is send through the method getpassword.
		
		String password = getpassword(driver); //returned value stored in password
		driver.get("https://rahulshettyacademy.com/locatorspractice//");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		Thread.sleep(5000);
		//driver.close();		 
	}

	public static String getpassword(WebDriver driver) throws InterruptedException
	{
		// we changed void to string in above line because we are returning a string
		//we had given static because we can call this method directly without creating object
		
		driver.get("https://rahulshettyacademy.com/locatorspractice//");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password = driver.findElement(By.cssSelector("form p")).getText(); 
		//Please use temporary password 'rahulshettyacademy' to Login.   - text displayed
		String[] pwdarray = password.split("'");
		
		//0th index = Please use temporary password 
		//1st index= rahulshettyacademy' to Login.
		
		System.out.println(pwdarray[0]); 
		System.out.println(pwdarray[1]); 
		System.out.println(pwdarray[2]);
		
		//Again we need to split the string in 1st index based on ' to get the correct password
		
		//====String[] pwdarrfinal = pwdarray[1].split("'");
		
		//0th index = rahulshettyacademy
		//1st index= to Login.
		
		//====System.out.println(pwdarrfinal[0]); 
		//====System.out.println(pwdarrfinal[1]); 
		
		//we need to return the value to the method. So store in a sting and return
		
		//======String finalpwd = pwdarrfinal[0];
		//=======return finalpwd;
		
		String finalpwd = pwdarray[1];
		return finalpwd;
		
		
	}
}


