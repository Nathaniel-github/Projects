/*
Author: Nathaniel Thomas
Date: 09/18/19
Rev: 02
*/

import java. util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class PRI1 {
	public static void main(String[ ] args) {
		Scanner myobj = new Scanner(System.in);
		Scanner kboard = new Scanner(System.in);
		String tester = "True";
		String check;
		String test = "True";
		String nice = "True";
		int b = 0;
		String first = "Yes";
		String cont = "No";
		int x, y, z, probs;
		probs = 0;
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		System.out.println("How many problems do you have: ");
		while (cont == "No") {
			if ((first == "Yes") && myobj.hasNextInt()) {
				probs = myobj.nextInt();
				check = myobj.nextLine();
				if (check.isEmpty()) {
					cont = "Yes";
				}
				else {
					System.out.println("That wasn't a valid answer");
					first = "No";
				}	
			}
			else if (first != "Yes") {
				System.out.println("How many problems do you have: ");
				if (myobj.hasNextInt()) {
					probs = myobj.nextInt();
					check = myobj.nextLine();
					if (check.isEmpty()) {
						cont = "Yes";
					}
					else {
						System.out.println("That wasn't a valid answer");
						first = "No";
					}
				}
				else {
					System.out.println("That wasn't a number");
					myobj.next();
				}
			}
			else {
				System.out.println("That wasn't a number");
				myobj.next();
			}

			first = "No";
		}
		while (probs > 0) {
			System.out.println("Enter # of bags, # of Snickers, and # of Hersheys: ");
			if (kboard.hasNextInt()) {
				x = kboard.nextInt();
			}
			else {
				System.out.println("That wasn't a number");
				kboard.next();
				continue;
			}
			if (kboard.hasNextInt()) {
				y = kboard.nextInt();
			}
			else {
				System.out.println("That wasn't a number");
				kboard.next();
				continue;
			}
			if (kboard.hasNextInt()) {
				z = kboard.nextInt();
			}
			else {
				System.out.println("That wasn't a number");
				kboard.next();
				continue;
			}
			q.add(x);
			q.add(y);
			q.add(z);
			probs -= 1;
		}
		while (tester == "True") {
			if (q.isEmpty()) {
				tester = "False";
			}
			else {
				x = q.remove();
				y = q.remove();
				z = q.remove();
				b = 0;
				test = "True";
				while (test == "True")	{
					if (x < (y + z + b)) {
						y -= 1;
						z -= 1;
						b ++;
					}
					else if (x == (y + z + b)) {
						if (y > z) {
							y += 1;
						}
						if (z > y) {
							y = z;
							y +=1;
						}
						if (z == y) {
							y++;
						}
						test = "False";
						q2.add(y);
					}
				}
			}
		}
		
		while (nice == "True") {
			if (q2.isEmpty()) {
				nice = "False";
			}
			else {
				int answer = q2.remove();
				System.out.println(answer);
			}
		}
		myobj.close();
		kboard.close();
	}
}

		