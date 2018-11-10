package marist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import marist.Requirements.Status;

public class DegreeWorksParser {

  File file;
  List<String[]> report = new ArrayList<>();
  public int currLine = 0;
  public Student student = new Student();
  
  public DegreeWorksParser(File file) {
    this.file = file;
  }

  private void initReport() throws FileNotFoundException {
    Scanner sc = new Scanner(this.file);
    StringBuilder fileContents = new StringBuilder();
    while (sc.hasNextLine()) {
      String[] wordsInLine = sc.nextLine().split("\\s+");
      if (wordsInLine.length > 0) {
        if (wordsInLine.length == 1 && wordsInLine[0].length() == 0) {
          // ignore lines with nothing in them
        } else {
          report.add(wordsInLine);
        }
      }
    }
  }

  public Student extractStudentInfo() {

    try {
      initReport();
    } catch (Exception ex) {
      System.out.println("Failed to initialize report for " + file.getName());
    }

    advanceUntil("Student");
    currLine++;

    // Student name and [Undergraduate | Graduate]
    student.lastName = removeLastChar(report.get(currLine)[1]);
    student.firstName = report.get(currLine)[2];
    student.isUndergraduate = (findNextProperty("Level", 3).equals("Undergraduate"));
    currLine++;

    // CWID
    student.CWID = Integer.parseInt(report.get(currLine)[1]);
    currLine++;

    // Grade (ex: Senior) and School (ex: Computer Science & Mathematics)
    student.grade = report.get(currLine)[1];
    student.school = getSchool(2);
    currLine++;

    // Advisor(s)
    student.advisors = getAdvisors();

    // Major(s)
    student.majors = getStudies("Major", "Overall");
    // don't enumerate currLine, already done in getMajorsMistudent.majors = nors()

    // GPA
    student.GPA = Double.parseDouble(report.get(currLine)[2]);

    // Minor(s)
    student.minors = getStudies("Minor", "Student");

    // Degree Requirements %
    advanceUntil("Requirements");
    currLine++;
    student.degreeProgress.requirementsPercent = Integer.valueOf(removeLastChar(report.get(currLine)[0]));

    // Degree Credits %
    advanceUntil("Credits");
    currLine++;
    student.degreeProgress.creditsPercent = Integer.valueOf(removeLastChar(report.get(currLine)[0]));

    // Academic Year
    advanceUntil("Degree");
    currLine++;
    student.academicYear = findNextProperty("Year:", 0);

    // Degree Credits Required
    student.degreeProgress.creditsRequired = Integer.valueOf(findNextProperty("Required:", 2));

    // Credits Applied
    advanceUntil("Academic");
    currLine++;
    student.degreeProgress.creditsApplied = Integer.valueOf(findNextProperty("Applied:", 0));

    // Requirements
    currLine++;
    student.requirements.isLast30Credits = checkStatus();
    student.requirements.hasMinLibArts = checkStatus();
    student.requirements.hasMinCredits = checkStatus();
    student.requirements.hasMinGPA = checkStatus();
    student.requirements.has20GPA = checkStatus();
    student.requirements.hasFoundation = checkStatus();
    student.requirements.hasBreadth = checkStatus();
    student.requirements.hasPathway = checkStatus();
    student.requirements.hasSkill = checkStatus();
    if (isHonorsStudent()) {
      student.requirements.hasHonors = checkStatus();
    } else {
      student.requirements.hasHonors = Requirements.Status.NA;
    }
    student.requirements.hasMajor = checkStatus();

    // get credits applied/required for each major and minor
    updateStudies();

    // get classes in progress
    getInProgress();

    return student;
  }

  private String findNextProperty(String targetWord, int startingIndex) {
    int wordIndex = startingIndex;
    while (!report.get(currLine)[wordIndex].equals(targetWord)) {
      wordIndex++;
    }
    return report.get(currLine)[++wordIndex];
  }

  private void advanceUntil(String targetWord) {
    while (!report.get(currLine)[0].equals(targetWord)) {
      currLine++;
    }
  }

  private void advanceUntil(String targetWord, int targetIndex) {
    while (true) {
      if (report.get(currLine).length - 1 < targetIndex) {
        currLine++;
      } else {
        if (report.get(currLine)[targetIndex].equals(targetWord)) {
          currLine++;
          return;
        }
      }
      currLine++;
    }
  }

  private Status checkStatus() {
    if (report.get(currLine + 1)[0].equals("Still")) {
      currLine += 2;
      return Status.INCOMPLETE;
    } else {
      currLine++;
      return Status.COMPLETE;
    }
  }

  private String getSchool(int wordIndex) {
    while (!report.get(currLine)[wordIndex].equals("College")) {
      wordIndex++;
    }
    wordIndex++;
    int lineLength = report.get(currLine).length;
    StringBuilder schoolName = new StringBuilder();

    while (wordIndex < lineLength) {
      schoolName.append(report.get(currLine)[wordIndex]).append(" ");
      wordIndex++;
    }
    schoolName.setLength(schoolName.length() - 1);
    return schoolName.toString();
  }

