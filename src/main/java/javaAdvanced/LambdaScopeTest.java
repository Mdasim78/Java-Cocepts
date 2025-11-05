package javaAdvanced;

import java.util.function.Consumer;


/**
 * In Java, lambda parameters share the same scope as the method they’re written in.
 * You cannot reuse variable names (like x or z) already declared in that method — it causes a “variable already defined” error.
 * Using a new name (like y) works fine since it doesn’t conflict with any existing variable.
 * Lambdas don’t create a new scope, but anonymous inner classes do, which is why inner classes can shadow variables while lambdas cannot.
 */
public class LambdaScopeTest {
	public int x = 0;
	 
    class FirstLevel {
 
        public int x = 1;
        
        void methodInFirstLevel(int x) {

            int z = 2;
            
            Consumer<Integer> myConsumer = (y) -> 	   //Consumer<T> is a built-in functional interface in java.util.function package. //It has only one abstract method: void accept(T t). Hence, lambdas can implement it.
            
            // here we can't use x or z as variable because lambda expression does not allow variable shadowing of local variables from the enclosing scope 
            //Because y is not used anywhere else in that method. So (y) introduces a new variable name that represents the parameter of the lambda expression, without clashing with any existing variable.
            
            {
                // The following statement causes the compiler to generate
                // the error "Local variable z defined in an enclosing scope
                // must be final or effectively final" 
                //
                // z = 99;
            	// x=50;
                
                System.out.println("x = " + x); 
                System.out.println("y = " + y); 
                System.out.println("z = " + z);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " +
                    LambdaScopeTest.this.x);
            };
 
            myConsumer.accept(x);												//calling method of the Consumer<T> interface.									
 
        }
    }
 
    public static void main(String... args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
