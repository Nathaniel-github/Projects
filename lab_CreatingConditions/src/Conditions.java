/*
	This is the Conditions class template. Use this class to 
	create methods that return the results of tests described in the
	lab description!

	Author:Nathaniel Thomas
	Date: 12/13/19
	Rev: 03
	Notes: Pretty nice program. Added a menu using switch
	
*/

public class Conditions {
	// No fields

	// This is an example method that tests the parameters in some way,
	// then returns the result of the test
	public boolean exampleTestMethod(int x, int y, int rectX, int rectY, int rectWidth, int rectHeight) {

		boolean result = false;

		if (x < rectX + rectWidth && x > rectX && y < rectY + rectHeight && y > rectY) {
			result = true;
		}

		return result;
	}

	public boolean isLeapYear(int year) {
		boolean result = false;

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			result = true;
		}

		return result;
	}

	// Add methods for the additional conditions below

	public boolean hasTwoEndingZeroes(int number) {
		boolean result = false;
		if (number % 100 == 0 && number % 1000 != 0) {
			result = true;
		}
		return result;
	}

	public boolean isLater(String firstDate, String secondDate) {
		boolean result = false;

		String parts[] = firstDate.split("/");
		String parts2[] = secondDate.split("/");
		try {
			for (int i = 2; i >= 0; i--) {
				if (Integer.parseInt(parts[i]) > Integer.parseInt(parts2[i])) {
					result = true;
					break;
				} else if (Integer.parseInt(parts[i]) < Integer.parseInt(parts2[i])) {
					break;
				}
			}
		} catch (Exception e) {
			result = false;
		}
		if (parts.length > 3 || parts2.length > 3) {
			result = false;
		}
		return result;
	}

	public double getOrderTotal(int bp, int nb) {
		double orderTotal = 0.00;

		if (bp + nb >= 12) {
			orderTotal = (bp + nb) * 14.00;
		} else if (bp + nb >= 3) {
			orderTotal = (bp + nb) * 15.95;
		} else {
			orderTotal = bp * 18.95 + nb * 21.95;
		}
		return orderTotal;
	}

}
