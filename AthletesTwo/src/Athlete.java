
public abstract class Athlete extends Person {
	
	public Athlete(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	
	public abstract void doThis(String action);
	
	private String getAthleteAction() {
		String atheleteAction = "";
		
		if (this instanceof Baseballer) {
			atheleteAction = "I hit something.";
		} else if (this instanceof Footballer) {
			atheleteAction = "I tackle something.";
		} else if (this instanceof Golfer) {
			atheleteAction = "I put it in the hole.";
		} else if (this instanceof HockeyPlayer) {
			atheleteAction = "I sit in a penalty box.";
		} 
		
		return atheleteAction;
	}
	
	@Override 
	public boolean equals(Object obj) {
		// call parent class to check that it is the same person and that person is an athlete
		if (!super.equals(obj) || !(obj instanceof Athlete)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Athlete [getFullName()=" + getFullName() + " getAthleteAction()=" + getAthleteAction() + "]";
	}
	
}
