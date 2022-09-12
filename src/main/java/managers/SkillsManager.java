package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.CharacterClass;
import models.Feat;
import models.Skill;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class SkillsManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Skill> getAllSkillObjects() {
        List<Skill> skillList = null;
        try {
            String jsonArray = readFromFile("skills");
            ObjectMapper objectMapper = new ObjectMapper();
            skillList = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return skillList;
    }

    public static List<Skill> getSkillsByAbility(List<Skill> skillList, String ability) {

        List<Skill> skills = skillList.stream()
                .filter(sk -> sk.getAbility().equalsIgnoreCase(ability))
                .collect(Collectors.toList());

        return skills;
    }

    public static List<Skill> getSkillsByClass(List<Skill> skillList, String className) {

        List<Skill> skills = skillList.stream()
                .filter(sk -> sk.getClasses().contains(className))
                .collect(Collectors.toList());

        return skills;
    }

    public static Set<String> getSkillsList() {
        Set<String> skills = new HashSet<>();
        List<Skill> skillList = getAllSkillObjects();

        for (Skill sk : skillList)
            skills.add(sk.getSkill());

        return skills;

    }

    public static void saveSkills(List<Skill> skillList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(skillList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "armors.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveSkill(Skill skill, String userName) {

        boolean isNewSkill = false;

        if (skill.getSkillID() == null) {
            skill.setSkillID(getNewSkillID());
            isNewSkill = true;
        }

        List<Skill> skillList = getAllSkillObjects();

        if (skillList == null)
            skillList = new ArrayList<>();

        //overwrite
        Skill oldSkill = null;
        if (!isNewSkill) {
            if (skillList.stream().anyMatch(sk -> sk.getSkillID().equals(skill.getSkillID()))) {
                oldSkill = skillList.stream()
                        .filter(skl -> skl.getSkillID().equals(skill.getSkillID()))
                        .findFirst().get();

                if (oldSkill.getAuthor().equals(userName))
                    skillList.remove(oldSkill);
            }
        }

        skillList.add(skill);
        saveSkills(skillList);
    }

    private static String getNewSkillID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String skillID = "";

        List<Skill> skillList = getAllSkillObjects();
        Set<String> ids = skillList.stream()
                .map(Skill::getSkillID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }
            skillID = "SK-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(skillID));

        return skillID;
    }

    public static void deleteArmorByID(String skillID, String userName) {
        List<Skill> skillList = getAllSkillObjects();
        Skill skill = null;

        if (skillList.stream().anyMatch(sk -> sk.getSkillID().equals(skillID))) {
            skill = skillList.stream().filter(skl -> skl.getSkillID().equals(skillID))
                    .findFirst().get();

            if (skill.getAuthor().equals(userName)) {
                skillList.remove(skill);
                saveSkills(skillList);
            }
        }

        return;
    }

}
