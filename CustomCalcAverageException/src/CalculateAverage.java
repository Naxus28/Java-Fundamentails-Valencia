import java.text.DecimalFormat;
import java.util.Arrays;

public class CalculateAverage {
	// format two decimal points for all doubles
	final static DecimalFormat df2 = new DecimalFormat("#.00"); 
	
	public static void main(String[] args) {
		int [] invalidNums = {1, 2, 3, 4, 5, 5, 59, 61, 101, -1, 200, -10};
		int [] validNums = {0, 1, 2, 3, 4, 5, 5, 59, 61, 100};
		
		/**
		 * pass an array with invalid numbers to method getAverage
		 */
		try {
			String average = getAverage(invalidNums);
			System.out.println("\nThe average in invalidNums [] is: " + average + "\n"); // this line never gets executed
		} catch (InvalidGradeException e) {
			e.getError();
		} finally {
			System.out.println("invalidNums[] after mutation: " + Arrays.toString(invalidNums));
		}
		
		/**
		 * pass an array with all valid numbers to method getAverage
		 */
		try {
			String average = getAverage(validNums);
			System.out.println("\nThe average in validNums [] is: " + average + "\n");
		} catch (InvalidGradeException e) {
			e.getError();
		} finally {
			System.out.println("validNums[] after mutation: " +  Arrays.toString(validNums));
		} 	
	}
	
	public static String getAverage(int [] nums) throws InvalidGradeException {
		double sum = 0;
		double average = 0;
		
		// use a try block to be able to execute default functionality 
		// (replace array elements) on the "finally" block
		try {
			for (int num : nums) {
				if (num < 0 || num > 100) {
					throw new InvalidGradeException(nums);
				}
					
				sum+=num;
			}
			
			average = sum / nums.length;
			
		} finally {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] < 60) {
					nums[i] = 60; // mutates the array
				}
			}
		}
	
		
		return df2.format(average);
	}

}
