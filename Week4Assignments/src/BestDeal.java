/**
 * @author gabrielferraz
 *
 */
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class BestDeal {
	/**
	 * class globals
	 */
	static String amountRemainingInCard;
	static String mealsInput;
	static String [] mealsValues;
	static double [] mealsValuesAsDoubles;
	static String mealCardInputDirections = "What is the amount left on your card? (value needs to be less a non-negative number smaller than 1,000)";
	static String mealsInputDirections = "What is the cost in dollars of the three items you may buy? (values need to be less a non-negative number smaller than 1,000. Negative numbers will be converted to positive numbers.)";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * get amount left in card
		 */
		do 
		{
			amountRemainingInCard = JOptionPane.showInputDialog(mealCardInputDirections);
			JOptionPane.showMessageDialog(null, amountRemainingInCard, "Amount left", JOptionPane.PLAIN_MESSAGE);
		}
		while(amountRemainingInCard.length() == 0 || converStringToDouble(amountRemainingInCard) > 1000 || converStringToDouble(amountRemainingInCard) < 0);
		
		do 
		{
			mealsInput = JOptionPane.showInputDialog(mealsInputDirections);
			mealsValues = getMealValuesAsArray(mealsInput);
			mealsValuesAsDoubles = getStringArrayAsDouble(mealsValues);
			
			if (Arrays.asList(mealsValuesAsDoubles).contains(0)) 
			{
				JOptionPane.showMessageDialog(null, mealsValues[0] + " " + mealsValues[1] + " " + mealsValues[2] , "Input Accepted Meals Values", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, mealsValues[0] + " " + mealsValues[1] + " " + mealsValues[2] , "Meals values", JOptionPane.PLAIN_MESSAGE);
			}
				
		}
		while(checkMealsValues(mealsValuesAsDoubles));
		
		double amountLeftInCard = getAmountLeftInCard(converStringToDouble(amountRemainingInCard), mealsValuesAsDoubles);
		
		System.out.println("The least amount of money you can leave on your card is $" + amountLeftInCard);
		
	}
	
	
	/**
	 * entry point method to get remaining amount in card
	 * @param amountRemainingInCard
	 * @param mealValues
	 * @return
	 */
	static private double getAmountLeftInCard(double amountRemainingInCard, double [] mealValues) 
	{
		double totalMealsAmount = getTotalMealsAmount(mealValues);
		double amountLeftInCard;
		
		if(amountRemainingInCard > totalMealsAmount) 
		{
			amountLeftInCard = amountRemainingInCard - totalMealsAmount;
		}
		else if(amountRemainingInCard == totalMealsAmount) 
		{
			amountLeftInCard = amountRemainingInCard - totalMealsAmount;
		}
		else {
			amountLeftInCard = getRemainderFromPurchase(amountRemainingInCard, mealValues);
		}
		
		return amountLeftInCard;
	}
	
	
	/**
	 * calculates the remainder amount in card
	 * @param amountLeftInCard
	 * @param mealValues
	 * @return
	 */
	static private double getRemainderFromPurchase(double amountLeftInCard, double [] mealValues) 
	{
		double remainderFromPurchase = 0;
		double currentValue = 0;
		double previousValue = 0;

		for(int i = 0; i < mealValues.length; i++)
		{
			if (i == mealValues.length - 1) 
			{
				currentValue = mealValues[i] + mealValues[0];
			} 
			else 
			{
				currentValue = mealValues[i] + mealValues[i + 1];
				
				if (previousValue <= currentValue && currentValue <= amountLeftInCard) 
				{
					previousValue = currentValue;
				} 
			}
		}
		
		if (currentValue > previousValue && currentValue <= amountLeftInCard) {
			remainderFromPurchase = amountLeftInCard - currentValue;
		} 
		else 
		{
			remainderFromPurchase = amountLeftInCard - previousValue;
		}
		
		return remainderFromPurchase;
	}
	
	/**
	 * convenience method
	 * @param string
	 * @return
	 */
	static private double converStringToDouble(String string) 
	{
		return Double.parseDouble(string);
	}
	
	/**
	 * convenience method
	 * @param string []
	 * @return
	 */
	static private double [] getStringArrayAsDouble(String [] stringArray) 
	{
		double [] doubleArray = new double[3];
		
		for(int i = 0; i < stringArray.length; i++) {
			doubleArray[i] = converStringToDouble(stringArray[i]);
		}
		
		return doubleArray;
	}
	
	/**
	 * convenience method
	 * @param mealsValues
	 * @return
	 */
	static private boolean checkMealsValues(double [] mealsValues)
	{	
		for(double mv: mealsValues)
			if (mv == 0 || mv > 1000) return true;
			return false;
	}
	
	/**
	 * convenience method
	 * @param mealValues
	 * @return
	 */
	static private double getTotalMealsAmount(double [] mealValues) 
	{
		double totalMealsAmount = 0;
		
		for(double mv: mealValues)
		{
			totalMealsAmount+=mv;
		}
		
		return totalMealsAmount;
	}
	
	
	/**
	 * parse values sides out of string input and return them as elements of array "mealsValues"
	 * @param ratio
	 * @return
	 */
	static private String [] getMealValuesAsArray(String mealsInput) 
	{
		Pattern p = Pattern.compile("\\d+"); // define regex to get numbers only
		Matcher values = p.matcher(mealsInput); // user matcher class to match regex in string
		String [] mealsValues =  {"0", "0", "0"}; // initialize sides array to hold values
		int index = 0;
		
		while(values.find()) 
		{
			if (values.group() != null) {
				mealsValues[index] = values.group();
			}
			
			index++;
		}
		
		return mealsValues;
	} 

}
