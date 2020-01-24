/**
 * @(#)DogYears.java
 *

  For testing purposes:
  Dog age of 1 = Human age 13
  Dog age of 2 = Human age 18
  Dog age of 5 = Human age 34
  Dog age of 8 = Human age 50
  Dog age of 12 = Human age 72

 *
 * Author: Nathaniel Thomas
 * Date: 11/3/19
 * Rev: 01
 */

import java.util.concurrent.TimeUnit;

public class DogYears {
	
    public int convertToHumanYears(int dog) { //Converts dog to human years
    	double halfStep = (dog - 13) * (3/16.0) + 1;
    	int human = 0;
    	if (halfStep < 0) {
    	 human = 0;
    	}
    	else {
    		human = (int)halfStep;
    		if ((human + 0.5 < halfStep)) {
    			human ++;
    		}
    	}
    	return human;
    }

	
    public int convertToDogYears(int human) {
    	double halfStep = (16.0/3) * (human - 1) + 13;
    	int dog = (int)halfStep;
    	if ((dog + 0.5 < halfStep)) {
			dog ++;
		}
    	return dog;
    }
    

	public static void main (String[] args) {
		// TAKE IN USER INPUT
		CheckInput myobj = new CheckInput();
		int dog = myobj.getInt("Enter your age: ");

		DogYears converter = new DogYears();
		int human = converter.convertToDogYears(dog);

		// PRINT OUT THE RESULT
		System.out.println("Your age in dog years is");
		
		
		for (int i = 0; i < 3; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} 
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			System.out.print(".");
		}
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} 
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println();
		System.out.println(human);
		
		int dogAge = myobj.getInt("Enter your dog's age in dog years: ");
		
		int humanAge = converter.convertToHumanYears(dogAge);

		System.out.println("Your dog's age in human years is ");
		for (int i = 0; i < 3; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			System.out.print(".");
		}
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println();
		System.out.println(humanAge);
	}

}