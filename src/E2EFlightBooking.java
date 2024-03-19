import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2EFlightBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	    WebDriver driver = new ChromeDriver();  //driver object
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//FROM & TO LOCATION SELECTION
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		
		//DATE SELECTION
	    Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	    if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))//if attribute value contains 1
	     {
	    	 System.out.println("is not enabled");
	    	 Assert.assertTrue(true);    	 
	    	 
	     }
	     else
	     {
	    	 Assert.assertTrue(false); 
	     }

	    
	    //SENIOR CITIZEN CHECKBOX
	    driver.findElement(By.cssSelector("input[id*='_SeniorCitizenDiscount']")).click();
	    
	    
	    //SELECT PASSENGERS
	     driver.findElement(By.id("divpaxinfo")).click(); //this will open the passenger list
	     Thread.sleep(2000);
	     System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	     int i= 1;
	     while(i < 5)
	      { 
	          driver.findElement(By.id("hrefIncAdt")).click(); //this will click the adult + addition
	          i++;
	     }
	     driver.findElement(By.id("btnclosepaxoption")).click();
	     
	     //CURRENCY
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByValue("INR");	 //selected based on the value of the attribute from html code
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        //SEARCH
        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
       //                    OR
       // driver.findElement(By.cssSelector("input[value='Search']")).click();//THERE ARE MULTIPLE SEARCHS BUT SINCE THIS 
       //                  IS FIRST ONE,THIS WILL STILL WORK.
       //                     OR
        //driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
        
	    
	}

}
