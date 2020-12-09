import java.io.*;
import java.util.*;

public class Day9Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
            ArrayList<Long> input = new ArrayList<>();
            int preamble = 25;
            boolean found = false;

            for (int i = 0; in.hasNext(); i++) {
                long num = in.nextLong();
                input.add(num);
                if (i < preamble) continue;
                found = false;
                
                for (int j = i-preamble; j < i; j++) {
                    long need = num - input.get(j%(preamble));
                    
                    if (input.contains(need)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("STOP: " + num);
                    break;
                }
                input.remove(0);
            }
		}
	}
}