import java.io.*;
import java.util.*;

public class Day7Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			ArrayList<String> checkBags = new ArrayList<>();
			checkBags.add("shiny gold");
            ArrayList<String> contains = new ArrayList<>();
			ArrayList<String> bagHolds = new ArrayList<>();
			int sum = 1;
			boolean moreHolds = true;
			String line, bag;
			int holds;
			ArrayList<Bag> bags = new ArrayList<>();
			Bag created;
			Bag bagTemp = new Bag("", new ArrayList<String>());
			
			while (true) {
				line = in.nextLine();
				if (line.equals("")) break;
				bagHolds.clear();
				
				bag = line.split("contain")[0];
				bag = bag.substring(0, bag.length()-6);
				
				if (line.split("contain")[1].contains("no")) {
					created = new Bag(bag, new ArrayList<String>());
					bags.add(created);
					continue;
				}
				
				for (int i = 0; i < line.split("contain")[1].split(",").length; i++) {
					String bagLine = line.split("contain")[1].split(",")[i];
					holds = Integer.parseInt(bagLine.split("\\s+")[1]);
					String temp = bagLine.split("\\s+")[2] + " " + bagLine.split("\\s+")[3];
					//bagHolds.put(temp, holds);

					for (int j = 0; j < holds; j++) {
						bagHolds.add(temp);
					}
				}
				created = new Bag(bag, bagHolds);
				bags.add(created);
				
			}
            /*
            * DO RECURSION WITH ONLY ONE CONTAINS TO GET THE
            * MULTIPLYING SUM, THEN SWITCH ON TO THE NEXT
            * CONTAINING BAG
            */
            ArrayList<String> tempBags = new ArrayList<>();
            bagTemp = new Bag("", new ArrayList<String>());
            for (int i = 0; i < bags.size(); i++) {
                bagTemp = bags.get(i);
                if (bagTemp.getName().equals("shiny gold")) {
					break;
				}
            }
                //checkBags = (ArrayList<String>) tempBags.clone();
			
            //System.out.println(contains.size());
            System.out.println(howMany(bagTemp, 0, bags));
		}

		private static long howMany(Bag bag, long size, ArrayList<Bag> bags) {
			if (bag.contains().size() == 0) return size;
			else {
				size = bag.contains().size();
				for (String bagName: bag.contains()) {
					//System.out.println(bagName + " " + size);
					//System.out.println(bagName + " has " + bag.contains().size() + " bags inside");

					for (int i = 0; i < bags.size(); i++) {
						if (bags.get(i).getName().equals(bagName)) {
							size += howMany(bags.get(i), 0, bags);
							//System.out.println(bags.get(i).getName() + " " + count);
							break;
						}
					}

				}
			}

			return size;
		}
	}
	
	static class Bag {
		String name;
		ArrayList<String> bagHolds;
		
		Bag(String name, ArrayList<String> bagHolds) {
			this.name = name;
			this.bagHolds = (ArrayList<String>) bagHolds.clone();
		}
		
		public String getName() {
			return this.name;
		}
		


		public boolean hasBag(String bagName) {
			boolean contains = false;
			
			for (String bag: this.bagHolds) {
				if (bag.equals(bagName)) {
					contains = true;
					break;
				}
			}
			
			return contains;
        }
        
        public ArrayList<String> contains() {
            return this.bagHolds;
        }

        public int containsNum(String bagContain) {
			int sum = 0;
            for (String bag: bagHolds) {
				if (bag.equals(bagContain)) sum++;
			}
			return sum;
        }
	}
}