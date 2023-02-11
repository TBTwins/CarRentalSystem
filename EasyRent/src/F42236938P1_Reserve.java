//Turki Alqahtani F4 2236938 P1

// for the date class
import java.util.*;
public class F42236938P1_Reserve {
String reservation_code;
String Pickup_Location;
String Dropoff_Location;
Date Pickup_date;
Date Dropoff_date;
Date date_of_reservation;
F42236938P1_Car car;
F42236938P1_Customer customer;
F42236938P1_Service service;

public F42236938P1_Reserve(String reservation_code, String pickup_Location, String dropoff_Location, Date pickup_date,
		Date dropoff_date, Date date_of_reservation, F42236938P1_Car car, F42236938P1_Customer customer, F42236938P1_Service service) {
	super();
	this.reservation_code = reservation_code;
	Pickup_Location = pickup_Location;
	Dropoff_Location = dropoff_Location;
	Pickup_date = pickup_date;
	Dropoff_date = dropoff_date;
	this.date_of_reservation = date_of_reservation;
	this.car = car;
	this.customer = customer;
	this.service = service;
}
public String getReservation_code() {
	return reservation_code;
}
public void setReservation_code(String reservation_code) {
	this.reservation_code = reservation_code;
}
public String getPickup_Location() {
	return Pickup_Location;
}
public void setPickup_Location(String pickup_Location) {
	Pickup_Location = pickup_Location;
}
public String getDropoff_Location() {
	return Dropoff_Location;
}
public void setDropoff_Location(String dropoff_Location) {
	Dropoff_Location = dropoff_Location;
}
public Date getPickup_date() {
	return Pickup_date;
}
public void setPickup_date(Date pickup_date) {
	Pickup_date = pickup_date;
}
public Date getDropoff_date() {
	return Dropoff_date;
}
public void setDropoff_date(Date dropoff_date) {
	Dropoff_date = dropoff_date;
}
public Date getDate_of_reservation() {
	return date_of_reservation;
}
public void setDate_of_reservation(Date date_of_reservation) {
	this.date_of_reservation = date_of_reservation;
}
public F42236938P1_Car getCar() {
	return car;
}
public void setCar(F42236938P1_Car car) {
	this.car = car;
}
public F42236938P1_Customer getCustomer() {
	return customer;
}
public void setCustomer(F42236938P1_Customer customer) {
	this.customer = customer;
}
public F42236938P1_Service getService() {
	return service;
}
public void setService(F42236938P1_Service service) {
	this.service = service;
}



}
