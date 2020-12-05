import java.io.*;
import java.util.*;

public class Day1Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			ArrayList<Integer> currentNums = new ArrayList<>();
			while (in.hasNextInt()) {
				int num = in.nextInt();
				int need = 2020-num;
				if (currentNums.contains(need)) {
					System.out.println("num1: " + num + " num2: " + need);
					System.out.println((num*need));
					break;
				}
				currentNums.add(num);
			}
		}
	}
}