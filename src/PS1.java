import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS1 extends PS{
	
     //Inherits properties of parent class PS
	//Child Class
	
    //When u run PS1,testng test since PS1 inherits from PS it will check for all methods in parentclass.
	//Since there is a BeforeMethod in PS, it will run before the testRun() method in PS1
	//As there is parent-connection method,PS will be executed and then PS1
	
	@Test
	//Import Test Annotation Package
	public void testRun()
	{
		doThis();
		//we called method in parentclass PS in child class PS1 without creating object of this class.
		//This was possible only due to Inheritance.
		
		//Consider the case when there is no inheritance.NO extends method.
		//I need to access method present in another class PS.
		//One way to do this is create object of this class
		//   PS ps = new PS();
		//   ps.doThis(); - using this object we can access method of other class
		
	     
		//REAL TIME
		//In selenium webbrowser,we need to each time open browser,maximize window.
		//All these can be put in BeforeMethod can be kept in parent class
		//Child class can then concentrate only on testcases
		
		// B) Constructor -147
		//Consider we create class PS2 for increment & decrement
		//To call increment method in class PS2 here instead of inheritance we create object and do.
		int a = 3;
		//we have to pass this number into our testcase that is PS2 class
		PS2 ps2 = new PS2(3);
		//System.out.println(ps2.increment(3));
		//one way is to parameterise by sending value from here like above.
		//if there are multiple testcases for every method we have to do this
		//other way is by passing this number to the class -> PS2 ps2 = new PS2(3);
		//But it shows error.So constructor comes in pic
		//whenever u create object for any class without parameters ,a default constructor is created in background
		//But if u are creating class with parameters,we have to explicitly call that constructor.
		//Click the suggestion Create constructor for class PS2(int)
	     System.out.println(ps2.increment());
	     System.out.println(ps2.decrement());
	     
	     //C)  Consider case we create separate utility class PS3 for multiplication
	     //so to access the class PS3 we have to create object of that class
	     PS3 ps3 = new PS3(4);
	     //if we need to pass parameters we have to click suggestion create parameterised constructor that is done
	     //automatically in class PS3
	     //System.out.println(ps3.multiplyTwo());
	     //System.out.println(ps3.multiplyThree());
	     //This is one way to accesss function.We dont need to create 2 objects.
	     //We need to accesss methods in PS3, using PS2.It can be possible by using inheritance
	     //By using extends in PS2
	     System.out.println(ps2.multiplyTwo());
	     System.out.println(ps2.multiplyThree());
	}

}
