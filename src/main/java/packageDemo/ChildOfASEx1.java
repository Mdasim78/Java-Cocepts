package packageDemo;

import javaBasic.accessSpecifierExample2;

public class ChildOfASEx1 extends accessSpecifierExample2 {
	public static void main(String[] args) {
		
		accessSpecifierExample2 e2 = new accessSpecifierExample2();
		System.out.println("Parent height : "+e2.height);
		ChildOfASEx1 child = new ChildOfASEx1();  //**** to access the protected variable we have to create object of child class
		System.out.println("child height : "+child.height); 
		
		//System.out.println(e1.name);  
	    //System.out.println(e1.age);
		System.out.println(child.gender); 
		
	}
}
