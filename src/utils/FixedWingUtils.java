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

public class FixedWingUtils {
	public static void saveOneFixedWing(Fixedwing fw) {
		try {
			FileWriter f = new FileWriter("FWList.txt",true);
			f.write("\n");
			f.write(fw.getId());
			f.write("\n");
			f.write(fw.getModel());
			f.write("\n");
			f.write(fw.getPlaneType());
			f.write("\n");
			f.write(fw.getFlymethod());
			f.write("\n");
			f.write(fw.getCruiseSpeed()+"");
			f.write("\n");
			f.write(fw.getEmptyWeight()+"");
			f.write("\n");
			f.write(fw.getMaxTakeoffWeight() + "");
			f.write("\n");
			f.write(fw.getMinNeededRunwaySize() + "");
			
			f.close();
		} catch (IOException e) {
			System.out.println("Lỗi ghi file");
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Fixedwing> getAllFromFile() {
		ArrayList<Fixedwing> listRead = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("FWList.txt"));
			while(input.hasNextLine()) {
				String id = input.nextLine();
				String model = input.nextLine();
				String planeType = input.nextLine();
				String flyMethod = input.nextLine();
				double cruiseSpeed = Double.parseDouble(input.nextLine());
				double emptyWeight = Double.parseDouble(input.nextLine());
				double maxTakeOffWeight = Double.parseDouble(input.nextLine());
				double minNeededRunwaySize = Double.parseDouble(input.nextLine());
				Fixedwing fw = new Fixedwing(id, model, cruiseSpeed, emptyWeight, maxTakeOffWeight, planeType, minNeededRunwaySize);
				listRead.add(fw);
				input.close();
			}
				
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Không tìm thấy file");
		}
		
		return listRead;
		
	}
	
	public static ArrayList<Fixedwing> listNonParked() {
		ArrayList<Fixedwing> allFW = FixedWingUtils.getAllFromFile();
		ArrayList<Airports> allAirport = AirportUtils.readAllFromFile();
		for(Airports a : allAirport) {
			for(Fixedwing fw : allFW) {
				if(a.getListFixedWingAirplaneID().contains(fw.getId())) {
					allFW.remove(fw);
				}
			}
		}
		return allFW;
	}
	
	public static Map<Fixedwing, Airports> listParked() {
		Map<Fixedwing, Airports> listFwA = new HashMap<>();
		ArrayList<Fixedwing> allFW = FixedWingUtils.getAllFromFile();
		ArrayList<Airports> allAirport = AirportUtils.readAllFromFile();
		for(Airports a : allAirport) {
			for(Fixedwing fw : allFW) {
				if(a.getListFixedWingAirplaneID().contains(fw.getId())) {
					listFwA.put(fw, a);
					allFW.remove(fw);
				}
			}
		}
		return listFwA;
	}
}
