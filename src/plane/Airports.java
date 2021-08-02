package plane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Airports implements Comparable<Airports>, Serializable{
	private String id;
	private String name;
	private double runwaySize;
	private int maxFixedWingParkingPlace;
	private int maxRotatedWingParkingPlace;
	private ArrayList<String> listFixedWingAirplaneID;
	private ArrayList<String> listHelicopterID;
	
	public Airports() {
		super();
	}

	public Airports(String id, String name, double runwaySize, int maxFixedWingParkingPlace,
			int maxRotatedWingParkingPlace, ArrayList<String> listFixedWingAirplaneID, ArrayList<String> listHelicopterID) {
		super();
		this.id = id;
		this.name = name;
		this.runwaySize = runwaySize;
		this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
		this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
		this.listFixedWingAirplaneID = listFixedWingAirplaneID;
		this.listHelicopterID = listHelicopterID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRunwaySize() {
		return runwaySize;
	}

	public void setRunwaySize(double runwaySize) {
		this.runwaySize = runwaySize;
	}

	public int getMaxFixedWingParkingPlace() {
		return maxFixedWingParkingPlace;
	}

	public void setMaxFixedWingParkingPlace(int maxFixedWingParkingPlace) {
		this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
	}

	public int getMaxRotatedWingParkingPlace() {
		return maxRotatedWingParkingPlace;
	}

	public void setMaxRotatedWingParkingPlace(int maxRotatedWingParkingPlace) {
		this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
	}

	public List<String> getListFixedWingAirplaneID() {
		return listFixedWingAirplaneID;
	}

	public void setListFixedWingAirplaneID(ArrayList<String> listFixedWingAirplaneID) {
		this.listFixedWingAirplaneID = listFixedWingAirplaneID;
	}

	public List<String> getListHelicopterID() {
		return listHelicopterID;
	}

	public void setListHelicopterID(ArrayList<String> listHelicopterID) {
		this.listHelicopterID = listHelicopterID;
	}

	@Override
	public int compareTo(Airports o) {
		return this.getId().compareTo(o.getId());
	}
	
	@Override
	public String toString() {
		return getId() + " : " + getName()+ " : " +getRunwaySize()+ " : " +getMaxFixedWingParkingPlace()+ " : " +getMaxRotatedWingParkingPlace()
		+ " : " +"Number of Fixedwing plane: "+ " : " +getListFixedWingAirplaneID().size()
		+ " : " +"Number of helicopter: "+getListHelicopterID().size();
	}
	
	public void displayListFWID() {
		System.out.println("List Fixedwing ID: ");
		for(String id : getListFixedWingAirplaneID()) {
			System.out.print(id+"\t");
		}
	}
	public void displayListHID() {
		System.out.println("List Helicopters ID: ");
		for(String id : getListHelicopterID()) {
			System.out.print(id+"\t");
		}
	}
}
