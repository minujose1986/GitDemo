import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class scopeDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
				
		driver.get("http://qaclickacademy.com/practice.php");
		
		//1) to get the count of all links in this browserpage.
		//Any link in html page have a tagname "a".a stands for anchor.
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		//gives all the links in the entire web page
		
		//2) consider the case we need to get links only in the footer section.
		//to get that ,we need to create a child driver whose scope is limited to footer section.
		//once we create that driver, it behaves as normal driver but returns only links in footer
		//as scope is only in footer.
		
		//inspect the footer section such that entire footer is selected.
		//create a webelement driver based on the id.
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		
		//import webelement package
		//once driver is ready,  can access it to work as normal.
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3)consider the case when we need to get the link count of only 1st column in the 
		//footer section.For this we need to create a webelement(child webdriver) for the entire 
		//column in the footer section
		//we have created a footer driver already.we can start from there.
		
		WebElement columndriver = footerdriver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul "));
		
		//we have created child driver for column driver.Toget the count of links in this column,we can
		//check by tagname.
		
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//4)Now click on each link in the column and check if browser is opening for each link.
		//Number of links are dynamic,which means it can increase in future.
		//0th location it is discount coupn.we are not considering it and hence starting from 1.
		
		for( int i=1;i< columndriver.findElements(By.tagName("a")).size();i++)
		{
			//columndriver.findElements(By.tagName("a")).get(i).click();
			//we can give this statement.when we run code,we get stale element exception.
			//this is because after opening first link,it is trying to find the second link
			//inn the opened page and hence it is giving this exception.
			//to resolve we need to go back to main page and click second link which is achieved 
			//using the back button.
			//although we can do this way, problem is that it takes lot of time in clicking and then
			//going back which is not advisable
			//solution is when we press control + link,page opens in a separate window.
			//in that case, we can skip back button.
			
			String clickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			Thread.sleep(3000);
			//now all links will open in separate tabs
			
		
		}
		
		//5) Consider the case when we need to get the title of all windows printed in output.
		//This is similar to windowHandle concept where we nee dto iterate through all child
		//windows to get the title name.
		
		Set<String> windows = driver.getWindowHandles();
		//import Set package
		//windowhandles get all the windows count opened by automation and get their ids into a
		//set collection(parent window,child window) where parent is at 0th index & child at 1st
		//To get all child window count we need to iterate using iterator method
		
		Iterator<String> it = windows.iterator();
		//import iterator package.
		//By default,iterator is outside the set collection.
		//inorder to get the element in the 0th index,that is parent we need to give it.next()
		
		while(it.hasNext())
			//this means that if it has next element then enter loop and print,otherwise exit
		{
			driver.switchTo().window(it.next());
			//switches to the next window.In first time, from outside collection to 0th to
			//print parent,then,child1,child2..
			System.out.println(driver.getTitle());
			//prints title of the current window.
			
		}
		
		
		
		
	

	}

}
