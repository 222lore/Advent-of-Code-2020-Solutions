import java.io.*;
import java.util.*;

public class Day6Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			ArrayList<String> sims = new ArrayList<>();
			boolean end = false;
			int sum = 0;
			String line;
			
			while (true) {
				line = in.nextLine();
				if (line.equals("")) {
					if (end) break;
					end = true;
					sum += sims.size();
					sims.clear();
					continue;
				}
				else end = false;
				 
				for (int i = 0; i < line.length(); i++) {
					String letter = line.substring(i, i+1);
					if (!sims.contains(letter)) sims.add(letter);
				}
			}
			
			System.out.println(sum);
		}
	}
}