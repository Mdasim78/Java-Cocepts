package javaBasic;

public class WrapperClass {
	public static void main(String[] args) {
		int num1 = 20;
		Integer num = new Integer(num1);
		Integer wrappedInt = num1;         // autoboxing -- automatic conversion of primitive data type into its corresponding wrapper class 
		int unwrappedInt = wrappedInt;     //unboxing -- Automatic conversion of wrapper class object to its corresponding primitive data type 
		System.out.println(unwrappedInt);  
		System.out.println(wrappedInt);    
		
		char value = 'a';
		Character wrappedChar = value;
		
		//wrapper class methods
		
		String phoneNo = "4574563646";
		long phoneNo1 = Long.parseLong(phoneNo);
		System.out.println(phoneNo1);
		
		Integer num3 = 5656564;
		Long num4 = num3.longValue();
		
	}
}
