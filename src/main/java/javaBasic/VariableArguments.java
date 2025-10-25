package javaBasic;

public class VariableArguments {
	
/*
 * Java allowed us to pass variable number of values to an argument of a method
 * this is useful when we do not know the exact number of values to be passed to an argument
 * Variable arguments passed to a method is treated like an array 
 */
	
	public void display(int customerId,String name, long ...contactNumbers) {
		System.out.println("CustomerName: "+name);
		System.out.println("CustomerId: "+customerId);
		
		String numbers ="" ;
		for(long contactNumber : contactNumbers) {
			String number = Long.toString(contactNumber);
			numbers += number+", ";
		}
			System.out.println("ContactNumbers: "+numbers);
		
	}
	
	public static void main(String[] args) {
		VariableArguments va1 = new VariableArguments();
		va1.display(100, "Asim", 249747563,76374537,7863544,87365343);
	}
}
