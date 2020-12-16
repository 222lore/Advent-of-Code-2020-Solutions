import java.io.*;
import java.util.*;

public class Day15Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
            ArrayList<Integer> spoken = new ArrayList<>();
            int startVal = 6;
            spoken.add(2); spoken.add(1); spoken.add(10); spoken.add(11); spoken.add(0); spoken.add(6);
            //spoken.add(1); spoken.add(2); spoken.add(3);

            for (int i = startVal; i < 2020; i++) {
                int lastSpoken = spoken.get(i-1);
                spoken.add(spokenOrDiff(spoken, lastSpoken));
            }

            System.out.println(spoken.get(2019));
        }
        
        private int spokenOrDiff(ArrayList<Integer> spoken, int val) {
            ArrayList<Integer> temp = (ArrayList<Integer>) spoken.clone();
            int secondIndex = -1;
            for (int i = temp.size()-1; i >= 0; i--) {
                if (temp.get(i) == val) {
                    if (secondIndex != -1) return (secondIndex - i);
                    else secondIndex = i;
                }
            }
            return 0; 
        }
	}
}