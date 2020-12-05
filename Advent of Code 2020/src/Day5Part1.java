import java.io.*;
import java.util.*;

public class Day5Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			String line;
			int row = 0, column = 0, id = 0;
			int max = 0;
			boolean stop = true;
			
			while (in.hasNextLine()) {
				line = in.nextLine();
				if (line.equals("")) {
					if (stop) break;
					else stop = true;
					continue;
				}
				else stop = false;
				row = binarySearch(line.substring(0, 7), 0, 127);
				column = binarySearch(line.substring(7), 0, 7);
				id = row*8+column;
				
				if (id > max) {
					//System.out.println("max: " + max + " new max: " + id);
					max = id;
				}
				
			}
			
			System.out.println("max: " + max);
		}
		
		private static int binarySearch(String range, int min, int max) {
			double mid = (min + max)/2.0; 
			boolean upperHalf, print = (max == 127);
			
			for (int i = 0; i < range.length(); i++) {
				upperHalf = (range.substring(i, i+1).equals("B") || range.substring(i, i+1).equals("R"));
				
				if (upperHalf) {
					if (mid/(int)mid > 0) mid += 1;
					min = (int)mid;
				}
				else {
					max = (int)mid;
				}
				mid = (min + max)/2.0;
				
				//if (print) System.out.println("Went upper?: " + upperHalf + " new min: " + min + " new max: " + max);
			}
			
			return (int)mid;
		}
	}
}