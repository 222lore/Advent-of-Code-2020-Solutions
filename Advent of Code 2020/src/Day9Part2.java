import java.io.*;
import java.util.*;

public class Day9Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
            ArrayList<Long> input = new ArrayList<>(), temp = new ArrayList<>(), full = new ArrayList<>();
            int preamble = 25;
            boolean found = false, done = false;
            long invalid = -1;
            for (int i = 0; in.hasNext(); i++) {
            	String line = in.nextLine();
            	if (line.equals("")) break;
                long num = Long.parseLong(line);
                input.add(num);
                full.add(num);
                if (done || i < preamble) continue;
                found = false;
                
                for (int j = i-preamble; j < i; j++) {
                    long need = num - input.get(j%(preamble));
                    
                    if (input.contains(need)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    //System.out.println("STOP: " + num);
                    invalid = num;
                    done = true;
                }
                input.remove(0);
            }
            
            
            done = false;
            for (int i = 0; done || i < full.size(); i++) {
            	long num = full.get(i);
            	temp.add(num);
            	
            	for (int j = i+1; j < full.size(); j++) {
            		temp.add(full.get(j));
            		if (sumList(temp) > invalid) break;
            		else if (sumList(temp) == invalid) {
            			done = true;
            			break;
            		}
            	}
            	
            	if (done) break;
            	temp.clear();
            }
            
            long min = Integer.MAX_VALUE;
            long max = 0;
            for (long num: temp) {
            	if (num > max) max = num;
            	if (num < min) min = num;
            }
            
            System.out.println((min+max));
		}
		
		private static long sumList(ArrayList<Long> param) {
			long sum = 0;
			for (long num: param) {
				sum += num;
			}
			return sum;
		}
	}
}