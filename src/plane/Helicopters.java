package plane;

import java.io.Serializable;

public class Helicopters extends Airplane implements Serializable{
	private double range;
	private static final String flyMethod = "fixed wing";
	public Helicopters(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
	}
	public Helicopters(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight,
			double range) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
		this.range = range;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public static String getFlymethod() {
		return flyMethod;
	}
	
	
}
