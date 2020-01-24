/*
 Author: Nathaniel Thomas
 Date: 12/13/19
 Rev:01
 */
public class Tester {

	public static void main(String[] args) {
		CheckInput myobj = new CheckInput();
		FinalReview calc = new FinalReview();
		double moneyAdded = 0;
		boolean looping = true;
		double total = 0;
		boolean first = true;
		while (looping) {
			System.out.println("X ----------- 10");
			System.out.println("Y ----------- 20");
			System.out.println("Z ----------- 30");
			System.out.println("exit ------ EXIT");
			if (!first) {
				System.out.println("Your current total is: " + total);
			}
			else {
				first = false;
			}
			String userInput = myobj.getMessage("Enter your input", "x y z exit");
			switch (userInput) {
			case "x":
			case "X":
				moneyAdded = 10;
				break;
			case "y":
			case "Y":
				moneyAdded = 20;
				break;
			case "z":
			case "Z":
				moneyAdded = 30;
				break;
			}
			if (userInput.equalsIgnoreCase("exit")) {
				looping = false;
				break;
			}
			total = calc.updateTotal(moneyAdded);
		}

	}
}
