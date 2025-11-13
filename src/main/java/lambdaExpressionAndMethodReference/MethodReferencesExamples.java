package lambdaExpressionAndMethodReference;

import java.util.function.BiFunction;

/**
 * A method reference is a shortcut for writing a lambda expression that only calls an existing method. It’s a way to refer to a method by its name instead of writing a full lambda.
 * ❌ No, you cannot use a method reference without referring to an existing method. 
 * Method references are literally references (or pointers) to already existing methods or constructors — they don’t define new logic like lambdas do.
 * What if you need new logic? Then you should use a lambda expression instead, not a method reference.
 *Use them when:
 	Your lambda only calls an existing method.
 	You want cleaner and more readable code.
 * There are 4 types of method references in Java:
	| Type                                                                               | Syntax                      | Example               | Description                                                    |
	| ---------------------------------------------------------------------------------- | --------------------------- | --------------------- | -------------------------------------------------------------- |
	| **1. Reference to a static method**                                                | `ClassName::staticMethod`   | `Math::max`           | Refers to a static method                                      |
	| **2. Reference to an instance method of a particular object**                      | `instance::instanceMethod`  | `System.out::println` | Refers to a method of an existing object                       |
	| **3. Reference to an instance method of an arbitrary object of a particular type** | `ClassName::instanceMethod` | `String::toUpperCase` | Refers to instance methods that will be called on each element |
	| **4. Reference to a constructor**                                                  | `ClassName::new`            | `ArrayList::new`      | Creates new objects                                            |

 */
public class MethodReferencesExamples {
	public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {			//BiFunction is a functional interface
        return merger.apply(a, b);													//calling the abstract method of functional interface
    }
    
    public static String appendStrings(String a, String b) {
    	return a + b;
    }
    
    public String appendStrings2(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        
        MethodReferencesExamples myApp = new MethodReferencesExamples();

        // Calling the method mergeThings with a lambda expression
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", (a, b) -> a + b));							//(a, b) -> a + b) --> implementation of abstract method "apply" using lambda
        
        // Reference to a static method
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", MethodReferencesExamples::appendStrings));	//MethodReferencesExamples::appendStrings --> implementation of abstract method "apply" using method reference that calls an existing method

        // Reference to an instance method of a particular object        
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", myApp::appendStrings2));					//MethodReferencesExamples::appendStrings --> implementation of abstract method "apply" using method reference that calls an existing method
        
        // Reference to an instance method of an arbitrary object of a
        // particular type
        System.out.println(MethodReferencesExamples.
            mergeThings("Hello ", "World!", String::concat));
    }
}
