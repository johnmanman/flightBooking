package wintertimeFlightReservation;

import java.util.Scanner;

/*this is my first independent coding back from the times of coding start.
* I took this Question from Quora and tried to write it on my own way. 
 * 
 *this is also the third edition.
 
 * This is the question: 
 
 * (Airline Reservations System) A small airline has just purchased a computer
 * for its new automated reservations system. You have been asked to develop the
 * new system. You are to write an application to assign seats on each flight of
 * the airline’s only plane (capacity: 10 seats).
 * 
 * Your application should display the following alternatives:
 * 
 * "Please type 1 for First Class" "Please type 2 for Economy" If the user types
 * 1, your application should assign a seat in the first-class section (seats
 * 1–5). If the user types 2, your application should assign a seat in the
 * economy section (seats 6–10). Your application should then display a boarding
 * pass indicating the person's seat number and whether it is in the first-class
 * or economy section of the plane.
 * 
 * Use a one-dimensional array of primitive type boolean to represent the
 * seating chart of the plane. Initialize all the elements of the array to false
 * to indicate that all the seats are empty. As each seat is assigned, set the
 * corresponding elements of the array to true to indicate that the seat is no
 * longer available.
 * 
 * Your application should never assign a seat that has already been assigned.
 * When the economy section is full, your application should ask the person if
 * it is acceptable to be placed in the first-class section (and vice versa). If
 * yes, make the appropriate seat assignment. If no, display the message
 * "Next flight leaves in 3 hours."
 * 
 */

//without the exception handling problem; I have not covered it yet

//I have used the Scanner input, two classes for Seat Reservation and for passenger;
//I have used 3 methods: 1. reserveYourFlight(); 2. reserveFirstClassSeat(); 3. reserveEconomyClassSeat();
//93 lines; 

public class SeatReservation {
	Scanner scn = new Scanner(System.in);
	public void reserveYourFlight() {
		System.out.println("Pleas enter 1 for first class seats or 2 for economy class seats.");
		int x = scn.nextInt();
		if (x == 1)
			reserveFirstClassSeat();
		if (x == 2)
			reserveEconomyClassSeat();
		if (x != 1 || x != 2) {
			System.out.println("please write either 1 or 2.");
			scn.nextInt();
		}
	}
	public void reserveEconomyClassSeat() {
		Passenger[] buClassSeats = new Passenger[5];
		for (int j = 1; j <= buClassSeats.length; j++) {
			if (buClassSeats[j] == null) {
				System.out.println("enter your fullName: ");
				String fullName = scn.next();
				System.out.println("enter your id: ");
				int id = scn.nextInt();
				System.out.println("enter your birthDate: ");
				int birthDate = scn.nextInt();
				buClassSeats[j] = new Passenger(fullName, id, birthDate);
				System.out.println("you have successfully booked your Economy Class Sseat. your seat number is " + j);
				return;
			} else {
				System.out.println(" All Economy Class Seats are already booked; please try First class Seats.");
				System.exit(0);
			}
		}
	}
	public void reserveFirstClassSeat() {
		Passenger[] firClassSeats = new Passenger[5];
		for (int k = 1; k <= firClassSeats.length; k++) {
			if (firClassSeats[k] == null) {
				System.out.println("Enter your fullName: ");
				String fullName = scn.next();
				System.out.println("Enter your id: ");
				int id = scn.nextInt();
				System.out.println("Enter your Birth Year: ");
				int birthDate = scn.nextInt();
				firClassSeats[k] = new Passenger(fullName, id, birthDate);
				System.out.println(firClassSeats[k]);
				System.out.println("you have successfully booked your seat. your seat number is " + k);
			} else {
				System.out.println(" All first Class Seats are already booked; please try economy class.");
				System.exit(0);
			}
		}
	}
	
	
	public static void main(String[] arg) {
		
		Scanner scn = new Scanner(System.in);
		SeatReservation strn = new SeatReservation();
		strn.reserveYourFlight();
	}
}


public class Passenger {
	private String fullName;
	private int id;
	private int birthDate;

	public String getFullName() {
		return fullName;

	}

	public Passenger(String fullName, int id, int birthDate) {
		super();
		this.fullName = fullName;
		this.id = id;
		this.birthDate = birthDate;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Passenger [fullName=" + fullName + ", id=" + id + ", birthDate=" + birthDate + "]";
	}

}

