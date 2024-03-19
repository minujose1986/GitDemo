import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sslCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. First time when u run the code,we get error certifictae in the browser and Privacy Error in output console.
		//so we introduce chromeoptions class to bypass the certificate and load the browserpage.
	
		ChromeOptions options = new ChromeOptions();
		//import Chromeoptions package and create object.
		options.setAcceptInsecureCerts(true);
		//this statement allows chromedriver to accept the error/insecure certificates.		
		
		
		//2. Add EXtensions.
		//We know by default a browser has extensions.But when we run by automation,browser page opens without extensions.
		//To add extensions/plugins to browser we use this command.
		//We have to add extension as file and give path in the method.
		//So chromeoptions pick up file from path add extensions and then pass to chromedriver.
		
		options.addExtensions("/path/to/extension.crx");
		
		
		//3. Some websites really need special proxies to open up.We can set proxy at run time .
		//this is done by Proxy class. We get proxy from Networkimg guys in company
		
		Proxy proxy= new Proxy();
		//Import Proxy Class
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy",proxy);
		
		//4.Sometimes in flightbooking ,we have small popups like allow to detect location.
		//if we need to block all those popups we can use this.
		
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		
		//5.When we download a file,by default it is getting downloaded in the Downloads directory.
		//We can change the download path using this .
		
		Map<String, Object> prefs = new HashMap<String, Object>();
        //Import Map and HashMap Class
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		//in this lastline of "prefs", we give the prefs path.
		//it will be  like  options.setExperimentalOption("prefs", prefs.put("download.default_directory", "/directory/path"););
				
		
		WebDriver driver = new ChromeDriver(options);
		//we have to pass ChromeOptions behaviour as an argument to ChromeDriver.Then only chromeDriver knows about it.
		driver.manage().window().maximize();				
				
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		//Similar to this we have EdgeOptions,FirefoxOptions and SafariOptions

	}

}
