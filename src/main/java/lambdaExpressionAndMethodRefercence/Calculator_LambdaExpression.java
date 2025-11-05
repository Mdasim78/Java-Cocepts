package lambdaExpressionAndMethodRefercence;

/**
 * 
 * 
 */
public class Calculator_LambdaExpression {

interface IntegerMath {															//functional interface --> lambda expression only works with functional interface
	int operation(int a, int b);   												//abstract method --> This is the method that will be implemented by lambda expressions.
	}

	public int operateBinary(int a, int b, IntegerMath op) {					//IntegerMath (called op)--> implementation of the interface as a paremeter.
		return op.operation(a, b);												//It then calls the abstract method operation(a, b) of that interface and returns the result
	}

	
	
	public static void main(String... args) {	    
		Calculator_LambdaExpression myApp = new Calculator_LambdaExpression();
		IntegerMath addition = (a, b) -> a + b;									//defines a lambda expression to implement the abstract method of the interface (IntegerMath.operation(a, b) method without writing a full class) and assigns it to a variable "addition" of type IntegerMath
		IntegerMath subtraction = (a, b) -> a - b;
		System.out.println("40 + 2 = " +
				myApp.operateBinary(40, 2, addition));
		System.out.println("20 - 10 = " +
				myApp.operateBinary(20, 10, subtraction)); 
		
		
		//FYI the above lambda expression can be written using anonymous class but lambda is simpler
		IntegerMath additionAnonymous = new IntegerMath() {
			@Override		
			public int operation(int a, int b) {
				return a+b;
			}
		};
		IntegerMath subtractionAnonymous = new IntegerMath() {
			@Override		
			public int operation(int a, int b) {
				return a-b;
			}
		};		
		System.out.println("additionAnonymous: "+myApp.operateBinary(30, 10, additionAnonymous));
		System.out.println("subtractionAnonymous: "+myApp.operateBinary(30, 10, subtractionAnonymous));
	}

}
