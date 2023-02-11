//Turki Alqahtani F4 2236938 P1
public class F42236938P1_Customer {
	String First_name;
	String LastName_name;
	String Email;
	long Credit_Card;
	int Customer_Code;
	public F42236938P1_Customer(String first_name, String lastName_name, String email, long credit_Card, int customer_Code) {
		super();
		First_name = first_name;
		LastName_name = lastName_name;
		Email = email;
		Credit_Card = credit_Card;
		Customer_Code = customer_Code;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLastName_name() {
		return LastName_name;
	}
	public void setLastName_name(String lastName_name) {
		LastName_name = lastName_name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getCredit_Card() {
		return Credit_Card;
	}
	public void setCredit_Card(long credit_Card) {
		Credit_Card = credit_Card;
	}
	public int getCustomer_Code() {
		return Customer_Code;
	}
	public void setCustomer_Code(int customer_Code) {
		Customer_Code = customer_Code;
	}
	
	public String toString() {
		
		return "Customer Name: " + First_name + " " + LastName_name + ", Email: " + Email
				+ ", Code: " + Customer_Code ;
	}
	
}
