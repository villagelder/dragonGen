package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Skill;
import models.User;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class UserManager {

    private static final String basePath = "src/main/java/data/jsondata/";

    public static List<User> getAllUsers() {
        List<User> userList = null;
        try {
            String jsonString = readFromFile("users");
            if (jsonString == null)
                return null;

            final ObjectMapper mapper = new ObjectMapper();
            userList = mapper.readValue(jsonString, new TypeReference<>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static String getNewUserIDToken() {
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String userID = "";

        List<User> userList = getAllUsers();
        Set<String> ids = userList.stream()
                .map(User::getUserID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 28; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }
            userID = chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(userID));

        return userID;

    }

    public static void saveUser(User user) {
        try {

            List<User> userList = getAllUsers();

            if (userList == null)
                userList = new ArrayList<>();

            //overwrite
            User nowUser = null;
            if (userList.stream().anyMatch(usr -> usr.getUserID().equals(user.getUserID()))) {
                nowUser = userList.stream()
                        .filter(opc -> opc.getUsername().equals(user.getUsername()))
                        .findFirst().get();
            }

            userList.remove(nowUser);
            userList.add(user);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);
            String p = basePath + "users.json";

            Path path = Paths.get(p);
            byte[] strToBytes = json.getBytes();

            Files.write(path, strToBytes);

        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static User getUserByID(String userID) {
        List<User> userList = getAllUsers();
        User user = null;
        if (userList == null)
            return null;

        if (userList.stream().anyMatch(um -> um.getUserID().equals(userID))) {
            user = userList.stream()
                    .filter(usr -> usr.getUserID().equals(userID))
                    .findFirst().get();
        }

        return user;

    }
}
