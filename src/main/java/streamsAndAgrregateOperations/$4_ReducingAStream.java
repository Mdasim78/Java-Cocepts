package streamsAndAgrregateOperations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/***
 * Reduction is a terminal operation which combines all elements of a stream into a single result.
 * Example results: sum, product, min, max, concatenated string, etc.
 * Achieved using the reduce() method (a terminal operation).
 * 	| Signature                                                                                       | Description                                |
	| ----------------------------------------------------------------------------------------------- | ------------------------------------------ |
	| `Optional<T> reduce(BinaryOperator<T> accumulator)`                                             | Reduces elements without an initial value. |
	| `T reduce(T identity, BinaryOperator<T> accumulator)`                                           | Uses an **identity** (starting value).     |
	| `<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)` | Used for **parallel streams** (advanced).  |

 */
public class $4_ReducingAStream {
	public static void main(String[] args) {
		List<Integer> ints = List.of(3, 6, 2, 1);
		
		//Reducing with an Identity Element
		int sum1 = ints.stream().reduce(5,(a, b)->a+b);
		System.out.println("sum with an initial value 5: "+sum1);									//return int and adds identity/initial value
		int sum2 = ints.stream().reduce(0,(a, b)->a+b);
		System.out.println("sum with an initial value 0: "+sum2);	
		
		//Reducing without an Identity Element
		Optional<Integer> sum3 = ints.stream().reduce((a,b)->a+b);   //return optional int
		if(sum3.isPresent()) System.out.println("sum without an initial value: "+sum3.orElseThrow());
		
		//Fusing Mapping and Reduction in one Method  -- it is used when we need to transform and reduce simultaneously but we can do it separately by calling map and reduce subsequently
		List<String> strings = List.of("one", "two", "three", "four","five");
		int sumStrLength = strings.stream().reduce(0,(sum,str)->sum+str.length(), Integer::sum);  
		System.out.println("transformation and reduction simultaneously: "+sumStrLength);
		//here transformation/mapping and reduction occur at the same time  by ->>>  (sum,str)->sum+str.length()
		//Integer::sum  ->>>> it does nothing here & it will be useful in parallel stream see below example
		int sumStrLength2 = strings.parallelStream().reduce(0,(sum,str)->sum+str.length(), Integer::rotateLeft); 
		System.out.println(sumStrLength2);
	}
}
