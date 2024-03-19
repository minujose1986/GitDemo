import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

	//Parent Class
      public void doThis()
      {
    	  System.out.println("Parent Class- I am here");
      }

  	//if i need to execute something before test
  	@BeforeMethod
  	//Import BeforeMethod Annotation Package
  	public void  beforeRun()
  	{
  		System.out.println("Run me first");
  		
  	}
  	
  	@AfterMethod
  	//Import AfterMethod Annotation Package
  	public void  afterRun()
  	{
  		System.out.println("Run me last");
  		
  	}
}
