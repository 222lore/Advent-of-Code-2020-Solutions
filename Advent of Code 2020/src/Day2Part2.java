import java.io.*;
import java.util.*;

public class Day2Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			int index1, index2, letterCount, result = 0;
			String letter, code, line, char1, char2;
			
			while (in.hasNextLine()) {
				line = in.nextLine();
				if (line.isEmpty()) break;
				
				index1 = Integer.parseInt(line.split("-")[0]);
				index2 = Integer.parseInt(line.split("-")[1].split(" ")[0]);
				
				letter = line.split(" ")[1].substring(0, 1);
				
				code = line.split(" ")[2];
				letterCount = 0;
				
				char1 = code.substring(index1-1, index1);
				char2 = code.substring(index2-1, index2);
				
				if (char1.equals(letter) ^ char2.equals(letter)) result++;		
			}
			
			System.out.println(result);
		}
	}
}