package javaBasic;

public class Arrays {
	public static void main(String[] args) {
		
		//Different ways to write an array in Java 
		int[] marks = {10, 30, 40, 20, 50};
		String names[] = {"Asim","Qadir", "Ashraf", "Sharib"};
		int scores[] = new int[] {10,20,40,50};
		
		int pizzaCost[] = new int[3];
		pizzaCost[0] = 20;
		pizzaCost[1] = 30;
		pizzaCost[2] = 40;
		
		//printing array data
		for(String x : names) System.out.println(x); //using for each loop
		for(int i = 0; i < marks.length; i++) System.out.println(marks[i]); //using for loop
		
		
		///////////////////////     M U L T I - D I M E N T I O N A L    A R R A Y     ////////////////////////////
		
		System.out.println("---------------Multi dimentional array----------------------");
		
		//creating 2d array
		String fullNames[][] = new String[4][2]; //here 4 -- row size, 2 -- column size  -- MY WAY :: 
		fullNames[0][0] = "Mohd";
		fullNames[0][1] = "Asim";
		fullNames[1][0] = "Abdul";
		fullNames[1][1] = "Qadir";
		fullNames[2][0] = "Mohd";
		fullNames[2][1] = "Ashraf";
		fullNames[3][0] = "Mohd";
		fullNames[3][1] = "Sharib";
		
		for(String[] person : fullNames) {
			System.out.println(person[0]+" "+person[1]);
		}
		
		//creating 2d array other method
		String fullNamesAlt[][] ={
				{"Mohd","Asim"},{"Abdul","Qadir"},{"Mohd","Ashraf"},{"Mohd","Sharib"}
		};
		//creating 3d array
		String results[][][] = {{{"Mohd","Asim"},{"1001","27"}},{{"Abdul","Qadir"},{"1002","25"}},{{"Mohd","Ashraf"},{"1003","30"}},{{"Mohd","Sharib"},{"1004","27"}}};
		
	}
}
	
