
public class Name {
	String firstName;
	String middleName;
	String lastName;
	String suffix;
	
	
	// constructors
	public Name(String firstName, String lastName) {
		this(firstName, "", lastName, "");
	}
	 
	public Name(String firstName, String middleName, String lastName) {
		this(firstName, middleName, lastName, "");
	}
	
	public Name(String firstName, String middleName, String lastName, String suffix) {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setSuffix(suffix);
	}
	
	// to string
	@Override
	public String toString() {
		String middleName = getMiddleName();
		middleName = middleName != null && !middleName.isEmpty() ? middleName + " " : "";
		
		return getFirstName() + " " + middleName +  getLastName();
	}

	
	// getters and setters
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
}
