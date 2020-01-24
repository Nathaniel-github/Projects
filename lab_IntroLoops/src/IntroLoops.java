public class IntroLoops {

	public static void main(String[] args) {

		CheckInput myobj = new CheckInput();
		IntroLoops menu = new IntroLoops();
		String str = "";
		do {
		System.out.println("---MENU---");
		System.out.println("What would you like to see?");
		System.out.println("0) Division");
		System.out.println("1) Print Series");
		System.out.println("2) Repeat Word");
		System.out.println("3) Print Index Line");
		System.out.println("4) Standard Deviation");
		int menuChoice = myobj.checkIntRange("-----> ", 0, 4);
		
		if (menuChoice == 0) {
			int m = myobj.getInt("Enter your dividend: ");
			int n = myobj.getInt("Enter your divisor: ");
			System.out.println(menu.divide(m, n));
		} else if (menuChoice == 1) {
			int start = myobj.getInt("Enter your starting integer: ");
			int end = myobj.getInt("Enter your ending integer: ");
			System.out.println();
			menu.printSeries(start, end);
		} else if (menuChoice == 2) {
			String word = myobj.getString("Enter a word: ");
			menu.repeatWord(word);
		} else if (menuChoice == 3) {
			boolean repeat = true;
			String word1 = "";
			String word2 = "";
			while (repeat) {
				word1 = myobj.next("Enter a string: ");
				word2 = myobj.next("Enter a string: ");
				if (word1.length() + word2.length() <= 30) {
					repeat = false;
				}
				else {
					System.out.println("The words you entered were too long, type 'continue' if you would still like to continue. ");
					System.out.print("This means that no dots will be printed. Otherwise type anything else.");
					String cont = myobj.next("");
					if (cont.equalsIgnoreCase("continue")) {
						repeat = false;
					}
				}
			}
			menu.printIndexLine(word1, word2);
		} else if (menuChoice == 4) {
			int num = myobj.getInt("Enter how many numbers you have: ");
			int nums [] = new int [num];
			for (int i = 0; i < num; i++) {
				nums[i] = myobj.getInt("Enter a number: ");
			}
			menu.standardDeviation(nums, num);
		} else if (menuChoice == 5) {
			myobj.getInt("Enter how many numbers you have: ");
		}
		str = myobj.next("Type 'quit' to quit and anything else to continue: ");
		}while(!str.equalsIgnoreCase("quit"));
	}

	public String divide(int m, int n) {
		int count = 0;
		String answer = "";
		while (m >= n) {
			m -= n;
			count++;
		}
		n = m;
		answer = "Answer: " + count + " R: " + n;
		return answer;
	}

	public void printSeries(int start, int end) {
		int count = 0;
		int dif = end - start;
		while (count <= dif) {
			System.out.println(start);
			start++;
			count++;
		}
	}

	public void repeatWord(String word) {
		int length = word.length();
		for (int i = 0; i < length; i++) {
			System.out.println(word);
		}
	}

	public void printIndexLine(String word1, String word2) {
		int totalLength = word1.length() + word2.length();
		int numOfDots = 30 - totalLength;
		System.out.print(word1);
		for (int i = 0; i < numOfDots; i++) {
			System.out.print(".");
		}
		System.out.print(word2);
	}
	
	public void standardDeviation(int [] nums, int num) {
		double answer = 0;
		double avgSquare = 0;
		double avg = 0;
		for (int i = 0; i < num; i++) {
			avgSquare += nums[i] * nums[i];
		}
		avgSquare /= num;
		for (int i = 0; i < num; i++) {
			avg += nums[i];
		}
		avg /= num;
		answer = Math.sqrt(avgSquare - avg * avg);
		System.out.println("Your standard deviation is: " + answer);
	}
	
	public void addIntegers(int [] nums, int num) {
		int answer = 0;
		for (int i = 0; i < num; i++) {
			answer += nums[i];
		}
		System.out.println("Your answer is: " + answer);
	}

}