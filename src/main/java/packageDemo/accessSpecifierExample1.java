
package packageDemo;
import javaBasic.accessSpecifierExample2; ////You have to import class to use public variables and methods from that class
public class accessSpecifierExample1 {
	public static void main(String[] args) {
		accessSpecifierExample2 e1=new accessSpecifierExample2();
		System.out.println("Height : "+e1.height); 
		
		//Below attributes are not available because of the access issue 
/*		System.out.println(e1.name);  
		System.out.println(e1.age);
		System.out.println(e1.religion);  */
		
		System.out.println("Age : "+e1.getAge()); //accessed using getter and setter method
		
	}
}
