/**
 * @author gabrielferraz
 *
 */
import javax.swing.JOptionPane;

public class PayCalculator {
	/**
	 * class globals
	 */
	final static int incentiveLevelOne = 5;
	final static int incentiveLevelTwo = 10;
	final static int incentiveLevelThree = 15;
	static int totalKnives;
	static int totalPay;
	static String soldKnives;
	static String inputDirections = "Please input the number of knoves you sold this month (value needs to be less than 1,000,000)";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * get knives #
		 */
		do 
		{
			soldKnives = JOptionPane.showInputDialog(inputDirections);
			JOptionPane.showMessageDialog(null, soldKnives, "Knives sold this month", JOptionPane.PLAIN_MESSAGE);
		}
		while(soldKnives.length() == 0 || converStringToInt(soldKnives) > 1000000 || converStringToInt(soldKnives) < 0);
		
		totalKnives = converStringToInt(soldKnives);
		totalPay = getTotalPay(totalKnives);
		
		System.out.println("You made $" + totalPay + " selling knives this month.");
	}
	
	/**
	 * convenience method
	 * @param string
	 * @return
	 */
	static private int converStringToInt(String string) 
	{
		return Integer.parseInt(string);
	}
	
	/**
	 * algorithm to be used for any number of knives input
	 * @param totalKnives
	 * @return
	 */
	static private int getTotalPay(int totalKnives) 
	{	
		int totalPay = 0;
		int timesBiggerThan100 = (int) Math.floor(totalKnives/100);
		int remainderFrom100 = (int) (totalKnives % 100);
		int baseNumberForLowerincentives = 100;
		int baseNumberForIncentiveLevelThree = totalKnives - remainderFrom100 - 200;
		
		if (timesBiggerThan100 == 0) 
		{
			totalPay = totalKnives * incentiveLevelOne;
		}
		else 
		{
			for(int i = 0; i < timesBiggerThan100; i++) {
				if (i == 0 ) {
					totalPay += baseNumberForLowerincentives * incentiveLevelOne;
				} else if (i == 1) {
					totalPay += baseNumberForLowerincentives * incentiveLevelTwo;
				} else if (i > 1) {
					totalPay += baseNumberForIncentiveLevelThree * incentiveLevelThree;
					break; // this part of the loop executes only once since we are imperatively getting the total knives that exceed 299
				}	
			}
			
			totalPay += remainderFrom100 * incentiveLevelOne;
		}
		
		return totalPay;
	}
}
