/*
Author: Nathaniel Thomas
Date: 09/18/19
Rev: 01
*/

import java.util.Scanner;
	
public class HelloWorldChoice {
	public static void main(String[ ] args) {
		int y = 1; //Sets the counter to 1
		Scanner myobj = new Scanner(System.in); //Initializes Scanner variable
		System.out.println("Type an integer: "); //Prints the quote
		int x = myobj.nextInt(); //Receives user input and stores it in integer x
		if (x == 1) {
			System.out.println("Hello, World!"); //Checks if input is 1 and if so prints Hello World
		}
		if (x == 2) {
			System.out.println("Hola, Mundo!"); //Checks if input is 2 and if so prints Hola Mundo
		}	
		if (x >= 3) { //This part of the code prints hello world as many times as the user's input
			while (x > 0) {
				System.out.println("Hello, World!"); //Prints Hello World
				System.out.println("This line has been printed " + y + " times.");
				x -= 1; //Makes the vaue of x one less
				y ++; //Sets the counter up one
			}
		}
		myobj.close();
	}	
}