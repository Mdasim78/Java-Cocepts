package nestedClass;
/**
 * Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a class at the same time. 
 * They are like local classes except that they do not have a name. Use them if you need to use a local class only once.
 * While local classes are class declarations, anonymous classes are expressions, which means that you define the class in another expression. 
 * 
 * The anonymous class expression consists of the following:
	1-The new operator
	2-The name of an interface to implement or a class to extend. In this example, the anonymous class is implementing the interface HelloWorld.
	3-Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression. 
	Note: When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in this example.
	
  *	Because an anonymous class definition is an expression, it must be part of a statement. 
	In this example, the anonymous class expression is part of the statement that instantiates the frenchGreeting object. (This explains why there is a semicolon after the closing brace.)
	
 *Accessing Local Variables of the Enclosing Scope, and Declaring and Accessing Members of the Anonymous Class:----->
	An anonymous class has access to the members of its enclosing class.
	An anonymous class cannot access local variables in its enclosing scope(method) that are not declared as final or effectively final.
	Like a nested class, a declaration of a type (such as a variable) in an anonymous class shadows any other declarations in the enclosing scope that have the same name. See Shadowing for more information.
	You cannot declare static initializers or member interfaces in an anonymous class.
	An anonymous class can have static members provided that they are constant variables.

 *Note that you can declare the following in anonymous classes:
	Fields
	Extra methods (even if they do not implement any methods of the supertype)
	Instance initializers
	Local classes
	However, you cannot declare constructors in an anonymous class.

 */
public class HelloWorldAnonymousClasses {
	
	interface HelloWorld {                                     //interface defined within a class--> inner interface
        public void greet();
        public void greetSomeone(String someone);
    }
  
    public void sayHello() {									//method of the class HelloWorldAnonymousClasses
        
        class EnglishGreeting implements HelloWorld {			// local class which implements interface and it's abstract methods 
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }
      
        HelloWorld englishGreeting = new EnglishGreeting();		//creating object of local class with parent reference
        
        HelloWorld frenchGreeting = new HelloWorld() {			//Anonymous class which implements HelloWorld interface and instantiate object using parent class/interface reference
            String name = "tout le monde";
             public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };														//end of anonymous class expression
        
        HelloWorld spanishGreeting = new HelloWorld() {			//Anonymous class which implements HelloWorld interface and instantiate object using parent class/interface reference
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };														//end of anonymous class expression
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp =
            new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }            
}
