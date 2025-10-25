package CollectionFramework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MyCollections {
	
	/***
	 * The methods/operations described here are common for all the collections whether it's a list/set or another kind of Collection like queue/de-queue
	 * 
	 */
public static void main(String[] args) {
	System.out.println("Collections");
	Collection<Integer> c1 = new ArrayList<>();
	Collection<Integer> c2 = new ArrayList<>();
	Collection<Integer> c3 = new ArrayList<>();
	Collection<Integer> c4 = new ArrayList<>();
	
	int[] arr1 = {5, 7, 9, 45, 12};
	for(int i:arr1) {
		c1.add(i);
		if(i%3==0) c2.add(i);
	}
	
	/////////////////methods in collection/////////////////////////////////
	c2.add(78);  //returns-> boolean values based on changes to the collection
	c2.contains(13);  //returns-> boolean values based on changes to the collection
	c1.remove(7);  //returns-> boolean values based on changes to the collection
	c3.isEmpty(); //returns-> boolean values based on changes to the collection
	System.out.println(c1.size()); //returns-> int
	Iterator<Integer> it = c1.iterator(); //returns-> Iterator
	while(it.hasNext()) System.out.print(it.next()+" ");  //it.next() returns next element and places the moves the curse between next and next of next
	
	///////////Collection Interface Bulk Operations
	c3.addAll(c2); //adds all elements from c2 to c3 and returns boolean
	boolean check = c3.containsAll(c2);
	System.out.println("\ncheck1 : "+check); //returns-> boolean
	boolean check2 = c3.removeAll(c1); //removes all the elements from c3 that are also present in c1 
	boolean check3 = c3.removeAll(c4); //collection c3 didn't because c4 is empty change so false
	boolean check4 = c1.retainAll(c2); //removes all elements from c1 except those are also present in c2
	System.out.println("check2 : "+check2+", check3 : "+check3+", check4 : "+check4);
	Iterator<Integer> it2 = c1.iterator();
	while(it2.hasNext()) System.out.print(it2.next()+" ");
	c2.clear(); //removes all elements from c2	
	c1.removeAll(Collections.singleton(null));  //removes all nulls from c1 .....  Collections.singleton(null) returns set conatining null
	//for(int i:nums) System.out.println(i+" ");
	Collection<Integer> c5 = new ArrayList<>(c1); //creates a new ArrayList , initially containing all the elements in c1.
	
	////////////traversing through collections//////////
	//1- using for each
	for(int i:c1) {
		System.out.println(i/5);
		c2.add(i/5);
	}
	//2- using iterator 
	Iterator<Integer> it3 = c2.iterator();
	while(it3.hasNext()) {
		System.out.print(it3.next()+" ");
	}
	
	
	///////////Collection Interface Array Operations
	Object[] array2 = c1.toArray(); //return object array 
	Integer[] nums = c5.toArray(new Integer[0]); //Suppose that c5 is known to contain only integer (perhaps because c is of type Collection<Integer>).
	System.out.println("\nnums length: "+array2.length);
}
}
