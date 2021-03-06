import java.util.Arrays;

public class Footballer extends Athlete implements Helmet {
	private String specialty;

	public Footballer(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		String [] specialtyValues = {"offense", "defense", "special teams"};
		
		if (!Arrays.asList(specialtyValues).contains(specialty)) {
			System.out.println("Please pass one of these values to Footballer: " + Arrays.toString(specialtyValues));
			return;
		}
		
		this.specialty = specialty;
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
		if (obj == null || !(obj instanceof Footballer)) {
			return false;
		}
		
		// call parent class to check that it is the same person and the person is an athlete and
		// make sure specialty is the same
		if (!super.equals(obj) || this.specialty != ((Footballer) obj).specialty) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Footballer [getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", specialty=" + specialty +  "wearsHelmet()=" + wearsHelmet() + "]";
	}

}
