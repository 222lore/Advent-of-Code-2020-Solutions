import java.io.*;
import java.util.*;

public class Day3Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			HashMap<Integer, String> mountain = new HashMap<>();
			int treeCount = 0;
			
			for (int i = 0; true; i++) {
				String line = in.nextLine();
				if (line.isEmpty()) break;
				mountain.put(i, line);
				//System.out.println("line " + line);
			}
			
			//System.out.println();
			
			for (int i = 1; i < mountain.keySet().size(); i++) {
				String line = mountain.get(i).replaceAll("\\s+","");
				int index = (i*3)%line.length();
				if (line.isEmpty()) break;
				String space = line.substring(index, index+1);
				//System.out.println("line #" + i + " " + line + " index " + index + " space " + space);
				if (space.equals("#")) treeCount++;
			}
			
			System.out.println("result " + treeCount);
		}
	}
}