import java.io.*;
import java.util.*;

public class Day4Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			String[] reqs = {"byr:",
							"iyr:",
							"eyr:", 
							"hgt:",
							"hcl:", 
							"ecl:", 
							"pid:"}; 
							//"cid"};
			boolean[] checks = {false, false, false, false, false, false, false};
			boolean stop = false, quit = false;
			long valids = 0, counter = 0;
			
			while (!quit) {
				resetBool(checks);
				counter = 0;
				while (true) {
					String line = in.nextLine();
					if (line.isBlank()) {
						if (stop) quit = true;
						stop = true;
						break;
					}
					else stop = false;
					
					//System.out.println("line " + counter + ": " +  line);
					
					for (int i = 0; i < reqs.length; i++) {
						if (line.contains(reqs[i])) checks[i] = true;
					}
					//counter++;
				}
				if (checker(checks)) valids++;
			}
			
			System.out.println(valids);
		}
		
		private static void resetBool(boolean[] arr) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = false;
			}
		}
		
		private static boolean checker(boolean[] arr) {
			boolean result = true;
			for (boolean bool: arr) { if (!bool) result = false; }
			return result;
		}
	}
}