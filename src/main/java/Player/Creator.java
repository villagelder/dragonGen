package Player;



import managers.*;
import models.*;
import utilities.Randomizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Creator {

    public static void main(String[] args) throws IOException, IllegalAccessException {
       // PlayerCharacter pc = PlayerCharacterGenerator.generateRandomPC(null, null, "male", "not evil", 1, false, true);

        //SpellBook spellBook =  SpellBookGenerator.generateSpellBook("wizard", "necromancy", 6);

//        for (int i = 0; i < 12; i++) {
//            System.out.println(SpellBookGenerator.createSpellBookName("necromancy"));
//        }
//        Object o = pc;
//        for (Field field : o.getClass().getDeclaredFields()) {
//            field.setAccessible(true);
//            String name = field.getName();
//            Object value = field.get(o);
//            if (value != null)
//                System.out.println(name + ": " + value);
//        }
//        System.out.println("\n");
//
    }

}
