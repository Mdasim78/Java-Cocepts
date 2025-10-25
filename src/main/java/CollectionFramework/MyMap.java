package CollectionFramework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MyMap {
	/***  
	 * IMPORTANT NOTES
	 * A Map is an object that maps keys to values. 
	 * A map cannot contain duplicate keys: Each key can map to at most one value.
	 * Two Map instances are equal if they represent the same key-value mappings (regardless of order).
	 * 3 types: HashMap, TreeMap, and LinkedHashMap
	 * 
	 *  Map Type	    Ordering					Performance						 Allows Null?								Use Case
		-----------------------------------------------------------------------------------------------------------------------------------------
		HashMap	        ❌ No order (unordered)		🔥 Fastest (O(1))				 ✅ Yes (1 null key, many null values)		General-purpose lookup
		LinkedHashMap	✅ Insertion order			⚡ Slightly slower than HashMap  (O(1))	✅ Yes								When you need predictable iteration order
		TreeMap	        ✅ Sorted by key				🐢 Slower 	(O(log n))			 ❌ No null key (but null values allowed)	When you need sorted data
	 					(natural order or custom comparator)
	 
	 
	 ***Collection Views:
	 *The Collection view methods allow a Map to be viewed as a Collection in these three ways:
		keySet — the Set of keys contained in the Map.
		values — The Collection of values contained in the Map. This Collection is not a Set, because multiple keys can map to the same value.
		entrySet — the Set of key-value pairs contained in the Map. The Map interface provides a small nested interface called Map.Entry, the type of the elements in this Set.
	 *The Collection views provide the ONLY means to iterate over a Map.	
	 *Collection views support element removal in all its many forms — remove, removeAll, retainAll, and clear operations, as well as the Iterator.remove operation. and it is also reflected in backing map
	 *Collection views do not support element addition under any circumstances. 
	 *All default Map collection views are backed by the Map, so removal operations are destructive (affect the original Map).
	 *Adding elements directly through the view is not supported.
	 *Modifying entries via Map.Entry.setValue() is allowed and updates the original Map — so that’s also a destructive (mutating) operation.
	 *If you use unmodifiable views (e.g., via Collections.unmodifiableMap()), then none of the operations are destructive because they’re not allowed.
	 *		
	 *Fancy Uses of Collection Views: Map Algebra-->
	 *m1.entrySet().containsAll(m2.entrySet()) --> checks if m2 is a submap of m1 or not
	 *m1.keySet().equals(m2.keySet() --> checks if both map contain same keys or not
	 */
	
	public static void main(String[] args) {
		
		
		/*
		 * Map Interface Basic Operations
		 * cityCountUnsorted.size() --> returns number of key-value mapping present in the map
		 * cityCountUnsorted.put(city, count); -->puts key & value to the map if key is present then replaces the value
		 * cityCountUnsorted.get(city) --> gets the value for the key city if key is not present then returns null
		 * 
		 * Map Interface Bulk Operations
		 * cityCountUnsorted.clear(); //removes all element from the map
		 * cityCountUnsorted2.putAll(cityCountInsertionSorted); //puts all element from cityCountInsertionSorted map to cityCountUnsorted2
		 * 
		 * //Collection Views
		 * The Collection views support element removal in all its many forms — remove, removeAll, retainAll, and clear operations,
		 * Collection views do not support element addition under any circumstances. 
		 * cityCountInsertionSorted.keySet(); //returns all the keys as a set
		 * cityCountInsertionSorted.values(); //returns all the values as a collection not set because values are not unique
		 * Set<Entry<String, Integer>> cityCountEntries = cityCountInsertionSorted.entrySet(); //return set of entry object
		 * while(entryIt.hasNext()) {
			Entry<String, Integer> entry = entryIt.next();
			if(entry.getKey() == "Delhi") entry.setValue(7); //set the value for the given key from the entry
			if(entry.getKey() == "Pune") entryIt.remove(); //remove the specific entry(key,value) from the map
			}
		 */
		
		String[] cities = new String[] {"Bhubaneswar", "Mysore", "Kolkata", "Bangalore", "Puri", "Delhi", "Chennai", "Salepur", "Bangalore", "Pune", "Cuttack", "Pune",  "Cuttack"};
		
		Map<String, Integer> cityCountUnsorted = new HashMap<String, Integer>(); //unsorted
		for(String city:cities) {
			cityCountUnsorted.put(city, cityCountUnsorted.get(city) == null ? 1:cityCountUnsorted.get(city)+1);
		}
		System.out.println("HashMap: "+cityCountUnsorted.toString());
		Map<String, Integer> cityCountSorted = new TreeMap<String, Integer>(cityCountUnsorted); //sorted alphabetically from map cityCountUnsorted
		System.out.println("TreeMap: "+cityCountSorted);
		Map<String, Integer> cityCountInsertionSorted = new LinkedHashMap<String, Integer>(); //insertion sorted
		for(String city:cities) {
			cityCountInsertionSorted.put(city, cityCountInsertionSorted.get(city) == null ? 1:cityCountInsertionSorted.get(city)+1);
		}
		System.out.println("LinkedHashMap: "+cityCountInsertionSorted);		
		System.out.println(cityCountUnsorted.size());
		System.out.println(cityCountUnsorted.equals(cityCountSorted)); // true --> Two Map instances are equal if they represent the same key-value mappings (regardless of order).
	
		////Map Interface Bulk Operations
		cityCountUnsorted.clear(); //removes all element from the map
		Map<String, Integer> cityMap = new TreeMap<String, Integer>();
		cityMap.putAll(cityCountInsertionSorted); //puts all element from cityCountInsertionSorted map to cityCountUnsorted2
		System.out.println(cityMap);
		
		////Collection Views
		Set<String> keys = cityCountInsertionSorted.keySet(); //returns all the keys as a set
		for(String key:keys) System.out.print(key+", ");
		
		Collection<Integer> cityCounts = cityCountInsertionSorted.values();
		System.out.println("\n"+cityCounts.toString());
		
		Set<Entry<String, Integer>> cityCountEntries = cityCountInsertionSorted.entrySet(); 
		//return set of entry object changes to this set like remove,removeAll also reflected in backing map
		Iterator<Entry<String, Integer>> entryIt = cityCountEntries.iterator(); 
		while(entryIt.hasNext()) {
			Entry<String, Integer> entry = entryIt.next();
			if(entry.getKey() == "Delhi") entry.setValue(7); //set the value for the given key from the entry
			if(entry.getKey() == "Pune") entryIt.remove(); //remove the specific entry(key,value) from the map
		}
		System.out.println(cityCountInsertionSorted.toString()); //pune got removed from original map
		for(Entry<String, Integer> entry: cityCountEntries) {
			System.out.println(entry.getKey()+": "+entry.getValue());
			if(entry.getKey() == "Cuttack") entry.setValue(5);  //setting a value while traversing through set
		}
		System.out.println(cityCountInsertionSorted.toString());
	}
}
