import java.io.*;
import java.util.*;

public class Day5Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			String line;
			int row = 0, column = 0, id = 0;
			boolean stop = true;
			ArrayList<Integer> seats = new ArrayList<>();
			
			//seats = (ArrayList<Integer>) fillList(127, 7).clone();
			
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
				
				if (!seats.contains((Integer)id)) seats.add((Integer)id);
			}
			
			for (int seat: searchSeat(seats)) {
				System.out.println("Possible seat: " + seat);
			}
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
		
		/*
		private static ArrayList<Integer> fillList(int max1, int max2) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0; i <= max1; i++) {
				for (int j = 0; j <= max2; j++) {
					if (!temp.contains(i*8+j)) temp.add(i*8+j);
				}
			}
			return temp;
		}
		*/
		
		private static ArrayList<Integer> searchSeat(ArrayList<Integer> seats) {
			int seat;
			ArrayList<Integer> possibleSeats = new ArrayList<>();
			for (int i = 0; i < 1024; i++) {
				seat = i;
				if (!(seats.contains((Integer)seat)) && seats.contains((Integer)(seat-1)) && seats.contains((Integer)(seat+1))) {
					possibleSeats.add(seat);
				}
			}
			
			return possibleSeats;
		}
	}
}