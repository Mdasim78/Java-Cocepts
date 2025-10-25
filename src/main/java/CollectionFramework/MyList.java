package CollectionFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyList {
	/***  IMPORTANT NOTES
	 * A List is an ordered Collection (sometimes called a sequence). 
	 * Lists may contain duplicate elements. 
	 * Allows any number of null elements.
	 * Two List objects are equal if they contain the same elements in the same order.
	 * 2 types: ArrayList, LinkedList
	 * 
	 * The methods/operations described here are specific to List
	 * for common collection methods @see MyCollections.java
	 * 
	 */
	
	public static void main(String[] args) {
		List<String> cityList = new ArrayList<String>();
		for(String city:new String[]{"Cuttack","Bhubaneswar","Delhi","Kolkata","Bangalore"}) cityList.add(city);
		
		/*  METHOD HIGHLIGHTS
		 * 
		 * Positional Access and Search Operations
		 * 	cityList.size(); //get the list size
		 *  cityList.get(2);
		 *  cityList.set(5, "Mumbai"); //set method replaces existing the element using index and returns existing old value but can not add new element
		 *  cityList.indexOf("Mumbai");
		 *	cityList.lastIndexOf("Kolkata");
		 *  cityList.add("Cuttack"); //always add element to the end
		 *	cityList.remove("Cuttack"); //always removes the first occurrence and returns the removed value
		 *	cityList.remove(index); //always removes the first occurrence and returns the removed value
		 *  cityList2.add(4, "Mumbai"); //add new element to current position and Shifts the element currently at that position(if any) and any subsequent elements to the right (adds one to theirindices).
		 *  cityList2.addAll(4, cityList); //adds all the elements from collection->citylist to the list starting from the given index
		 *  
		 *  * ListIterator
		 *  ListIterator<String> li1 = cityList2.listIterator(); //returns list iterator and keeps the cursor position at the beginning
		 *	ListIterator<String> li2 = cityList2.listIterator(4); //returns list iterator and keeps the cursor position between index 3 & 4
		 *	li2.hasPrevious() -> checks if previous element is present or not 
		 *	li2.previous() ->  return previous element and moves the cursor left by 1 element
		 *	li2.hasNext() -> checks if next element is present or not 
		 *	li2.next() -> return next element and moves the cursor right by 1 element
		 *	li2.previousIndex() -> returns previous element index
		 *	li1.nextIndex()-> returns next element index
		 *	li2.set("Mysore"); //The set method overwrites the last element returned by next() or previous() with the specified element.
		 *	li1.add("Pune"); //The add method inserts a new element into the list immediately before the current cursor position.
		 *
		 *	*Range-View Operation
		 *	
		 */
		
		System.out.println("---------------POSITIONAL ACCESS AND SEARCH---------------");
		cityList.get(2);
		cityList.add("Hyderabad"); //from collection @see MyCollections.java
		try {
			System.out.println("last index: "+(cityList.size()-1));
			cityList.set(6, "Mumbai"); //will give error because index 6 does not exist
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			cityList.set(5, "Mumbai");  //set method replaces existing the element using index and returns existing old value but can not add new element
		}
		System.out.println(cityList.indexOf("Mumbai"));
		System.out.println(cityList.lastIndexOf("Kolkata"));
		cityList.add("Cuttack"); //always add element to the end
		cityList.remove("Cuttack"); //always removes the first occurrence
		System.out.println(cityList.toString());
		
		//Two List objects are equal if they contain the same elements in the same order.
		List<String> cityList2 = new ArrayList<String>(cityList);
		System.out.println(cityList2.equals(cityList));  //true
		cityList2.add(4, "Mumbai"); 
		System.out.println(cityList2.equals(cityList)); //false
		
		cityList2.addAll(4, cityList); //adds all the elements from collection->citylist to the list starting from the given index
		System.out.println(cityList2.toString());
		
		//ListIterators
		System.out.println("---------------LIST ITERATOR---------------");
		ListIterator<String> li1 = cityList2.listIterator(); //returns list iterator and keeps the cursor position at the beginning
		ListIterator<String> li2 = cityList2.listIterator(4); //returns list iterator and keeps the cursor position between index 3 & 4
			while(li2.hasPrevious()) {  
				String city = li2.previous();
				System.out.print(li2.previousIndex()+" : "+city+", ");
				if(city.equals("Delhi")) {
					li2.set("Mysore"); //replaces current element
					
				}
				
			}
			System.out.println("\n"+cityList2);
			while(li1.hasNext()) {  
				int index = li1.nextIndex();
				
				String city = li1.next();					
				if(city.equals("Mumbai")) {
					System.out.print(index+" : "+city+", ");
					
					li1.remove();
					li1.add("Pune"); //The add method inserts a new element into the list immediately before the current cursor position.
				}
			}
			System.out.println("\n"+cityList2);
			
			//Range-View Operation
			System.out.println("---------------RANGE VIEW OPERATION---------------");
			List<String> cityList3 = cityList2.subList(3, 7); //As the term view implies, the returned List is backed up by the List on which subList was called, so changes in the former are reflected in the latter.
			System.out.println(cityList3.toString());
			
			/*
			  	Now you modify the original list structure (adding/removing elements outside the sublist).
				This breaks the structural integrity between cityList2 and cityList3.
				
				⚠️ What happens next:
				The next time you try to access cityList3, Java will throw: java.util.ConcurrentModificationException
				Why?
				Because the sublist view (cityList3) expects the original list (cityList2) to remain structurally unchanged — same size, same modCount (internal version counter).
				When you add or remove from cityList2 directly, it invalidates the subList view.
				
				Operation						Effect on subList					Safe?
				set()							Reflects in both					✅ Yes
				add() / remove() in parent		Breaks link							❌ No
				add() / remove() in sublist		Reflects in parent (within range)	✅ Yes
				add() / remove() outside range	❌ ConcurrentModificationException	
				new ArrayList<>(subList)		Independent copy					✅ Safe
			 */
			//cityList2.add(4, "Chennai");  // uncomment this to get exception
			cityList3.add(3, "Chennai");
			cityList2.set(4, "Puri");
			cityList3.set(4, "Salepur");
			System.out.println( cityList3.toString());
			System.out.println( cityList2.toString());
			System.out.println(cityList3.indexOf("Bangalore")+ " "+cityList2.indexOf("Bangalore"));
			cityList3.subList(2, 5).clear(); //clears elements from sublist of cityList3 subsequently  from cityList3 & cityList2
			System.out.println( cityList3.toString());
			System.out.println( cityList2.toString());
	}
}
