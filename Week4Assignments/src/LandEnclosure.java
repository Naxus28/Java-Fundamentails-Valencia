/**
 * @author gabrielferraz
 *
 */
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class LandEnclosure {
	
	/**
	 * class globals
	 */
	final static DecimalFormat df = new DecimalFormat("#.00"); // use this variable to format two decimal points for all doubles
	static private double lengthRatio;
	static private double widthRatio;
	static private double sideMeasureUnit;
	static private double length;
	static private double width;
	static private double fenceTotal;
	static private String ratio;
	static private String area;
	static private String areaInputDirections = "What is the area of the enclosure in square feet? Please input a non-negative number smaller than 1,000,000,000 and disregard the measurement unit sqft)";
	static private String ratioInputDirections = "What is the ratio L:W of the enclosure? Please input non-negative numbers smaller than 100. i.e. (10:6)";
	static private String [] enclosureSides = new String [2];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * get area input
		 */
		do 
		{
			area = JOptionPane.showInputDialog(areaInputDirections);
			JOptionPane.showMessageDialog(null, area, "Area of enclosure", JOptionPane.PLAIN_MESSAGE);
		}
		while(area.length() == 0 ||converStringToDouble(area) > 1000000000 || converStringToDouble(area) <= 0);
		
		/**
		 * get L:W input
		 */
		do 
		{
			ratio = JOptionPane.showInputDialog(ratioInputDirections);
			
			// this is not bulletproof but at least guarantees user will enter 3 characters to fulfill requirement (L:W) 
			if (ratio.length() >= 3) 
			{
				enclosureSides = getSides(ratio);
				lengthRatio = converStringToDouble(enclosureSides[0]);
				widthRatio = converStringToDouble(enclosureSides[1]);
				JOptionPane.showMessageDialog(null, "lengthRatio: " + lengthRatio + ", widthRatio: " + widthRatio, "L:W ratio of enclosure", JOptionPane.PLAIN_MESSAGE);
			} 
			
		}
		while((lengthRatio <= 0 || lengthRatio > 100) || (widthRatio <= 0 || widthRatio > 100) );
		
		/**
		 * cache computed measurements
		 */
		sideMeasureUnit = getMeasurementUnit(converStringToDouble(area), lengthRatio, widthRatio);
		length = getRectangleSide(lengthRatio, sideMeasureUnit);
		width = getRectangleSide(widthRatio, sideMeasureUnit);
		fenceTotal = getFenceTotal(length, width);
		
		/**
		 * print results
		 */
		System.out.println("Your enclosure has dimensions " + df.format(length) + " feet by "+ df.format(width) +" feet.");
		System.out.println("You will need " + df.format(fenceTotal) + " feet of fence total.");
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
	 * parse rectangle sides out of string input and return them as elements of array "sides"
	 * @param ratio
	 * @return
	 */
	static private String [] getSides(String ratio) 
	{
		Pattern p = Pattern.compile("\\d+"); // define regex to get numbers only
		Matcher numbers = p.matcher(ratio); // user matcher class to match regex in string
		String [] sides =  new String[2]; // initialize sides array to hold l and w
		int index = 0;
		
		while(numbers.find()) 
		{
			sides[index] = numbers.group();
			index++;
		}
		
		return sides;
	} 
	
	/**
	 * this method solves for the common unit of measurement used to calculate the L and W
	 * @param area
	 * @param lenghtRatio
	 * @param widthRatio
	 * @return
	 */
	static private double getMeasurementUnit(double area, double lenghtRatio, double widthRatio) 
	{
		return Math.sqrt(area / (lenghtRatio * widthRatio));
	}
	
	/**
	 * Gets the rectangle side
	 * @param widthRatio
	 * @param sideMeasureUnit
	 * @return
	 */
	static private double getRectangleSide(double sideRatio, double sideMeasureUnit) 
	{
		return sideRatio * sideMeasureUnit;
	}
	
	/**
	 * get fence total measurements
	 * @param length
	 * @param width
	 * @return
	 */
	private static double getFenceTotal(double length, double width) 
	{
		return length * 2 + width * 2;
	}

}
