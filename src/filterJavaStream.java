import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filterJavaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//A)To check whether search textbox is working fine or not using Selenium Javastream.
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Automation script to validate whatever we type in searchbox is getting filtered & coming in table.
		//Inspect searchtextbox
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		//We need to see how many columns are displayed with this veg Rice and all these columns have word Rice.
		//First we need to get all rows where rice is there.
		List<WebElement> veggies = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//5 results
		//Import List & WebElement package
		List<WebElement>  match= veggies.stream().filter(s-> s.getText().contains("Rice")).collect(Collectors.toList());
		//1 result.
		//Ideally, veggies list and match list should be identical as we are first giving condition for rice in searchbutton
		//and getting the veggies list.if both are not matching then there should be issue with application.
		Assert.assertEquals(veggies.size(), match.size());
		
		

	}

}
