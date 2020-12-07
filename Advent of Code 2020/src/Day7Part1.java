import java.io.*;
import java.util.*;

public class Day7Part1 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			ArrayList<String> canHold = new ArrayList<>();
			canHold.add("shiny gold");
			ArrayList<String> bans = new ArrayList<>();
			bans.add("shiny gold");
 			HashMap<String, Integer> bagHolds = new HashMap<>();
			int sum = 0;
			boolean moreHolds = true;
			String line, bag;
			int holds;
			ArrayList<Bag> bags = new ArrayList<>();
			Bag created;
			
			while (true) {
				line = in.nextLine();
				if (line.equals("")) break;
				bagHolds.clear();
				
				bag = line.split("contain")[0];
				bag = bag.substring(0, bag.length()-6);
				
				if (line.split("contain")[1].contains("no")) {
					created = new Bag(bag, new HashMap<String, Integer>());
					bags.add(created);
					continue;
				}
				
				for (int i = 0; i < line.split("contain")[1].split(",").length; i++) {
					String bagLine = line.split("contain")[1].split(",")[i];
					holds = Integer.parseInt(bagLine.split("\\s+")[1]);
					String temp = bagLine.split("\\s+")[2] + " " + bagLine.split("\\s+")[3];
					bagHolds.put(temp, holds);
				}
				created = new Bag(bag, bagHolds);
				bags.add(created);
				
			}
			
			while (canHold.size() != 0 ) {
				ArrayList<String> temp = new ArrayList<>();
				for (int i = 0; i < bags.size(); i++) {
					Bag thisBag = bags.get(i);
					for (int j = 0; j < canHold.size(); j++) {
						String bagName = canHold.get(j);
						if (!bans.contains(thisBag.getName()) && thisBag.hasBag(bagName)) {
							sum++;
							temp.add(thisBag.getName());
							//System.out.println(thisBag.getName() + " can hold " + bagName);
							bans.add(thisBag.getName());
							break;
						}
					}	
				}
				canHold = (ArrayList<String>) temp.clone();
			}
			
			System.out.println(sum);
		}
	}
	
	static class Bag {
		String name;
		HashMap<String, Integer> bagHolds;
		
		Bag(String name, HashMap<String, Integer> bagHolds) {
			this.name = name;
			this.bagHolds = (HashMap<String, Integer>) bagHolds.clone();
		}
		
		public String getName() {
			return this.name;
		}
		
		public boolean hasBag(String bagName) {
			boolean contains = false;
			
			for (String bag: this.bagHolds.keySet()) {
				if (bag.equals(bagName)) {
					contains = true;
					break;
				}
			}
			
			return contains;
		}
	}
}