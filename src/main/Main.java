package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import plane.Airports;
import plane.Fixedwing;
import plane.Helicopters;
import plane.Validator;
import utils.AirportUtils;
import utils.FixedWingUtils;
import utils.HelicopterUtils;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("=========== Airport and Plane management program ===========");
		System.out.println("1. Add an airport");
		System.out.println("2. Add an fixed wing plane");
		System.out.println("3. Add an helicopter");
		System.out.println("4. Display list of all airport information, sorted by airport ID");
		System.out.println("5. Display the status of one airport, selected by airport ID");
		System.out.println("6. Display list of all fixed wing airplanes with its parking airport ID and name");
		System.out.println("7. Display list of all helicopters with its parking airport ID and name");
		System.out.println("8. Exit");
		
		int key = 0;
		
		while(key != 8) {
			System.out.print("Input your choice: ");
			key = sc.nextInt();
			switch (key) {
			case 1:
				addAnAirport();
				break;
			case 2:
				addAnFixedWing();
			case 3:
				addAnHelicopters();
			case 4:
				displaySortedAirport();
			case 5:
				displayOneAirport();
			case 6:
				displayListFixedwing();
			case 7:
				displayListHelicopters();
			case 8:
				System.exit(0);
			default:
				break;
			}
		}
		
		
		sc.close();
	}



	private static void addAnAirport() {
		int count = AirportUtils.readAllFromFile().size() + 1;
		String id = Validator.generateID(3, count+1);
		System.out.print("Input airport name: ");
		String name = sc.next();
		System.out.print("Input runway size: ");
		double runwaySize = sc.nextDouble();
		System.out.print("Input max fixedwing parking place: ");
		int maxFixedwingParkingPlace = sc.nextInt();
		System.out.print("Input max rotatedwing parking place: ");
		int maxRotatedwingParkingPlace = sc.nextInt();
		System.out.print("Input number of fixedwing to park: ");
		int currCount = sc.nextInt();
		ArrayList<String> listFixedwingID = new ArrayList<>();
		while(currCount > maxFixedwingParkingPlace) {
			System.out.print("Input number of fixedwing to park: ");
			currCount = sc.nextInt();
		}
		for(int i = 0; i < currCount; i++) {
			System.out.println("List of non-parked fixedwing plane: ");
			ArrayList<Fixedwing> listNonPark = FixedWingUtils.listNonParked();
			for(Fixedwing f : listNonPark) {
				System.out.println(f.getId());
			}
			System.out.print("Choose plane: ");
			String fwID = sc.next();
			while(!listNonPark.contains(fwID)) {
				System.out.print("Choose plane: ");
				fwID = sc.next();
			}
			listFixedwingID.add(fwID);
		}
		
		System.out.print("Input number of helicopter to park: ");
		int currHCount = sc.nextInt();
		ArrayList<String> listHelicopterID = new ArrayList<>();
		while(currHCount > maxRotatedwingParkingPlace) {
			System.out.print("Input number of helicopter to park: ");
			currHCount = sc.nextInt();
		}
		for(int i = 0; i < currHCount; i++) {
			System.out.println("List of non-parked helicopter plane: ");
			ArrayList<Helicopters> listNonPark = HelicopterUtils.listNonParked();
			for(Helicopters f : listNonPark) {
				System.out.println(f.getId());
			}
			System.out.print("Choose plane: ");
			String hID = sc.next();
			while(!listNonPark.contains(hID)) {
				System.out.print("Choose plane: ");
				hID = sc.next();
			}
			listHelicopterID.add(hID);
		}
		
		Airports a = new Airports(id, name, runwaySize, maxFixedwingParkingPlace, maxRotatedwingParkingPlace, listFixedwingID, listHelicopterID);
		AirportUtils.writeAnAirportToFile(a);
		System.out.println("Add complete");
		
	}

	private static void addAnFixedWing() {
		int count = FixedWingUtils.getAllFromFile().size() + 1;
		String id = Validator.generateID(1, count+1);
		System.out.print("Input your model: ");
		String model = sc.next();
		while(Validator.checkModelSize(model) == false) {
			System.out.print("Input your model: ");
			model = sc.next();
		}
		System.out.println("Input your plane type: ");
		String planeType = sc.next();
		while(Validator.checkFixedWingType(planeType) == false) {
			System.out.print("Input your plane type: ");
			planeType = sc.next();
		}
		System.out.print("Input cruise speed: ");
		double cruiseSpeed = sc.nextDouble();
		System.out.print("Input empty weight: ");
		double emptyWeight = sc.nextDouble();
		System.out.print("Input max takeoff weight: ");
		double maxTakeoffWeight = sc.nextDouble();
		while(Validator.checkMaxTakeOfWeight(maxTakeoffWeight, emptyWeight) == false) {
			System.out.print("Input max takeoff weight: ");
			maxTakeoffWeight = sc.nextDouble();
		}
		
		System.out.print("Input min needed runway size: ");
		double minNeededRunwaySize = sc.nextDouble();
		
		Fixedwing fw = new Fixedwing(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, planeType, minNeededRunwaySize);
		FixedWingUtils.saveOneFixedWing(fw);
		System.out.println("Add complete");
	}

	private static void addAnHelicopters() {
		int count = HelicopterUtils.getAllFromFile().size() + 1;
		String id = Validator.generateID(2, count+1);
		System.out.print("Input your model: ");
		String model = sc.next();

		System.out.print("Input range: ");
		double range = sc.nextDouble();
		
		System.out.print("Input cruise speed: ");
		double cruiseSpeed = sc.nextDouble();
		System.out.print("Input empty weight: ");
		double emptyWeight = sc.nextDouble();
		System.out.print("Input max takeoff weight: ");
		double maxTakeoffWeight = sc.nextDouble();
		while(Validator.checkMaxTakeOfWeight(maxTakeoffWeight, emptyWeight) == false) {
			System.out.print("Input max takeoff weight: ");
			maxTakeoffWeight = sc.nextDouble();
		}
		
		Helicopters h = new Helicopters(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, range);
		HelicopterUtils.saveOneHelicopters(h);
		System.out.println("Add complete");
	}

	private static void displaySortedAirport() {
		ArrayList<Airports> listAllAirport = AirportUtils.readAllFromFile();
		Collections.sort(listAllAirport);
		System.out.println("ID\tName\tRunwaySize\tMaxFixedWingParkingPlace\tMaxHelicopterParkingPlace\t");
		
		for(Airports a : listAllAirport) {
			System.out.println(a.toString());
		}
	}

	private static void displayOneAirport() {
		
		ArrayList<Airports> listAllAirport = AirportUtils.readAllFromFile();
		Airports displayAirport = null;
		boolean check = false;
		String airportID;
		while(check == false) {
			System.out.print("Input airport ID: ");
			airportID = sc.next();
			for(Airports a : listAllAirport) {
				if(a.getId().equals(airportID)) {
					check = true;
					displayAirport = a;
					break;
				}
			}
		}
		if(displayAirport != null) {
			System.out.println(displayAirport.toString());
			displayAirport.displayListFWID();
			displayAirport.displayListHID();
		}
		
	}

	private static void displayListFixedwing() {
		System.out.println("List parked fixedwing plane: ");
		Map<Fixedwing, Airports> list = FixedWingUtils.listParked();
		for(Map.Entry<Fixedwing, Airports> entry : list.entrySet()) {
			System.out.println(entry.getKey().getId() + " : " + entry.getKey().getModel() + " / " + entry.getValue().getId() + " : " + entry.getValue().getName());
		}
	}

	private static void displayListHelicopters() {
		System.out.println("List parked helicopters: ");
		Map<Helicopters, Airports> list = HelicopterUtils.listParked();
		for(Map.Entry<Helicopters, Airports> entry : list.entrySet()) {
			System.out.println(entry.getKey().getId() + " : " + entry.getKey().getModel() + " / " + entry.getValue().getId() + " : " + entry.getValue().getName());
		}
	}
}
