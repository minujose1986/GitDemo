
public class PS2 extends PS3 {
	
	// this means PS2 can access all functions in PS3
	int a;	//here a is class variable
	//class variable a is accessed by increment & decrement
	public PS2(int a) {  
		
		//we can see that this method is automatically created when we give suggestion create constructor
		//for PS2(int)
		//constructor name will always be the class name.it also reflects the no of parameters
		
		//B)here a is instance variable.so scope of this variables lies only in this  block
		//we cannot access this a outside this block
		// default parameterized constructor is created
		
		//C) when u inherit PS3,it shows error for public PS2(int a)  because value of a is not passed here
		//because it was done in class object creation level.Since we r not creating
		//object of class PS3,parameter cannot be passed and hence the error.
		
        super(a);
        //this activates the a in class PS3.so that value  got in PS2 at object creation in PS1 is passed to PS3
        //parent class constructor is invoked
        //super keyword is used only when there is a inheritance.Duty of this is to invoke parent class constructor
        //Also super keword code should be the first line in that child constructor
		
		this.a = a;
		//B)eventhough instance variable a has 3 passed from PS1,we need to set that value in class variable so 
		//that it can be accessed by increment & decrement functions
		//here this.a is the class variable.our own class variable can be called with this
		//a is instance variable.
		//so we set the instance variable value to class variable
		
		
	}

	public int increment()
	{	
		
		//if we are doing parameterised, we can write-> public int increment(int a)
		//but we dont need this as we have done constructor
		//a here is class variable a and not instance variable
		 a = a+1;
		 return a;
		 
	}
	
	public int decrement()
	{		
		 a = a-1;
		 return a;
		//a here is class variable a and not instance variable
		 
	}

}
