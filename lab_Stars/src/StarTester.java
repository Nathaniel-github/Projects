
public class StarTester {

	public static void main(String[] args) {
		CheckInput myobj = new CheckInput();
		Stars myprinter = new Stars();
		String str;

		do {
			System.out.println("1) Stars");
			System.out.println("2) Stars in a square");
			System.out.println("3) Stars in a triangle");
			System.out.println("4) Stars in an inverted triangle");
			System.out.println("5) Stars in a pyramid");
			System.out.println("6) Stars in a diamond");
			System.out.println("7) Stars in an hour glass");
			int caseNum = myobj.checkIntRange("Enter the number of the method you would like to try: ", 1, 7);
			int num = myobj.getInt("Enter the number of rows you would like: ");
			switch (caseNum) {

			case 1:
				myprinter.printStars(num);
				System.out.println();
				break;
			case 2:
				myprinter.printStarSquare(num);
				System.out.println();
				break;
			case 3:
				myprinter.printStarTriangle(num);
				System.out.println();
				break;
			case 4:
				myprinter.printStarInvertedTriangle(num);
				System.out.println();
				break;
			case 5:
				myprinter.printStarPyramid(num);
				System.out.println();
				break;
			case 6:
				myprinter.printStarDiamond(num);
				System.out.println();
				break;
			case 7:
				myprinter.printStarHourGlass(num);
				break;

			}
			str = myobj.next("Enter 'quit' to quit and anything else to continue: ");
		} while (!str.equalsIgnoreCase("quit"));
	}

}
