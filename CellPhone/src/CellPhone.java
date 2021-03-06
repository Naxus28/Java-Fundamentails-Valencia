public class CellPhone 
{
	// phone is
	private Boolean on = false;
	private Boolean onCall = false;
	
	// phone has a
	private String brand;
	private String color;
	private String model;
	private String number;
	private String numericPassword;
	
	// phone might have a(n)
	private Boolean imessage;
	private Boolean headPhones;
	private String extendedWarranty;
	

	// static variables
	private static int passwordLength = 4;
	
	// constructors
	public CellPhone(String brand, String color, String number, String model)
	{
		this(brand, color, number, model, "no extended warranty", false, false);
	}
	
	public CellPhone(String brand, String color, String model, String number, String extendedWarranty)
	{
		this(brand, color, number, model, extendedWarranty, false, false);
	}
	
	public CellPhone(String brand, String color, String model, String number, String extendedWarranty, Boolean headPhones)
	{
		this(brand, color, number, model, extendedWarranty, headPhones, false);
	}

	
	public CellPhone(String brand, String color, String number, String model, String extendedWarranty, Boolean headPhones, Boolean imessage)
	{
		setBrand(brand);
		setColor(color);
		setModel(model);
		setNumber(number);
		setExtendedWarranty(extendedWarranty);
		setImessage(imessage);
		setHeadPhones(headPhones);
	}


	// getters/setters
	public Boolean getOn() {
		return on;
	}

	public void setOn(Boolean on) {
		this.on = on;
		System.out.println("Phone is on.");
	}

	public Boolean getOnCall() {
		return onCall;
	}

	public void setOnCall(Boolean onCall) {
		if (on) 
		{
			this.onCall = onCall;
		}
		else
		{
			System.out.println("Phone is off.");
		}
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumericPassword() {
		return numericPassword;
	}

	public void setNumericPassword(String numericPassword) {
		if (on) 
		{
			if (!isAllNumeric(numericPassword)) 
			{
				System.out.println("Please use only numbers.");
			}
			
			if (numericPassword.length() != passwordLength)
			{
				System.out.println("======Your password is too long. Plese set a 4-number password.======");
			}
			else
			{
				this.numericPassword = numericPassword;
				System.out.println("Setting password: " + numericPassword);
			}
		}
		else 
		{
			System.out.println("======Can't set password because the phone is off.=====");
		}
	}
	
	public Boolean getImessage() {
		return imessage;
	}

	public void setImessage(Boolean imessage) {
		this.imessage = imessage;
	}

	public Boolean getHeadPhones() {
		return headPhones;
	}

	public void setHeadPhones(Boolean headPhones) {
		this.headPhones = headPhones;
	}

	public String getExtendedWarranty() {
		return extendedWarranty;
	}

	public void setExtendedWarranty(String extendedWarranty) {
		this.extendedWarranty = extendedWarranty;
	}

	@Override
	public String toString() {
		return "CellPhone [brand=" + brand + ", color=" + color + ", model=" + model + ",\n" + 
				"number=" + number + ", numericPassword=" + numericPassword + ", extended warranty=" + extendedWarranty + "\n" + 
				"has head phones=" + headPhones + ", has iMessage=" + imessage +", is on=" + on + ", is on call=" + onCall + "]\n\n";
	}
	
	
	// helper methods
	public boolean isAllNumeric(String phoneNumber)
	{
		for (int i=0; i < phoneNumber.length(); i++)
		{
			if (Character.isLetter(phoneNumber.charAt(i)))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isNumberValid(String number)
	{	
		return isAllNumeric(number) && number.length() == 10;
	}

}
