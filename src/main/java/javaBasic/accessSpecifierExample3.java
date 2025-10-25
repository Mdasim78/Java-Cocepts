package javaBasic;

public class accessSpecifierExample3 {

	public static void main(String[] args) {
		accessSpecifierExample2 e1 = new accessSpecifierExample2();
		System.out.println(e1.height);  //public
		System.out.println(e1.name);  //default
		System.out.println(e1.gender);  //protected
	/*	System.out.println(e1.age);  */  //private so it's not accesible in other class

	}

}
