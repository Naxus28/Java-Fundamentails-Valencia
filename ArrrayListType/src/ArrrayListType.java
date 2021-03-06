
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class ArrrayListType {

	public static void main(String[] args) {
		/* array list allows to add any number of elements to the array (size is not fixed like a common array)
		 * used to store objects of a certain type--cannot be used to store primitives--
		 * ArrayList is a generic class with a generic type E
		 *  E is normally replaced with a concrete class
		 */ 
		ArrayList<String> cities = new ArrayList<String>(); //new ArrayList<>() is valid as well since Java 7
		cities.add("Orlando");
		cities.add("Miami");
		cities.add("Winter Park");
		cities.add("Winter Garden");
		cities.add("Jacksonville");
		cities.add("Oviedo");
		System.out.println(cities); // [Orlando, Miami]
		System.out.println(cities.get(0));
		cities.set(1, "Gainesville");
		System.out.println(cities);
		cities.remove(0);
		cities.remove("Winter Garden");
		System.out.println(cities);
		System.out.println(cities.contains("Miami"));
		System.out.println(cities.contains("Gainesville"));
		System.out.println(cities.toString()); // same as "cities"
		System.out.println(cities.size()); // note that simple array has a "length" property and ArrayList has a "size" method
		
		ArrayList<Date> dates = new ArrayList<>(); // no need to specify the array type in the constructor
		dates.add(new Date());
		System.out.println(dates);
		
		
		// ArrayList<int> numbers = new ArrayList<>(); doesn't compile because the type is a primitive
		
		ArrayList<Integer> numbers = new ArrayList<>(); // this compiles because we are using the Integer object type
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		System.out.println(numbers);
		
		
		// USEFUL METHODS
		
		// sort
		Collections.sort(cities); // sort lists
		System.out.println(cities);
		
		// array to list
		String[] colors = {"red", "green", "blue"};
		ArrayList<String> colorsList = new ArrayList<>(Arrays.asList(colors)); //Arrays.asList converts array to list
		System.out.println(colorsList instanceof ArrayList); // true
		
		
		// list to array 
		ArrayList<String> list = new ArrayList<>(); 
		list.add("item");
		list.add("item");
		list.add("item");
		
		String[] array= new String[list.size()]; // creates new array with list's size
		list.toArray(array); // toArray copies content from list to array
		System.out.println(array[0]); // item
		
		
		// max and min
		Integer[] numArray = {3, 5, 34, 56, 76, 87, 23};
		ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(numArray)); // converts Integer array to list
		System.out.println(Collections.max(numList)); // 87
		System.out.println(Collections.min(numList)); // 3
		
		// shuffle
		Collections.shuffle(numList);
		System.out.println(numList);
		
	}

}
