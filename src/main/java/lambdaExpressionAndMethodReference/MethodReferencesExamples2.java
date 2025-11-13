package lambdaExpressionAndMethodReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class MethodReferencesExamples2 {
	
	@FunctionalInterface
	interface SquareCalculator{
		int findSquare(int a); 											//functional interface
	}
	
	@FunctionalInterface
	interface SortedFruitFactory<T>{
		T sortCities(Comparator<String> comparator); 					//functional interface
	}
	
	
	public static void findSquare1(int a) {
		SquareCalculator sc = y->y*y;									//functional interface implementation using lambda
		System.out.println(sc.findSquare(a));
	}
	
	public static void findSquare2(int a, SquareCalculator sc) {
		System.out.println(sc.findSquare(a));							//no implementation but just calling abstract method in another method
	}
	
	public static int findSquare3(int a) {								//existing method static
		return a*a;
	} 
	
	public int findSquare4(int a) {										//existing method non static
		return a*a;
	}
	
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
	        
	    DEST result = collectionFactory.get();
	    for (T t : sourceCollection) {
	        result.add(t);
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		findSquare1(5);													// lambda inside method
		findSquare2(6, a->a*a);                                     	//passing the implementation during method call using lambda
		findSquare2(7, MethodReferencesExamples2::findSquare3);			//method reference calls an existing static method as an implementation
		findSquare2(9, new MethodReferencesExamples2()::findSquare4);	//method reference calls an existing non static method as an implementation
		
		
		
		
		List<String> fruites = List.of("papaya", "apple", "banana", "mango", "guava", "kiwi", "orange","pineapple", "grapes", "watermelon", 
				"strawberry", "mango", "grapes");  //creates immutable list
		System.out.println("original fruit list: "+fruites.toString());
		//cities.sort((a,b)->a.compareTo(b)); 							// -->this will give error because this list is immutable
		
		Set<String> uniqueFruites = MethodReferencesExamples2.<String, List<String>, Set<String>>transferElements(fruites, TreeSet::new);	
		//TreeSet::new is a constructor reference.It automatically matches any functional interface whose abstract method signature matches one of the TreeSet constructors.
		System.out.println("Unique fruites: "+uniqueFruites.toString());
		
		// Custom comparator: sort strings by length
		Comparator<String> lengthComparator = Comparator.comparingInt(a->a.length());
		Comparator<String> lengthComparator2 = Comparator.comparingInt(String::length); //same as above --> Reference to an instance method of an arbitrary object of a particular type
		// Custom comparator: sort strings by length and then natural order
		Comparator<String> lengthAndNaturalOrderComparator =Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder());
		List<String> fruitList = new ArrayList<String>();
		SortedFruitFactory<TreeSet<String>> sortedFruitFactory = TreeSet::new;
		TreeSet<String> sortedFruites = sortedFruitFactory.sortCities((a,b)->a.length()-b.length()); //only fruits with unique lengths present
		for(String fruit: fruites) {
			sortedFruites.add(fruit);
			fruitList.add(fruit);
		}
		System.out.println("fruites with unique length: "+sortedFruites.toString());		
		fruitList.sort(lengthComparator2);
		System.out.println("length sorted and maintains insertion order: "+fruitList.toString());
		fruitList.sort(lengthAndNaturalOrderComparator);
		System.out.println("length sorted and maintains natural order: "+fruitList.toString());
		
	}
}
