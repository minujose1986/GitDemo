import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	 
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//To iterate thru all links and get the url and get the status code
		
		List<WebElement> link = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		//Import List package.
		//Finds all the elements with tagname 'a'and belonging to class gf-li.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		SoftAssert a = new SoftAssert();
		//Import SoftAssert Class and create an object.
		//This class is imported from TESTNG.
		
		for (int i=0; i< link.size() ; i++)
		{
			
			
			//Broken link means broken url.That means URL is not working.
			//For a link we have 'a' anchor tag and 'href' attribute
			//All successful navigation URLs have status code 200 or 201,..300 in XHR tab of Network tab
			//all broken links have status code > 400 or 401,402...500.
			//Thus by getting all URLs in page and checking status code,we know link is broken or not.
			
			//Steps involved in identifying broken link. 
			//1)Land on page & scan all links using Selenium.
			//For each link,u get the url using getAttribute() method.
			
			//String url = driver.findElement(By.cssSelector("a[href*='soapui.org']")).getAttribute("href");
			//This gives the url of the attribute href for CssSelector soapui.
			String url = link.get(i).getAttribute("href");
			//gets url of all links 
			
		    //2) Java method will call the urls and get their status code
			//There is a method called OpenConnection() that comes from URL Class.
			//To call a method,we need to create object of that class
			
			HttpURLConnection  conn   =( HttpURLConnection) new URL(url).openConnection();
			//Import HttpURLConnection Package , URL Package
			//This opens connection & send url to internet & get the response.
			//URL which has to open up,has to be send as an argument.
			//URL() ->OBJECT             OpenConnection ->Method
			//Return type of OpenConnection() method is HTTPURLConnection 
			//So we need to cast it on the other side
			//Remove error,add throws declaration
			
			//When we click a link,we have different kinds of request method like get,hit./
			//we need to specify which type of request method is this
			//we are calling url using Head HTTP Request method.
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			//makes call to url and u get the response back and it will also sit in
			//conn object.

			//thus object conn -> opens connection
			//                 -> request http head request connection
			//                 -> makes connection 
			//                 -> response also retrieved from this object.
			

			//Now we need response status code
			int respCode = conn.getResponseCode();
			//This gives response of code which mean URL status
			
			System.out.println(respCode + link.get(i).getText());
			//Thus without clicking link,we get statuscode
			
			
			a.assertTrue(respCode<400, "The link with text " + link.get(i).getText()+ " is broken with code" + respCode);
			//Instead of if condition we can give, validation a.Asserttrue(boolean,message)
			//This means that when condition becomes false,it will print the message. a.AssertTrue(false) = fail
			//if condition fails,it stores the failure but donot stop execution.
			//It will continue with execution and complete it.
						
			//if (respCode>400)
			//{
				
				
				//if (respCode == 403)
				//{

	              //  System.out.println("The Link With Text '" + link.get(i).getText() + "' is forbidden with the code " + respCode);
				//}
				//else
				//{
				//System.out.println("The link with text " + link.get(i).getText()+ "is broken with code" + respCode);
				//Assert.assertTrue(false);
				//Assertion checks validation is true or not.If false assertion fails.
				//}
			//}						
		}
		
		
		a.assertAll();
		//This should be outside all execution of for loop.
		//if we don't give this, it will catch all the failures but donot report it in output.
		//So this code basically reports failures.
		
		
		
	}
	
	

}
