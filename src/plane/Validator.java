package plane;

public class Validator {
	
	public static String generateID(int idType, int modelCount) {
		StringBuilder temp = new StringBuilder();
		
		int idLength = (int)(Math.log(modelCount)+1);
		if(idType == 1) {
			temp.append("FW");
		}
		if(idType == 2) {
			temp.append("RW");
		}
		if(idType == 3) {
			temp.append("AP");
		}
		for(int i = 0; i < 5 - idLength; i++) {
			temp.append("0");
		}
		return temp.toString();
	}

	public static boolean checkModelSize(String modelSize) {
		if(modelSize.length() > 40 || modelSize.length() == 0) return false;
		else return true;
	}

	public static boolean checkFixedWingType (String fWType) {
		if(!fWType.equals("CAG") && !fWType.equals("LGR") && !fWType.equals("PRV")) {
			return false;
		}
		else return true;
	}
	
	public static boolean checkMaxTakeOfWeight(double maxTakeoffWeight, double emptyWeight) {
		boolean rs = false;
		
		if(maxTakeoffWeight >= (emptyWeight * 1.5) || emptyWeight > maxTakeoffWeight) rs = false;
		else rs = true;
		
		return rs;
	}
}
