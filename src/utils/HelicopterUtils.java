package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import plane.Airports;
import plane.Fixedwing;
import plane.Helicopters;


public class HelicopterUtils {

	public static ArrayList<Helicopters> listNonParked() {
		ArrayList<Helicopters> allH = HelicopterUtils.getAllFromFile();
		ArrayList<Airports> allAirport = AirportUtils.readAllFromFile();
		for(Airports a : allAirport) {
			for(Helicopters h : allH) {
				if(a.getListFixedWingAirplaneID().contains(h.getId())) {
					allAirport.remove(h);
				}
			}
		}
		return allH;
	}

	public static ArrayList<Helicopters> getAllFromFile() {
		ArrayList<Helicopters> listRead = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("HList.txt"));
			while(input.hasNextLine()) {
				String id = input.nextLine();
				String model = input.nextLine();
				String flyMethod = input.nextLine();
				double range = Double.parseDouble(input.nextLine());
				double cruiseSpeed = Double.parseDouble(input.nextLine());
				double emptyWeight = Double.parseDouble(input.nextLine());
				double maxTakeOffWeight = Double.parseDouble(input.nextLine());
				Helicopters h = new Helicopters(id, model, cruiseSpeed, emptyWeight, maxTakeOffWeight, range);
				listRead.add(h);
				input.close();
			}
				
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Không tìm thấy file");
		}
		
		return listRead;
	}

	public static void saveOneHelicopters(Helicopters h) {
		try {
			FileWriter f = new FileWriter("HList.txt",true);
			f.write("\n");
			f.write(h.getId());
			f.write("\n");
			f.write(h.getModel());
			f.write("\n");
			f.write(h.getFlymethod());
			f.write("\n");
			f.write(h.getRange()+"");
			f.write("\n");
			f.write(h.getCruiseSpeed()+"");
			f.write("\n");
			f.write(h.getEmptyWeight()+"");
			f.write("\n");
			f.write(h.getMaxTakeoffWeight() + "");
			
			f.close();
		} catch (IOException e) {
			System.out.println("Lỗi ghi file");
			e.printStackTrace();
		}
	}
	
	public static Map<Helicopters, Airports> listParked() {
		Map<Helicopters, Airports> listHA = new HashMap<>();
		ArrayList<Helicopters> allH = HelicopterUtils.getAllFromFile();
		ArrayList<Airports> allAirport = AirportUtils.readAllFromFile();
		for(Airports a : allAirport) {
			for(Helicopters fw : allH) {
				if(a.getListHelicopterID().contains(fw.getId())) {
					listHA.put(fw, a);
					allH.remove(fw);
				}
			}
		}
		return listHA;
	}
}
