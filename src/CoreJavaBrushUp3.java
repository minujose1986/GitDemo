
public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Rahul Shetty Academy";
		String[] s1 = s.split(" ");
		for(int i=0; i< s1.length; i++)
		{
			System.out.println(s1[i]);
		}
		
		String[] s2 = s.split("Shetty");
		for(int i=0; i< s2.length; i++)
		{

					
			System.out.println(s2[i].trim());
		}

		
//		for(int i=0; i< s.length(); i++)
//		{
//			
//			System.out.println(s.charAt(i));
//		}
		System.out.println(s.length()-1);
		for(int i = s.length()-1; i >= 0; i--)
		{
					
			System.out.println(s.charAt(i));
		}
	}

}
