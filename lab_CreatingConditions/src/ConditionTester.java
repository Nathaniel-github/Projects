/*
   This is the ConditionTester template. Use this class to test simple boolean methods!

   Author: Nathaniel Thomas
   Date: 11/27/19
   Rev: 01
   Notes:
   
*/

import java.util.Scanner;

public class ConditionTester {
	public static void main(String[] args) {
		CheckInput kboard = new CheckInput();
		Conditions myConditions = new Conditions();
		boolean result = false;
		double moneyResult = 0.0;
		Scanner myobj = new Scanner(System.in);
		boolean looping = true;

		// Copy-Paste more of these lines if more input is necessary
		while (looping) {
			System.out.println("0 -------- Example Test Method");
			System.out.println("1 -------- Leap Year Method");
			System.out.println("2 -------- Ending In Two Zeroes Method");
			System.out.println("3 -------- Is Later Method");
			System.out.println("4 -------- Book Cost Method");
			System.out.println("5 -------- Exit");
			
			int condition = kboard.checkIntRange("Enter the type of condition you want to test as a number between 0 and 5 --> ", 0, 5);
			
			switch (condition) {
			
			case 0:
				int num1 = kboard.getInt("Enter the x cord of the mouse --> ");

				int num2 = kboard.getInt("Enter the y cord of the mouse --> ");

				int num3 = kboard.getInt("Enter the starting x coordinate of the rectangle --> ");

				int num4 = kboard.getInt("Enter the starting y coordinate of the rectangle --> ");

				int num5 = kboard.getInt("Enter the width of the rectangle --> ");

				int num6 = kboard.getInt("Enter the height of the rectangle --> ");

				// Change this code so that it calls your method.
				result = myConditions.exampleTestMethod(num1, num2, num3, num4, num5, num6);
				break;

			case 1:
				int num7 = kboard.getInt("Enter the year you wish to check --> ");

				// Change this code so that it calls your method.
				result = myConditions.isLeapYear(num7);
				break;

			case 2:
				int num8 = kboard.getInt("Enter the number you wish to check --> ");

				// Change this code so that it calls your method.
				result = myConditions.hasTwoEndingZeroes(num8);
				break;

			case 3:
				System.out.println("Enter the first date you wish to check --> ");
				String num9 = myobj.nextLine();

				System.out.println("Enter the second date you wish to check --> ");
				String num10 = myobj.nextLine();
				// Change this code so that it calls your method.
				result = myConditions.isLater(num9, num10);
				break;

			case 4:
				int num11 = kboard.getInt("Enter the number of 'Be Prepared' books you have --> ");

				int num12 = kboard.getInt("Enter the number of 'Next Best' book you have --> ");
				// Change this code so that it calls your method.
				moneyResult = myConditions.getOrderTotal(num11, num12);
				break;
			case 5:
				break;
			}
//			if (condition == 0) {
//				int num1 = kboard.getInt("Enter the x cord of the mouse --> ");
//
//				int num2 = kboard.getInt("Enter the y cord of the mouse --> ");
//
//				int num3 = kboard.getInt("Enter the starting x coordinate of the rectangle --> ");
//
//				int num4 = kboard.getInt("Enter the starting y coordinate of the rectangle --> ");
//
//				int num5 = kboard.getInt("Enter the width of the rectangle --> ");
//
//				int num6 = kboard.getInt("Enter the height of the rectangle --> ");
//
//				// Change this code so that it calls your method.
//				result = myConditions.exampleTestMethod(num1, num2, num3, num4, num5, num6);
//			}
//
//			if (condition == 1) {
//				int num1 = kboard.getInt("Enter the year you wish to check --> ");
//
//				// Change this code so that it calls your method.
//				result = myConditions.isLeapYear(num1);
//			}
//
//			if (condition == 2) {
//				int num1 = kboard.getInt("Enter the number you wish to check --> ");
//
//				// Change this code so that it calls your method.
//				result = myConditions.hasTwoEndingZeroes(num1);
//			}
//
//			if (condition == 3) {
//				System.out.println("Enter the first date you wish to check --> ");
//				String num1 = myobj.nextLine();
//
//				System.out.println("Enter the second date you wish to check --> ");
//				String num2 = myobj.nextLine();
//				// Change this code so that it calls your method.
//				result = myConditions.isLater(num1, num2);
//			}
//
//			if (condition == 4) {
//				int num1 = kboard.getInt("Enter the number of 'Be Prepared' books you have --> ");
//
//				int num2 = kboard.getInt("Enter the number of 'Next Best' book you have --> ");
//				// Change this code so that it calls your method.
//				moneyResult = myConditions.getOrderTotal(num1, num2);
//			}
			
			// Printing out the result of the test!
			if (condition == 4) {
				System.out.println("The total cost was: " + moneyResult);
			} 
			else if (condition == 5) {
				break;
			}
			else {
				System.out.println("The result of the test: " + result);
			}
			System.out.println();
			System.out.println();
			System.out.println("Type 'exit' to stop the program or type anything else to continue");
			String leave = myobj.nextLine();
			if (leave.equalsIgnoreCase("exit")) {
				looping = false;
			}
		}
		myobj.close();
	}

}
