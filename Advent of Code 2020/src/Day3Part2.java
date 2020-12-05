import java.io.*;
import java.util.*;

public class Day3Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			HashMap<Integer, String> mountain = new HashMap<>();
			long treeCount = 0, result = 1;
			int right, down;
			int[] rights = {1, 3, 5, 7, 1}, downs = {1, 1, 1, 1, 2};
			
			for (int i = 0; true; i++) {
				String line = in.nextLine();
				if (line.isEmpty()) break;
				mountain.put(i, line);
				//System.out.println("line " + line);
			}
			
			//System.out.println();
			for (int run = 0; run < 5; run++) {
				treeCount = 0;
				right = rights[run];
				down = downs[run];
				
				for (int i = 1; i < mountain.keySet().size()/down; i++) {
					String line = mountain.get(i*down).replaceAll("\\s+","");
					int index = (i*right)%line.length();
					if (line.isEmpty()) break;
					String space = line.substring(index, index+1);
					//if (down == 2) System.out.println("line #" + i*down + " " + line + " index " + index + " space " + space);
					if (space.equals("#")) treeCount++;
				}
				
				//System.out.println("run " + run + " trees " + treeCount);
				result*=treeCount;
			}
			
			System.out.println("result " + result);
		}
	}
}