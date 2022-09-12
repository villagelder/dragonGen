package Player;

import managers.ArchetypesManager;
import managers.ClassesManager;
import managers.RacesManager;
import models.Archetype;
import models.Race;
import utilities.DiceRoller;
import utilities.Randomizer;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Starter {

    public static void main (String[]args) throws IOException, IllegalAccessException {
        prompt();
    }
    private static void prompt() {

        String subject = "";
        Scanner in = null;
        do {

            in = new Scanner(System.in);

            System.out.println("\nWhat item would you like to generate? ('info' for more information)");
            subject = in.nextLine();

            if (subject.equals("Q"))
                System.exit(0);
            getResult(subject);

        } while (!subject.equals("Q"));

        in.close();

    }

    private static void getResult(String subject) {
        String race = RacesManager.getRandomRace(null).getRaceName();
        String classOne = ClassesManager.getRandomClass(null).getClassName();

        switch(subject) {
            case "info": System.out.println("INFO");
                System.out.println("class - random class");
                System.out.println("archetype - class with archetype");
                System.out.println("multiclass - random multiclass");
                System.out.println("race - base race");
                System.out.println("subrace - race with subrace");
                break;
            case "class": System.out.println("Class: " + ClassesManager.getRandomClass(null).getClassName());
                break;
            case "archetype": System.out.println("Archetype: " + classOne + ", " + Randomizer.getRandomElement(ArchetypesManager.getSimpleArchetypesByClassName(classOne)));
                break;
            case "multiclass":
                int roll = DiceRoller.roll1d6();
                String classTwo = null;
                String classThree = null;

                do {
                    classTwo = ClassesManager.getRandomClass(null).getClassName();
                    classThree = ClassesManager.getRandomClass(null).getClassName();
                } while (classOne.equals(classTwo) || classOne.equals(classThree) || classThree.equals(classTwo));

                if (roll < 5) {
                    System.out.println("Multiclass: " + classOne + "/" + classTwo);
                } else{
                    System.out.println("Multiclass: " + classOne + "/" + classTwo + "/" + classThree);
                }
                break;
            case "race": System.out.println("Race: " + race);
            break;
            case "subrace":
                String subrace = Randomizer.getRandomElement(RacesManager.getSimpleSubracesList(race));
                System.out.println("Subrace: " + subrace + " " + race);
                break;

            default: System.out.println("Improper selection. Please try again.");;
                break;

        }


    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
