import java.io.*;
import java.util.*;

public class Day2Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			int min, max, letterCount, result = 0;
			String letter, code, line;
			
			while (in.hasNextLine()) {
				line = in.nextLine();
				if (line.isEmpty()) break;
				
				min = Integer.parseInt(line.split("-")[0]);
				max = Integer.parseInt(line.split("-")[1].split(" ")[0]);
				
				letter = line.split(" ")[1].substring(0, 1);
				
				code = line.split(" ")[2];
				letterCount = 0;
				
				for (int i = 0; i < code.length(); i++) {
					if (code.substring(i, i+1).equals(letter)) letterCount++;
				}
				
				if (letterCount >= min && letterCount <= max) result++;		
			}
			
			System.out.println(result);
		}
	}
}