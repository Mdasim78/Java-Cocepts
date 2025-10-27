package nestedClass;

/***
 * You can define a local class inside any block. For example, you can define a local class in a method body, a for loop, or an if clause.
 * A local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final.
 * declaring static variable and method is not possible in local class
 */

public class LocalClassExample {

	static String regularExpression = "[^0-9]";
	
	public static void printStr() {
		System.out.println("Outerclass static method");
	}
	
	
	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {      
		final int numberLength = 10;    
		
		//local class defined inside a method
		class PhoneNumber {    	
			static final int a=10;  //--> declaring static variable and method is not possible in local class unless it is final
			String formattedPhoneNumber = null;  //local class instance variable
			PhoneNumber(String phoneNumber){  //local class constructor
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");  
				if (currentNumber.length() == numberLength) formattedPhoneNumber = currentNumber;
				else formattedPhoneNumber = null;
			}
			
			public String getNumber() { //local class method
				//printStr();  //outer class method
				return formattedPhoneNumber;
			}
			
			// Valid in JDK 8 and later: local class can access enclosing method parameter
            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1 +
                    " and " + phoneNumber2);
            }
		}

		PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1); //local class object created
		PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

		// Valid in JDK 8 and later:
		myNumber1.printOriginalNumbers();

		if (myNumber1.getNumber() == null) 
			System.out.println("First number is invalid");
		else
			System.out.println("First number is " + myNumber1.getNumber());
		if (myNumber2.getNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Second number is " + myNumber2.getNumber());

	}

	public static void main(String... args) {
		validatePhoneNumber("123-456-7890", "456-7890");
	}
}
