//****** CONSOLE BASED PROJECT ******//
package airlineproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Airline {
	private String airline_id, airline_name, source, destination;
	private int seating_capacity, cost;
	private static Scanner scan = new Scanner(System.in);

	List<Airline> airline_object = new ArrayList<Airline>();

	public Airline() {
		System.out.println("*******WELCOME TO FLYHIGH RESERVATION******");

		System.out.println();

		System.out.println("Press 1 to add an airline");

		System.out.println("Press 2 to display all the airlines");

		System.out.println("Press 3 to search an airline");

		System.out.println("Press 4 to delete an  airline");

		System.out.println("Press 5 to update an airline");

		System.out.println("Press 6 to logout");

		System.out.println();
	}

	public Airline(String airline_name, String airline_id, String source, String destination, int seating_capacity,
			int cost) {
		this.airline_name = airline_name;
		this.airline_id = airline_id;
		this.source = source;
		this.destination = destination;
		this.seating_capacity = seating_capacity;
		this.cost = cost;
	}

	public String getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(String airline_id) {
		this.airline_id = airline_id;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeatingCapacity() {
		return seating_capacity;
	}

	public void setSeatingCapacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String toString() {
		return airline_id + " " + airline_name + " " + source + " " + destination + " " + seating_capacity + " " + cost;
	}

	public static void logIn() {
		System.out.print("Holder name: ");
		String holder_name = scan.next();

		System.out.print("Holder password: ");
		String holder_password = scan.next();

		checkCredentials(holder_name, holder_password);
	}

	public static void checkCredentials(String holder_name, String holder_password) {
		if (holder_name.equals("Traveller") && holder_password.equals("journey90")) {
			System.out.println("Logged In Successfully");
		} else {
			System.out.println("Check your credentials and Enter correct holder_name, holder_password again");
			System.out.println();
			Airline.logIn();
		}
	}

	public void addAirlines() {
		System.out.print("Enter airline_name: ");
		String airline_name = scan.next();

		System.out.print("Enter airline_id: ");
		String airline_id = scan.next();

		System.out.print("Enter source: ");
		String source = scan.next();

		System.out.print("Enter destination: ");
		String destination = scan.next();

		System.out.print("Enter seating capacity: ");
		int seating_capacity = scan.nextInt();

		System.out.print("Enter cost: ");
		int cost = scan.nextInt();

		airline_object.add(new Airline(airline_name, airline_id, source, destination, seating_capacity, cost));
	}

	public void displayAirlines() {
		Iterator<Airline> show = airline_object.iterator();
		while (show.hasNext())
			System.out.println(show.next());
	}

	public void searchAirlines() {
		boolean search_flag = false;

		System.out.println("Type unique id to search the details");
		String searched_id = scan.next();
		for (Airline content : airline_object) {
			if (content.getAirline_id().equals(searched_id)) {
				search_flag = true;
				System.out.println("Airline detail found");
				break;
			}
		}
		if (search_flag == false)
			System.out.println("Airline detail not found");
	}

	public void deleteAirlines() {
		boolean delete_flag = false;

		System.out.println("Type unique id to delete the details");
		String delete_id = scan.next();

		for (Airline content : airline_object) {
			if (content.getAirline_id().equals(delete_id)) {
				delete_flag = true;
				airline_object.remove(content);
				System.out.println("deleted succesfully");
				break;
			}
		}
		if (delete_flag == false)
			System.out.println("Airline detail not found");
	}

	public void updateAirlines() {
		boolean update_flag = false;

		System.out.println("Type unique id to update the details: ");
		String unique_id = scan.next();

		System.out.println("Type airline name to update the details: ");
		String airline = scan.next();

		int timer = -1;
		for (Airline details : airline_object) {
			timer++;
			if (details.getAirline_id().equals(unique_id)) {
				update_flag = true;
				System.out.println("Type the updated seating capacity: ");
				int update_seatingCapacity = scan.nextInt();

				System.out.println("Type the updated source: ");
				String update_source = scan.next();

				System.out.println("Type the updated destination: ");
				String update_destination = scan.next();

				System.out.println("Type the updated cost: ");
				int update_cost = scan.nextInt();

				airline_object.set(timer, new Airline(airline, unique_id, update_source, update_destination,
						update_seatingCapacity, update_cost));
				break;
			}
		}
		if (update_flag == false)
			System.out.println("ID not found");
	}

	public void logOut() {
		System.out.println("Logged out successfully");
	}

}
