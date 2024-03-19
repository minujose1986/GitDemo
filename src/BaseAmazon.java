import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAmazon {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//implicit wait for 5s.So when the warning no such element arises,selenium ask browser
		//to wait for 5s before throwing the error.
		//5s is the maximum time it will wait.if page is loaded in 2s,then it wont wait for the rest 3s.
		//but if it takes 6s this will fail.
		//wait is applied globally.so each and ever code waits for 5s before executing
		
		//we will comment out implicit wait and give explicit wait whereever necessary.
		//for that we declare explicit wait object globally so can be accessed whereever condition is there
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		//explicit wait
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Carrot"};
				
		addItems(driver,itemsNeeded);
		//everything in the method is given without declaration
		//basically these are called utilities.here addItems is the utility.
		
		//or by creating object of class.so code will be and we don't need to give static
		//BaseAmazon b = new BaseAmazon();
		//object of the base class
		//b.addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//explicit wait until promocode is displayed
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait is applied until we get the information applied .
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
	}
	
	public static  void addItems(WebDriver driver,String[] itemsNeeded )
	
	//static is given because we are accessing the method without creating the object of class
	//in this bracket,everything on left handside of main code is given along with declaration
	
	{
		int j=0;
	
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		// this will find all the webelements with this css name

		for (int i = 0; i < products.size(); i++) // gives number of elements
		{
			// String name = products.get(i).getText();
			// get(i) - returns the element at this position
			// getText() - gives the text of the element

			// check whether name you extracted is in the array itemsNeeded
			// to use contains operation we need to convert array into arraylist.

			// formatting is needed to compare vegetablename with itemsNeeded.Need to trim
			// 1kg
			// first we need to separate the vegetable and 1 kg part by split

			String[] name = products.get(i).getText().split("-");
			// name[0]= cucumber name[1]= 1kg

			String veg = name[0].trim();
			// trims left and right spaces

			List cartItems = Arrays.asList(itemsNeeded);

			if (cartItems.contains(veg)) 
			{
				j++;
				// taking count of number of times cart items matched one in our list.we have
				// 2 items i cart.so j must be 2
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) 
				{
					break;
				}
				// break;
				// we cannot give break in arraylist,because after checking 1st element it comes
				// out
				// automatically
			}

		}
	}

}
