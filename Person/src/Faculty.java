
public class Faculty extends Employee {

	public static void main(String[] args) {
		new Faculty(); // invokes the faculty no-arg constructor
	}
	
	
	public Faculty() {
		System.out.println("4 - Faculty constructor");
	}
}

/* print out
 * 1 - Person
 * 2 - Employee overloaded constructor
 * 3 - Employee no-args constructor
 * 4 - Faculty constructor
 * */