  private List<Study> getStudies(String majorOrMinor, String targetWord) {
    List<Study> studies = new LinkedList<>();
    int wordIndex = 0;
    while (!report.get(currLine)[wordIndex].contains(majorOrMinor)) {
      wordIndex++;
    }
    wordIndex++;

    do {
      int lineLength = report.get(currLine).length;
      StringBuilder sb = new StringBuilder();
      while (wordIndex < lineLength) {
        sb.append(report.get(currLine)[wordIndex]).append(" ");
        wordIndex++;
      }

      // check if there is no minor
      if (sb.length() == 0) {
        return studies;
      }

      sb.setLength(sb.length() - 1);
      Study study = new Study();
      study.name = sb.toString();
      studies.add(study);
      wordIndex = 0;
      currLine++;
    } while (!report.get(currLine)[0].equals(targetWord));

    return studies;
  }

  private List<Advisor> getAdvisors() {
    List<Advisor> advisors = new ArrayList<>();
    Advisor advisor = new Advisor();
    advisor.lastName = removeLastChar(report.get(currLine)[1]);
    advisor.firstName = report.get(currLine)[2];
    advisors.add(advisor);

    // check if student has one advisor
    for (String word : report.get(currLine)) {
      if (word.contains("Major")) {
        return advisors;
      }
    }
    // student has multiple advisors
    boolean hasAnotherAdvisor = true;
    while (hasAnotherAdvisor) {
      currLine++;
      for (String word : report.get(currLine)) {
        if (word.contains("Major")) {
          hasAnotherAdvisor = false;
        }
      }
      advisor = new Advisor();
      advisor.lastName = removeLastChar(report.get(currLine)[0]);
      advisor.firstName = report.get(currLine)[1];
      advisors.add(advisor);
    }
    return advisors;
  }

  private boolean isHonorsStudent() {
    return report.get(currLine)[0].equals("Honors");
  }

  private void updateStudies() {
    // Majors

    // there are two ways the major details are displayed
    // option A
    /*
    Major in Computer Science
    Academic Year:   2015-2016
    GPA:   3.952
    A CONCENTRATION IS REQUIRED FOR THIS MAJOR 
    Software Development Concentration
    Concentration in Software Development
    Academic Year:   2015-2016 Credits Required:   67
    Credits Applied:   67
     */
    // option B
    /*
    Major in Information Technology and Systems
    Academic Year:   2017-2018 Credits Required:   73
    GPA:   3.508 Credits Applied:   75
     */
    student.majors.forEach((study) -> {
      advanceUntil("Major");
      currLine++;

      // check for option A
      if (report.get(currLine).length == 3) {
        currLine++;
        study.GPA = Double.parseDouble(report.get(currLine)[1]);
        // attempt to get credits required/applied one or many lines down
        // may not be possible if student has two majors

        // search next ten lines for "Academic" at position 0
        int lineToStopAt = currLine + 10;
        while (currLine < lineToStopAt) {
          if (report.get(currLine)[0].equals("Academic")) {
            // check if line format is like: "Academic Year: 2015-2016 Credits Required: 67"
            if (report.get(currLine).length == 6) {
              // credits required/applied values are located in last index of array
              int lineLength = report.get(currLine).length;
              study.creditsRequired = Integer.parseInt(report.get(currLine)[lineLength - 1]);
              currLine++;
              lineLength = report.get(currLine).length;
              study.creditsApplied = Integer.parseInt(report.get(currLine)[lineLength - 1]);
              return;
            }
          } else {
            currLine++;
          }
        }
      } else {
        // must be option B

        // credits required/applied values are located in last index of array
        int lineLength = report.get(currLine).length;
        study.creditsRequired = Integer.parseInt(report.get(currLine)[lineLength - 1]);
        currLine++;

        study.GPA = Double.parseDouble(report.get(currLine)[1]);
        lineLength = report.get(currLine).length;
        study.creditsApplied = Integer.parseInt(report.get(currLine)[lineLength - 1]);
      }
    });

    // Minors
    student.minors.forEach((study) -> {
      advanceUntil("Minor");
      currLine++;
      int lastIndex = 5;
      study.creditsRequired = Integer.parseInt(report.get(currLine)[lastIndex]);
      currLine++;
      study.GPA = Double.parseDouble(report.get(currLine)[1]);
      lastIndex = 4;
      study.creditsApplied = Integer.parseInt(report.get(currLine)[lastIndex]);
    });
  }

  private void getInProgress() {
    advanceUntil("In-progress", 1);
    student.inProgress.numCredits = Integer.parseInt(report.get(currLine)[2]);
    int numClasses = student.inProgress.numClasses = Integer.parseInt(report.get(currLine)[5]);
    currLine++;
    int endIndex = currLine + numClasses;
    while (currLine < endIndex) {
      Course course = new Course();
      course.dept = report.get(currLine)[0];
      course.number = report.get(currLine)[1];
      int wordIndex = 2;
      StringBuilder courseNameBuilder = new StringBuilder();
      while (!report.get(currLine)[wordIndex].equals("IP")) {
        courseNameBuilder.append(report.get(currLine)[wordIndex])
                .append(" ");
        wordIndex++;
      }
      courseNameBuilder.setLength(courseNameBuilder.length() - 1);
      course.name = courseNameBuilder.toString();

      // skip "IP"
      wordIndex++;

      // credits
      course.credits = Integer.parseInt(report.get(currLine)[wordIndex]);
      wordIndex++;

      // semester
      course.semester = report.get(currLine)[wordIndex];
      wordIndex++;

      // year
      course.year = Integer.parseInt(report.get(currLine)[wordIndex]);

      student.inProgress.courses.add(course);
      currLine++;
    }
  }

  private static String removeLastChar(String string) {
    return string.substring(0, string.length() - 1);
  }
}
