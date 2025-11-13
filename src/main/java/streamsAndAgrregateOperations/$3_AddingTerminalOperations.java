package streamsAndAgrregateOperations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**** Calling a Terminal Operation on a Stream
 * A terminal operation is the final step in a Stream pipeline.
 * It triggers the actual processing of data in the stream.
 * After a terminal operation, the stream cannot be reused.
 * Terminal operations return a non-stream result (e.g., number, list, boolean, etc.).
 * Without a terminal operation, no processing actually happens — streams are lazy.
 * 
 * 	| Category                            | Methods                                   | Description                                             |
	| ----------------------------------- | ----------------------------------------- | ------------------------------------------------------- |
	| **Collection & Reduction**          | `collect()`, `reduce()`                   | Combine elements into a single result (list, sum, etc.) |
	| **Iteration**                       | `forEach()`, `forEachOrdered()`           | Perform an action for each element                      |
	| **Matching**                        | `anyMatch()`, `allMatch()`, `noneMatch()` | Check if elements match a condition                     |
	| **Finding**                         | `findFirst()`, `findAny()`                | Retrieve an element (optional result)                   |
	| **Counting**                        | `count()`                                 | Returns the number of elements                          |
	| **Min/Max**                         | `min()`, `max()`                          | Find smallest/largest element (via comparator)          |
	| **Aggregation (Primitive Streams)** | `sum()`, `average()`                      | Numeric calculations (e.g., `IntStream`)                |

 */
public class $3_AddingTerminalOperations {
	public static void main(String[] args) {
		Collection<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

		//to learn more about reduce() operation @see $4_ReducingAStream.java 
		//you should avoid using the reduce() method. you should use this reduce() method as a last resort, only if you have no other solution.
		
		/*** Counting the Elements Processed by a Stream ***/
		long count = strings.stream().count();
		System.out.println("string count: "+count);
		long count2 = strings.stream().filter(s->s.length()>=5).count(); //returns count of all string with length>=5.
		System.out.println("string with length>=5 count: "+count2);
		
		
		/*** Consuming Each Element One by One ***/
		strings.stream().filter(s->s.length()>=5).map(String::toUpperCase).forEach(System.out::println); //printing all string with length>=5.
		
		
		/*** Collecting Stream Elements in a Collection, or an Array ***/
		//Collecting in a Plain ArrayList
		List<String> upperCaseList = strings.stream().map(String::toUpperCase).collect(Collectors.toList()); //creates mutable list
		upperCaseList.sort(Comparator.naturalOrder());    
		System.out.println("upperCaseList: "+upperCaseList);
		
		//Collecting in an Immutable List
		List<String> immutableList1 = strings.stream().map(String::toUpperCase).toList(); 	//creates immutable list
		List<String> immutableList2 = strings.stream().map(String::toUpperCase).collect(Collectors.toUnmodifiableList());  //creates immutable list
		//immutableList1.sort(Comparator.naturalOrder());  //throws exception because list is immutable
		System.out.println("immutableList: "+immutableList1);
		
		//Collecting in a custom List
		List<String> mmutableCustomList = strings.stream().map(String::toUpperCase).collect(Collectors.toCollection(LinkedList::new)); //creates mutable list
		mmutableCustomList.sort(Comparator.naturalOrder());
		System.out.println("mmutableCustomList: "+mmutableCustomList.toString());
		
		//Collecting in a Set
		Collection<String> strings2 = List.of("one", "two", "three", "four", "five", "six", "seven","two", "three", "four");
		Set<String> set = strings2.stream().collect(Collectors.toSet());
		System.out.println("set: "+ set);
		Set<String> set2 = strings2.stream().collect(Collectors.toCollection(TreeSet<String>::new));
		System.out.println("TreeSet: "+ set2);
		
		//Collecting in a Array
		String[] strArray = strings.stream().toArray(String[]::new);
		System.out.println("string Array: "+Arrays.toString(strArray));
		
		
		/*** Extracting the Maximum, the Minimum & average of a Stream ***/
		Optional<String> longest = strings.stream().max(Comparator.comparing(String::length));
		System.out.println("Longest string: "+longest.orElseThrow());
		
		Optional<String> smallest = strings.stream().min(Comparator.comparing(String::length));
		System.out.println("smallest string: "+smallest.orElseThrow());
		
		OptionalDouble avgLength = strings.stream().mapToInt(String::length).average();
		System.out.println("avgLength: "+avgLength);
		
		
		/*** Finding an Element in a Stream ***/
		List<String> fruits = List.of("papaya", "apple", "banana", "mango", "guava", "kiwi", "orange","pineapple", "grapes", "watermelon", 
				"strawberry", "mango", "grapes");
		Optional<String> first = fruits.stream().filter(s->s.length()==5).findFirst();
		Optional<String> any = fruits.stream().filter(s->s.length()==5).findAny();
		System.out.println("first: "+first.orElseThrow());
		System.out.println("any: "+any.orElseThrow());
		//the difference is visible if stream is parallel or unordered
		Optional<String> first2 = fruits.stream().parallel().filter(s->s.length()==5).findFirst();
		Optional<String> any2 = fruits.stream().parallel().filter(s->s.length()==5).findAny();
		System.out.println("first2: "+first2.orElseThrow());
		System.out.println("any2: "+any2.orElseThrow());
		
		
		/*** Checking if the Elements of a Stream Match a Predicate ***/
		//isPresent()
		boolean isPresent = fruits.stream().parallel().filter(s->s.length()>10).findFirst().isPresent();
		System.out.println("checking if string with length>10 present: "+isPresent);
		//anyMatch(predicate)
		boolean anyMatch = fruits.stream().parallel().anyMatch(s->s.length()==10);
		System.out.println("anyMatch: "+anyMatch);
		boolean allMatch = fruits.stream().parallel().allMatch(s->s.length()>3);
		System.out.println("allMatch: "+allMatch);
		boolean noneMatch = fruits.stream().parallel().noneMatch(s->s.length()>10);
		System.out.println("noneMatch: "+noneMatch);
	}
}
