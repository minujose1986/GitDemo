import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class miscelleanous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		//driver.manage().addCookie(null);
		//driver.manage().deleteCookieNamed("asdf");
		//driver.manage().deleteCookieNamed("sessionKey");
		
		//click on any link
		//login page- verify login url
			
		driver.get("http://google.com");
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//import File,TakeScreenshotAs Package
		//get ScreenshotAs() method
		//This line takes screenshot by casting the driver
		//After taking screenshot,we ask webdriver to o/p  screenshot as file
		//so that we can view as  it is stored in src object
		
		//FileUtils.copyFile(src,new File("C:\\screenshot.png"));
		//this step copies file from source object to our local machine.
		//we need to go & download fileutils jars from internet to our buildpath.
		//Download from commons.apache.otg/proper/commons-io/
		//This adds the package import org.apache.commons.io.FileUtils;
		//Also add throws declaration to remove error.
				
		//when u run code script fails, because access is denied.
		//C drive can be accessed to create/delete file only by admin.
		//solution is to change location to any other drive.
		
		FileUtils.copyFile(src,new File("C:\\Users\\97155\\screenshot.png"));
        //if we dont have any other drive other than c drive,then point your file
		//to Users Directory. c->Users->Minu
		//We can place in our folder.Windows allows that.
		//Goto location and open in paint
	}

}
