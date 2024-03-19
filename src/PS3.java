
public class PS3 {
	
	int a;
	

	public PS3(int a) {
		// default parameterized constructor created automatically from PS1
		this.a = a;
		//this.a is the class variable
		//a is the instance variable
		//we r setting instance variable value passed from ps1 to class variable a so
		//that it can be accessed by the methods
	}

	public int multiplyTwo()
	{			
		 a = a * 2;
		 return a;		 
	}
	
	public int multiplyThree()
	{			
		 a = a * 3;
		 return a;		 
	}
	

}
