import java.io.FileNotFoundException;
import java.io.FileReader;

public class CatchExceptions {

	public static void main(String[] args) {
		/**
		 * ArrayIndexOutOfBoundsException
		 */
		String [] names = {"Paul", "Ringo", "John"};
		try {
			String harry = names[3];
		} catch (ArrayIndexOutOfBoundsException aibe) {
			System.out.println(aibe.toString());
		}
		
		
		/**
		 * ClassCastException
		 */	
		Object o = new Object();
		try {
			String d = (String)o;
		} catch (ClassCastException cce) {
			System.out.println(cce.toString());
		}
		
		
		/**
		 * StringIndexOutOfBoundsException
		 */	
		String s = "abc";
		try {
			System.out.println(s.charAt(3));
		} catch (StringIndexOutOfBoundsException sobe) {
			System.out.println(sobe.toString());
		}
		
		
		/**
		 * IllegalArgumentException
		 */
		try {
			takesPositiveOnly(-1);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		
		/**
		 * NullPointerException
		 */
		Object n = null;
		
		try {
			System.out.println(n.toString());
		} catch (NullPointerException npe){
			System.out.println(npe.toString());
		}
		
		
		/**
		 * NumberFormatException
		 */
		try {
			int num = new Integer("abc");
		} catch (NumberFormatException nfe){
			System.out.println(nfe.toString());
		}
		
		
		/**
		 * FileNotFoundException
		 */
		try {
			FileReader fileReader = new FileReader("somefileThatDoesNotExist");
		} catch (FileNotFoundException fnfe){
			System.out.println(fnfe.toString());
		}
		
		/**
		 * NegativeArraySizeException
		 */
		try {
			int[] negArray = new int[-1];
		} catch (NegativeArraySizeException nase){
			System.out.println(nase.toString());
		}
		
		/**
		 * StackOverflowError
		 */
		try {
			callRecursive();
		} catch(StackOverflowError soe) {
			System.out.println(soe.toString());
			System.out.println(soe.getClass());
		}
		
		/**	
		 * ClassNotFoundException
		 */
		try {
			Class.forName("InexistentClass");
		} catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe.toString());
		}
		
		
		
	}
	
	/**
	 * 
	 * @param i
	 * @throws IllegalArgumentException
	 */
	public static void takesPositiveOnly(int i) 
			throws IllegalArgumentException {
		if (i <= 0) {
			throw new IllegalArgumentException("Argument needs to be a positive integer.");
		}
		
		System.out.println("Your number is " + i);
	}
	
	/**
	 * @throws StackOverflowError
	 */
	private static void callRecursive() throws StackOverflowError {
		String s = new String();
		callRecursive();
	}

}
