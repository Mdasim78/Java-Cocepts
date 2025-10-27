package nestedClass;

/**
 * There are 4 main types of nested classes:
	Static nested class
	Non-static inner class (a.k.a. member inner class)
	Local inner class
	Anonymous inner class

| **Feature**                        | **Static Nested Class**                                               | **Non-static Inner Class (Member Inner Class)**                                   | **Local Inner Class**                                                                            | **Anonymous Inner Class**                                                                  |
| :--------------------------------- | :-------------------------------------------------------------------- | :-------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------- |
| **Where defined**                  | Inside another class, declared with `static` keyword                  | Inside another class, but **outside any method or block**, and **without static** | Inside a **method**, **constructor**, or **block** of a class                                    | Inside a **method**, **constructor**, or **expression**, declared and instantiated at once |
| **Scope / Lifetime**               | Exists as long as the **outer class** is loaded                       | Exists as long as the **outer class instance** exists                             | Exists **only while the method/block executes**                                                  | Exists **only for that specific statement/expression**                                     |
| **Access to outer class members**  | Can access **only static members** of outer class                     | Can access **all members (static + instance)**, including private                 | Can access **outer class members** and **final/effectively final local variables** of the method | Same as Local Inner Class — can access **outer members** and **effectively final locals**  |
| **Access modifiers allowed**       | `public`, `private`, `protected`, or default                          | `public`, `private`, `protected`, or default                                      | ❌ No (implicitly local to method/block)                                                          | ❌ No (anonymous, no declaration)                                                           |
| **Associated with**                | The **outer class** itself (does not depend on instance)              | A **specific instance** of outer class                                            | A **specific method or block**                                                                   | A **specific method or expression**                                                        |
| **Requires outer class instance?** | ❌ No                                                                  | ✅ Yes (`Outer.Inner inner = outer.new Inner();`)                                  | ✅ Created inside a method only                                                                   | ✅ Created inline automatically                                                             |
| **Can be static?**                 | ✅ Already static                                                      | ❌ No                                                                              | ❌ No                                                                                             | ❌ No                                                                                       |
| **Can have constructors?**         | ✅ Yes                                                                 | ✅ Yes                                                                             | ✅ Yes                                                                                            | ❌ No (no name)                                                                             |
| **Can extend/implement?**          | ✅ Yes                                                                 | ✅ Yes                                                                             | ✅ Yes                                                                                            | ✅ Yes (but only **one class or interface**)                                                |
| **Use case**                       | Used for **utility/helper classes** logically tied to the outer class | Used to **access and operate on outer class instance data**                       | Used for **temporary helper logic within a method**                                              | Used for **one-time use**, especially **event handling** or **functional callbacks**       |
| **Commonly used with**             | Utility/helper logic (e.g., `Map.Entry`)                              | Encapsulated logic bound to outer instance                                        | Encapsulate method-specific behavior                                                             | Implementing **interfaces** or **abstract classes** inline                                 |
| **Example keyword**                | `static class Inner`                                                  | `class Inner`                                                                     | `class Inner` (inside a method)                                                                  | `new Interface/Class() { ... }`                                                            |
| **Typical Example**                | Utility classes like `Map.Entry`                                      | Helper accessing outer instance fields                                            | Temporary helper inside method                                                                   | Inline listener: `new Runnable() { public void run() {...} }`                              |
| **Example Creation**               | `Outer.StaticNested sn = new Outer.StaticNested();`                   | `Outer.Inner in = outer.new Inner();`                                             | Defined and used inside a method                                                                 | `Interface obj = new Interface() { ... };`                                                 |
| **Can be reused outside?**         | ✅ Yes                                                                 | ✅ Yes                                                                             | ❌ No (local scope only)                                                                          | ❌ No (one-time definition)                                                                 |
| **Compiles to**                    | Separate `.class` file (e.g., `Outer$Inner.class`)                    | Separate `.class` file (e.g., `Outer$Inner.class`)                                | Separate `.class` file (e.g., `Outer$1Local.class`)                                              | Separate `.class` file (e.g., `Outer$1.class`)                                             |


 */

public class OuterClass {
	
	//In this class file we will only learn member inner class and static nested class

    String outerField = "Outer field";
    int x=0;
    static String staticOuterField = "Static outer field";
    
    void printString(String str) {
    	System.out.println("Printing string using Outerclass method: "+str);
    }

    //Non static nested class is also called as Inner class
    class InnerClass {
    	String innerField = "Inner field";   //instance variable of inner class
    	int x=10;  //same variable name as in outer class to test shadowing of variables
        void accessMembers() {
        	 System.out.println(innerField);
            System.out.println(outerField);  // inner class has access instance variable as well as static variable from outer class
            System.out.println(staticOuterField); 
        }
        
        void shadowTest(int x) {
        	System.out.println("x ="+x);  //here x is method parameter
        	System.out.println("this.x ="+InnerClass.this.x);  //here x is current inner object instance variable
        	System.out.println("OuterObect.InnerObject.x ="+OuterClass.this.x);  //here x is current outer object instance variable
        }
        
        void printString(String str) {
        	System.out.println("Printing string using InnerClass method: "+str);
        }
    }

    //Static Nested Class
    static class StaticNestedClass {
    	String innerField = "inner field";
        void accessMembers(OuterClass outer) {  //passing outer class object as method parameter
            //System.out.println(outerField);   // Compiler error: Cannot make a static reference to the non-static
            System.out.println(outer.outerField); //Static Nested Class can not access outer class instance variable directly here it accessed from method parameter
            System.out.println(staticOuterField); //Static Nested Class can access outer class static variable
            System.out.println(innerField);
        }
    }

    public static void main(String[] args) {
    	
    	
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass(); //outer class reference(outerObject) is must to create inner class object(innerObject)
        innerObject.accessMembers();
        innerObject.shadowTest(50);
        outerObject.printString("Outer class method is called");
        innerObject.printString("Inner class method is called");
        
        

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass(); // outer class reference is NOT required because StaticNestedClass behaves same as any top level class(outer class) @See "TopLevelClass.java" and it's just wrapped inside another class
        staticNestedObject.accessMembers(outerObject);
        
        
        
        
        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        TopLevelClass topLevelObject = new TopLevelClass();        
        topLevelObject.accessMembers(outerObject);                
    }
}
