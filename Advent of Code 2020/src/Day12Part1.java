import java.io.*;
import java.util.*;

public class Day12Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
            int ns = 0, ew = 0, facing = 1; // NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3
            String[] dirs = {"N", "E", "S", "W"};

            while (true) {
                String line = in.nextLine();
                if (line.equals("")) break;
                String com = line.substring(0, 1);
                int val = Integer.parseInt(line.substring(1));

                if (com.equals("F")) com = dirs[facing];

                if (com.equals("N")) ns+= val;
                else if (com.equals("S")) ns-= val;

                else if (com.equals("E")) ew+= val;
                else if (com.equals("W")) ew-= val;

                else if (com.equals("L")) {
                    facing-= (val/90);
                    facing = (facing+4)%4;
                }
                else if (com.equals("R")) {
                    facing+= (val/90);
                    facing = (facing+4)%4;
                }
            }

            System.out.println((Math.abs(ns) + Math.abs(ew)));
		}
	}
}