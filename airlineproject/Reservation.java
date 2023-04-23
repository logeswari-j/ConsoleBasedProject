package airlineproject;

import java.util.Scanner;

public class Reservation {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] array_name) {
		Airline object = new Airline();
		Airline.logIn();

		byte typeChoice;

		do {
			typeChoice = scan.nextByte();

			switch (typeChoice) {
			case 1:
				object.addAirlines();
				break;

			case 2:
				object.displayAirlines();
				break;

			case 3:
				object.searchAirlines();
				break;

			case 4:
				object.deleteAirlines();
				break;

			case 5:
				object.updateAirlines();
				break;

			case 6:
				object.logOut();
			}
		} while (typeChoice != 6);
	}
}
