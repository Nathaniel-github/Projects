/*
Author: Nathaniel Thomas
Date: 09/18/19
Rev: 01
*/

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInput {
	public static void main(String[ ] args) throws InterruptedException {
		double fNum, sNum;
		Scanner myobj = new Scanner(System.in); //Initializes Scanner variable
		System.out.println("Would you like the full version (y/n): ");
		String input = myobj.nextLine(); //Takes the user input and stores it in input
		if (input.equals("y")) {
			System.out.println("Enter your first number: ");
			String firstnumber = myobj.nextLine(); // Stops program and stores the input of the user into the variable
			
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Enter your operator: ");
			String operator = myobj.nextLine(); // Reads the operator and stores it in the variable 'operator'

			System.out.println("Enter your second number: ");
			String secondnumber = myobj.nextLine(); // Reads the number again and stores it in the variable 'secondnumber'

			double answer = 1;
			if (operator.equals("+")) {
				answer = Double.valueOf(firstnumber) + Double.valueOf(secondnumber); // If the operator is '+' then the program adds the inputs
			}
			if (operator.equals("-")) {
				answer = Double.valueOf(firstnumber) - Double.valueOf(secondnumber); // If the operator is '-' then the program subtracts the inputs
					}
			if (operator.equals("*")) {
				answer = Double.valueOf(firstnumber) * Double.valueOf(secondnumber); // If the operator is '*' then the program multiplies the inputs
			}
			if (operator.equals("/")) {
				answer = Double.valueOf(firstnumber) / Double.valueOf(secondnumber); // If the operator is '/' then the program divides the inputs
			}
			System.out.println(answer);
		}		
		else {
			System.out.println("Enter a number: "); 
			int x = myobj.nextInt(); //Gets user input and stores it in x
			System.out.println("Enter a number: ");
			int y = myobj.nextInt(); //Gets user input and stores it in y
			System.out.println("The sum is: " + (x + y)); //Prints the sum of the user's input
			
			System.out.println("Enter a number: ");
			x = myobj.nextInt(); //Sets the new user input to x
			System.out.println("Enter a number: ");
			y = myobj.nextInt(); //Sets the new user input to y
			System.out.println("The product is: " + (x * y)); //Prints the product of the user's input
			
			System.out.println("Enter a number: ");
			fNum = myobj.nextInt(); //Sets the new user input to x
			System.out.println("Enter a number: ");
			sNum = myobj.nextInt(); //Sets the new user input to y
			System.out.println("The quotient is: " + (fNum / sNum)); //Prints the quotient of the user's input
			myobj.close();
		}
	}	
}