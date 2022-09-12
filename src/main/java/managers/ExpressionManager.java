package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Expression;
import models.Onomasticon;
import utilities.Randomizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class ExpressionManager {

//    private static String basePath = "src/main/java/data/jsondata/onomasticon/";
//
//    public static List<Expression> getAllExpressionsInFile(String subject) {
//
//        List<Expression> expressions = new ArrayList<>();
//        try {
//            String jsonArray = readFromFile("ono-" + subject);
//            ObjectMapper objectMapper = new ObjectMapper();
//            expressions = objectMapper.readValue(jsonArray, new TypeReference<>() {
//            });
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return expressions;
//    }
//
//    public static Set<String> getAllSubjectsInFile(String subject) {
//
//        return getAllExpressionsInFile(subject).stream()
//                .map(sub -> sub.getSubject())
//                .collect(Collectors.toSet());
//    }
//
//    public static Expression getExpressionBySubjectName(String subject) {
//        List<Expression> expressionList = getAllExpressionsInFile(subject);
//        Expression expression = null;
//
//        if (expressionList.stream().anyMatch(ono -> ono.getSubject().equalsIgnoreCase(subject)))
//            expression = expressionList.stream()
//                    .filter(onom -> onom.getSubject().equalsIgnoreCase(subject))
//                    .findFirst().get();
//
//        return expression;
//
//    }
//
//    public static String getRandomExpressionBySubjectName(String subject) {
//        Expression expression = getExpressionBySubjectName(subject);
//
//        return Randomizer.getRandomElement(expression.getMetonym());
//
//    }
}
