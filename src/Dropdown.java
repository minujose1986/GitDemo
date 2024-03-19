import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		   WebDriver driver = new ChromeDriver();  //driver object
			
		   driver.manage().window().maximize();
		   driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		   //  //a[@value='MAA']   --- xpath for From dropdown chennai. Actually there are 2 elements with same xpath.
		   //                      --- chennai in From dropdown and To dropdown.
		   //  //a[@value='BLR']   --- xpath for banglore
		   
		   driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		   driver.findElement(By.xpath("//a[@value='BLR']")).click();
		   Thread.sleep(2000);		   	   
		   //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();  --indexing
		   
		   //    OR 
		   
		   driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		   // Parentxpath   Childxpath
		   
		   ////div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']  --XPATH FOR FROM Dropdown
		   
           //to load todays date in depart date of the calendar
		   //.ui-state-default.ui-state-highlight  ==>current date always have unique highlighter state.
		   Thread.sleep(3000);
		   driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	}
 
}
