//Turki Alqahtani F4 2236938 P1
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class F42236938P1_EasyRent {

	public static void main(String[] args) throws Exception {
		
		//------------------------------------------------------------------------------------------------------------------------------------
		// Step 1: Reading Car Information and Services.
		
		// creating file objects 
		File InputCar = new File("C:\\Users\\Turki Alqahtani\\Desktop\\InputCar.txt");
		//Check if the files exists. "!" to delete the else statement and make it shorter
		if(!InputCar.exists()) {
			System.out.println("File Not Found!");
			System.exit(0);
		}
		// Creating Scanner objects to save the variables;
		Scanner readCar = new Scanner(InputCar);
		//Creating 1D array for cartypes for the last step
		String[] Cartypes = new String[readCar.nextInt()];
		for(int i = 0; i < Cartypes.length ; i++) {
			Cartypes[i] = readCar.next();
		}
		// creating objects for cars and services class
		F42236938P1_Car[] AddCar = new F42236938P1_Car[readCar.nextInt()];
		F42236938P1_Service [] AddService = new F42236938P1_Service[readCar.nextInt()];
		// creating counters for the objects array in the class
		int carcounter = 0;
		int servicecounter = 0;
		//loop hasNext
		while (readCar.hasNext()) {
			//Checking which command is it AddCar or etc....
			String Command = readCar.next();
			//applying variables to the AddCar object in Car class if the command is AddCar
			if (Command.equals("AddCar")) {
				String Brand = readCar.next();
				int year = readCar.nextInt();
				double rate = readCar.nextDouble();
				boolean transmission = readCar.nextBoolean();
				String Type = readCar.next();
				boolean Convertible = readCar.nextBoolean();
				AddCar[carcounter] = new F42236938P1_Car(Brand , year , rate , transmission , Type , Convertible );
				carcounter++;
			}
			//applying variables to the AddService object in Service class if the command AddService
			else if (Command.equals("AddService")) {
				String Service = readCar.next();
				double Rate = readCar.nextDouble();
				AddService [servicecounter]= new F42236938P1_Service(Service,Rate); 
				servicecounter++;
			}
			//Closing readCar scanner if the command Quit
			else if (Command.equals("Quit")){
				readCar.close();
				break;
			}
			
		}
		//----------------------------------------------------------------------------------------------------------------------------------
		// Step 2: Reserve the Car
		// creating file object
		File InputRes = new File("C:\\Users\\Turki Alqahtani\\Desktop\\Reservationinput.txt");
		//Check if the files exists. "!" to delete the else statement and make it shorter
		if(!InputRes.exists()) {
			System.out.println("File Not Found!");
			System.exit(0);
		}
		// Creating Scanner objects to save the variables;
		Scanner readRes = new Scanner(InputRes);
		// taking the counter to make objects for both reserve class and customers class
		int ReserveAndCustomercounter = readRes.nextInt();
		F42236938P1_Reserve[] reserve = new F42236938P1_Reserve[ReserveAndCustomercounter];
		F42236938P1_Customer [] customer = new F42236938P1_Customer[ReserveAndCustomercounter];
		// Counter for which Reserve object do I save
		int counter = 0;
		// loop
		while(readRes.hasNext()) {
			// reading the command
			String Command = readRes.next();
			// if command is Reserve save it to variables
			if (Command.equals("Reserve")){
				String Type = readRes.next();
				String Transmission = readRes.next();
				// String to boolean
				boolean B_Transmission;
				if (Transmission.equals("Manual"))
					B_Transmission = true;
				else
					B_Transmission = false;
				String Convertible = readRes.next();
				boolean B_Convertible;
				if (Convertible.equals("Convertible"))
					B_Convertible = true;
				else
					B_Convertible = false;
				
				String pickup_location = readRes.next();
				String dropoff_location = readRes.next();
				//Saving it to Date class. the rules of date class you need to minus year 1900 and month 1
				int year = readRes.nextInt();
				int month = readRes.nextInt();
				int day = readRes.nextInt();
				Date pickup_date = new Date(year-1900, month-1, day);
				year = readRes.nextInt(); 
				month = readRes.nextInt();
				day = readRes.nextInt();
				Date dropoff_date = new Date(year-1900, month-1, day);	
				String First_Name = readRes.next();
				String Last_Name = readRes.next();
				String Email = readRes.next();
				Long Credit_card = readRes.nextLong();
				int Customer_code = readRes.nextInt();
				//this string determinants if is it submit or service 
				String x = readRes.next();
				// taking the realtime now date
				Date date_of_reservation = new Date();
				// this token will give me which car object do i save to reserve object
				int token = -1;
				// this string we will change it in the loop
				String reservation_code = "";
				// saving the customer info even if there is no match car.
				customer[counter] = new F42236938P1_Customer(First_Name, Last_Name, Email, Credit_card , Customer_code);
				// this loop for if we find match car we will get the token of this car and generate reservation code since it matched .
				for (int i = 0 ; i < AddCar.length ; i++) {
					if (Type.equals(AddCar[i].Type)) {
						if(B_Convertible == AddCar[i].Convertible) {
							if(B_Transmission == AddCar[i].transmission) {
								token = i;
								//reservation code is the first letter for first and last name, and random number from 0 to 999, and the module car of the matched car
								reservation_code = First_Name.charAt(0) +""+Last_Name.charAt(0)+ "_"+(int) (Math.random()* 1000) + "_"+ AddCar[i].getYear();
							}
						}
					}
				}
				
				// here the if statement, if token didn't change the initial that means there is no match car
				if (token != -1) {
					//here is the x that we took if there is submit instead of service, save the variables to reserve object and the service will be null.
					if (x.equals("submit")) {
						
						reserve [counter] = new F42236938P1_Reserve(reservation_code, pickup_location, dropoff_location, pickup_date, dropoff_date, date_of_reservation, AddCar[token], customer[counter], null);
						
					}
					//else that means x = service.
					else {
						//initials service token
						int servicetoken = -1;
						// loop to match which service is equal to x,  to get the token and save it to reserve object
						for (int i = 0 ; i < AddService.length ; i++) {
							if (x.equals(AddService[i].getService())) {
								servicetoken = i;
							}
						}
						reserve [counter] = new F42236938P1_Reserve(reservation_code, pickup_location, dropoff_location, pickup_date, dropoff_date, date_of_reservation, AddCar[token], customer[counter], AddService[servicetoken]);
						//skipping the next word since it's 100% will be submit to jump the next line
						readRes.next();
					}
				}
				//after saving all the info to first reserve object we go to next one.
				counter++;
				
			}
			//if the command quit we stop scanning and break the loop
			else if (Command.equals("Quit")) {
				readRes.close();
				break;
			}
			//if there isn't any command the means it's empty space so we skip line
			else {
				readRes.nextLine();
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------
		// Step 3: Print all the information
		
		//creating printwrite object for cars info
		PrintWriter outputcarinfo = new PrintWriter("C:\\Users\\Turki Alqahtani\\Desktop\\CarsInfo.txt");
		//header
		outputcarinfo.print("--------------- Welcome to Car Renting  Data Base ---------------\n\n\n");
		//loop to print all available cars
		for (int i = 0; i < AddCar.length ; i++) {
			// car info toString
			outputcarinfo.println(AddCar[i].toString());
			outputcarinfo.print("-----------------------------------------------------------------------\n\n");
		}
		//closing the printwriter
		outputcarinfo.close();
		//---------------------------------------
		//creating printwriter object for reserve info
		PrintWriter outputresinfo = new PrintWriter("C:\\Users\\Turki Alqahtani\\Desktop\\ReservationStatus.txt");
		//headers
		outputresinfo.print("--------------- Welcome to Car Renting  Management System ---------------\n\n\n");
		outputresinfo.print("--------------- Display All System Procedures ---------------\n\n\n");
		//loop to print every reserve object and i is the token
		for (int i = 0; i < reserve.length ; i++) {
			// if reserve is null that means in the matching cars before we said if there isn't matching car we don't change the initial value of token so the token don't go through the if system that means we didn't save any values
			if (reserve[i]==null) {
				//print message
				outputresinfo.print("SORRY: The reservation is NOT completed \n\nThere is no available Car \n\n\n\n");
				
			}
			// else means there is a reservation.
			else {
				//header
				outputresinfo.print("DONE: The reservation is completed\n\n");
				//reservation number
				outputresinfo.print("******Reservation Refrence number : " + reserve[i].getReservation_code()+"\n\n");
				//customer information toString
				outputresinfo.print("******Customer information : " + reserve[i].customer.toString() + "\n\n");
				//pickup and drop off location
				outputresinfo.print("******Pick up location : "+ reserve[i].getPickup_Location()+ " ******Drop of location : " + reserve[i].Dropoff_Location + "\n\n");
				//this class is to display the date to currect form
				SimpleDateFormat dateform = new SimpleDateFormat("d-M-YYYY");
				// displaying the dates of pick up and drop off
				outputresinfo.print("******Pick up date : " + dateform.format(reserve[i].getPickup_date()) + "	******Drop of date : "+ dateform.format(reserve[i].getDropoff_date())+"\n\n");
				// printing car info toString
				outputresinfo.print("******Car information : " + reserve[i].car.toString()+"\n\n");
				// Additional services *we didn't close it, we will know in the next step
				outputresinfo.print("******Additional services : ");
				// if there is a additional service in the reserve object. print the service
				if(reserve[i].service != null) {
					outputresinfo.print("Service "+reserve[i].service.getService()+ "\n\n");
				}
				else {
					// if there isn't print NONE
					outputresinfo.print("NONE\n\n");
				}
				//header
				outputresinfo.print("--------------- Invoice Details ---------------\n\n");
				// this equation to get the day difference
				long daydiff = ((reserve[i].getDropoff_date().getTime() - reserve[i].getPickup_date().getTime()) /  (1000 * 60 * 60 * 24)) % 365;
				// printing the day difference
				outputresinfo.print("Number of reserved days: " + daydiff+ "\n\n");
				//total is about the day difference multiplying by the rate of the car
				double total = reserve[i].car.getRate() * daydiff;
				//if it's Luxury add 10% to the total 
				if (reserve[i].car.getType().equals("Luxury")) {
					total = total * 1.1;
				}
				//print the intial total price
				outputresinfo.print("Intial Total: " + (total)+ "\n\n");
				//here is important step, if there is additional service print the additional service price header and change the total price by adding the service rate
				if(reserve[i].service != null) {
					//header
					outputresinfo.print("--------------- Additional Services Price ---------------\n\n");
					//adding the rate of service to the total price
					total = total + reserve[i].service.getRate();
					//printing
					outputresinfo.print("Total After additional Services  : " + total+ "\n\n");
				}
				//header
				outputresinfo.print("--------------- Final Payment after Discount ---------------\n\n");
				// determinants how much discount does he get by the first digit of the customer code
				int firstdigit = (int)(reserve[i].customer.getCustomer_Code()/100);
				//if the first digit is either 9 or 8 + (or 7 <- i put the number. the assaignment slide did't tell me. but the first example that he gave me with the first digit 7, he gave him discount even though in the assaginment slide didn't tell him to give discount. so this is the only thing that I conclude which is he may forgot to add number 7)
				if (firstdigit == 9 || firstdigit == 8 || firstdigit == 7) {
					// 20% discount
					total = total * 0.8;
				}
				// if it's 6 or 5 or 4 
				else if (firstdigit == 6 || firstdigit == 5 || firstdigit == 4) {
					// 15% discount
					total = total * 0.85;
				}
				//else which is 0 or 1 or 2 or 3
				else {
					// 10% discount
					total=total * 0.9;
				}
				//print the total price
				outputresinfo.print("Final Total  : " + total+"\n\n\n\n\n");
				
				
			}
		}
		// close the reserve printwriter
		outputresinfo.close();
		//---------------------------------------------------------
		//create printwriter object for the analysis report
		PrintWriter outputany = new PrintWriter("C:\\Users\\Turki Alqahtani\\Desktop\\AnalysisReport.txt");
		// 2D array, rows are the services available and coloums are the car types (array) <---------------- this is the last step that I meant when I Created the car types array in the first step
		int [][] analysis = new int [AddService.length][Cartypes.length];
		//header
		outputany.print("-------------- Analysis Report ---------------\n\n\n");
		outputany.print("\t\tCarType\t\t");
		//loop to print the car types in coloums format
		for (int i = 0 ; Cartypes.length >i ; i++) {
			outputany.print(Cartypes[i] + "\t\t");
		}
		// Here is important point. I didn't close the lines (---) because maybe we will have additional car types. so the line will be longer or shorter it depends of how many car types do we have.
		outputany.print("\n\tServices\n\t-----------------");
		for (int i = 0 ; Cartypes.length >i ; i++) {
			outputany.print("-----------------");
		}
		
		
		//here is the loop to check every reservations and taking the analysis report
		for (int i = 0 ; reserve.length> i ; i++) {
			//if there is reservation. we will not skip the reservation and not going to the next one
			if (reserve[i] != null) {
				//rows for checking service
				for (int row = 0 ; analysis.length > row; row++) {
					//As I said rows for every service so if there is additional service, we won't skip the row 
					if (reserve[i].service != null) {
						//loop for the coloums which is the car types 
						for(int coloum = 0 ; analysis[row].length >coloum ; coloum++) {
							// so this if tells me if there is car type equal in the reservation is equal to the car type in the car type coloum format and service in the reservation is equal to the service in the service format
							if(reserve[i].car.getType().equals(Cartypes[coloum]) && reserve[i].service.getService().equals(AddService[row].getService())){
								// if yes then add one to the old number
								analysis[row][coloum] += 1;
							}
						}
					}
				}
			}
		}
		// print writing the analysis array.
		for (int row = 0 ; row < analysis.length ; row++) {
			// here we get the service name in the first row 
			outputany.print("\n\n\t" + AddService[row].getService());
			for(int coloum = 0 ; coloum < analysis[row].length ; coloum++) {
				// here we print the value
				outputany.print("\t\t" + analysis[row][coloum]);
			}
		}
		//close the printwriter
		outputany.close();
	}

}
