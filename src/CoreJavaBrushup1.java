
public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int myNum =5;
		  String website = "Calgary Jobs";
		  char letter ='r';
		  double dec = 5.99;
		  boolean mycard = true;
		  
		  System.out.println(myNum + " is the value stored in myNum variable");
		  System.out.println(website);
		  System.out.println(letter);
		  System.out.println(dec);
		  System.out.println(mycard);
		  
		  int[] arr = new int[5];
		  arr[0]= 1;
		  arr[1]=2;
		  arr[2]=3;
		  arr[3]=4;
		  arr[4]=5;
		  
		  int[] arr2 = {1,2,3,4,5};
		  System.out.println(arr2[4]);
		  
		  for(int i=0; i< arr.length; i++)
		  {
			  
			  System.out.println(arr[i]);
		  }
		  // string array retreiving in 2 ways
		  String[] name = {"rahul","shetty","minu","roy"};
		  for(int i=0; i< name.length;i++)
		  {
			  System.out.println(name[i]);
		  }
		  
		  for(String s:name)
		  {
			  System.out.println(s);
		  }
		  
		  for (int i=0;i<name.length;i++)
		  {
			  if( name[i] == "roy")
			  {
				  System.out.println(name[i]);
			      break;
			  }
		  }
	}

}
