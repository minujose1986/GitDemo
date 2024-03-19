import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newWindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//A)Navigate to https://rahulshettyacademy.com/angularpractice/
		//Fill name field with first course name available at 
		

        WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();	
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Now we need to switch to other page and get the first course name and switch back to angularpage and paste in name field
		//In selenium,we can open another tab or window itself.
		
		driver.switchTo().newWindow(WindowType.TAB);
		//inside argument we should pass whether we need new tab or new window.
		//consider we need to open new tab
		//When u do this selenium opens a blank tab for you and it can receive any url now.
		//Eventhough selenium opened newtab,control has not gone to the new tab.Controls scope is still in homepage.
		
		Set<String> handles = driver.getWindowHandles();
		//IMport set package
		//when u give windowhandles ,selenium sees how many windows are currently open.And all window ids will be stored in
		//its return type set datastructure.so here it is 2 windows.
		//Now we got 2 window ids in handles method.
		
		Iterator<String> it = handles.iterator();
		//return type of this method is string
		//Import iterator package.
		//Currently 'it' will be at the top of set data structure.
		
		String parentid = it.next();
		//'it' now points to parent window when we give next.i.e the 0th index value.
		
		String childid = it.next();
		//'it' now points to child window i.e the 1st index.
			
	    driver.switchTo().window(childid);
        //now control moves to new window by switching and in windowhandle argument we need to give window id.
	    //here we give childwindowid so that control switches to child window.
	    //now we give url it hits the child window.
	    
	//    Thread.sleep(9000);
	     
	    driver.get("https://rahulshettyacademy.com/");
	    
	    Thread.sleep(9000); 
	    
	    //Inspect the first course and get the locator.
	    String course = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
	    //There are almost 24 courses in this page .To get the first link we should give get(1) as links are starting from 1st position.
	    System.out.println(course); 
	    
	    driver.switchTo().window(parentid);
	    //switch back to parent window. 
	    
	    driver.findElement(By.name("name")).sendKeys(course);
	    
	    //B) TO GET THE SCREENSHOT OF A SPECIFIC WEBEELEMENT IN A PAGE
	    //Consider the case we need to get the screenshot of namefield where course is typed from above.
	    
	    WebElement name = driver.findElement(By.name("name"));
	    File srcfile = name.getScreenshotAs(OutputType.FILE);
	    //get screenshot gets the screenshot of the name field.
	    //Import file package and outputtype package and cahnge type to file
	    //File is class and srcfile is object of class.
	    //screenshot taken is saved in file.
	    
	    FileUtils.copyFile(srcfile, new File("logo.png"));
	    //To get FileUtils class we need to import jar 
	    //Google apache common fileutils maven ->Apache commom IO->Download Jar->RightclickIntrodcution->
	    //Properties->Put in Java build path all jars.
	    //This fileutils convert file object to physical file.
	    //fileutils(sourcefile,destination file).So screenshot->srcfile is converted to logo.png can be found in system.
	    //Add throws declartion.
	    //Now when u run this code and give File->Refresh we can see logo.png is created in test output of src.
	    //Right click->Prperties->Click File location->Open->screenshot
	    
	    //C) TO GET THE HEIGHT AND WIDTH OF EDITBOX
	     System.out.println(name.getRect().getDimension().getHeight());
	     System.out.println(name.getRect().getDimension().getWidth());
	     //This gives the height and width of the editbox
	     
	     
	     
	    
	    
	}

}
