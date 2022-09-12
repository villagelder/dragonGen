package managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

//    public static String readFile(String path, Charset encoding) throws IOException {
//        return Files.readString(Paths.get(path), encoding);
//    }

    public static String readFromFile(String filename) throws IOException {

        File file = new File("src/main/java/data/jsondata/" + filename + ".json");
        if (!file.exists())
            return null;

        FileInputStream fis = null;

        fis = new FileInputStream(file);
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();

        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }

        return sb.toString();


    }
}