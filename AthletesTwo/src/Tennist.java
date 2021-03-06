
public class Tennist extends Athlete {
	private Boolean isPro;

	public Tennist(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	
	public Boolean getIsPro() {
		return isPro;
	}

	public void setIsPro(Boolean isPro) {
		this.isPro = isPro;
	}

	@Override
	public void doThis(String action) {
		System.out.println(action);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Tennist)) {
			return false;
		}
		
		// call parent class to check that it is the same person and the person is an athlete and
		// make sure the batting position is the same
		if (!super.equals(obj) || this.isPro != ((Tennist) obj).isPro) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Tennist  getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", isPro=" + isPro + "]";
	}
	
}
