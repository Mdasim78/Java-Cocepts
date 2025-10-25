package javaBasic;

public class accessSpecifierExample2 {
	String name = "asim";   //default -- Accessible within the same package if you know access specifier is mentioned so it is default 
	public float height = 5.11f;  //Accessible everywhere including classes of different packages 
	private int age =27;   //Accessible within the class only 
	protected String gender = "Male"; //Accessible within the package as well as child class of this(here accessSpecifierExample2) class in another package. **** to access the protected variable we have to create object of child class  
	
	
	public int getAge() {  //to access private instance variables we have to use getter and setter
		return this.age;
	}
	
	public static void main(String[] args) {
		accessSpecifierExample2 e1 = new accessSpecifierExample2();
		
		//Everything is accessible within same class 
		System.out.println(e1.name);
		System.out.println(e1.height);
		System.out.println(e1.age);
		System.out.println(e1.gender);
	}
}
