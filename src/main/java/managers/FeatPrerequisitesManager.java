package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.FeatPrerequisite;

import java.io.IOException;
import java.util.List;

import static managers.ReadFile.readFromFile;

public class FeatPrerequisitesManager {

    public static List<FeatPrerequisite> getAllFeatPrerequisiteObjects() {
        List<FeatPrerequisite> prerequisites = null;
        try {
            String jsonArray = readFromFile("featPrerequisites");
            ObjectMapper objectMapper = new ObjectMapper();
            prerequisites = objectMapper.readValue(jsonArray, new TypeReference<List<FeatPrerequisite>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prerequisites;
    }


}
