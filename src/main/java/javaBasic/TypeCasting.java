package javaBasic;

public class TypeCasting {
	public static void main(String[] args) {
		System.out.println("Type casting in Java");
		
		///////////////       T Y P E      C A S T I N G      /////////////////
		//type casting is needed to prevent data loss
		//explict type casting
		//The data type in the ascending order of their size is byte>short>int>long>float>double   and char>int
		long num1=10;
		int num2=(int)num1; //typecast is needed while storing value from bigger data type to smaller datatype
		float num3 = num2; //here typecasting is not needed because it's opposite of above. It is called implict typecasting
		
		
		
	}
}
