
public class Strings {

	public static void main(String[] args) {
		String str = "stringing";
		
		// common static methods
		System.out.println(str.charAt(1)); // char at index -- t
		System.out.println(str.indexOf("r")); // index of char -- 2
		System.out.println(str.indexOf("ing")); // index of substring -- 3
		System.out.println(str.lastIndexOf("g")); // index of char -- 8
		System.out.println(str.substring(2, 5)); // substring -- rin
		System.out.println(str.length()); // 9
		
		// common ways to create a string
		String str1 = new String("This is a string."); // creates obj--too verbose
		String str2 = "This is a string."; //creates obj--preferred
		
		// string from chars
		char[] charArray = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 's', 't', 'r', 'i', 'n', 'g', '.'};
		String str3 = new String(charArray);
		System.out.println(str3); // This is a string.
		
		// immutability--strings are immutable objects
		String str4 = "some string";
		str4 = "some new string";
		
		// although "str4" points to "some new string", the string "some string" that "str4" previously pointed to 
		// still exists in memory although it cannot be accessed anymore--it is unreferenced by the JVM but it is not changed
		System.out.println(str4); // some new string
		
		// interned strings
		String str5 = "another string";
		String str6 = "another string";
		String str7 = new String("another string");
		System.out.println(str5==str6);// true--string is interned for better performance
		System.out.println(str5==str7);// false--strings point to different objects
		
		// string objects have replace methods but they still don't change the string, only create a new pointer to the new string
		System.out.println("Hello".replace('e', 'a'));
		
		// string to array
		char[] chars = "Java".toCharArray();
		System.out.println(chars[1]); // a 
		
		char[] chars1= {'s', 't', 'r', 'i', 'n', 'g'};
		System.out.println(chars1[2]); // r
		
		
		// string from array
		String str8 = new String(new char[] {'J', 'a', 'v', 'a'});
		System.out.println(str8); // Java
		
		String str9 = String.valueOf(new char[] {'J', 'a', 'v', 'a'});
		System.out.println(str9); // Java--using valueOf
		
		
		// formatting strings
		String s = String.format("%7.2f%6d%-4s", 45.556, 14, "AB");
		System.out.println(s);//     45.56    14AB 
		
		// same as 
		System.out.printf("%7.2f%6d%-4s", 45.556, 14, "AB"); // printf

	}
}
