package streamsAndAgrregateOperations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
	 * A pipeline is a sequence of aggregate operations.
	 * A pipeline contains the following components:
	 * A source: This could be a collection, an array, a generator function, or an I/O channel.
	 * A stream is a sequence of elements. Unlike a collection, it is not a data structure that stores elements. Instead, a stream carries values from a source through a pipeline.
	 * Zero or more intermediate operations. An intermediate operation, such as filter, produces a new stream. 
	 * A terminal operation, such as forEach, produces a non-stream result, such as a primitive value (like a double value), a collection, or in the case of forEach, no value at all.
	 */
public class $1_CreatingStream {
	public static void main(String[] args) {
		
		//Creating an Empty Stream
		Stream<String> emptyStream = Stream.empty();
		
		//Creating a Stream from a Collection or an Iterator
		List<Integer> numList = List.of(3,5,7,90,35,470,56);
		Set<String> fruitSet = Set.of("Apple","Banana","Kiwi","Guava","Mango");
		Stream<Integer> numStream = numList.stream();
		Stream<String> fruitSetStream = fruitSet.stream();
		
		//will learn about creating stream from iterator later
		
		//Creating a Stream from a Vararg or an Array
		Stream<String> varArgStream = Stream.of("Banana","Guava","Apple","Pinapple");
		String[] fruits = new String[] {"Banana","Guava","Apple","Pinapple"};
		Stream<String> arrayStream = Arrays.stream(fruits);
		
		//Creating a Stream from a Supplier  --> Using a supplier is great if you need to generate constant streams.
		Stream<Double> generatedStream = Stream.generate(()->Math.random()); 		//using generate method and passing supplier. It will create unbounded stream
		List<Double> list = generatedStream.limit(5).collect(Collectors.toList());
		System.out.println(list.toString());
		
		//Creating a Stream from a UnaryOperator and a Seed --> f you need an infinite stream with varying values, then you can use the iterate() pattern.
		Stream<String> iteratedStream = Stream.iterate("+", s->s+"-"); // This pattern works with a seed, which is the first generated element. here + is a seed
		iteratedStream.limit(6).forEach(System.out::println);			//Then it uses a UnaryOperator to generate the next element of the stream by transforming the previous element.
		Stream<Integer> iteratedStream2 = Stream.iterate(0, s->s+1);
		iteratedStream2.limit(10).forEach(a-> System.out.print(a+" "));
		
		//Creating a Stream from a Range of Numbers
		String[] letters = new String[] {"A","B","C","D"};
		List<String> letterList = IntStream.range(0, 10)				//The range() method takes the initial value and the upper bound of the range, excluded
				.mapToObj(index->letters[index % letters.length])
				.collect(Collectors.toList());  
		System.out.println("\n"+letterList.toString());
		
		//Creating a Stream of Random Numbers
		Random random = new Random(0);
		IntStream randomIntStream = random.ints(6, 12, 40);
		randomIntStream.boxed().forEach(a->System.out.print(a+","));
		
		//Creating a Stream from the Characters of a String
		
		//Creating a Stream from the Lines of a Text File
		
		//Creating a Stream from a Regular Expression
		
		//Creating a Stream with the Builder Pattern
		
		//Creating a Stream on an HTTP Source
		
	}
	
}
