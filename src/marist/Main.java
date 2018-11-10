package marist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    File folder = new File("reports");
    File[] listOfFiles = folder.listFiles();

    Arrays.stream(listOfFiles)
            .forEach(file -> {
              DegreeWorksParser degreeWorksParser = new DegreeWorksParser(file);
              Student student = degreeWorksParser.extractStudentInfo();
              Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
              System.out.println(gson.toJson(student));
            });

  }
}
