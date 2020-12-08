import java.io.*;
import java.util.*;

public class Day8Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
            HashMap<Integer, Object[]> bootCode = new HashMap<>();
            ArrayList<Integer> completedLines = new ArrayList<>();
            int acc = 0;

            for (int i = 0; true; i++) {
                String line = in.nextLine();
                if (line.equals("")) break;

                String code = line.substring(0, 3);
                int val = Integer.parseInt(line.substring(5));
                val = (line.substring(4, 5).equals("-") ? -val:val);
                Object[] temp = {code, val};
                
                bootCode.put(i, temp);
            }

            for (int i = 0; true; i++) {
                if (completedLines.contains(i)) break;
                completedLines.add(i);
                Object[] temp = bootCode.get(i);

                if (temp[0].equals("acc")) acc += (int)temp[1];
                else if (temp[0].equals("jmp")) i += (int)temp[1]-1;
            }

            System.out.println(acc);
		}
	}
}