package com.epam.house.constuction;

/**
 * This class provides services for house construction
 */
public class HouseConstruction {
	
	/**
	 * This method is to calculate the the cost of house construction based on various materials
	 * @param materialQuality , signifies quality of the material ranging 1 to 3
	 * @param area, it  signifies area of the house
	 * @param fully_automated , signifies weather house is fully automated or not
	 * @return
	 */
	public double ConstructionCost(int materialQuality, double area, boolean fully_automated) {
		
		/**
		 * checks if material quality is Standard
		 */
		if(materialQuality == 1) {
			return 1200*area;
		}
		
		/**
		 * Checks if material quality is above standard 
		 */
		else if( materialQuality == 2) {
			return 1500*area;
		}
		
		/**
		 * checks if user needs fully automated home
		 * only home with high standard material will be checked for fully automation   
		 */
		else if(fully_automated){
			return 2500*area;
		}
		
		/**
		 * homes with high standard material with not fully automation will be left for this case
		 */
		else {
			return 1800*area;
		}
	}
}
