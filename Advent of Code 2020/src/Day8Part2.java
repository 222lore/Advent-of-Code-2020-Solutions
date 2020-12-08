import java.io.*;
import java.util.*;

public class Day8Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
            HashMap<Integer, Object[]> bootCode = new HashMap<>();
            ArrayList<Integer> completedLines = new ArrayList<>();
            int acc = 0, change = 0, changeCount = 0;
            boolean completed = true;

            for (int i = 0; true; i++) {
                String line = in.nextLine();
                if (line.equals("")) break;

                String code = line.substring(0, 3);
                int val = Integer.parseInt(line.substring(5));
                val = (line.substring(4, 5).equals("-") ? -val:val);
                Object[] temp = {code, val};
                
                bootCode.put(i, temp);
            }

            for (int i = 0; i < bootCode.size(); i++) {
                completed = true;
                acc = 0;
                changeCount = 0;

                for (int j = 0; j < bootCode.size(); j++) {
                    if (completedLines.contains(j)) {
                        completed = false;
                        break;
                    }
                    completedLines.add(j);
                    Object[] temp = bootCode.get(j);
    
                    if (temp[0].equals("acc")) acc += (int)temp[1];
                    else if (temp[0].equals("jmp")) {
                        if (change != changeCount) j += (int)temp[1]-1;
                    }
                    else if (temp[0].equals("nop") && change == changeCount) j += (int)temp[1]-1;

                    changeCount++;
                }

                if (completed) break;
                change++;
                completedLines.clear();
            }

            System.out.println(acc);
		}
	}
}