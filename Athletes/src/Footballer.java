import java.util.Arrays;

public class Footballer extends Athlete{
	private String specialty;

	public Footballer(String firstName, String lastName, int age, String specialty) {
		super(firstName, lastName, age);
		setSpecialty(specialty);
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
	
	// overload parent method
	public void doThis(String action) {
		System.out.println(action);
	}

	@Override
	public String toString() {
		return "Footballer [getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", specialty=" + specialty +"]";
	}

}
