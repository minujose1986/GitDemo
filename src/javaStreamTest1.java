import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class javaStreamTest1 {
	
	//Count the number of names starting with alphabet 'A'
	
	// @Test
	 
	 //This annotation is used to identify the actual test case.if something needs to be automated,
	 //that code needs to be inserted into test method.Test method then executes @Test by passing
	 //attributes.this is required as JUnit allows multiple tests to be grouped under a single test class.
	 //Test annotation refers to adding information to your tests,such as name,build number,tag,and pass/fail status.
	 //TestNG is preferred for its ability to write powerful test cases with help of annotations,grouping,parametrizing.
	 //This covers all types of test like Unit Testing,Functional and End to end testing
	 
	 //After installing TestNG add this test to your code @Test on top of the Public Void or public class to run the application as TestNG
	public void reguar()
	{
	 
	ArrayList<String> names = new ArrayList<String>();
	//Import ArrayList
	
	names.add("Abhishek");
	names.add("Don");
	names.add("Alekhya");
	names.add("Adam");
	names.add("Ram");
	
	int count = 0;  
	
	for (int i=0;i< names.size();i++)
	{
		String actual = names.get(i);
		if (actual.startsWith("A"))
		{
			count = count + 1;
		}
	}
	
	System.out.println(count);
	
	}
	 
	 //Same program we are going to write in Javastream using a method called Filter
	 //a) Terminal operation - count()
	 
	// @Test
	 public void streamFilter()

	 {
			ArrayList<String> names = new ArrayList<String>();
			//Import ArrayList
			
			names.add("Abhishek");
			names.add("Don");
			names.add("Alekhya");
			names.add("Adam");
			names.add("Ram");
			
			Long c = names.stream().filter(s->s.startsWith("A")).count();
			//Datatype of c is Long.
			//Here Arraylist names need to be converted to streams to perform operation. names.stream()
			//Stream is a collection of strings.When u give this arraylist is moved to stream so that
			//it can process all information very quick and can be done parallely along with storage of names.
			//Filter is a method in stream that filters based on our condition.It takes argument along with expression.
			//Lambda expression is the new arrow operator
			//s is the new parameter we are using for this execution.
			//Leftside of lambda -> gives parameter .i.e 's'
			//Rightside of lambda -> action to be performed on the parameter.
			//This filter scans all names and stores in s .Along with this,parallely it will be scanning all names with letter 'A' 
			//While in other cases,it first stores and loops everytime to scan name which is done serially and takes more time.
			
			//Working of stream can be explained in 3 ways
			//1)Create stream. we created arraylist stream
			//2)Perform intermediate operation.Here filter is the intermediate.It executes filter on initial stream and convert
			//into another stream with names starting with only 'A'
			//Intermediate operation can execute only if there is a terminal operation.Here count is terminal operation.
			//Life of intermediate exist only if there is a terminal operation.
			//3)Terminal operation means the method we apply on the intermediate stream.
			//Terminal operation will execute only if intermediate operation returns true.If it is false, it wont excecute.
			
			System.out.println(c);
			//We need to comment out first test to run this test.
			//Whatever changes you have made to names,it wont affect your original source allocation names.
			//From names here we are deriving new stream and are working on new stream.
			
			//OR
			//How to create stream compatible collection
			
			//long d = Stream.of("Abhishek","Don","Alekhya","Adam","Ram").filter(s->s.startsWith("A")).count();
			
			//OR if multiple operations are there we can write as loop
			long d = Stream.of("Abhishek","Don","Alekhya","Adam","Ram").filter(s->
					{
						return  s.startsWith("A");						
					}).count();
			System.out.println(d);
												
			//b) To print all names in arraylist whose length is > 4 (Terminal Operation)
			     names.stream().filter(s-> s.length()>4).forEach(s-> System.out.println(s));
			     //intermediate operation gets all names with length >4
			     //Terminal operation forEach() takes each item from intermediate and performs operation of printing it in output
			     
			//c) To get only the first element in arraylist whose length is > 4(Terminal Operation)
			     names.stream().filter(s-> s.length()>4).limit(1).forEach(s-> System.out.println(s));
			     //intermediate operation gets all names with length > 4, but since we have given limit 1, it takes only 1st element
			     //Terminal operation forEach() takes that one item from intermediate & performs operation of printing it in output
	 }
 
	// @Test
	 public void streamMap()
	 {
		 
		//d) To print all names which has last letter "a" with Uppercase.	 
		
		//Maps helps us to manipulate the stream .It converts stream of one type to another.It is also an intermediate operation.
		//Map returns a new array of elements where u have applied some function on element so that it changes the original element.
		//Filter select those elements that satisfy a condition (with no change in original values) & returns boolean.
		 Stream.of("Abhishek","Don","Alekhya","Adam","Ram").filter(s-> s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		 //Filter result - Map Method - Terminal Operation.
		 
		 //e) To print all names which has first letter "a" with Uppercase and sorted in output
		 Stream.of("Abhishek","Don","Alekhya","Adam","Ram").filter(s-> s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s-> System.out.println(s));
		 
		 //f) To merge 2 different lists- one an array and other arraylist
		 
		 ArrayList<String> names = new ArrayList<String>();
			//Import ArrayList
			
			names.add("Abhishek");
			names.add("Don");
			names.add("Alekhya");
			names.add("Adam");
			names.add("Ram");
			
		List<String> names1 = Arrays.asList("Minu","Vinu","Woman");
		//Import List. Convert array to arraylist
		//First we need to convert both into streams and then use concatenation operation to merge these 2 lists
		Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
		//newStream.sorted().forEach(s-> System.out.println(s));
		
		//g) To check whether Adam is present in the output list .If present,it returns true else false.
		//We can use match() method here.
		//we need to comment on above code for this to work as stream is already operated upon
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		//anyMatch is used to check if stream contains any matching element with condition.
		//Also it doesnot require a terminal operation like filter
		 		 
	 }

     @Test
     
     //h) Consider the case where we need to get output as list instead of printing one by one
     public void streamCollect()
     {
    	 List<String> ls = Stream.of("Abhishek","Don","Alekhya","Adam","Ram").filter(s-> s.endsWith("a")).map(s->s.toUpperCase())
    	         .collect(Collectors.toList());
    	 //Import Collect package.
    	 //Collect() is used to collect ur result from previous operation and convert it back to list
    	 //Till now List->Stream->Filter->Map-> Print in o/p
    	 //in Collect , List->Stream->Filter->Map-> Convert to list which is used for further operations.
    	 
    //i) To print the first element in the collected list
    	 System.out.println(ls.get(0)); 
    	 
    //j) To print unique numbers from an integer array and sort the array
    	 List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
    	 //This is arraylist which need to be converted to stream
    	 numbers.stream().distinct().sorted().forEach(s-> System.out.println(s));
    	 
    //k) Consider we need to print only the third element.
    	 List<Integer> num = numbers.stream().distinct().sorted().collect(Collectors.toList());
    	 System.out.println(num.get(2)); 
    	 
     }
}
