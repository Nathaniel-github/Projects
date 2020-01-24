/*
Author: Nathaniel Thomas
Date: 09/18/19
Rev: 01
*/

import java. util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class PRI1 {
	public static void main(String[ ] args) {
		Scanner myobj = new Scanner(System.in);
		String tester = "True";
		String test = "True";
		String nice = "True";
		int b = 0;
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		System.out.println("How many problems do you have: ");
		int probs = myobj.nextInt();
		while (probs > 0) {
			System.out.println("Enter # of bags, # of Snickers, and # of Hersheys: ");
			int x = myobj.nextInt();
			int y = myobj.nextInt();
			int z = myobj.nextInt();
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
				int x = q.remove();
				int y = q.remove();
				int z = q.remove();
				b = 0;
				test = "True";
				while (test == "True")	
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
					}
				q2.add(y);
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
	}
}
		