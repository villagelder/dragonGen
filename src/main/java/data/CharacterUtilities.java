package data;
//
//import java.util.ArrayList;
//import java.util.Random;
//
public class CharacterUtilities {
//
//	public static int randomAge(String chcl) {
//
//		int age = 0;
//
//		if (!chcl.equals("")) {
//			Tables.Races ro = Tables.Races.getRacesObject(chcl, "standard");
//			age = Integer.parseInt(ro.AGESTART) + DiceRoller.randInt(-3, 9, 1);
//		}
//
//		return age;
//	}
//
//	public static int[] setRandomHtWt(String r) {
//		int htLow = 0;
//		int htHigh = 0;
//		int htRoll = 0;
//		// int htFeet = 0;
//		// int htInch = 0;
//		int height = 0;
//		int wtLow = 0;
//		int wtHigh = 0;
//		int wtRoll = 0;
//		int weight = 0;
//		int[] htwt = new int[2];
//
//		if (!r.equals("")) {
//			Tables.Races ro = Tables.Races.getRacesObject(r, "standard");
//			htLow = Integer.parseInt(ro.HEIGHTMODLOW);
//			htHigh = Integer.parseInt(ro.HEIGHTMODHIGH);
//			htRoll = DiceRoller.randInt(htLow, htHigh, 0);
//			height = Integer.parseInt(ro.BASEHEIGHT) + htRoll;
//			// htFeet = height / 12;
//			// htInch = height % 12;
//			//
//			// ht.setText(String.valueOf(htFeet + "' " + htInch + "\""));
//
//			wtLow = Integer.parseInt(ro.WEIGHTMODLOW);
//			wtHigh = Integer.parseInt(ro.WEIGHTMODHIGH);
//			wtRoll = DiceRoller.randInt(wtLow, wtHigh, 0);
//			weight = Integer.parseInt(ro.BASEWEIGHT) + (wtRoll * htRoll);
//
//		}
//
//		htwt[0] = height;
//		htwt[1] = weight;
//
//		return htwt;
//
//	}
//
//	public static String getRandomFirstName(String race, String gender) {
//		int roll = DiceRoller.roll1d6();
//
//		if (race.equalsIgnoreCase("half-elf")) {
//			if (roll < 4) {
//				race = "human";
//			} else {
//				race = "elf";
//			}
//		}
//
//		String[] names = Tables.Firstnames.getFirstnamesByRaceAndGender(race, gender);
//
//		Random rand = new Random();
//		// random.nextInt(max - min + 1) + min
//		int r = rand.nextInt((names.length - 1) - 0 + 1) + 0;
//
//		return names[r];
//
//	}
//
//	public static String getRandomClanName(String race) {
//		int roll = DiceRoller.roll1d6();
//
//		if (race.equalsIgnoreCase("half-elf")) {
//			if (roll < 4) {
//				race = "human";
//			} else {
//				race = "elf";
//			}
//		}
//		String[] names = Tables.Clannames.getClannamesbyRace(race);
//
//		Random rand = new Random();
//		// random.nextInt(max - min + 1) + min
//		int r = rand.nextInt((names.length - 1) - 0 + 1) + 0;
//
//		return names[r];
//	}
//
//	public static int calculateAbilityModifier(int abil) {
//		int mod = 0;
//
//		if (abil - 10 < 0) {
//			abil--;
//		}
//
//		mod = (abil - 10) / 2;
//
//		return mod;
//
//	}
//
//	public static String[] refineSubraces(String race) {
//		race = race.toLowerCase();
//		String[] subraces = Tables.Races.getSubRaces(race);
//		ArrayList<String> subList = new ArrayList<String>();
//
//		for (int i = 0; i < subraces.length; i++) {
//			subList.add(subraces[i]);
//		}
//
//		boolean includeStandard = true;
//
//		switch (race) {
//
//		case "elf":
//			includeStandard = false;
//			break;
//
//		case "dwarf":
//			includeStandard = false;
//			break;
//
//		case "gnome":
//			includeStandard = false;
//			break;
//
//		case "halfling":
//			includeStandard = false;
//			break;
//
//		case "dragonborn":
//			includeStandard = false;
//			break;
//
//		}
//
//		if (includeStandard == false) {
//			subList.remove("Standard");
//			subraces = new String[subList.size()];
//
//			for (int j = 0; j < subraces.length; j++) {
//				subraces[j] = subList.get(j);
//			}
//		}
//
//		return subraces;
//	}
//
//	public static String getStatBonuses(String race, String subrace) {
//		String stats = "";
//		String[] ss = Tables.Races.getStats(race, subrace);
//		String[] abil = { "Str", "Dex", "Con", "Int", "Wis", "Cha" };
//		ArrayList<String> al = new ArrayList<String>();
//
//		for (int i = 0; i < ss.length; i++) {
//			if (!ss[i].equals("0")) {
//				al.add(abil[i] + " +" + ss[i]);
//			}
//
//		}
//
//		if (race.equalsIgnoreCase("half-elf")) {
//			al.add("two abilities by +1");
//		}
//
//		if (race.equalsIgnoreCase("human") && subrace.equalsIgnoreCase("standard")) {
//			al.removeAll(al);
//			al.add("All abilities by +1 each");
//		}
//
//		if (race.equalsIgnoreCase("human") && subrace.equalsIgnoreCase("variant")) {
//			al.add("Two abilities by +1 each");
//		}
//
//		//stats = String.join(al, ", ");
//
//		return stats;
//	}
//
}
