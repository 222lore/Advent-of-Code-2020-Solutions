import java.io.*;
import java.util.*;

public class Day4Part2 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Solver();
		in.close();
	}

	static class Solver {
		Solver() {
			String[] reqs = {
					"byr:",
					"iyr:",
					"eyr:", 
					"hgt:",
					"hcl:", 
					"ecl:", 
					"pid:"
			}; 
							//"cid"};
			
			boolean[] checks = {false, false, false, false, false, false, false};
			boolean stop = false, quit = false;
			long valids = 0, counter = 0;
			
			//System.out.println(tagCheck("byr:2003", "byr:"));
			
			
			
			while (!quit) {
				resetBool(checks);
				counter = 0;
				while (true) {
					String line = in.nextLine();
					if (line.isBlank()) {
						if (stop) quit = true;
						stop = true;
						break;
					}
					else stop = false;
										
					String[] tags = line.split(" ");
					for (int i = 0; i < tags.length; i++) {
						String tag = getTag(tags[i], reqs);
						if (tagCheck(tags[i], tag)) {
							//System.out.println("tag correct " + tag);
							for (int j = 0; j < reqs.length; j++) {
								if (tag.equals(reqs[j])) {
									checks[j] = true;
									//System.out.println("tag correct " + tag);
								}
							}
						}
						//else System.out.println("tag incorrect " + tags[i]);
					}
				}
				//System.out.println("");
				if (checker(checks)) valids++;
			}
			
			System.out.println(valids); 
		}
		
		private static void resetBool(boolean[] arr) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = false;
			}
		}
		
		private static boolean checker(boolean[] arr) {
			boolean result = true;
			for (boolean bool: arr) { if (!bool) result = false; }
			return result;
		}
		
		private static String getTag(String word, String[] tags) {
			for (String tag: tags) {
				if (word.contains(tag)) return tag;
			}
			return null;
		}
		
		private static boolean tagCheck(String full, String tag) {
			boolean out = false;
			String[] ecls = {
					"amb",
					"blu",
					"brn",
					"gry",
					"grn",
					"hzl",
					"oth"
			};
			
			char[] chars = {
					'g',
					'h',
					'i',
					'j',
					'k',
					'l',
					'm',
					'n',
					'o',
					'p',
					'q',
					'r',
					's',
					't',
					'u',
					'v',
					'w',
					'x',
					'y',
					'z'

			};
			
			if (tag == null || full == null || tag.equals("") || full.equals("")) return false;
			
			//else if (tag.equals("cid:")) return true;
			
			else if (tag.equals("byr:")) {
				int year = Integer.parseInt(full.substring(4));
				out = (year >= 1920 && year <= 2002);
			}
			
			else if (tag.equals("iyr:")) {
				int year = Integer.parseInt(full.substring(4));
				out = (year >= 2010 && year <= 2020);
			}
			
			else if (tag.equals("eyr:")) {
				int year = Integer.parseInt(full.substring(4));
				out = (year >= 2020 && year <= 2030);
			}
			
			else if (tag.equals("hgt:")) {
				String hgt = full.substring(4, full.length()-2);
				if (hgt != null && !hgt.equals("")) {
					int height = Integer.parseInt(hgt);
					if (full.contains("cm")) out = (height >= 150 && height <= 193);
					if (full.contains("in")) out = (height >= 59 && height <= 76);
				}
			}
			
			else if (tag.equals("hcl:")) {
				if (!full.substring(4, 5).equals("#")) return false;
				String hair = full.substring(5);
				if (hair.length() != 6) return false;
				out = true;
				//System.out.println("hair: " + hair);
				for (int i = 0; i < hair.length(); i++) {
					char chr = hair.charAt(i);
					if (Character.isLetter(chr)) {
						for (int j = chars.length-1; j >= 0; j--) {
							//System.out.println("char: " + chr + " test: " + chars[j]);
							if (chr == chars[j]) {
								out = false;
							}
						}
					}
				}
			}
			
			else if (tag.equals("ecl:")) {
				String color = full.substring(4);
				for (String clr: ecls) {
					if (color.equals(clr)) out = true;
				}
			}
			
			else if (tag.equals("pid:")) {
				boolean temp = true;
				String id = full.substring(4);
				for (int i = 0; i < id.length(); i++) {
					char chr = id.charAt(i);
					if (!Character.isDigit(chr) || id.length() != 9) {
						temp = false;
					}
				}
				out = temp;
			}
			
			return out;
		}
	}
}