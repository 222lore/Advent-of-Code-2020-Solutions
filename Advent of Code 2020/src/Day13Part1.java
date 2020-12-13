import java.io.*;
import java.util.*;

public class Day13Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
            int time = Integer.parseInt(in.nextLine()), best = Integer.MAX_VALUE, id = 0;
            String line = in.nextLine();

            for (String str: line.split(",")) {
                if (str.equals("x") || str.equals("")) continue;
                int bus = Integer.parseInt(str);

                if (bus - (time%bus) < best) {
                    best = bus - (time%bus);
                    id = bus;
                }
            }
            
            System.out.println(id * (id - (time%id)));
        }
    }
}