//Turki Alqahtani F4 2236938 P1
public class F42236938P1_Car {
	
	String Brand;
	int year;
	double rate;
	boolean transmission;
	String Type;
	boolean Convertible;
	
	
	public F42236938P1_Car(String brand, int year, double rate, boolean transmission, String type, boolean convertible) {
		
		Brand = brand;
		this.year = year;
		this.rate = rate;
		this.transmission = transmission;
		Type = type;
		Convertible = convertible;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public boolean isTransmission() {
		return transmission;
	}
	public void setTransmission(boolean transmission) {
		this.transmission = transmission;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public boolean isConvertible() {
		return Convertible;
	}
	public void setConvertible(boolean convertible) {
		Convertible = convertible;
	}
	
	public String toString() {
		// boolean to string 
		String trans;
		String Conv;
		if (transmission)
			trans = "Manual";
		else
			trans = "Automatic";
		if(Convertible)
			Conv = " and Convertible";
		else
			Conv = "";
		return "The car Type: " + Brand +" " +Type + ", Year: " + year + ", Transmission: " +trans + Conv;
	}
	
}

