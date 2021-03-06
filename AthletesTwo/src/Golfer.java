
public class Golfer extends Athlete {
	private String mainSponsor;
	
	public Golfer(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	
	public String getMainSponsor() {
		return mainSponsor;
	}

	public void setMainSponsor(String mainSponsor) {
		this.mainSponsor = mainSponsor;
	}
	
	//overload--polymorphic method
	public void doThis(String action) {
		System.out.println(action);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Golfer)) {
			return false;
		}
		
		// call parent class to check that it is the same person and the person is an athlete and
		// make sure mainSponsor is the same
		if (!super.equals(obj) || this.mainSponsor != ((Golfer) obj).mainSponsor) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Golfer [getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", mainSponsor=" + mainSponsor + "]";
	}

}
