package javaBasic;

public class StringNStringBuilder {

	
	public static void main(String[] args) {
		
		//3 ways to create string
		String s1 = new String();
		s1 = "Asim";
		String s2 = "Asim2";
		String s3 = new String("Asim3");
		System.out.println(s1+" "+s2+" "+s3);
		
		//Generally strings are immutable that means we have to store string modifications in a new variable
		s1.toUpperCase();
		System.out.println(s1);  //no changes occured
		String s1Modified = s1.toUpperCase(); //saved modified string in a new variable
		System.out.println(s1Modified);  
		
		System.out.println("---------------------------------------\nS T R I N G   B U I L D E R   C L A S S\n---------------------------------------");
		/***
		 * Method											Description
			append(...)										Appends different data types (String, char, int, Object, etc.) to the end.
			appendCodePoint(int codePoint)					Appends a Unicode code point as one or more chars.
			insert(int offset, ...)							Inserts text/values at a specific position. Works with all data types.
			delete(int start, int end)						Removes characters between start (inclusive) and end (exclusive).
			deleteCharAt(int index)							Removes a single character at the given position.
			replace(int start, int end, String str)			Replaces characters in a range with another string.
			reverse()										Reverses the entire sequence.
			capacity()										Returns current internal buffer capacity (not the string length).
			ensureCapacity(int minCapacity)					Ensures the buffer can hold at least that many chars.
			trimToSize()									Reduces capacity to match the actual string length (saves memory).
			setLength(int newLength)						Changes the length — truncates or pads with null characters.
			length()										Returns the number of characters currently in the builder.
			charAt(int index)								Returns the character at the given index.
			codePointAt(int index)							Returns Unicode code point at the index.
			codePointBefore(int index)						Returns Unicode code point before the index.
			codePointCount(int beginIndex, int endIndex)	Returns number of Unicode code points in a range.
			setCharAt(int index, char ch)					Modifies a character at the given position.
			subSequence(int start, int end)					Returns a CharSequence (like substring but lighter).
			substring(int start)							Returns a new String from the given start to end.
			substring(int start, int end)					Returns substring between indices.
			toString()										Converts the builder to an immutable String.
		 * 
		 */
		
		//StringBuilder class
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Asim4");
		System.out.println(sb1);
		sb1.reverse();
		System.out.println(sb1);
		
		//Strings created using string builder class are mutable that means if we modify a string we don't need to store the modified string in a new variable 
		sb1.append(" Asim");
		System.out.println(sb1);
		
		System.out.println("------------------------\nT E X T    B L O C K S\n------------------------");
		// String written within """ text """ Quote Behaves as text block and we don't need to write \n to make new line
		String textBlock1 = """
				Hello
				Asim
				Here""";
		
	}
}
