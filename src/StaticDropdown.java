import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    WebDriver driver = new ChromeDriver();  //driver object
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//drop down with select tag means static dropdown
		
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticdropdown);
		
        
        dropdown.selectByVisibleText("AED");	//selected based on the text in dropdown 
        System.out.println(dropdown.getFirstSelectedOption().getText());
      //in o/p first SELECT,INR,AED comes and AED is the final value
        
        dropdown.selectByValue("INR");	 //selected based on the value of the attribute from html code
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        dropdown.selectByIndex(3);	//to get usd which is in the third position
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //we need to manually see from the code that  usd we selected is coming ,although we can view in screen.
       

	}

}
 