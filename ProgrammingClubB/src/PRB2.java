import java.util.*;

public class PRB2 {
	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
		int answer = 0;
		int z = 0;
		boolean test = false;
		Deque<Integer> q = new LinkedList<>();
		int probs = myobj.nextInt();
		for (int i = 0; i < probs; i++) {
			int doors = myobj.nextInt();
			for (int k = 1; k <= doors; k++) {
				test = false;
				int x = myobj.nextInt();
				if (x == 0) {
					int y = q.removeLast();
					if (k != doors) {
						z = myobj.nextInt();
						k++;
						q.add(x);
						q.add(z);
						test = true;
					}
					else {
						continue;
					}
					if (y == 1 && z ==1) {
						answer ++;
						q.remove();
						q.add(0);
					}
				}
				if (!test) {
					q.add(x);
				}
			}
			System.out.println(answer);
			answer = 0;
		}
		myobj.close();
	}
}