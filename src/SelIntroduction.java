import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction  {
	//This means Chrome driver has to implement webdriver METHODS in the program

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Invoking Browser
		// Chrome - ChromeDriver ->Methods   close get 
		// Firefox - Firefoxdriver  ->Methods  close get 
		//Safari - SafariDriver -> Methods close get 
		
		//WebDriver close get 
		    //WebDriver only have method names close ,get but don't have implementation
		    //It is responsibility of classes to implement methods declared in Interface(WebDriver)
		//WebDriver methods + Class methods
		
		
		   System.setProperty("WebDriver.edge.driver", "C:\\Users\\97155\\Downloads\\edgedriver_win64.exe");
		
		  //  WebDriver driver = new ChromeDriver(); //Object is created under ChromeDriver Class with name driver.
		    
		   WebDriver driver = new EdgeDriver();
		  
		    driver.get("https://jobpostings.alberta.ca/");
		    System.out.println(driver.getTitle());
		    System.out.println(driver.getCurrentUrl());
		    driver.close();
		   // driver.quit();		      
		     //This syntax creates memory allocation for the object created.
		    // We need object to access all methods in ChromeDriver
		    //We need all methods so as to automate Chrome Browser
	}

}
