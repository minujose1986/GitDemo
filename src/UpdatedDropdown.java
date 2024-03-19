import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//TESTNG is one of the testing framework

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		 WebDriver driver = new ChromeDriver();  //driver object
		 driver.manage().window().maximize();
	     driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	     
	     //to handle checkbox and use assertions for validations instead of system.out.println so that execution 
	     //stops whenever it is false.Assertion Testng library is included.
	     //this assertion is false true assertion
	     
	     Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='_SeniorCitizenDiscount']")).isSelected());	     
	     //System.out.println(driver.findElement(By.cssSelector("input[id*='_SeniorCitizenDiscount']")).isSelected());
	     driver.findElement(By.cssSelector("input[id*='_SeniorCitizenDiscount']")).click();
	     //System.out.println(driver.findElement(By.cssSelector("input[id*='_SeniorCitizenDiscount']")).isSelected());
	     Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='_SeniorCitizenDiscount']")).isSelected());
	     
	     //to count all checkboxes in screen
	     //this will give the count of all checkboxes so we have to use FINDELEMENTSBY
	     System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	     
	     //to select depart date after enabling roundtrip
	     
	     System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));//gives value of attribute
	     System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());//default should b false
	     driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //enable roundtrip
	     System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());//enabled
	     
	     
	     //here before and after IsEnbaled function is returning true.Usually, when we click something disabled,it
	     //should not work.But if we click disabled calendar it is enabled automatically and trip selected to roundtrip
	     //workaround is we pull attribute causing this change .Inspect and we can see style attribute opacity is getting
	     //changed for one-way and roundtrip.So we will pull this attribute
	     
	     System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	     if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))//if attribute value contains 1
	     {
	    	 System.out.println("is enabled");
	    	 Assert.assertTrue(true);    	 
	    	 
	     }
	     else
	     {
	    	 Assert.assertTrue(false); 
	     }
	     
	     //check how it behaves before and after clicking radiobutton.It gives attribute value
	     	     	     
	     
	     //to select the passengers
	     
	     driver.findElement(By.id("divpaxinfo")).click(); //this will open the passenger list
	     Thread.sleep(2000);
	     
	     //we can either use while loop or for loop
	     System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	     int i= 1;
	     while(i < 5)
	      { 
	          driver.findElement(By.id("hrefIncAdt")).click(); //this will click the adult + addition
	          i++;
	     }
	     
	   //  for(int i= 1;i<5;i++)	    
	   //  { 
	   //       driver.findElement(By.id("hrefIncAdt")).click(); //this will click the adult + addition         
	   //  }
	     
	     driver.findElement(By.id("btnclosepaxoption")).click(); //this will click the done
	     Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	     //Assertion to compare 2 strings
	     //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	     	     
	}

}


