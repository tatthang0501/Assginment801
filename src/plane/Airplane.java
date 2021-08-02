package plane;

import java.io.Serializable;

public class Airplane implements Serializable{
	private String id;
	private String model;
	private double cruiseSpeed;
	private double emptyWeight;
	private double maxTakeoffWeight;
	
	public Airplane() {
		super();
	}

	public Airplane(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight) {
		super();
		this.id = id;
		this.model = model;
		this.cruiseSpeed = cruiseSpeed;
		this.emptyWeight = emptyWeight;
		this.maxTakeoffWeight = maxTakeoffWeight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getCruiseSpeed() {
		return cruiseSpeed;
	}

	public void setCruiseSpeed(double cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}

	public double getEmptyWeight() {
		return emptyWeight;
	}

	public void setEmptyWeight(double emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	public double getMaxTakeoffWeight() {
		return maxTakeoffWeight;
	}

	public void setMaxTakeoffWeight(double maxTakeoffWeight) {
		this.maxTakeoffWeight = maxTakeoffWeight;
	}
	
}
