import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr2= {1,2,4,5,6,7,8,9,10,122};
		
		for(int i=0; i< arr2.length; i++)
		{
			if (arr2[i]%2==0)
			{
				System.out.println(arr2[i]);
				break;
			}
				
			else
			{
				System.out.println(arr2[i] + " is not a multiple of 2");
			}
		}
		
		ArrayList <String> a = new ArrayList<String>();
		a.add("minu");
		a.add("jose");
		a.add("rahul");
		a.add("shetty");
		System.out.println(a.size());
		a.remove(3);
		System.out.println(a.size());
		System.out.println(a.get(2));
		
		for (int i =0; i< a.size();i++)
		{
			System.out.println(a.get(i));
		}
		
		System.out.println("*****");
		for ( String val : a)
		{
			System.out.println(val);
		}
		
		System.out.println(a.contains("minu"));
		
		String[] name = {"miya","minna","kuru" };
	      List<String>  name1= Arrays.asList(name);
	      System.out.println(name1.contains("minna"));
		
	}

}
