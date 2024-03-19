
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodsDemo d = new MethodsDemo();
		String name = d.getData();
		System.out.println(name);
		
		MethodsDemo2 d2 = new MethodsDemo2();
		String name2 = d2.getData();
		System.out.println(name2);
		
		String s1 = getData3();
		System.out.println(s1);
		
		
	}
	
	public String getData()
	{
		System.out.println("hello world");
		return "rahul shetty";
	}

	public static String getData3()
	{
		System.out.println("hai minu");
		return "okay";
	}
}
