import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class liveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//A)To check whether webtable is sorted or not using Selenium Javastream.
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//1)Click on column - elements get sorted
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//2)Capture all the webelements into a list
		
		List<WebElement> veg= driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//Import List and WebElement
		//Now we have WebElements.But we don't have text.
		
		//3)Capture text of all webelement into a new list.For that we need to iterate it using streams.
		
		List<String> orgList = veg.stream().map(s->s.getText()).collect(Collectors.toList());
		//Stream is a sequence of objects that supports various methods which can be applied to produce the desired result.
		//It takes input from collections,arrays,i/o channels.
		//Stream iterate through each and every element of veg list and get text and is stored in s.
		//Now return type is string.
		
		//4) Sort the captured text list ie orgList and collect into a new list
		List<String> sortList = orgList.stream().sorted().collect(Collectors.toList());
		
		//5)Compare original list with sorted list.
		Assert.assertTrue(orgList.equals(sortList));
		//Equals is a method that helps to compare with another list
		//While comparing original & sorted list,if both matches we know table is sorted.
		//Since assertion didn't fail,we know its working fine.
		//To check if assertion fails, we put a togglepoint in code and debug 
		//When webpage opens we will click the name and it comes in unsorted order
		//Then we resume the porgram.It directly goes to Assertion Error.
		
		
		//B)Consider the case when we need to get the price of vegetable - BEANS.
		
		//1) For this scan the name column with gettext and whenever you encounter Beans print it in output.
		 List<String> price = veg.stream().filter(s->s.getText().contains("Beans")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		 //When u place cursor under getPriceVeggie(), it shows create method and click it.
		 //It automatically creates the outer method function.
		 //I need web element with beans only so I had given filter there.
		 
		 //Once we get the value in the price ,to print it in output
		 price.forEach(a->System.out.println("Beans" + a));
		 // right action to be performed on the a.
		 
		 
		 //C)Consider the case when our vegetable is not in the 1st page -Rice.
		 
		 //In this case,we need to go through all pages and find it.This is pagination.
		 List<String> price1 ;
		 do
		 {
		 List<WebElement> vegpag= driver.findElements(By.xpath("//tbody/tr/td[1]"));
		 //find elements in the page
		 price1 = vegpag.stream().filter(s->s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		 //Atfirst,it searched in 1st page and rice is not there.So s is null and method is not getting executed.
		 //In this case price1 will be empty.
		 
		 if (price1.size()<1)
		 {
			 //When there is no element in the list we need to click and go to next page.
			 driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			 //This clicks next button.
			 //Again, we need to collect all elements of that page into list and check for rice.
			 //so we need to loop through entire set of code
		 }
		 }while(price1.size()<1);
		 
		 price1.forEach(b->System.out.println("Rice" + b)); 
		 
		 //Since price1, is local to do loop we need to declare it outside so can be accessed by while 
		//do while loop first check for rice In 1st page.It is not there .So it goes into if loop as size =0
		 //Here,it clicks next page.It checks while condition .if size >1,it stops executing do loop.
		 //But since while is true,it continues executing until rice is found.when rice is there,size>1 and exits.
		 //do while loop executes until while is true.it exits lopp,when while is false.
		 	 	
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		//it passes the webelement s to the function
		//REturn type  should be string.so private static string.
		//Now we observe ,when we reach beans in the HTML, the  next step under html code of beans is its price.
		//so in selctors hub,try to write xpath for the price and //tr/td[1]/following-sibling::td[1] gives price
		//Already //tr/td[1] gives the first column and from that we have filtered and taken "Beans".Now the remaining
		//portion is just needed that gives the price.
		
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		//This gives the price of beans.
		return pricevalue;
	}
	

}

