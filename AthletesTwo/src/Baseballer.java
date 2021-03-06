import java.util.Arrays;

public class Baseballer extends Athlete implements Helmet {
	private String battingPosition;
	
	public Baseballer(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	

	public String getBattingPosition() {
		return battingPosition;
	}
	
	public void setBattingPosition(String battingPosition) {
		String [] acceptedbattingPositions = {"left", "right", "left and right", "right and left"};
		
		if (!Arrays.asList(acceptedbattingPositions).contains(battingPosition)) {
			System.out.println("Please pass one of these values to Baseballer : " + Arrays.toString(acceptedbattingPositions));
			return;
		}
		
		this.battingPosition = battingPosition;
	}
	
	//overload--polymorphic method
	public void doThis(String action) {
		System.out.println(action);
	}
	
	@Override
	public Boolean wearsHelmet() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Baseballer)) {
			return false;
		}
		
		// call parent class to check that it is the same person and the person is an athlete and
		// make sure the batting position is the same
		if (!super.equals(obj) || this.battingPosition != ((Baseballer) obj).battingPosition) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Baseballer  getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", battingPosition=" + battingPosition +  "wearsHelmet()=" + wearsHelmet() + "]";
	}

}
