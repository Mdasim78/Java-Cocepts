package javaBasic;

public class JavaClassConcepts {
		String str1;  //Attributes of class
		int num1;
		
	////////////////////////////       C O N S T R U C T E R S       ///////////////////////////////
	//Constructor is a special method in Java whose name is same as class name and it is used to create the object. 
	//Constructor can be parameterized or non parameterized if any argument is passed to the constructor it is parameterized and if not it is non parameterized below is a non parameterized constructor
	public JavaClassConcepts() {
		System.out.println("Parameter less constructor");
	}
	
	//Parameterized constructor 
	public JavaClassConcepts(String str1, int i) {
		this();  //We can call one constructor in another constructor, for that the called-constructor should be the fast line And Constructor can be called using this keyword 
		System.out.println("Parameterized constructor ");
		this.str1 = str1; //Here this.str1 refers to current object attribute and we are passing local str1 value to the attribute. this keyword is necessary otherwise the value will not be passed to the attribute because str1 without this keyword refers to local variable 
		num1 = i;  //When local variable name and instance variable name is not same we don't need to write this keyword 
		
	}
	
	////////////////////////////////////       M A I N      M E T H O D      ////////////////////////////////////////
	public static void main(String[] args) {
		//In Java main() method is the entry point of execution if there is no main method then we cannot run that Java program 
		//We declare main method as static because by declaring method static we don't need to create instance of the class 
		//Hear void keyboard specifies the return type of the method if there is no return type it is void, if there is any written type then we write int short float based on what data type that method is going to return 
		System.out.println("In Java main() method is the entry point of execution if there is no main method then we cannot run that Java program \nWe declare main method as static because by declaring method static we don't need to create instance of the class ");
		
		//To call the willow doSum method we need to create object of the class because the method below is not a static method 
		//In Java object is always created inside main method and using the object we can call methods of the class and it is variables or attributes 
		JavaClassConcepts j1 = new JavaClassConcepts();  // creating object using non parameterized constructor or default constructor 
		j1.doSum(5, 10);   //Calling other methods inside main method
		
		JavaClassConcepts j2 = new JavaClassConcepts("Asim", 27); //Creating object using parameterized constructor 
		j2.displayInfo();
		j1.displayInfo();
	}
	
/////////////////////////////// Other methods ////////////////////////////////////////////
	public void doSum(int a, int b) {
		System.out.println("Sum of  "+ a +" and " + b + " is "+ (a+b));
		//Here public is access specifier void is written type. doSum is method name int a and int. B is parameter
	}

	public void displayInfo() {
		System.out.println(str1+ " is "+num1+" years old");
		this.doSum(num1, num1);  //This keyword can be used to invoke a method inside another method 
	}

}
