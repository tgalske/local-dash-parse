package marist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

  public static void main(String[] args) {
    DegreeWorksParser degreeWorksParser = new DegreeWorksParser();
    
    Student student = degreeWorksParser.extractStudentInfo();
    
    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    System.out.println(gson.toJson(student));

  }
}
