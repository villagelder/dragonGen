package data;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//import java.util.TreeSet;
//
public class MakeMe {
//
//	protected static class CharData {
//		private int multiclass = 0;
//		private int[] level = null;
//		private String race = null;
//		private String subrace = null;
//		private String gender = null;
//		private int age = 0;
//		private String firstname = null;
//		private String clanname = null;
//		private int weight = 0;
//		private int height = 0;
//		private String eyes = null;
//		private String hair = null;
//		private String skin = null;
//		private String build = null;
//		private String distinguishingmarks = null;
//		private String str = null;
//		private String dex = null;
//		private String con = null;
//		private String ite = null;
//		private String wis = null;
//		private String cha = null;
//		private String[] clas = null;
//		private String[] archetype = null;
//		private int proficiency = 0;
//		private String[] hitdie = null;
//		private int hitpoints = 0;
//		private int conbonus = 0;
//		private int totalhp = 0;
//		private String background = null;
//		private String backgroundspecialty = null;
//		private String alignment = null;
//		private String traita = null;
//		private String traitb = null;
//		private String flaw = null;
//		private String bond = null;
//		private String ideal = null;
//		private String specialty = null;
//		private String languages = null;
//		private String skills = null;
//		private String[] feats = null;
//		private String equipment = null;
//		private String cantrips = null;
//		private String spells = null;
//
//		//		public CharData
//		//		(
//		//			int newlevel,
//		//			String newrace,
//		//			String newsubrace,
//		//			String newgender,
//		//			int newage,
//		//			String newfirstname,
//		//			String newclanname,
//		//			int newweight,
//		//			int newheight,
//		//			String neweyes,
//		//			String newhair,
//		//			String newskin,
//		//			String newbuild,
//		//			String newdistinguishingmarks,
//		//			String newstr,
//		//			String newdex,
//		//			String newcon,
//		//			String newite,
//		//			String newwis,
//		//			String newcha,
//		//			String newclas,
//		//			String newarchetype,
//		//			String newhitdie,
//		//			int newhitpoints,
//		//			int newconbonus,
//		//			int newtotalhp,
//		//			String newbackground,
//		//			String newbackgroundspecialty,
//		//			String newalignment,
//		//			String newtraita,
//		//			String newtraitb,
//		//			String newflaw,
//		//			String newbond,
//		//			String newideal,
//		//			String newspecialty,
//		//			String newlanguages,
//		//			String newskills,
//		//			String newequipment,
//		//			String newspells
//		//			){
//		//			level = newlevel;
//		//			race = newrace;
//		//			subrace = newsubrace;
//		//			gender = newgender;
//		//			age = newage;
//		//			firstname = newfirstname;
//		//			clanname = newclanname;
//		//			weight = newweight;
//		//			height = newheight;
//		//			eyes = neweyes;
//		//			hair = newhair;
//		//			skin = newskin;
//		//			build = newbuild;
//		//			distinguishingmarks = newdistinguishingmarks;
//		//			str = newstr;
//		//			dex = newdex;
//		//			con = newcon;
//		//			ite = newite;
//		//			wis = newwis;
//		//			cha = newcha;
//		//			clas = newclas;
//		//			archetype = newarchetype;
//		//			hitdie = newhitdie;
//		//			hitpoints = newhitpoints;
//		//			conbonus = newconbonus;
//		//			totalhp = newtotalhp;
//		//			background = newbackground;
//		//			backgroundspecialty = newbackgroundspecialty;
//		//			alignment = newalignment;
//		//			traita = newtraita;
//		//			traitb = newtraitb;
//		//			flaw = newflaw;
//		//			bond = newbond;
//		//			ideal = newideal;
//		//			specialty = newspecialty;
//		//			languages = newlanguages;
//		//			skills = newskills;
//		//			equipment = newequipment;
//		//			spells = newspells;
//		//
//		//		}
//		protected int getmulticlass() {
//			return multiclass;
//		}
//
//		protected void setmulticlass(int multiclass) {
//			this.multiclass = multiclass;
//		}
//
//		protected int[] getlevel() {
//			return level;
//		}
//
//		protected void setlevel(int[] level) {
//			this.level = level;
//		}
//
//		protected String getrace() {
//			return (null==race) ? "" : race.trim();
//		}
//
//		protected void setrace(String race) {
//			this.race = race;
//		}
//
//		protected String getsubrace() {
//			return (null==subrace) ? "" : subrace.trim();
//		}
//
//		protected void setsubrace(String subrace) {
//			this.subrace = subrace;
//		}
//
//		protected String getgender() {
//			return (null==gender) ? "" : gender.trim();
//		}
//
//		protected void setgender(String gender) {
//			this.gender = gender;
//		}
//
//		protected int getage() {
//			return age;
//		}
//
//		protected void setage(int age) {
//			this.age = age;
//		}
//
//		protected String getfirstname() {
//			return (null==firstname) ? "" : firstname.trim();
//		}
//
//		protected void setfirstname(String firstname) {
//			this.firstname = firstname;
//		}
//
//		protected String getclanname() {
//			return (null==clanname) ? "" : clanname.trim();
//		}
//
//		protected void setclanname(String clanname) {
//			this.clanname = clanname;
//		}
//
//		protected int getweight() {
//			return weight;
//		}
//
//		protected void setweight(int weight) {
//			this.weight = weight;
//		}
//
//		protected int getheight() {
//			return height;
//		}
//
//		protected void setheight(int height) {
//			this.height = height;
//		}
//
//		protected String geteyes () {
//			return (null==eyes) ? "" : eyes.trim();
//		}
//
//		protected void seteyes (String eyes) {
//			this.eyes = eyes;
//		}
//
//		protected String gethair () {
//			return (null==hair) ? "" : hair.trim();
//		}
//
//		protected void sethair (String hair) {
//			this.hair = hair;
//		}
//
//		protected String getskin () {
//			return (null==skin) ? "" : skin.trim();
//		}
//
//		protected void setskin (String skin) {
//			this.skin = skin;
//		}
//
//		protected String getbuild () {
//			return (null==build) ? "" : build.trim();
//		}
//
//		protected void setbuild (String build) {
//			this.build = build;
//		}
//
//		protected String getdistinguishingmarks () {
//			return (null==distinguishingmarks) ? "" : distinguishingmarks.trim();
//		}
//
//		protected void setdistinguishingmarks (String distinguishingmarks) {
//			this.distinguishingmarks = distinguishingmarks;
//		}
//
//		protected String getstr () {
//			return (null==str) ? "" : str.trim();
//		}
//
//		protected void setstr (String str) {
//			this.str = str;
//		}
//
//		protected String getdex () {
//			return (null==dex) ? "" : dex.trim();
//		}
//
//		protected void setdex (String dex) {
//			this.dex = dex;
//		}
//
//		protected String getcon () {
//			return (null==con) ? "" : con.trim();
//		}
//
//		protected void setcon (String con) {
//			this.con = con;
//		}
//
//		protected String getite () {
//			return (null==ite) ? "" : ite.trim();
//		}
//
//		protected void setite (String ite) {
//			this.ite = ite;
//		}
//
//		protected String getwis () {
//			return (null==wis) ? "" : wis.trim();
//		}
//
//		protected void setwis (String wis) {
//			this.wis = wis;
//		}
//
//		protected String getcha () {
//			return (null==cha) ? "" : cha.trim();
//		}
//
//		protected void setcha (String cha) {
//			this.cha = cha;
//		}
//
//		protected String[] getclas () {
//			return (null==clas) ? new String[0] : clas;
//		}
//
//		protected void setclas (String[] clas) {
//			this.clas = clas;
//		}
//
//		protected String[] getarchetype () {
//			return (null==archetype) ? new String[0] : archetype;
//		}
//
//		protected void setarchetype (String[] archetype) {
//			this.archetype = archetype;
//		}
//
//		protected int getproficiency() {
//			return proficiency;
//		}
//
//		protected void setproficiency(int proficiency) {
//			this.proficiency = proficiency;
//		}
//
//		protected String[] gethitdie () {
//			return (null==hitdie) ? new String[0] : hitdie;
//		}
//
//		protected void sethitdie (String[] hitdie) {
//			this.hitdie = hitdie;
//		}
//
//		protected int gethitpoints() {
//			return hitpoints;
//		}
//
//		protected void sethitpoints(int hitpoints) {
//			this.hitpoints = hitpoints;
//		}
//
//		protected int getconbonus () {
//			return conbonus;
//		}
//
//		protected void setconbonus (int conbonus) {
//			this.conbonus = conbonus;
//		}
//
//		protected int gettotalhp () {
//			return totalhp;
//		}
//
//		protected void settotalhp (int totalhp) {
//			this.totalhp = totalhp;
//		}
//
//		protected String getbackground () {
//			return (null==background) ? "" : background.trim();
//		}
//
//		protected void setbackground (String background) {
//			this.background = background;
//		}
//
//		protected String getbackgroundspecialty () {
//			return (null==backgroundspecialty) ? "" : backgroundspecialty.trim();
//		}
//
//		protected void setbackgroundspecialty (String backgroundspecialty) {
//			this.backgroundspecialty = backgroundspecialty;
//		}
//
//		protected String getalignment () {
//			return (null==alignment) ? "" : alignment.trim();
//		}
//
//		protected void setalignment (String alignment) {
//			this.alignment = alignment;
//		}
//
//		protected String gettraita () {
//			return (null==traita) ? "" : traita.trim();
//		}
//
//		protected void settraita (String traita) {
//			this.traita = traita;
//		}
//
//		protected String gettraitb () {
//			return (null==traitb) ? "" : traitb.trim();
//		}
//
//		protected void settraitb (String traitb) {
//			this.traitb = traitb;
//		}
//
//		protected String getflaw () {
//			return (null==flaw) ? "" : flaw.trim();
//		}
//
//		protected void setflaw (String flaw) {
//			this.flaw = flaw;
//		}
//
//		protected String getbond () {
//			return (null==bond) ? "" : bond.trim();
//		}
//
//		protected void setbond (String bond) {
//			this.bond = bond;
//		}
//
//		protected String getideal () {
//			return (null==ideal) ? "" : ideal.trim();
//		}
//
//		protected void setideal (String ideal) {
//			this.ideal = ideal;
//		}
//
//		protected String getspecialty () {
//			return (null==specialty) ? "" : specialty.trim();
//		}
//
//		protected void setspecialty (String specialty) {
//			this.specialty = specialty;
//		}
//
//		protected String getlanguages () {
//			return (null==languages) ? "" : languages.trim();
//		}
//
//		protected void setlanguages (String languages) {
//			this.languages = languages;
//		}
//
//		protected String getskills () {
//			return (null==skills) ? "" : skills.trim();
//		}
//
//		protected void setskills (String skills) {
//			this.skills = skills;
//		}
//
//		protected String[] getfeats () {
//			return (null==feats) ? new String[0] : feats;
//		}
//
//		protected void setfeats (String[] feats) {
//			this.feats = feats;
//		}
//
//		protected String getequipment () {
//			return (null==equipment) ? "" : equipment.trim();
//		}
//
//		protected void setequipment (String equipment) {
//			this.equipment = equipment;
//		}
//
//		protected String getcantrips () {
//			return (null==cantrips) ? "" : cantrips.trim();
//		}
//
//		protected void setcantrips (String cantrips) {
//			this.cantrips = cantrips;
//		}
//
//		protected String getspells () {
//			return (null==spells) ? "" : spells.trim();
//		}
//
//		protected void setspells (String spells) {
//			this.spells = spells;
//		}
//	}
//
//	public static void aHunkyDoreyPrintOut(CharData cd) {
//		System.out.println("Level: " +Arrays.toString(cd.getlevel()).replaceAll("\\[|\\]", ""));
//		System.out.println("Race: " +cd.getrace());
//		System.out.println("Subrace: " +cd.getsubrace());
//		System.out.println("Gender: " +cd.getgender());
//		System.out.println("Age: " +cd.getage());
//		System.out.println("Firstname: " +cd.getfirstname());
//		System.out.println("Clanname: " +cd.getclanname());
//		System.out.println("Weight: " +cd.getweight());
//		System.out.println("Height: " +cd.getheight());
//		System.out.println("Eyes: " +cd.geteyes());
//		System.out.println("Hair: " +cd.gethair());
//		System.out.println("Skin: " +cd.getskin());
//		System.out.println("Build: " +cd.getbuild());
//		System.out.println("Distinguishing Marks: " +cd.getdistinguishingmarks());
//		System.out.println("STR: " +cd.getstr());
//		System.out.println("DEX: " +cd.getdex());
//		System.out.println("CON: " +cd.getcon());
//		System.out.println("INT: " +cd.getite());
//		System.out.println("WIS: " +cd.getwis());
//		System.out.println("CHA: " +cd.getcha());
//		System.out.println("Class: " +Arrays.toString(cd.getclas()).replaceAll("\\[|\\]", ""));
//		System.out.println("Archetype: " +Arrays.toString(cd.getarchetype()).replaceAll("\\[|\\]", ""));
//		System.out.println("Proficiency: " +cd.getproficiency());
//		System.out.println("HitDie: " +Arrays.toString(cd.gethitdie()).replaceAll("\\[|\\]", ""));
//		System.out.println("HP: " +cd.gethitpoints());
//		System.out.println("CON Bonus: " +cd.getconbonus());
//		System.out.println("TOTAL HP: " +cd.gettotalhp());
//		System.out.println("Background: " +cd.getbackground());
//		System.out.println("BackgroundSpecialty: " +cd.getbackgroundspecialty());
//		System.out.println("Alignment: " +cd.getalignment());
//		System.out.println("TraitA: " +cd.gettraita());
//		System.out.println("TraitB: " +cd.gettraitb());
//		System.out.println("Flaw: " +cd.getflaw());
//		System.out.println("Bond: " +cd.getbond());
//		System.out.println("Ideal: " +cd.getideal());
//		System.out.println("Specialty: " +cd.getspecialty());
//		System.out.println("Languages: " +cd.getlanguages());
//		System.out.println("Skills: " +cd.getskills());
//		System.out.println("Feats: " +Arrays.toString(cd.getfeats()).replaceAll("\\[|\\]", ""));
//		System.out.println("Equipment: " +cd.getequipment());
//		System.out.println("Cantrips: " +cd.getcantrips());
//		System.out.println("Spells: " +cd.getspells());
//	}
//
//	public static CharData aSpiffyShinyNewRandomCharacter(String[] inclas, int[] inlvl) {
//
//		boolean doinput = (inclas!=null&&
//				inclas.length>0&&
//				inlvl!=null &&
//				inlvl.length>0&&
//				inclas.length==inlvl.length);
//
//		CharData cd = new CharData();
//
//		int[] lvl = null;
//		if (doinput) {
//			cd.setmulticlass(inlvl.length);
//			lvl = new int[cd.getmulticlass()];
//			lvl = inlvl;
//		} else {
//			cd.setmulticlass(generaterandomrange(1,3));
//			lvl = new int[cd.getmulticlass()];
//			for (int i=0; i<lvl.length; i++) {
//				lvl[i] = generaterandomrange(1,20);
//			}
//		}
//		cd.setlevel(lvl);
//
//		cd.setrace(getone(Tables.Races.getRaces()));
//		String[] sasr = new String[] {
//				"Elf",
//				"Halfling",
//				"Dwarf",
//				"Gnome",
//				"Dragonborn"
//		};
//		String subrace;
//		do {
//			subrace = getone(Tables.Races.getSubRaces(cd.getrace()));
//		} while(Arrays.asList(sasr).contains(cd.getrace()) && subrace.equalsIgnoreCase("standard"));
//		cd.setsubrace(subrace);
//
//		Tables.Races tro = Tables.Races.getRacesObject(cd.getrace(), cd.getsubrace());
//
//		String[] sagender = new String[] {"Male","Female"};
//		cd.setgender(getone(sagender));
//
//		cd.setage(Integer.parseInt(tro.AGESTART));
//
//		String firstname = "";
//		String clanname = "";
//		if (cd.getrace().equalsIgnoreCase("half-elf")) {
//			List<String> rlist = new ArrayList<String>(
//					Arrays.asList(Tables.Firstnames.getFirstnamesByRaceAndGender("Human", cd.getgender())));
//			rlist.addAll(Arrays.asList(Tables.Firstnames.getFirstnamesByRaceAndGender("Elf", cd.getgender())));
//			firstname = getone(rlist.toArray(new String[rlist.size()]));
//			List<String> clist = new ArrayList<String>(
//					Arrays.asList(Tables.Clannames.getClannamesbyRace("Human")));
//			clist.addAll(Arrays.asList(Tables.Clannames.getClannamesbyRace("Elf")));
//			clanname = getone(clist.toArray(new String[clist.size()]));
//		} else {
//			firstname = getone(Tables.Firstnames.getFirstnamesByRaceAndGender(cd.getrace(), cd.getgender()));
//			clanname = getone(Tables.Clannames.getClannamesbyRace(cd.getrace()));
//		}
//		cd.setfirstname(firstname);
//		cd.setclanname(clanname);
//
//		cd.setweight(Integer.parseInt(tro.BASEWEIGHT) +
//				generaterandomrange(Integer.parseInt(tro.WEIGHTMODLOW), Integer.parseInt(tro.WEIGHTMODHIGH)));
//
//		cd.setheight(Integer.parseInt(tro.BASEHEIGHT) +
//				generaterandomrange(Integer.parseInt(tro.HEIGHTMODLOW), Integer.parseInt(tro.HEIGHTMODHIGH)));
//
//
//
//
//
//
//		//TODO
//		//marks I need to populate a table.
//		//String distinguishingmarks = null;
//		//cd.setdistinguishingmarks("billy bob teeth (yellow), bald patch");
//
//
//
//
//
//
//
//
//		String[] cls = null;
//		if (doinput) {
//			cls = inclas;
//		} else {
//			cls = new String[cd.getmulticlass()];
//			for (int i=0; i<cls.length; i++) {
//				String s = null;
//				do {
//					s = getone(Tables.Classes.getClasses());
//				} while (Arrays.asList(cls).contains(s));
//				cls[i] = s;
//			}
//		}
//		cd.setclas(cls);
//
//		int[] stats = new int[6];
//		String[] statmod = Tables.Races.getStats(cd.getrace(), cd.getsubrace());
//		for(int i=0; i<statmod.length; i++) {
//			stats[i] = Integer.parseInt(statmod[i]);
//		}
//
//		int top=0;
//		int times=0;
//		if (cd.getrace().equalsIgnoreCase("human") && cd.getsubrace().equalsIgnoreCase("variant")) {
//			//two random mods
//			top=6;
//			times=2;
//		} else if (cd.getrace().equalsIgnoreCase("half-elf")) {
//			//two random mods, except cha
//			top=5;
//			times=2;
//		}
//
//		if (top>0) {
//			int[] inc = new int[times];
//			Arrays.fill(inc, 0);
//			for (int i=0; i<times; i++) {
//				int inc2 = 0;
//				do {
//					inc2 = generaterandomrange(1,top);
//				} while (Arrays.asList(inc).contains(inc2));
//				inc[i] = inc2;
//				stats[inc2-1] = stats[inc2-1]+1;
//			}
//		}
//
//		int[] rolls = new int[6];
//		for (int i=0; i<rolls.length; i++) {
//			rolls[i] = generaterandomrange(3,18);
//		}
//		Arrays.sort(rolls);
//
//		String[] ability = new String[] {
//				"STR",
//				"DEX",
//				"CON",
//				"INT",
//				"WIS",
//		"CHA"};
//
//		Integer[] highlevel = new Integer[cd.getlevel().length];
//		for (int i=0; i<highlevel.length; i++) {
//			highlevel[i] = Integer.valueOf(cd.getlevel()[i]);
//		}
//		Arrays.sort(highlevel);
//		int ivar = highlevel[highlevel.length-1];
//		int maxidx = Arrays.asList(highlevel).indexOf(ivar);
//
//		//for now just use highest class for abilities computations
//		String highclass = cd.getclas()[maxidx];
//
//		List<String> abilities = new ArrayList<String>();
//		abilities.add(Tables.Classes.getAbilityA(highclass));
//		abilities.add(Tables.Classes.getAbilityB(highclass));
//		abilities.add(Tables.Classes.getAbilityC(highclass));
//		for (String s: abilities) {
//			ability[Arrays.asList(ability).indexOf(s)] = null;
//		}
//
//		for (int i=0; i<3; i++) {
//			String s = null;
//			do {
//				s = getone(ability);
//			} while (s == null);
//			ability[Arrays.asList(ability).indexOf(s)] = null;
//			abilities.add(s);
//		}
//
//		int ir = 5;
//		for (String s: abilities) {
//			if ("str".equalsIgnoreCase(s)) {
//				cd.setstr(Integer.toString(rolls[ir--] + stats[0]));
//			} else if ("dex".equalsIgnoreCase(s)) {
//				cd.setdex(Integer.toString(rolls[ir--] + stats[1]));
//			} else if ("con".equalsIgnoreCase(s)) {
//				cd.setcon(Integer.toString(rolls[ir--] + stats[2]));
//			} else if ("int".equalsIgnoreCase(s)) {
//				cd.setite(Integer.toString(rolls[ir--] + stats[3]));
//			} else if ("wis".equalsIgnoreCase(s)) {
//				cd.setwis(Integer.toString(rolls[ir--] + stats[4]));
//			} else if ("cha".equalsIgnoreCase(s)) {
//				cd.setcha(Integer.toString(rolls[ir--] + stats[5]));
//			}
//		}
//
//		//minimum prerequisites for multiclassing
//		if (cd.getmulticlass()>1) {
//			for (String s: cd.getclas()) {
//				if (s.equals("Barbarian")) {
//					if (Integer.parseInt(cd.getstr()) < 13) {
//						cd.setstr("13");
//					}
//				} else if (s.equals("Bard") || s.equals("Sorcerer") || s.equals("Warlock")) {
//					if (Integer.parseInt(cd.getcha()) < 13) {
//						cd.setcha("13");
//					}
//				} else if (s.equals("Cleric") || s.equals("Druid")) {
//					if (Integer.parseInt(cd.getwis()) < 13) {
//						cd.setwis("13");
//					}
//				} else if (s.equals("Fighter")) {
//					if (Integer.parseInt(cd.getstr()) < 13) {
//						cd.setstr("13");
//					}
//					if (Integer.parseInt(cd.getdex()) < 13) {
//						cd.setdex("13");
//					}
//				} else if (s.equals("Monk")) {
//					if (Integer.parseInt(cd.getdex()) < 13) {
//						cd.setdex("13");
//					}
//					if (Integer.parseInt(cd.getwis()) < 13) {
//						cd.setwis("13");
//					}
//				} else if (s.equals("Paladin")) {
//					if (Integer.parseInt(cd.getstr()) < 13) {
//						cd.setstr("13");
//					}
//					if (Integer.parseInt(cd.getcha()) < 13) {
//						cd.setcha("13");
//					}
//				} else if (s.equals("Ranger")) {
//					if (Integer.parseInt(cd.getdex()) < 13) {
//						cd.setdex("13");
//					}
//					if (Integer.parseInt(cd.getwis()) < 13) {
//						cd.setwis("13");
//					}
//				} else if (s.equals("Rogue")) {
//					if (Integer.parseInt(cd.getdex()) < 13) {
//						cd.setdex("13");
//					}
//				} else if (s.equals("Wizard")) {
//					if (Integer.parseInt(cd.getite()) < 13) {
//						cd.setite("13");
//					}
//				}
//			}
//		}
//
////		PhysicalData pd = new PhysicalData();
////		pd = PhysicalAppearance.BeautyIsOnlySkinDeep(pd, Integer.parseInt(cd.getcon()),
////				Integer.parseInt(cd.getstr()), cd.getrace());
////
////		cd.seteyes(pd.geteyes());
////		cd.sethair(pd.gethair());
////		cd.setskin(pd.getskin());
////		cd.setbuild(pd.getbuild());
//
//		String[] art = new String[cd.getmulticlass()];
//		for (int i=0; i<art.length; i++) {
//			art[i] = getone(Tables.Archetypes.getArchetypesClass(cd.getclas()[i]));
//		}
//		cd.setarchetype(art);
//
//		int proficiency = 0;
//		for (int i=0; i<cd.getlevel().length; i++) {
//			proficiency += cd.getlevel()[i];
//			if (proficiency>20) {
//				proficiency=20;
//			}
//		}
//		cd.setproficiency(Integer.parseInt(Tables.SpecialStats.getSpecialStatsProfBonus(Integer.toString(proficiency))));
//
//		int hitpoints = 0;
//		int totallevel = 0;
//		String[] hdi = new String[cd.getmulticlass()];
//		for (int i=0; i<hdi.length; i++) {
//			int level = cd.getlevel()[i];
//			int dice = Integer.parseInt(Tables.Classes.getHitDie(cd.getclas()[i]));
//			hdi[i] = level + "d" + dice;
//			totallevel += level;
//			hitpoints += dice;
//			level = level-1;
//			if (level>0) {
//				hitpoints += DiceRoller.rollEm(level, dice)[level];
//			}
//		}
//		cd.sethitdie(hdi);
//		cd.setconbonus((Integer.parseInt(cd.getcon())/2)-5);
//
//		if (cd.race.equalsIgnoreCase("dwarf") && cd.subrace.equalsIgnoreCase("hill")) {
//			//Hill dwarves get normal HP +1 hit point per level
//			cd.sethitpoints(hitpoints + totallevel);
//		} else {
//			cd.sethitpoints(hitpoints);
//		}
//
//		cd.settotalhp(cd.gethitpoints()+(totallevel*cd.getconbonus()));
//
//		cd.setbackground(getone(Tables.Backgrounds.getBackgrounds()));
//		cd.setbackgroundspecialty(Tables.Backgrounds.getBackgroundSpecialty(cd.getbackground()));
//		String[] saalignment = new String[] {
//				"Lawful Good",
//				"Lawful Neutral",
//				"Lawful Evil",
//				"Chaotic Good",
//				"Chaotic Neutral",
//				"Chaotic Evil",
//				"Neutral Good",
//				"Neutral Evil",
//				"Neutral",
//		"Unaligned"};
//		cd.setalignment(getone(saalignment));
//		cd.settraita(getone(Tables.Personalities.getPersonalityNames(cd.getbackground(), "trait")));
//		cd.settraitb(cd.gettraita());
//		while (cd.gettraita().equalsIgnoreCase(cd.gettraitb())) {
//			cd.settraitb(getone(Tables.Personalities.getPersonalityNames(cd.getbackground(), "trait")));
//		}
//		cd.setflaw(getone(Tables.Personalities.getPersonalityNames(cd.getbackground(), "flaw")));
//		cd.setbond(getone(Tables.Personalities.getPersonalityNames(cd.getbackground(), "bond")));
//		cd.setideal(getone(Tables.Personalities.getPersonalityNames(cd.getbackground(), "ideal")));
//		cd.setspecialty(cd.getbackgroundspecialty());
//		if (!cd.getbackgroundspecialty().equalsIgnoreCase("none")) {
//			String[] pn = Tables.Personalities.getPersonalityNames(cd.getbackground(), cd.getbackgroundspecialty());
//			if (pn != null) {
//				cd.setspecialty(getone(pn));
//			}
//		}
//
//		List<String> langs = new ArrayList<String>();
//		for (String s: Tables.Races.getLanguages(cd.getrace(), cd.getsubrace()).split(",")) {
//			langs.add(s.trim());
//		}
//		String lastelement = langs.get(langs.size()-1).toUpperCase();
//		if (lastelement.contains("BONUS")) {
//			langs.remove(langs.size()-1);
//			for (int i=0; i<Integer.parseInt(Tables.Backgrounds.getBonusLanguages(cd.getbackground())); i++) {
//				String lang;
//				do {
//					lang = getone(Tables.Languages.getLanguages()).trim();
//				} while(langs.contains(lang));
//				langs.add(lang.trim());
//			}
//		} else if (lastelement.contains("AND")) {
//			lastelement = langs.get(langs.size()-1);
//			langs.remove(langs.size()-1);
//			langs.add(lastelement.substring(lastelement.indexOf("AND")+4, lastelement.length()).trim());
//		}
//
//		String languages = "";
//		Collections.sort(langs);
//		for (int i=0; i<langs.size(); i++) {
//			if (i != langs.size()-1) {
//				languages += langs.get(i) + ", ";
//			} else {
//				if (langs.size() < 3) {
//					languages += langs.get(i);
//				} else {
//					languages += "and " + langs.get(i);
//				}
//			}
//		}
//		cd.setlanguages(languages);
//
//		TreeSet<String> tsskills = new TreeSet<>();
//		for (String s: Tables.Backgrounds.getBackgroundSkills(cd.getbackground()).split(",")) {
//			tsskills.add(s.trim());
//		}
//
//		int skn = Integer.parseInt(Tables.Classes.getSkillNum(highclass));
//		for (int i=0; i<skn; i++) {
//			String skill;
//			do {
//				skill = getone(Tables.Skills.getSkills(Tables.Classes.getSkill(highclass)));
//			} while(tsskills.contains(skill));
//			tsskills.add(skill);
//		}
//		cd.setskills(tsskills.toString().replaceAll("\\[|\\]", ""));
//
//		List<String> equipment = new ArrayList<String>();
//		String[] sa = null;
//		if (highclass.equalsIgnoreCase("barbarian")) {
//			equipment.add("Javelin");
//		} else if (highclass.equalsIgnoreCase("bard")) {
//			equipment.add("Dagger");
//		} else if (highclass.equalsIgnoreCase("monk")) {
//			equipment.add("Dart");
//		} else if (highclass.equalsIgnoreCase("rogue")) {
//			equipment.add("Dagger");
//		} else if (highclass.equalsIgnoreCase("sorcerer")) {
//			equipment.add("Dagger");
//		} else if (highclass.equalsIgnoreCase("warlock")) {
//			equipment.add("Dagger");
//		}
//		for (int i=1; i<6; i++) {
//			switch(i) {
//			case 1: sa = Tables.Class_Start_Equipment.getCSEArmoryA(highclass);
//			break;
//			case 2: sa = Tables.Class_Start_Equipment.getCSEArmoryB(highclass);
//			break;
//			case 3: sa = Tables.Class_Start_Equipment.getCSEArmor(highclass);
//			break;
//			case 4: sa = Tables.Class_Start_Equipment.getCSEGeneral(highclass);
//			break;
//			case 5: sa = Tables.Class_Start_Equipment.getCSEPack(highclass);
//			break;
//			}
//			if (sa.length > 0) {
//				String item;
//				do {
//					item = getone(sa);
//				} while (equipment.contains(item) ||
//						item.contains("bow") && equipment.toString().contains("bow") ||
//						item.contains("holy") && equipment.toString().contains("holy"));
//				equipment.add(item);
//			}
//		}
//
//		if (equipment.contains("Shortbow") ||
//				equipment.contains("Longbow")) {
//			equipment.add("Quiver");
//			equipment.add("Arrows (20)");
//		}
//		if (equipment.contains("Hand crossbow")) {
//			equipment.add("Case (crossbow bolt)");
//			equipment.add("Crossbow bolts - Hand (20)");
//		}
//		if (equipment.contains("Light crossbow") ||
//				equipment.contains("Heavy crossbow")) {
//			equipment.add("Case (crossbow bolt)");
//			equipment.add("Crossbow bolts (20)");
//		}
//		if (equipment.contains("Javelin")) {
//			equipment.set(equipment.indexOf("Javelin"), "4 " +
//					equipment.get(equipment.indexOf("Javelin")) + "s");
//		}
//		if (equipment.contains("Handaxe")) {
//			equipment.set(equipment.indexOf("Handaxe"), "2 " +
//					equipment.get(equipment.indexOf("Handaxe")) + "s");
//		}
//		if (equipment.contains("Dagger")) {
//			equipment.set(equipment.indexOf("Dagger"), "2 " +
//					equipment.get(equipment.indexOf("Dagger")) + "s");
//		}
//		if (equipment.contains("Dart")) {
//			equipment.set(equipment.indexOf("Dart"), "10 " +
//					equipment.get(equipment.indexOf("Dart")) + "s");
//		}
//
//		if (highclass.equalsIgnoreCase("barbarian")) {
//			if (!equipment.contains("Explorer's pack")) {
//				equipment.add("Explorer's pack");
//			}
//		} else if (highclass.equalsIgnoreCase("bard")) {
//			if (!equipment.contains("Leather Armor")) {
//				equipment.add("Leather Armor");
//			}
//		} else if (highclass.equalsIgnoreCase("cleric")) {
//			if (!equipment.contains("Shield")) {
//				equipment.add("Shield");
//			}
//		} else if (highclass.equalsIgnoreCase("druid")) {
//			if (!equipment.contains("Leather Armor")) {
//				equipment.add("Leather Armor");
//			}
//			if (!equipment.contains("Explorer's pack")) {
//				equipment.add("Explorer's pack");
//			}
//		} else if (highclass.equalsIgnoreCase("fighter")) {
//		} else if (highclass.equalsIgnoreCase("monk")) {
//		} else if (highclass.equalsIgnoreCase("paladin")) {
//			if (!equipment.contains("Chain mail")) {
//				equipment.add("Chain mail");
//			}
//		} else if (highclass.equalsIgnoreCase("ranger")) {
//			if (!equipment.toString().contains("bow")) {
//				equipment.add("Longbow");
//				equipment.add("Quiver");
//				equipment.add("20 Arrows");
//			}
//		} else if (highclass.equalsIgnoreCase("rogue")) {
//			if (!equipment.contains("Leather Armor")) {
//				equipment.add("Leather Armor");
//			}
//			if (!equipment.contains("Thieves' tools")) {
//				equipment.add("Thieves' tools");
//			}
//		} else if (highclass.equalsIgnoreCase("sorcerer")) {
//		} else if (highclass.equalsIgnoreCase("warlock")) {
//			if (!equipment.contains("Leather Armor")) {
//				equipment.add("Leather Armor");
//			}
//		} else if (highclass.equalsIgnoreCase("wizard")) {
//			equipment.add("Spellbook");
//		}
//
//		String sequipment = "";
//		for (int i=0; i<equipment.size(); i++) {
//			if (i != equipment.size()-1) {
//				sequipment += equipment.get(i) + ", ";
//			} else {
//				sequipment += equipment.get(i);
//			}
//		}
//		cd.setequipment(sequipment);
//
////		Feats synopsis.
////		Feats are granted in the following manner:
////		Note: All granted feats should use suggested feats by class once granted
////		�	Human Variant at 1st Level gains one bonus feat
////		�	At 4th, 8th, 12th, 16th, and 19th class level, not total level
////		o	Multiclass example:
////			a drow elf 3rd level fighter and
////			3rd level wizard would gain zero feats
////		o	Another example,
////			a Variant (1 feat)
////			Human 4th level rogue (1 feat) and
////			11th level warlock (2 feats) would gain a total of 4 feats
////		o	Single classes simply use the initial 4�8�12� progression above
//
//		ArrayList<String> feats = new ArrayList<String>();
//		if (cd.getrace().equalsIgnoreCase("human") && cd.getsubrace().equalsIgnoreCase("variant")) {
//			feats.add(getone(Tables.Feats.getSuggestedFeats(highclass)));
//		}
//		for (int i=0; i<cd.getmulticlass(); i++) {
//			int nfeats = 5;
//			if (cd.getlevel()[i]<19) {
//				nfeats = cd.getlevel()[i]/4;
//			}
//			if (nfeats > 0) {
//				for (int j=0; j<nfeats; j++) {
//					String afeat;
//					do {
//						afeat = getone(Tables.Feats.getSuggestedFeats(cd.getclas()[i]));
//					} while(feats.contains(afeat));
//					feats.add(afeat);
//				}
//			}
//		}
//		Collections.sort(feats);
//		cd.setfeats(feats.toArray(new String[feats.size()]));
//
//
//		//TODO
//		//		//		�	Random starting spells
//		//
//		//		//spells I will have in a moment
//		//		//The SPELLSPERLVL table breaks down each class by level.
//		//		//Here we want to focus only on ARCHNAME, CANTRIPS, and SPELLSKNOWN
//		//		//pull the number of cantrips and spellsknown (equals only first level spells) and
//		//		//randomly select spells from their class spell list
//		//
//		//		//oh, in spellsknown you can get 99 at 1st level,
//		//		//this means that the class has access to all 1st level (class) spells at 1st level -
//		//		//this pertains to druids and clerics
//		//
//		//		//so maybe we should skip listing spells for 1st level cleric and druid, or simply put
//		//		//"All 1st level cleric spells" or druid
//		//
//		//
//		//		//cd.cantrips = Tables.SpellsPerLvl.getSpellsPerLvlCantrips(cd.clas, Integer.toString(cd.level));
//		////		String spellsknown = Tables.SpellsPerLvl.getSpellsPerLvlSpellsKnown(clas, Integer.toString(level));
//		////		System.out.println(spellsknown);
//		//
//		//
//		//
//		//		String[] spl;
//		//		if (cd.getclas1().equalsIgnoreCase("fighter") || cd.getclas1().equalsIgnoreCase("rogue")) {
//		//			spl = Tables.SpellsPerLvl.getSpellsPerLvl(cd.getarchetype1(), Integer.toString(cd.getlevel()));
//		//		} else {
//		//			spl = Tables.SpellsPerLvl.getSpellsPerLvl(cd.getclas1(), Integer.toString(cd.getlevel()));
//		//		}
//		//		if (spl.length > 0) {
//		//			cd.setspells(Arrays.toString(spl).replaceAll("\\[|\\]", ""));
//		//		}
//		//
//		//
//
//
//
//
//
//
//
//
//
//
//		//		Equipment Object For Save and Random
//		//		Fields:
//		//		ID                            Long   (autonumber, increment max ID)
//		//		Carried                 childset of Equipment IDs
//		//		Storage                                childset of Equipment IDs, not carried
//		//		Stronghold          childset of Equipment IDs, at or part of stronghold
//
//
//		//		SpellsKnown Object For Save and Random
//		//		Fields:
//		//		ID
//		//		SpellsCantrips    childset of Spells (cantrips) IDs
//		//		SpellsLvlOne      childset of Spells (cantrips) IDs
//		//		SpellsLvlTwo      etc� through levelnine
//
//
//
//
//
//
//
//
//		return cd;
//		//		return new CharData
//		//			(
//		//			level,
//		//			race,
//		//			subrace,
//		//			gender,
//		//			age,
//		//			firstname,
//		//			clanname,
//		//			weight,
//		//			height,
//		//			eyes,
//		//			hair,
//		//			skin,
//		//			build,
//		//			distinguishingmarks,
//		//			str,
//		//			dex,
//		//			con,
//		//			ite,
//		//			wis,
//		//			cha,
//		//			clas,
//		//			archetype,
//		//			hitdie,
//		//			hitpoints,
//		//			conbonus,
//		//			totalhp,
//		//			background,
//		//			backgroundspecialty,
//		//			alignment,
//		//			traita,
//		//			traitb,
//		//			flaw,
//		//			bond,
//		//			ideal,
//		//			specialty,
//		//			languages,
//		//			skills,
//		//			sequipment,
//		//			spells
//		//			);
//	}
//
//	public static int generaterandom(int i) {
//		return new Random().nextInt(i);
//	}
//
//	public static int generaterandomrange(int min, int max) {
//		return generaterandom((max - min) + 1) + min;
//	}
//
//	public static String getone(String[] sa) {
//		return sa[generaterandom(sa.length)];
//	}
}
