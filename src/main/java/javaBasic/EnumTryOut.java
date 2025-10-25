package javaBasic;

public class EnumTryOut {
	public static void main(String[] args) {
		EnumExample e1[] = EnumExample.values();    //value's method returns an array of enum type 
		for(EnumExample values : e1) System.out.println(values);
		
		System.out.println("----------------------------");
		
		switch (EnumExample.ENUMEX2) {
		case  ENUMEX1 : System.out.println(EnumExample.ENUMEX1); break;
		case  ENUMEX2 : System.out.println(EnumExample.ENUMEX2); break;
		default : System.out.println(EnumExample.ENUMEX4);
		
		}

		System.out.println("Week starts from : "+Days.Monday);
	}
}
