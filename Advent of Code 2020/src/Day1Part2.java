import java.io.*;
import java.util.*;

public class Day1Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			ArrayList<Integer> currentNums = new ArrayList<>();
			int ans = -1;
			while (in.hasNextInt()) {
				int num1 = in.nextInt();
				
				for (int i = 0; i < currentNums.size(); i++) {
					int num2 = currentNums.get(i);
					int needed = 2020-num1-num2;
					if (currentNums.contains(needed)) ans = num1*num2*needed;
				}
				
				if (ans != -1) {
					System.out.println(ans);
					break;
				}
				
				currentNums.add(num1);
			}
		}
	}
}