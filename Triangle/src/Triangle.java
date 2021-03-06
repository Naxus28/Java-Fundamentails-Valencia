
public class Triangle {
	private int sideOne;
	private int sideTwo;
	private int sideThree;
	
	public Triangle() { }
	
	public Triangle(int sideOne, int sideTwo, int sideThree)  throws InvalidTriangleException {
		if (!isValid(sideOne, sideTwo, sideThree)) {
			throw new InvalidTriangleException("passed wrong values");
		}

		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;

	}
	
	public int getPerimeter() {
		return sideOne + sideTwo + sideThree;
	}
	
	public Boolean isValid(int sideOne, int sideTwo, int sideThree) {
		Boolean isValid = true;
		
		if (sideOne <= 0 || sideTwo <= 0 || sideThree <= 0 ) {
			isValid = false;
		}
		
		Boolean checkSideOne = sideOne + sideTwo > sideThree;
		Boolean checkSideTwo = sideOne + sideThree > sideTwo;
		Boolean checkSideThree = sideTwo + sideThree> sideOne;
		 
		if ( !(checkSideOne || checkSideTwo || checkSideThree)) {
			 isValid = false;
		}
		
		return isValid;
		
	}
	
	@Override
	public String toString() {
		return "This is the perimeter: " + getPerimeter();
	}
	
	
}
