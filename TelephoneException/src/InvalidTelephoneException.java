
/**
 * 
 * @author gabrielferraz
 * InvalidTelephoneException is used when user attempts to create an instance of Telephone
 * passing a number that does not comply with either of these formats xxx xxx xxxx or xxxxxxxxx
 * Note: Number has to have 10 (numeric) digits or 10 digits and any number of separation spaces
 *  
 */
public class InvalidTelephoneException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidTelephoneException() {}
	
	public InvalidTelephoneException(String telephone) {
		super("The phone number " + telephone + " is not a valid format. Please use this format 'xxx xxx xxxx'");
	}
	
}
