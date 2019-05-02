package com.mercadolibre.solarsystem.utils;

public class MathUtil {

	public static int oppositeDegrees(Integer degrees) {
		
		int oppositeDegree = new Integer(degrees);
		oppositeDegree += 180;
		oppositeDegree = subtractSurplusDegress(oppositeDegree);
		return oppositeDegree;
	}
	
	public static boolean isOppositeDegree(Integer degrees, Integer oppositeDegrees) {
		Integer opposite = oppositeDegrees(degrees);
		return opposite.equals(oppositeDegrees);
	}
	
	private static int subtractSurplusDegress(Integer degrees) {
		if(degrees > 360) {
			return subtractSurplusDegress(degrees - 360);
		}
		return degrees;
	}

	public static int restYearsFromDays(Integer day,Integer daysOnYear) {
		if(day > daysOnYear) {
			return restYearsFromDays((day - daysOnYear), daysOnYear);
		}else {
			return day;
		}
	}
	
	public static boolean areDotsAlligned(Double x1,Double y1,Double x2,Double y2,Double x3,Double y3) {
		
		if (((x2-x1)*(y3-y2))-((y2-y1)*(x3-x2)) == new Double(0)){
			return true;
		}
		
		return false;
	}
	
	public static double area(Double x1,Double y1,Double x2,Double y2,Double x3,Double y3) {

		return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2.0); 
	
	} 

}
