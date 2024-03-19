import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
//Manually type and enter this package as it is static and not autosuggested.

public class relativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();	
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//a) To print the label above the textbox using above relative locator.
		
		//For labels above the textboxes,there are no attributes except the tagname.
		//And these tagnames are common to all labels above the different textboxes.
		//We can uniquely identify the labelname for each textbox using relative locators.
		
		//Here,we know that we can identify the editttextbox using name attribute.
		//And our required label,is just above that textbox.
		//So we write a code to first find the textbox and then use abovelocator to find label above that.
		
		WebElement nametextbox = driver.findElement(By.cssSelector("input[name='name']"));
		//Import WebElement Package.
		//If multiple elements are there,selenium by default identifies the 1st element.
		//Here there are 2 name css locators.But selenium takes the first one only.
		
		
		//Before writing relative locators we need to import package for them.
		//-import static org.openqa.selenium.support.locators.RelativeLocator.*;
		//By default,eclipse don't give suggestion for this,as this is a static package.
		//So we need to manually type the same.
		//driver.findElement(withTagname("xx")).above(WebElement))  -- Syntax
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nametextbox)).getText());
		//to print the label in the output

		
		//b) To print the webelement which is below the label DateofBirth
		
		//First we need to inspect the DateofBirth label.
		WebElement dateofbirth = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		
		//This gives the dateofbirth label location.Now we need to get the dateofbirth field below that.
		//But we can see that it's a flex webelement and hence relative locators cannot support them.
		//This is because relative  locators cannot see the dateofbirth textbox.It will only see the
		//subsequent element after the flex element.
		//So,the next element it can see is the button.
		//Flex elements cannot be touched by relative locators.
		
		driver.findElement(with(By.tagName("input")).below(dateofbirth)).click();
		//input is the tagname for the submit button as button is identified by tagname and relative locator.
		//this submits the form and message form has been submitted successfully appears.
		
		
		//c)To select the checkbox which is left to the label "Check me out if u love icecreams"
		
	    //Inspect the label.
		WebElement checkbox = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		
		//Now we need to select the checkbox near that label.
		driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();
		//input is the tagname of the checkbox.
		//if there are lot of checkboxes based on the label of checkbox we can do selection.
		
		
		//d)To display the label  which is right to the radiobutton.
		
		//Inspect the radiobutton.
		WebElement radiobtn = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobtn)).getText());
		//label is the tagname of radiobutton.
	}
	

}

