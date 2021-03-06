
public class Costumer extends Person implements Comparable<Costumer> {
	private int customerNumber;
	private String emailAddress;
	
	public Costumer(String firstName, String lastName, int customerNumber, String emailAddress) {
		super(firstName, lastName);
		setCustomerNumber(customerNumber);
		setEmailAddress(emailAddress);
	}

	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Customer: " + super.toString() + ", customerNumber=" + customerNumber + ", emailAddress=" + emailAddress;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Costumer)) {
			return false;
		}
		
		// call parent class to check that it is the same person 
		// then check that the person is the same costumer by comparing costumer specific data
		if (!super.equals(obj) || this.customerNumber != ((Costumer) obj).customerNumber || this.emailAddress != ((Costumer) obj).emailAddress) {
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(Costumer other) {
		if (this.getCustomerNumber() < other.getCustomerNumber()) {
			return 1;
		} else {
			return -1;
		}
	}

}
