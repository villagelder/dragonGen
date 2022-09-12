package data;

public class XmlToJson {

	//	@SuppressWarnings("rawtypes")
	//	public static ArrayList<Object> xml_to_object_array(Class classname, String file, String[] tags) {
	//		String[] subtags = tags;
	//		ArrayList<Object> arraylist = new ArrayList<Object>();
	//		Document doc = Utilities.parseDom(file);
	//		Node root = Utilities.getNode("dataroot", doc.getChildNodes());
	//		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
	//			Node currentNode = root.getChildNodes().item(i);
	//			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	//				try {
	//					arraylist.add(Utilities.churnAndBurn(classname.newInstance(), currentNode, subtags, new int[subtags.length]));
	//				} catch (InstantiationException | 
	//						IllegalAccessException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		}
	//		return arraylist;
	//	}
	//
	//	@SuppressWarnings("rawtypes")
//	public static void main(String[] args) {
//
//		String dot = ".";
//		String inext = "xml";
//		String outext = "json";
//		String[] dirsin = new String[] {
//				"src/org/dragonvault/xmldata/",
//				"src/org/dragonvault/xmldata/treasure/"
//		};
//		@SuppressWarnings("rawtypes")
//		Class[] cls = new Class[] {
//				Tables.class,
//				Treasure.class
//		};
//		String dirout = "src/org/dragonvault/data/jsondata/";
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		for (String d: dirsin) {
//			File dir = new File(d);
//			if (dir.exists()) {
//				List<File> filelist = (List<File>) FileUtils.listFiles(dir, new String[] {inext}, false);
//				for (File file : filelist) {
//					String fn = FilenameUtils.removeExtension(file.getName()).toLowerCase();
//					boolean processed = false;
//					for (@SuppressWarnings("rawtypes") Class cla: cls) {
//						for (@SuppressWarnings("rawtypes") Class cl: cla.getDeclaredClasses()) {
//							if (fn.equalsIgnoreCase(cl.getSimpleName())) {
//								String pin = d+fn+dot+inext;
//								String pout = dirout+fn+dot+outext;
//								File fout = new File(pout);
//								if (fout.exists()) {
//									fout.delete();
//								}
//								try {
//									String[] sa = (String[]) cl.getDeclaredField("subtags").get(cl);
//									FileWriter writer = new FileWriter(pout);
//									writer.write(gson.toJson(Utilities.xml_to_object_array(cl, pin, sa)));
//									writer.close();
//									System.out.println("Processed: " + pin);
//									processed = true;
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//								break;
//							}
//						}
//					}
//					if (!processed) {
//						System.out.println("Failed: " + fn);
//					}
//				}
//			}
//		}
//
//
//
//
//
//
//		//		int pcount = 0;
//		//		try {
//		//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		//			for (int loop=0; loop<100; loop++) {
//		//				Class classin = null;
//		//				String[] subtags = null;
//		//				String filein = null;
//		//				String fileout = null;
//		//
//		//				switch (loop) {
//		//				//=======================================================================================
//		//				//=======================================================================================
//		//				//================================TABLE ITEMS============================================
//		//				//=======================================================================================
//		//				//=======================================================================================
//		//				case 0:
//		//					classin = Tables.Archetypes.class;
//		//					subtags = Tables.Archetypes.subtags;
//		//					filein = "src/org/dv/data/xmldata/archetype.xml";
//		//					fileout = "src/org/dv/data/jsondata/archetype.json";
//		//					break;
//		//				case 1:
//		//					classin = Tables.ArmorProficiencies.class;
//		//					subtags = Tables.ArmorProficiencies.subtags;
//		//					filein = "src/org/dv/data/xmldata/armorproficiencies.xml";
//		//					fileout = "src/org/dv/data/jsondata/armorproficiencies.json";
//		//					break;
//		//				case 2:
//		//					classin = Tables.Armors.class;
//		//					subtags = Tables.Armors.subtags;
//		//					filein = "src/org/dv/data/xmldata/armors.xml";
//		//					fileout = "src/org/dv/data/jsondata/armors.json";
//		//					break;
//		//				case 3:
//		//					classin = Tables.Backgrounds.class;
//		//					subtags = Tables.Backgrounds.subtags;
//		//					filein = "src/org/dv/data/xmldata/background.xml";
//		//					fileout = "src/org/dv/data/jsondata/background.json";
//		//					break;
//		//				case 4:
//		//					classin = Tables.Classes.class;
//		//					subtags = Tables.Classes.subtags;
//		//					filein = "src/org/dv/data/xmldata/chclass.xml";
//		//					fileout = "src/org/dv/data/jsondata/chclass.json";
//		//					break;
//		//				case 5:
//		//					classin = Tables.Clannames.class;
//		//					subtags = Tables.Clannames.subtags;
//		//					filein = "src/org/dv/data/xmldata/clannames.xml";
//		//					fileout = "src/org/dv/data/jsondata/clannames.json";
//		//					break;
//		//				case 6:
//		//					classin = Tables.Class_Start_Equipment.class;
//		//					subtags = Tables.Class_Start_Equipment.subtags;
//		//					filein = "src/org/dv/data/xmldata/class_start_equip.xml";
//		//					fileout = "src/org/dv/data/jsondata/class_start_equip.json";
//		//					break;
//		//				case 7:
//		//					classin = Tables.Equipment.class;
//		//					subtags = Tables.Equipment.subtags;
//		//					filein = "src/org/dv/data/xmldata/equipment.xml";
//		//					fileout = "src/org/dv/data/jsondata/equipment.json";
//		//					break;
//		//				case 8:
//		//					classin = Tables.Equipmentpacks.class;
//		//					subtags = Tables.Equipmentpacks.subtags;
//		//					filein = "src/org/dv/data/xmldata/equipmentpacks.xml";
//		//					fileout = "src/org/dv/data/jsondata/equipmentpacks.json";
//		//					break;
//		//				case 9:
//		//					classin = Tables.Feats.class;
//		//					subtags = Tables.Feats.subtags;
//		//					filein = "src/org/dv/data/xmldata/feats.xml";
//		//					fileout = "src/org/dv/data/jsondata/feats.json";
//		//					break;
//		//				case 10:
//		//					classin = Tables.Features_class.class;
//		//					subtags = Tables.Features_class.subtags;
//		//					filein = "src/org/dv/data/xmldata/features_class.xml";
//		//					fileout = "src/org/dv/data/jsondata/classFeatures.json";
//		//					break;
//		//				case 11:
//		//					classin = Tables.Firstnames.class;
//		//					subtags = Tables.Firstnames.subtags;
//		//					filein = "src/org/dv/data/xmldata/firstname.xml";
//		//					fileout = "src/org/dv/data/jsondata/firstname.json";
//		//					break;
//		//				case 12:
//		//					classin = Tables.Gameworld.class;
//		//					subtags = Tables.Gameworld.subtags;
//		//					filein = "src/org/dv/data/xmldata/gameworld.xml";
//		//					fileout = "src/org/dv/data/jsondata/gameworld.json";
//		//					break;
//		//				case 13:
//		//					classin = Tables.Geography.class;
//		//					subtags = Tables.Geography.subtags;
//		//					filein = "src/org/dv/data/xmldata/geography.xml";
//		//					fileout = "src/org/dv/data/jsondata/geography.json";
//		//					break;
//		//				case 14:
//		//					classin = Tables.Languages.class;
//		//					subtags = Tables.Languages.subtags;
//		//					filein = "src/org/dv/data/xmldata/languages.xml";
//		//					fileout = "src/org/dv/data/jsondata/languages.json";
//		//					break;
//		//				case 15:
//		//					classin = Tables.Lexicon.class;
//		//					subtags = Tables.Lexicon.subtags;
//		//					filein = "src/org/dv/data/xmldata/lexicon.xml";
//		//					fileout = "src/org/dv/data/jsondata/lexicon.json";
//		//					break;
//		//				case 16:
//		//					classin = Tables.Personalities.class;
//		//					subtags = Tables.Personalities.subtags;
//		//					filein = "src/org/dv/data/xmldata/personality.xml";
//		//					fileout = "src/org/dv/data/jsondata/personality.json";
//		//					break;
//		//				case 17:
//		//					classin = Tables.Quickbuild_Equip.class;
//		//					subtags = Tables.Quickbuild_Equip.subtags;
//		//					filein = "src/org/dv/data/xmldata/quickbuild_equip.xml";
//		//					fileout = "src/org/dv/data/jsondata/quickbuild_equip.json";
//		//					break;
//		//				case 18:
//		//					classin = Tables.Races.class;
//		//					subtags = Tables.Races.subtags;
//		//					filein = "src/org/dv/data/xmldata/race.xml";
//		//					fileout = "src/org/dv/data/jsondata/race.json";
//		//					break;
//		//				case 19:
//		//					classin = Tables.Racial_Traits.class;
//		//					subtags = Tables.Racial_Traits.subtags;
//		//					filein = "src/org/dv/data/xmldata/racial_traits.xml";
//		//					fileout = "src/org/dv/data/jsondata/racial_traits.json";
//		//					break;
//		//				case 20:
//		//					classin = Tables.Skills.class;
//		//					subtags = Tables.Skills.subtags;
//		//					filein = "src/org/dv/data/xmldata/skills.xml";
//		//					fileout = "src/org/dv/data/jsondata/skills.json";
//		//					break;
//		//				case 21:
//		//					classin = Tables.SpecialStats.class;
//		//					subtags = Tables.SpecialStats.subtags;
//		//					filein = "src/org/dv/data/xmldata/specialstats.xml";
//		//					fileout = "src/org/dv/data/jsondata/specialstats.json";
//		//					break;
//		//				case 22:
//		//					classin = Tables.Specialty_Spells.class;
//		//					subtags = Tables.Specialty_Spells.subtags;
//		//					filein = "src/org/dv/data/xmldata/specialty_spells.xml";
//		//					fileout = "src/org/dv/data/jsondata/specialty_spells.json";
//		//					break;
//		//				case 23:
//		//					classin = Tables.Spells.class;
//		//					subtags = Tables.Spells.subtags;
//		//					filein = "src/org/dv/data/xmldata/spells.xml";
//		//					fileout = "src/org/dv/data/jsondata/spell.json";
//		//					break;
//		//				case 24:
//		//					classin = Tables.SpellsPerLvl.class;
//		//					subtags = Tables.SpellsPerLvl.subtags;
//		//					filein = "src/org/dv/data/xmldata/spellsperlvl.xml";
//		//					fileout = "src/org/dv/data/jsondata/spellsperlvl.json";
//		//					break;
//		//				case 25:
//		//					classin = Tables.Toolkits.class;
//		//					subtags = Tables.Toolkits.subtags;
//		//					filein = "src/org/dv/data/xmldata/toolkit.xml";
//		//					fileout = "src/org/dv/data/jsondata/toolkit.json";
//		//					break;
//		//				case 26:
//		//					classin = Tables.Traits.class;
//		//					subtags = Tables.Traits.subtags;
//		//					filein = "src/org/dv/data/xmldata/traits.xml";
//		//					fileout = "src/org/dv/data/jsondata/traits.json";
//		//					break;
//		//				case 27:
//		//					classin = Tables.Weapons.class;
//		//					subtags = Tables.Weapons.subtags;
//		//					filein = "src/org/dv/data/xmldata/weapons.xml";
//		//					fileout = "src/org/dv/data/jsondata/weapons.json";
//		//					break;
//		//				case 28:
//		//					classin = Tables.WeaponProficiencies.class;
//		//					subtags = Tables.WeaponProficiencies.subtags;
//		//					filein = "src/org/dv/data/xmldata/wpnproficiencies.xml";
//		//					fileout = "src/org/dv/data/jsondata/wpnproficiencies.json";
//		//					break;
//		//					//=======================================================================================
//		//					//=======================================================================================
//		//					//=============================TREASURE ITEMS============================================
//		//					//=======================================================================================
//		//					//=======================================================================================
//		//				case 29:
//		//					classin = Treasure.ArtItems.class;
//		//					subtags = Treasure.ArtItems.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/artobjects.xml";
//		//					fileout = "src/org/dv/data/jsondata/artobjects.json";
//		//					break;
//		//				case 30:
//		//					classin = Treasure.GemItem.class;
//		//					subtags = Treasure.GemItem.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/gems.xml";
//		//					fileout = "src/org/dv/data/jsondata/gems.json";
//		//					break;
//		//				case 31:
//		//					classin = Treasure.MagicItems.class;
//		//					subtags = Treasure.MagicItems.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/magicitems.xml";
//		//					fileout = "src/org/dv/data/jsondata/magicitems.json";
//		//					break;
//		//				case 32:
//		//					classin = Treasure.HoardCoins.class;
//		//					subtags = Treasure.HoardCoins.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasurehoardcoins.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasurehoardcoins.json";
//		//					break;
//		//				case 33:
//		//					classin = Treasure.HoardItemsHigh.class;
//		//					subtags = Treasure.HoardItemsHigh.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasurehoarditemshigh.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasurehoarditemshigh.json";
//		//					break;
//		//				case 34:
//		//					classin = Treasure.HoardItemsLow.class;
//		//					subtags = Treasure.HoardItemsLow.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasurehoarditemslow.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasurehoarditemslow.json";
//		//					break;
//		//				case 35:
//		//					classin = Treasure.HoardItemsMaster.class;
//		//					subtags = Treasure.HoardItemsMaster.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasurehoarditemsmaster.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasurehoarditemsmaster.json";
//		//					break;
//		//				case 36:
//		//					classin = Treasure.HoardItemsVet.class;
//		//					subtags = Treasure.HoardItemsVet.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasurehoarditemsvet.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasurehoarditemsvet.json";
//		//					break;
//		//				case 37:
//		//					classin = Treasure.IndividualHigh.class;
//		//					subtags = Treasure.IndividualHigh.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasureindividualhigh.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasureindividualhigh.json";
//		//					break;
//		//				case 38:
//		//					classin = Treasure.IndividualLow.class;
//		//					subtags = Treasure.IndividualLow.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasureindividuallow.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasureindividuallow.json";
//		//					break;
//		//				case 39:
//		//					classin = Treasure.IndividualMaster.class;
//		//					subtags = Treasure.IndividualMaster.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasureindividualmaster.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasureindividualmaster.json";
//		//					break;
//		//				case 40:
//		//					classin = Treasure.IndividualVet.class;
//		//					subtags = Treasure.IndividualVet.subtags;
//		//					filein = "src/org/dv/data/xmldata/treasure/treasureindividualvet.xml";
//		//					fileout = "src/org/dv/data/jsondata/treasureindividualvet.json";
//		//					break;
//		//				default:
//		//					break;
//		//				}
//		//
//		//				if (classin==null || subtags==null || filein==null || fileout==null) {
//		//					continue;
//		//				} else {
//		//					if (new File(filein).exists()) {
//		//						if (new File(fileout).exists()) {
//		//							new File(fileout).delete();
//		//						}
//		//						FileWriter writer = new FileWriter(fileout);
//		//						writer.write(gson.toJson(Utilities.xml_to_object_array(classin, filein, subtags)));
//		//						writer.close();
//		//						System.out.println("Processed: " + filein);
//		//						pcount++;
//		//					}
//		//				}
//		//			}
//		//		} catch (Exception e) {
//		//			e.printStackTrace();
//		//		}
//		System.out.println("Finished! :)");
//	}
}
