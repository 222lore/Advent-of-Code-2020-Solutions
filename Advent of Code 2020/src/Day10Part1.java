import java.io.*;
import java.util.*;

public class Day10Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			ArrayList<Integer> input = new ArrayList<>();
			int oneDiff = 0, threeDiff = 1;

			input.add(0);
			while (true) {
				String line = in.nextLine();
				if (line.equals("")) break;
				input.add(Integer.parseInt(line));
			}

			Collections.sort(input);

			for (int i = 0; i < input.size()-1; i++) {
				if (input.get(i+1) - input.get(i) == 1) oneDiff++;
				else if (input.get(i+1) - input.get(i) == 3) threeDiff++;
			}

			System.out.println((oneDiff * threeDiff));
		}
	}
}