import java.io.*;
import java.util.*;

public class Day11Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			int l = 97, w = 98, occupied = 0, newOccupied = -1;
			boolean top, bot, left, right;
            String[][] grid = new String[l][w], buffer = new String[l][w];
            
            for (int r = 0; r < l; r++) {
                String line = in.nextLine();
                for (int c = 0; c < w; c++) {
					grid[r][c] = line.substring(c, c+1);
					
                }
            }

			while (occupied != newOccupied) {
				//System.out.println("");
				//print2D(buffer);
				occupied = newOccupied;
				newOccupied = 0;
				
				for (int r = 0; r < l; r++) {
					for (int c = 0; c < w; c++) {
						buffer[r][c] = grid[r][c];
					}
				}

				for (int r = 0;  r < l; r++) {
					top = (r==0);
					bot = (r==l-1);
					
					for (int c = 0; c < w; c++) {
						if (grid[r][c].equals(".")) continue;
						boolean free = (grid[r][c].equals("L"));
						int count = 0;
						left = (c==0);
						right = (c==w-1);

						//System.out.println("row: " + r + " col: " + c + " top=" + top + " bot=" + bot + " left=" + left + " right=" + right);

						if (!top && !left && grid[r-1][c-1].equals("#")) count++; // Up and left
						if (!top && grid[r-1][c].equals("#")) count++; // Up
						if (!top && !right && grid[r-1][c+1].equals("#")) count++; // Up and right
						if (!left && grid[r][c-1].equals("#")) count++; // Left
						if (!right && grid[r][c+1].equals("#")) count++; // Right
						if (!bot && !left && grid[r+1][c-1].equals("#")) count++; // Down and left
						if (!bot && grid[r+1][c].equals("#")) count++; // Down
						if (!bot && !right && grid[r+1][c+1].equals("#")) count++; // Down and right
						
						if (free && count == 0) buffer[r][c] = "#";
						else if (!free && count > 3) buffer[r][c] = "L";

						if (buffer[r][c].equals("#")) newOccupied++;
					}
				}

				for (int r = 0; r < l; r++) {
					for (int c = 0; c < w; c++) {
						grid[r][c] = buffer[r][c];
					}
				}

			}

			System.out.println(occupied);
		}

		private static void print2D(String[][] arr) {
			for (String[] r: arr) {
				for (String c: r) {
					System.out.print(c);
				}
				System.out.println("");
			}
		}
	}
}