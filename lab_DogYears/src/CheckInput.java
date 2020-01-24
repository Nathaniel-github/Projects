/*
 Author: Nathaniel Thomas
 Date: 10/27/19
 Rev: 01
 */

import java.util.*;


public class CheckInput {
	Scanner myobj;
	public CheckInput() {
		myobj = new Scanner(System.in);
	}
	
	public int getInt(String message) { //Method that checks to make sure that the input is an integer
		int output = 0;
		boolean check = false;
		boolean firstTime = true;
		System.out.println(message);
		while (!check) { //Checks to make sure that the input is and integer and won't continue unless it is
			if (myobj.hasNextInt()) {
				output = myobj.nextInt();
				check = true;
			}
			else {
				System.out.println("That wasn't a valid input");
				System.out.println(message);
				myobj.nextLine();
			}
		}
		return output;
	}
	
	public int checkIntRange(String message, int lowPar, int highPar) { //Method that checks to make sure that the input is an integer in a certain range
		int output = 0;
		boolean check = false;
		boolean firstTime = true;
		System.out.println(message);
		while (!check) { //Checks to make sure that the input is in a certain range and won't continue unless it is
			if (myobj.hasNextInt()) {
				output = myobj.nextInt();
				if (output > lowPar && output < highPar) {
					check = true;
				}
				else {
					System.out.println("That wasn't a valid input");
					System.out.println(message);
					myobj.nextLine();
				}
			}
			else {
				System.out.println("That wasn't a valid input");
				System.out.println(message);
				myobj.nextLine();
			}
		}
		return output;
	}
	
	
	public String getMessage(String message, String desiredOutput) {
		String output = "";
		String checker;
		String [] parts = desiredOutput.split(" ");
		boolean check = false;
		System.out.println(message);
		while (!check) { //Checks to make sure that the input is a String and won't continue to the rest of the code unless it is
			checker = myobj.next();
			for (String element : parts) { //Checks the user input against all the possible outputs the code wanted
	            if (element.equals(checker)) { 
	                check = true; 
	                output = checker;
	                break; 
	            } 
	        }
			if (!check) {
				System.out.println("That wasn't a valid input");
				System.out.println(message);
			}
		}
		return output;
	}
	
	public String getYesNo(String message) {
		String output = "";
		String checker;
		boolean check = false;
		System.out.println(message);
		while (!check) { //Checks to make sure that the input is a String and won't continue to the rest of the code unless it is
			checker = myobj.next();
			if (checker.equals("y") || checker.equals("yes") || checker.equals("Yes") || checker.equals("n") || checker.equals("no") || checker.equals("No")) {
				check = true;
				output = checker;
			}
			else {
				System.out.println("That wasn't a valid input");
				System.out.println("Would you like the original version of the code? (y/n)");
			}
		}
		return output;
	}
	

}
