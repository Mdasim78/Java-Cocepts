package CollectionFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MySet {
	
	/***  
	 * IMPORTANT NOTES
	 *  cannot contain duplicate elements
	 *  Allows only one null except TreeSet.
	 *  They don’t allow indexing (like a list) so we can't get values in a set using index so only ways to get values from set are using loop, iterator or converting to arrays or stream
	 *  They are not synchronized
	 *  Two Set instances are equal if they contain the same elements.
	 *  3 types: HashSet, TreeSet, and LinkedHashSet.
	 *  
	 *  Feature						HashSet			LinkedHashSet					TreeSet
	 *  ---------------------------------------------------------------------------------------------
		Order						Unordered		Insertion order					Sorted (ascending)
		Underlying Structure		Hash table		Hash table + Linked list		Red-Black Tree
		Speed (add/search/remove)	O(1) average	O(1) average					O(log n)
		Allows null?				✅ Yes (1)		✅ Yes (1)						❌ No
		Duplicate allowed?			❌ No			❌ No							❌ No
		Maintains insertion order?	❌ No			✅ Yes							❌ (sorted order instead)
		Use case					Fast lookup		Predictable iteration order		Sorted data
	 *  
	 */
	
	public static void main(String[] args) {
		String str = "java FindDups i came i saw i left";
		Set<String> set1 = new HashSet<String>();
		for(String word:str.split(" ")) set1.add(word);
		/*
		 * Set Interface Basic Operations :-->
		 * set1.size()
		 * set1.add("hello"); --> return true if set got changed after operation else false
		 * set1.add("hello"); --> return false because it's present already so set remain unaltered
		 * set1.contains("python");
		 * set1.remove("java"); -->return true if set got changed after operation else false
		 * 
		 * Set Interface Bulk Operations :-->
		 * s1.containsAll(s2) — returns true if s2 is a subset of s1. (s2 is a subset of s1 if set s1 contains all of the elements in s2.)
		 * s1.addAll(s2) — transforms s1 into the union of s1 and s2. (The union of two sets is the set containing all of the elements contained in either set.)
		 * s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2. (The intersection of two sets is the set containing only the elements common to both sets.)
		 * s1.removeAll(s2) — transforms s1 into the (asymmetric) set difference of s1 and s2. (For example, the set difference of s1 minus s2 is the set containing all of the elements found in s1 but not in s2.)
		 * Object[] array2 = set2.toArray(); --> convert set to object array
		 * String[] array3 = set2.toArray(new String[0]); --> convert set to array of string type
		 */
		
		//Set Interface Basic Operations
		System.out.println(set1.toString());
		System.out.println("Size of set1: "+set1.size());
		System.out.println(set1.add("hello")); //return true
		System.out.println(set1.add("hello")); //return flase
		set1.contains("python");
		set1.remove("java");
		System.out.println("set1: "+set1.toString());
		Set<String> set2 = new HashSet<String>();
		for(String word: str.split(" ")) {
			if(word.length()>=4) set2.add(word);
			if(word.length()%2 !=3) set1.remove(word);
		}
		System.out.println("set1: "+set1.toString());
		System.out.println("set2: "+set2.toString());
		
		//Set Interface Bulk Operations
		set2.add("came");
		System.out.println("set1: "+set1);
		set2.removeAll(set1);
		System.out.println("set1: "+set1);
		set1.retainAll(set2);
		//set2.addAll(set2);
		System.out.println(set2);
		System.out.println(set1.equals(set2));
		Object[] array2 = set2.toArray();
		String[] array3 = set2.toArray(new String[0]);
		System.out.println(Arrays.toString(array3));
	}
}
