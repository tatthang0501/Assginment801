package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import plane.Airports;

public class AirportUtils {
	
	public AirportUtils() {
		super();
	}

	public static ArrayList<Airports> readAllFromFile(){
		ArrayList<Airports> listAirport = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("AirportList.txt"));
			while(input.hasNextLine()) {
				String id = input.nextLine();
				String name = input.nextLine();
				double runwaySize = Double.parseDouble(input.nextLine());
				int maxFixedWingParkingPlace = Integer.parseInt(input.nextLine());
				int maxRotatedWingParkingPlace = Integer.parseInt(input.nextLine());
				String listFWAID = input.nextLine();
				ArrayList<String> listFixedWingAirplaneID = stringtoList(listFWAID);
				String listHID = input.nextLine();
				ArrayList<String> listHelicopterID = stringtoList(listHID);
				
				Airports a = new Airports(id, name, runwaySize, maxFixedWingParkingPlace, maxRotatedWingParkingPlace, listFixedWingAirplaneID, listHelicopterID);
				listAirport.add(a);
			}
			input.close();
		} catch (IOException e) {
			System.out.println("Lỗi đọc file");
		}
		return listAirport;
	}
	
	private static ArrayList<String> stringtoList(String listIDByString){
			ArrayList<String> rs = new ArrayList<String>();
			String trimmedString = listIDByString.trim();
			String[] splitedList = trimmedString.split(" ");
			if(splitedList.length > 1) {
				for(int i = 1; i < splitedList.length; i++) {
					rs.add(splitedList[i]);
				}
				return rs;
			}
			else return null;
	}
	
	public static void writeAllToFile(ArrayList<Airports> listAirport) {
		try {
			FileWriter fw = new FileWriter("AirportList.txt");
			for(Airports a : listAirport) {
				fw.write(a.getId());
				fw.write("\n");
				fw.write(a.getName());
				fw.write("\n");
				fw.write(a.getRunwaySize()+"");
				fw.write("\n");
				fw.write(a.getMaxFixedWingParkingPlace());
				fw.write("\n");
				fw.write(a.getMaxRotatedWingParkingPlace());
				fw.write("\n");
				fw.write("ListFWID: ");
				for(String s : a.getListFixedWingAirplaneID()) {
					fw.write(s + " ");
				}
				fw.write("\n");
				fw.write("ListHID: ");
				for(String s : a.getListHelicopterID()) {
					fw.write(s + " ");
				}
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Lỗi ghi file");
		}
		
	}
	
	public static void writeAnAirportToFile(Airports a) {
		try {
			FileWriter fw = new FileWriter("AirportList", true);
				fw.write("\n");
				fw.write(a.getId());
				fw.write("\n");
				fw.write(a.getName());
				fw.write("\n");
				fw.write(a.getRunwaySize()+"");
				fw.write("\n");
				fw.write(a.getMaxFixedWingParkingPlace());
				fw.write("\n");
				fw.write(a.getMaxRotatedWingParkingPlace());
				fw.write("\n");
				for(String s : a.getListFixedWingAirplaneID()) {
					fw.write(s + " ");
				}
				fw.write("\n");
				for(String s : a.getListHelicopterID()) {
					fw.write(s + " ");
				}
			fw.close();
		} catch (IOException e) {
			System.out.println("Lỗi ghi file");
		}
		
	}	
	
	public static boolean deleteAirport(String airportID) {
		boolean check = false;
		ArrayList<Airports> listAirport = readAllFromFile();
		for(Airports a : listAirport) {
			if(a.getId().equals(airportID)) {
				listAirport.remove(a);
				check = true;
				break;
			}
		}
		return check;
	}
	
	public static Airports getAirportsByID(String airportID) {
		ArrayList<Airports> listAirport = readAllFromFile();
		Airports rs = null;
		for(Airports a : listAirport) {
			if(a.getId().equals(airportID)) {
				rs = a;
				break;
			}
		}
		return rs;
	}
}
