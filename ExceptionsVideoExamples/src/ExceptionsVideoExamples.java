import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsVideoExamples {

	public static void main(String[] args) {
		exceptionOne();
		
		exceptionTwo();
		System.out.println("In main"); // If there is an unhandled exception on lower levels of this stack call, this statement will not be printed
		
		exceptionThree();
		
		exceptionFour();
		
		exceptionFive();
		
		exceptionSix();
		
		exceptionSeven();
	}
	
	/**
	 * first exception example
	 */
	public static void exceptionOne() {
		int a, b = 6;
		 
		 try {
			 a = b / -1;
		 } catch(ArithmeticException ae) {
			 System.out.println("Arithmetic Exception in exceptionOne: " + ae.getMessage());
		 }
	}
	
	/**
	 * second exception example -- exception handled where it first occurs on the stack
	 */
	public static void exceptionTwo() {
		System.out.println("\nIn exceptionTwo");
		exceptionTwoStackOne(); // If there is an unhandled exception on lower levels of this stack call, this statement will not be printed
		System.out.println("Not printed if there is an unhandled excpetion in exceptionTwoStackOne");
	}
	
	public static void exceptionTwoStackOne() {
		int num;
		System.out.println("In exceptionTwoStackOne");
		
		/**
		 * num = 1 / 0
		 * This line throws an exception. If the exception is not handled no code will be executed after this line; 
		 * this includes code below the function callers (written in functions up in the stack) that invoked "exceptionTwoStackOne": exceptionTwoStackOne() and exceptionTwo()
		 */

		// handled exception
		try {
			num = 1 / 0;
			System.out.println("This line doesn't get executed");
		 } catch (ArithmeticException ae) {
			 System.out.println("Arithmetic Exception in exceptionTwoStackOne: " + ae.getMessage());
		 }
	}
	
	
	/**
	 * third exception example -- exception handled on the caller of the function that throws the exception
	 */
	public static void exceptionThree() {
		System.out.println("\nIn exceptionThree");
		
		// exception can be handled here since this is the caller of the function that throws the exception
		try {
			exceptionThreeStackOne(); 
			System.out.println("This line doesn't get executed");
		 } catch (ArithmeticException ae) {
			 System.out.println("Arithmetic Exception in exceptionThree: " + ae.getMessage());
		 }
	}
	
	public static void exceptionThreeStackOne() {
		System.out.println("In exceptionThreeStackOne");
		
		/**
		 * num = 1 / 0
		 * This line throws an exception. If the exception is not handled no code will be executed after this line; 
		 * this includes code below the function callers (written in functions up in the stack) that invoked "exceptionTwoStackOne": exceptionTwoStackOne() and exceptionTwo()
		 */

		// unhandled exception -- handled up the call stack
		int num = 1 / 0;
		System.out.println("This line doesn't get executed");
	}
	
	/**
	 * fourth exception example -- multiple catch blocks in inverse hierarchical order (more specific exceptions--child classes--to more generic exceptions--parent classes)
	 * if parent exception types are placed before their children in the try/catch block the code doesn't compile 
	 * (it wouldn't make sense since the parent would catch any exception of its children's types). 
	 * 
	 * i.e. 
	 * 
	 * catch (Exception e) {
	 *    // some code
	 * } catch (ArithmeticException ae) {
	 *   // some code that will never run since type Exception is a parent of type ArithmeticException and catches all Arithmetic Exceptions
	 * }
	 */
	public static void exceptionFour() {
		System.out.println("\nIn exceptionFour");
		
		// exception can be handled here since this is the caller of the function that throws the exception
		try {
			int num = 1 / 0;
			System.out.println("This line doesn't get executed");
		 } catch (ArithmeticException ae) {
			System.out.println("Arithmetic Exception in exceptionFour: " + ae.getMessage());
		 } catch (RuntimeException re) {
			// this line only gets executed if exception is not of type ArithmeticException (which extends RuntimeException) and is of type RuntimeException
			System.out.println("Runtime Exception in exceptionFour: " + re.getMessage()); 
		 } catch (Exception e) {
			// this line only gets executed if the exception is not of one of the  more specific exceptions on the above "catch" blocks 
			System.out.println("Exception in exceptionFour: " + e.getMessage()); 
		 } finally {
			 System.out.println("This line always gets executed--opportunity to clean up operations that are hanging"); 
		 }
	}
	
	
	/**
	 * fifth exception example -- using the "throws" clause to handle exceptions that are not of type RuntimeException (which the JVM handles implicitly by default in all methods)
	 * @throws FileNotFoundException 
	 */
	
	public static void exceptionFive() {
		System.out.println("\nIn exceptionFive");
		
		// need to catch the exception here if it is thrown down the stack and not handled where it happens
		try {
			exceptionFiveStackOne();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		}
	}
	
	public static void exceptionFiveStackOne() throws FileNotFoundException {
		System.out.println("In exceptionFiveStackOne");
		
		// this line throws an exception because the file doesn't exist
		// exception can be handled with a try/catch or can be send up the stack (like exceptionThreeStackOne()) 
		// Different than "exceptionThreeStackOne" though we need to use a "throws" clause in the method signature 
		// because the JVM does not do it by default like it does for type RuntimeException
		FileReader fileReader = new FileReader("somefileThatDoesNotExist");
	}
	
	
	/**
	 * sixth exception example -- using the "throw" clause to throw an exception explicitly
	 * @throws ArithmeticException 
	 */
	public static void exceptionSix() {
		System.out.println("\nIn exceptionSix");
		
		try {
			exceptionSixStackOne();
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
	}
	
	public static void exceptionSixStackOne() {
		System.out.println("In exceptionSixStackOne");
		
		if (10 > 6) {
			throw new ArithmeticException("This exception is thrown imperatively");
		}
	}
	
	/**
	 * seventh exception example -- using custom type CustomerRecordMissingException to throw an exception imperatively
	 * @throws CustomerRecordMissingException 
	 */
	public static void exceptionSeven() {
		System.out.println("\nIn exceptionSeven");
		
		// exception can be handled here or in the call to exceptionSeven() in the main method
		try {
			exceptionSevenStackOne();
		} catch (CustomerRecordMissingException crme) {
			System.out.println(crme.getMessage());
		}
		
	}
	
	public static void exceptionSevenStackOne() throws CustomerRecordMissingException {
		System.out.println("\nIn exceptionSevenStackOne");
		
		// this needs to be handled up the call stack since we are delegating the exception via a "throws" clause
		// as opposed to handling it locally via try/catch
		if (true) {
			throw new CustomerRecordMissingException("This custom exception is thrown imperatively");
		}
	}
	
	
}
