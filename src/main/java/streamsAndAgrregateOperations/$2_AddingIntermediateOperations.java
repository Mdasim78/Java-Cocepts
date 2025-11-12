package streamsAndAgrregateOperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class $2_AddingIntermediateOperations {
	public static void main(String[] args) {
		
		List<String> strings = List.of("one", "two", "three", "four");
		System.out.println("Original strings: "+strings.toString());
		
		
		/****** Mapping a Stream to Another Stream
		 * Mapping a stream consists of transforming its elements using a function. 
		 * This transformation may change the types of the elements processed by that stream, but you can also transform them without changing their type.
		 * 
		 */
		Function<String, Integer> toLengthFunc = String::length;
		Stream<Integer> stringLengthStream = strings.stream()  							//converted list to stream
													 //.peek(a->System.out.println(a))  //it give preview of each element 
													 .map(toLengthFunc);				//Adding intermediate operation to stream. Here map transforms the element as well as the type of element from string to integer													
		List<Integer> numList = stringLengthStream.collect(Collectors.toList()); 		//adding terminal operation to list -- the stream executes after adding terminal operations only
		System.out.println("String lengths: "+numList);
		
		List<String> stringUppercaseList = strings.stream().map(String::toUpperCase).collect(Collectors.toList()); //Here map transforms the element without transforming the type
		System.out.println("Uppercase strings: "+stringUppercaseList.toString());
		
		IntStream strLengthIntStream = strings.stream().mapToInt(String::length);   //mapToInt -- is a specialized map that returns Intstream
		IntSummaryStatistics statistics = strLengthIntStream.summaryStatistics();
		System.out.println(statistics.toString());
		
		
		
		/*******  Filtering a Stream
		 * Filtering is about discarding some elements processed by a stream with a predicate.
		 * Filtering is done using the filter() method in the Stream API.
		 * Signature: Stream<T> filter(Predicate<? super T> predicate).
		 * Common use case: filtering nulls, specific values, ranges, or objects based on properties.
		 */
		List<String> strings2 = strings.stream()
									   .filter((str)->str.length()>=4)  //we passed the predicate to filter out all the strings <4
									   .collect(Collectors.toList());
		System.out.println("String with length 4 or more: "+strings2.toString());
		
		
		
		
		/******* Flat mapping a Stream to Handle 1:p Relations
		 * flatMap() is used to flatten nested structures (like a Stream of Streams or a List of Lists) into a single Stream.
		 * It’s often used when each element of a stream produces another stream or collection, and you want to process all those inner elements together.
		 * Signature: flatMap(Function<T, Stream<R>> mapper)
		 * Typical use cases: flattening lists, splitting strings, or combining object collections.
		 * Must return a Stream inside the lambda — not a List or Collection.
		 * You can chain multiple flatMap() calls to flatten multiple nesting levels.
		 */
		
		List<List<String>> fruits = List.of(List.of("Apple","Banana"),List.of("Guava", "Pineapple"),List.of("Grapes", "Orange","Dragon fruit"));
		
		//without using flat map
		List<String> allFruitsList = new ArrayList<>();
		fruits.stream().map(list->list).forEach(allFruitsList::addAll);
		System.out.println("without using flat map: "+allFruitsList.toString());		
		//without using flat map
		 Stream<List<String>> allFruitsListStream = fruits.stream(); 								//returned stream of lists
		 Stream<Stream<String>> allFruitsStream = allFruitsListStream.map(List::stream);			//returns stream of stream of fruits
         List<String> allFruits = allFruitsStream.collect(ArrayList::new, (accumulator, innerStream)-> accumulator.addAll(innerStream.collect(Collectors.toList())), List::addAll);
		System.out.println("without using flat map: "+allFruits.toString());
		
		//using flat map
		Stream<List<String>> allFruitsListStream2 = fruits.stream();								//returns the stream of lists
		Stream<String> allFruitsStream2 = allFruitsListStream2.flatMap(list->list.stream());		//flat map converts all the stream of lists to single stream of string
		List<String> allFruits2 = allFruitsStream2.collect(Collectors.toList());					
		System.out.println("using flat map: "+allFruits2.toString());
		
		//using flat map on object 
		class State{
			String stateName;
			String capital;
			
			public State(String stateName, String capital) {
				this.stateName = stateName;
				this.capital = capital;
			}
		}  
		class Country{
			String countryname;
			List<State> state;
			public Country(String countryname, List<State> state) {
				this.countryname = countryname;
				this.state = state;
			}
		}
		
		State s1 = new State("Odisha", "Bhubaneswar");
		State s2 = new State("WestBengal", "Kolkata");
		State s3 = new State("Scotland", "Edinburgh");
		State s4 = new State("England", "London");		
		Country india = new Country("India", List.of(s1,s2));
		Country uk = new Country("UK", List.of(s3,s4));
		List<Country> countries = List.of(india,uk);
		
		//using flat map to get list of all the states and capitals
		List<String> capitals = countries.stream().flatMap(country->country.state.stream()).map(state->state.capital).collect(Collectors.toList());
		System.out.println("using flat map: "+capitals.toString());
		List<String> states = countries.stream().flatMap(country->country.state.stream()).map(state->state.stateName).collect(Collectors.toList());
		System.out.println("using flat map: "+states.toString());
		
		
		
		/******	Using Flatmap and MapMulti to Validate Elements Transformation
		 * 
		 * 	| Feature        | `flatMap()`                                                    | `mapMulti()`                                                         |
			| -------------- | -------------------------------------------------------------- | -------------------------------------------------------------------- |
			| How it works   | Returns a **Stream** for each element, which is then flattened | Takes a **callback (BiConsumer)** to push multiple elements directly |
			| Type signature | `flatMap(Function<T, Stream<R>>)`                              | `mapMulti(BiConsumer<T, Consumer<R>>)`                               |
			| Overhead       | Creates temporary inner streams                                | No temporary streams (faster)                                        |
			| Use case       | Easy and readable                                              | Faster, memory-efficient in high-performance cases                   |

		 */	
		List<String> numStrings = List.of("1", " ", "2", "3 ", "", "3");
		//List<Integer> nums1 = numStrings.stream().map(Integer::parseInt).collect(Collectors.toList()); // will through number format exception
		List<Integer> nums2 = numStrings.stream().flatMap(s->{ 
				try{
					return Stream.of(Integer.parseInt(s));
				}catch(NumberFormatException nfe) {
				}
				return Stream.empty();})        
				.collect(Collectors.toList());
				
		System.out.println(nums2.toString());
		//This use of the flatmap code works well, but it has an overhead: there is one stream created for each element of the stream you need to process.
		
		//to avoid this we can use map multi
		List<Integer> nums3 = numStrings.stream().<Integer>mapMulti((string, consumer)->{
			try {
				consumer.accept(Integer.parseInt(string));
			}catch (NumberFormatException e) {
				//nothing
			}
		}).collect(Collectors.toList());
		System.out.println(nums3.toString());
		
		
		
		
		/**** Removing Duplicates and Sorting a Stream
		 * The Stream API has two methods, distinct() and sorted(), that will simply detect and remove duplicates and sort the elements of your stream.
		 * The distinct() method uses the hashCode() and equals() methods to spot the duplicates. 
		 * The sorted() method has an overload that takes a comparator, which will be used to compare and sort the elements of your stream.
		 * The distinct() method can be used on unbound (infinite) streams, the sorted() method cannot.
		 * 
		 */
		List<Integer> ints = List.of(1, 4, 2, 1, 3, 3);
		List<Integer> distinctInts = ints.stream().distinct().collect(Collectors.toList());
		System.out.println("distinct integers: "+distinctInts.toString());
		List<Integer> sortedInts = ints.stream().sorted().collect(Collectors.toList());
		System.out.println("sorted integers: "+sortedInts.toString());
		
		List<String> strings3 = List.of("one", "two", "three", "four");
		List<String> naturalSort = strings3.stream().sorted().collect(Collectors.toList());
		System.out.println("naturalSort: "+naturalSort.toString());
		List<String> shortestFirst1 = strings3.stream().sorted((String a, String b)-> a.length()-b.length()).collect(Collectors.toList());
		List<String> shortestFirst2 = strings3.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println("shortestFirst1: "+shortestFirst1.toString());
		System.out.println("shortestFirst2: "+shortestFirst2.toString());
		
		
		
		
		/****** Limiting and Skipping the Elements of a Stream
		 * Limiting Elements — limit(n)
			 * Used to take only the first n elements from a stream.
			 * Signature: Stream<T> limit(long maxSize)
			 * Returns a new stream containing at most n elements (in encounter order).
			 * Commonly used for pagination, sampling, or top results.
		 * Skipping Elements — skip(n)
			 * Used to discard the first n elements of a stream.
			 * Signature: Stream<T> skip(long n)
			 * Returns a new stream without the first n elements.
			 * Useful for pagination or skipping processed items.
		 * takeWhile(predicate)
			 * Takes elements from the start of the stream until the predicate becomes false.
			 * Once an element fails the condition, the stream stops — remaining elements are ignored.
		 * dropWhile(predicate)
		 	 * Skips elements from the start of the stream while the predicate is true,then includes all remaining elements
		 */
		List<Integer> ints2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> res1 = ints2.stream()
								 .skip(2)   //skipped first two elements and returned a stream from 3,4,5,6,....
								 .limit(4)	//limit the stream at 3,4,5,6 and then returned the stream
								 .collect(Collectors.toList());
		System.out.println("skip and limit: "+res1.toString());
		
		List<Integer> res2 = ints2.stream()
								  .dropWhile(a->a%5!=0)		// all the elements are dropped till the condition remains true
								  .collect(Collectors.toList());
		System.out.println("dropwhile: "+res2.toString());
		
		List<Integer> res3 = ints2.stream()
								  .takeWhile(a->a%5!=0)		// all the elements are taken till the condition remains true
								  .collect(Collectors.toList());
		System.out.println("takewhile: "+res3.toString());
		
		
		
		
		/****** Concatenating Streams
		 * Stream.concat(stream1, stream2) - Combines both streams in order: elements of stream1 first, then stream2.
		 * This method takes two streams and produces a stream with the elements produced by the first stream, followed by the elements of the second stream.
		 * Both streams must have the same type (Stream<T>).
		 * You can chain concatenations for more streams: Stream.concat(Stream.concat(a, b), c);
		 * Works only with finite streams (infinite ones can hang).
		 *  concat produces a SIZED stream, whereas flatmap does not.
		 * 
		 * 	| Feature          | `Stream.concat()`                     | `flatMap()`                                              |
			| ---------------- | ------------------------------------- | -------------------------------------------------------- |
			| Input            | Two existing streams                  | A stream whose elements themselves contain streams/lists |
			| Combines         | Two whole streams                     | Multiple nested streams                                  |
			| Output           | Single merged stream                  | Flattened stream                                         |
			| Typical Use      | Merging sources                       | Flattening nested collections                            |
			| Number of inputs | Exactly 2                             | Any number (through mapping)                             |
			| Laziness         | Lazy (like all streams)               | Lazy                                                     |
			| Common use case  | Merge `Stream.of(a)` + `Stream.of(b)` | Flatten `List<List<T>>` or object hierarchies            |

		 */
		List<Integer> list0 = List.of(1, 2, 3);
		List<Integer> list1 = List.of(4, 5, 6);
		List<Integer> list2 = List.of(7, 8, 9);
		List<Integer> concatedList = Stream.concat(Stream.concat(list0.stream(), list1.stream()),list2.stream()).collect(Collectors.toList());
		System.out.println("concatedList: "+concatedList.toString());
		
		
		
		/****** Debugging Streams
		 * The Stream API has a method for that: the peek() method. 
		 * This method is meant to be used to debug your data processing pipeline.
		 * You should not use this method in your production code.
		 * This method takes a consumer as an argument that will be invoked by the API on each element of the stream.
		 */
		List<String> strings4 = List.of("one", "two", "three", "four");

		List<String> result =
		   strings.stream()
		          .peek(s -> System.out.println("Starting with = " + s))
		          .filter(s -> s.startsWith("t"))
		          .peek(s -> System.out.println("Filtered = " + s))
		          .map(String::toUpperCase)
		          .peek(s -> System.out.println("Mapped = " + s))
		          .toList();
		System.out.println("result = " + result);
	}
}
