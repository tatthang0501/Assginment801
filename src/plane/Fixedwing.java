package plane;

import java.io.Serializable;

public class Fixedwing extends Airplane implements Serializable{
	private String planeType;
	private double minNeededRunwaySize;
	private static final String flyMethod = "fixed wing";
	
	public Fixedwing(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
	}

	public Fixedwing(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight,
			String planeType, double minNeededRunwaySize) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
		this.planeType = planeType;
		this.minNeededRunwaySize = minNeededRunwaySize;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public double getMinNeededRunwaySize() {
		return minNeededRunwaySize;
	}

	public void setMinNeededRunwaySize(double minNeededRunwaySize) {
		this.minNeededRunwaySize = minNeededRunwaySize;
	}

	public static String getFlymethod() {
		return flyMethod;
	}
	
}
