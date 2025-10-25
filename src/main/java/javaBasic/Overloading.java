package javaBasic;

public class Overloading {
	
	/***
	 *Method overloading lets you have more than one method with same name and same return type in a class 
	 *But these methods differ in parameter data types, number of parameters or their order 
	 *Call to overloaded methods is resolved during compile time based on the method signature so it is called static polymorphism.
	 *
	 *Just like normal methods constructors can also be overloaded. A class can have multiple constructors this is called constructor overloading
	 *We can call one constructor in another construct by using this() or this(parameters) keyword
	 *Constructor call should be the first statement inside another constructor
	 */
	
	//constructor overloading
	public Overloading() {
		System.out.println("parameterless constructor is called");
	}
	
	public Overloading(String str) {
		this();   //Constructor call must the first statement inside constructor
		System.out.println(str);
	}
	
	public Overloading(String str,int num) {
		this("calling one parameterized constructor in another");
		System.out.println(str+ " "+num);
		
	}
	
	//method overloading
	public void method1(String str) {
		System.out.println(str);
	}
	
	public void method1(String str1, String str2) {  //Differs in number of parameters 
		System.out.println(str1+" "+str2);
	}
	
	public void method1(String str1, int num1) {   //Differs in type of parameter 
		System.out.println(str1+" "+num1);
	}
	
	public void method1(int num1, String str1) {  //Differs in order of parameter if parameters have different data types
		System.out.println(str1+" "+num1);
	}
	
	public static void main(String[] args) {
		Overloading o1 = new Overloading();
		o1.method1("str1");
		o1.method1("str1", "str2");
		o1.method1("str1", 10);
		o1.method1(20, "str1");
		
		Overloading o2 = new Overloading("parameterized constructor is called");
		Overloading o3 = new Overloading("calling one parameterized constructor in another", 10);
	}
}
