import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
				
		//We have action class to handle this.When u pass driver in the action class, driver gets the 
		//capabilities of the action class.Action class object is created to access its methods
		
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();

		//we need to move the mouse to an element and dropdown must appear without clicking.so we use 
		//move to element function for that locator. This is the action
		//Once u reach the element we need to build the action.Build builds the entire action.
		//If we don't build the action,it won't execute.It is just ready now.But won't execute.
		//If we want to execute ,then we have to give perform.Perform execute the code.
		 
		//we need to perform composite action.weneed to enter details in search button in capital letters
		//when u press shift+ alphabet,it is automatically in Capital Letters.
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
		                                .sendKeys("hello").doubleClick().build().perform();
		
		//this function first moves to the search box .Then we need to click the box to enter details.
		//Shift+ letters has to be given. So keydown presses shift key and we send this hello to box.
		//we will build and perform.So automatically small letters converted to capital
		
		
		//To select entire text in the searchbox using mouse,we usually doubleclick to select it.
		//so after sending details we give doubleclick so that text got selected.
		
		
	    //now after moving to first element dropdown without mouse click,consider the case we want to 
		//rightclick that element.
		
		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick()
		   .build().perform();
		
		//context click helps to right click the particular element

		
		
		
		
		
	}

}
