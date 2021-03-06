public class Date {
	private int day;
	private int month;
	private int year;
	
	// constructor
	public Date(int month, int day, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	
	// getters and setters
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		// disregard leap year for simplicity
		if (day > 0 && day <= 31) {
			this.day = day;
		} else {
			System.out.println("Please enter days form 1 to 31");
		}
		
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month > 0 && month <= 12) {
			this.month = month;
		} else {
			System.out.println("Please enter months form 1 to 12");
		}
		
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		// assumes no one living is older than 117 years
		if (year >= 1900 && year <= 2017) {
			this.year = year;
		} else {
			System.out.println("Please enter years form 1900 to 2017");
		}	
	}
	
	// to string
	@Override
	public String toString() {
		return String.format("%d/%d/%d", getMonth(), getDay(), getYear());
	}
	
}
