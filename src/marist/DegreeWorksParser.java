package marist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import marist.Requirements.Status;

public class DegreeWorksParser {

  List<String[]> report = new ArrayList<>();
  public int currLine = 0;
  public Student student = new Student();

  private void initReport() {
    String degreeWorksText = "DWPROD\nStudent View    AB218SdT as of 28-Aug-2018 at 22:11\nStudent Galske, Tyler O Level Undergraduate\nID 20064184 Degree B.S.  \nClassification Senior   College Computer Science & Mathematics\nAdvisor Schwartz, Donald R  Major Computer Science\nOverall GPA 3.953 Minors Cybersecurity\nInformation Technology\nInformation Systems\nStudent Type Traditional Continuing Concentration CompSci: Software Development\nTerm Location Poughkeepsie\n\nDegree Progress\nRequirements\n97%\n \nCredits\n94%\n \n\nDegree in Bachelor of Science\nAcademic Year:   2015-2016 Credits Required:   120\nGPA:   3.953 Credits Applied:   113\nLast 30 Credits At Marist\nMimimum Liberal Art Credits\nMinimum Degree Credits\nStill Needed: 120 CREDITS ARE REQUIRED. YOU CURRENTLY HAVE 113, (INCLUDING BOTH EARNED AND IN PROGRESS COURSES) YOU STILL NEED 7 ADDITIONAL CREDITS. COURSES THAT APPEAR TWICE ON THE AUDIT ARE ONLY COUNTED ONCE TOWARD THIS REQUIREMENT.\nMinimum GPA\n2.0 GPA Requirement\nFoundation\nDistribution: Breadth\nDistribution: Pathway\nSkill Requirement\nMajor Requirements\nStill Needed: See Major in Computer Science section\nFoundation\n        ACADEMIC FOUNDATION REQUIREMENTS\nFirst-Year Seminar\nFYS 101L FIRST YEAR SEMINAR A  4 Spring 2016\nWriting for College\nENG 120L WRITING FOR COLLEGE A  3 Fall 2015\nDistribution: Breadth\n        Minimum Distribution Credit\nBREADTH REQUIREMENTS\n3 credits in Philosophical Perspectives\nPHIL 101L PHILOSOPHICAL PERSPECTIVES A  3 Spring 2016\n3 credits in Fine Arts\nMUS 392L ST:HIST OF ROCK'N ROLL A-  3 Fall 2015\n3 credits in History\nHIST 252L MODERN EUROPE A  3 Fall 2016\n3 credits in Literature\nENG 240L AM SHORT FIC A  3 Fall 2017\n3 credits in Math\nMATH 241L CALCULUS I A-  4 Fall 2017\n3 credits in Natural Science\nENSC 101L INTRO ENVIRON ISS A  3 Spring 2017\n3 credits Ethics/Applied Ethics/Religious Studies\nREST 201L RELIGION IN AMER A  3 Spring 2018\n3 credits in Social Science\nECON 150L ECON-SOCIAL ISSUES A  3 Spring 2018\nDISTRIBUTION OVERFLOW\nEVERY STUDENT MUST HAVE A TOTAL OF 36 CORE DISTRIBUTION CREDITS. PATHWAY COURSES MAY BE LISTED IN EITHER THE BREADTH OR OVERFLOW AREAS. PLEASE NOTE, HOWEVER, THAT EVERY COURSE CAN ONLY COUNT ONCE TOWARD THE 36-CREDIT DISTRIBUTION TOTAL. \nDistribution Overflow\nSPAN 106L INTER SPAN II A  3 Fall 2015\nDistribution Overflow\nMATH 130L INTRO-STATISTICS T  3 Fall 2015\nSatisfied by MATH130L - INTRO-STATISTICS - ADVANCED PLACEMENT EXAM:AP\nDistribution Overflow\nMATH 205L DISCRETE MATHEMATICS A  4 Spring 2017\nDistribution Overflow\nANTH 102L CULTURAL ANTHROPOLOGY IP  (3) Fall 2018\nPathway: Quantitative Studies\n        QUANTITATIVE STUDIES PATHWAY COURSES\nPATHWAYS REQUIRE A MIN OF 3 DIFFERENT AUTHORIZED AREAS FOR THIS PATHWAY - 1: [MUS 106L, 120L, 220L] AND 2: [MATH 130L, 205L, 210L, 241L, 242L] AND 3: [CHEM 101L, 132L, ENSC 305L, PHYS 108L, 201L,  202L, 211L, 212L, 221L] AND 4: [PHIL 203L, 235L, 310L] AND 5: [ECON 104L, 150L, 305L, POSC 121L, 122L, 124L,  235L, 289L, 325L, 342L, PSYC 350L, SOCW 383N] AND 6: [COM 200L, CMPT 120L, CRJU 374L, ENG 222L, FASH 304N] \nQuantitative Studies Options\nMATH 130L INTRO-STATISTICS T  3 Fall 2015\nSatisfied by MATH130L - INTRO-STATISTICS - ADVANCED PLACEMENT EXAM:AP\nMATH 205L DISCRETE MATHEMATICS A  4 Spring 2017\nECON 150L ECON-SOCIAL ISSUES A  3 Spring 2018\nCMPT 120L INTRO TO PROGRAMMING A-  4 Fall 2015\nSkill Requirement\n        SKILL REQUIREMENT\nTechnological Competency\nCMPT 120L INTRO TO PROGRAMMING A-  4 Fall 2015\nMajor in Computer Science\nAcademic Year:   2015-2016\nGPA:   3.952\nA CONCENTRATION IS REQUIRED FOR THIS MAJOR \nSoftware Development Concentration\nStill Needed: See Concentration in Software Development section\nConcentration in Software Development\nAcademic Year:   2015-2016 Credits Required:   67\n    Credits Applied:   60\nUnmet conditions for this set of requirements: 67 to 69 credits are required. You currently have 60, you still need 7 more credits. \nCOURSE REQUIREMENTS FOR SOFTWARE DEVEL CONC\nIntroduction to Programming\nCMPT 120L INTRO TO PROGRAMMING A-  4 Fall 2015\nSoftware Development I\nCMPT 220L SOFTWARE DEVELOPMENT I A  4 Spring 2016\nSoftware Development II\nCMPT 221L SOFTWARE DEVELOPMENT II A  4 Fall 2016\nSoftware Systems and Analysis\nCMPT 230L SOFTWARE SYSTEMS+ANALYSIS A  4 Spring 2016\nData Communications and Networks\nCMPT 306N DATA COMMUNICATIONS A  4 Fall 2016\nDatabase Management\nCMPT 308N DATABASE MANAGEMENT A  4 Fall 2016\nInternetworking\nCMPT 307N INTERNETWORKING A  4 Spring 2017\nSystem Design\nCMPT 330L SYSTEM DESIGN A  4 Spring 2017\nComputer Organization and Architecture\nCMPT 422N COMPUTER ORG & ARCH A  4 Fall 2017\nAlgorithm Analysis and Design\nCMPT 435L ALGORITHM ANALYSIS+DESIGN A  3 Spring 2018\nCONCENTRATION ELECTIVES\nStill Needed: Choose from 2 of the following:\nSystem Elective Option\n( Choose from 1 of the following: ) and\nOperating Systems\n( 1 Class in CMPT 424L* ) or\nDesign of Compilers\n( 1 Class in CMPT 432L* )\nLanguage Elective Option\nTheory of Programming Languages\nCMPT 331L THEORY OF PROGRAM LANG IP  (3) Fall 2018\nThird Required Elective\n( Choose from 1 of the following: )\nLanguage Study\n( 1 Class in CMPT 333L* ) or\nAlternate Elective Options\n( 1 Class in CMPT 331L* or 424L* or 432L* or 440L* )\nProject I\nCMPT 475N CS PROJECT IP  (3) Fall 2018\nProject II\nCMPT 476N CS PROJECT II IP  (1) Fall 2018\nCOURSE REQUIREMENTS IN RELATED FIELDS\nIntroduction to Business & Management\nBUS 100N INTRO BUS & MGT A  3 Fall 2015\nIntroduction to Statistics\nMATH 130L INTRO-STATISTICS T  3 Fall 2015\nSatisfied by MATH130L - INTRO-STATISTICS - ADVANCED PLACEMENT EXAM:AP\nCalculus I\nMATH 241L CALCULUS I A-  4 Fall 2017\nDiscrete Mathematics\nMATH 205L DISCRETE MATHEMATICS A  4 Spring 2017\nMinor in Cybersecurity\nAcademic Year:   2016-2017 Credits Required:   23\nGPA:   3.896 Credits Applied:   23\nMinimum Minor Credit\nMinimum Minor GPA\nMinimum Credit At Marist\nMINOR REQUIREMENTS\nIntroduction to Programming\nCMPT 120L INTRO TO PROGRAMMING A-  4 Fall 2015\nData Communications and Networks\nCMPT 306N DATA COMMUNICATIONS A  4 Fall 2016\nInternetworking\nCMPT 307N INTERNETWORKING A  4 Spring 2017\nIntroduction to Cybersecurity\nCMPT 416N INTRO TO CYBERSECURITY A  4 Fall 2017\nHacking and Penetration Testing\nCMPT 417N HACKING + PENETRATION TESTING A  3 Spring 2018\nMobile Security\nCMPT 418N MOBILE SECURITY A-  4 Spring 2018\nMinor in Information Technology\nAcademic Year:   2016-2017 Credits Required:   24\nGPA:   3.950 Credits Applied:   24\nMinimum Minor Credit\nMinimum Minor GPA\nMinimum Credit At Marist\nCOURSE REQUIREMENTS\nIntroduction to Programming\nCMPT 120L INTRO TO PROGRAMMING A-  4 Fall 2015\nSoftware Development I\nCMPT 220L SOFTWARE DEVELOPMENT I A  4 Spring 2016\nSoftware Development II\nCMPT 221L SOFTWARE DEVELOPMENT II A  4 Fall 2016\nData Communications and Networks\nCMPT 306N DATA COMMUNICATIONS A  4 Fall 2016\nDiscrete Mathematics\nMATH 205L DISCRETE MATHEMATICS A  4 Spring 2017\nInternetworking\nCMPT 307N INTERNETWORKING A  4 Spring 2017\nMinor in Information Systems\nAcademic Year:   2016-2017 Credits Required:   23\nGPA:   3.948 Credits Applied:   23\nMinimum Minor Credit\nMinimum Minor GPA\nMinimum Credit At Marist\nCOURSE REQUIREMENTS\nIntroduction to Programming\nCMPT 120L INTRO TO PROGRAMMING A-  4 Fall 2015\nIntroduction to Business & Management\nBUS 100N INTRO BUS & MGT A  3 Fall 2015\nSoftware Systems and Analysis\nCMPT 230L SOFTWARE SYSTEMS+ANALYSIS A  4 Spring 2016\nData Communications\nCMPT 306N DATA COMMUNICATIONS A  4 Fall 2016\nSystems Design\nCMPT 330L SYSTEM DESIGN A  4 Spring 2017\nData Management\nCMPT 308N DATABASE MANAGEMENT A  4 Fall 2016\n\n  Electives\nCredits Applied: 8 Classes Applied: 6\nMDIA 210L INTERACTIVE MEDIA I IP  (3) Fall 2018\nMUS 250N MC SINGERS-MEN A  1 Fall 2015\nMUS 250N MC SINGERS-MEN A  1 Spring 2016\nMUS 250N MC SINGERS-MEN A  1 Fall 2016\nMUS 250N MC SINGERS-MEN A  1 Fall 2017\nMUS 250N MC SINGERS-MEN IP  (1) Fall 2018\n  In-progress\nCredits Applied: 14 Classes Applied: 6\nANTH 102L CULTURAL ANTHROPOLOGY IP  3 Fall 2018\nCMPT 331L THEORY OF PROGRAM LANG IP  3 Fall 2018\nCMPT 475N CS PROJECT IP  3 Fall 2018\nCMPT 476N CS PROJECT II IP  1 Fall 2018\nMDIA 210L INTERACTIVE MEDIA I IP  3 Fall 2018\nMUS 250N MC SINGERS-MEN IP  1 Fall 2018\n\n\nLegend\nComplete Complete except for classes in-progress (T) Transfer Class\nNot Complete Nearly complete - see advisor @ Any course number\n\n Disclaimer\nYou are encouraged to use this degree audit report as a guide when planning your progress toward completion of the above requirements. Your academic advisor or the Registrar's Office may be contacted for assistance in interpreting this report. This audit is not your academic transcript and it is not official notification of completion of degree or certificate requirements. Please contact the Registrar's Office regarding this degree audit report, your official degree/certificate completion status, or to obtain a copy of your academic transcript.";
    String[] lines = degreeWorksText.split("\\n");
    String[] wordsInLine;
    for (String line : lines) {
      wordsInLine = line.split("\\s+");
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

    initReport();

    advanceUntil("Student");
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
    student.majors = getMajorsMinors("Major", "Overall");
    // don't enumerate currLine, already done in getMajorsMinors()

    // GPA and Minor(s)
    student.GPA = Double.parseDouble(report.get(currLine)[2]);
    student.minors = getMajorsMinors("Minor", "Student");
    // don't enumerate currLine, already done in getMajorsMinors()

    // Degree Requirements %
    advanceUntil("Requirements");
    student.degreeProgress.requirementsPercent = Integer.valueOf(removeLastChar(report.get(currLine)[0]));

    // Degree Credits %
    advanceUntil("Credits");

    student.degreeProgress.creditsPercent = Integer.valueOf(removeLastChar(report.get(currLine)[0]));

    // Academic Year
    advanceUntil("Degree");
    student.academicYear = findNextProperty("Year:", 0);

    // Degree Credits Required
    student.degreeProgress.creditsRequired = Integer.valueOf(findNextProperty("Required:", 2));

    // Credits Applied
    advanceUntil("Academic");
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
    currLine++;
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

  private List<String> getMajorsMinors(String majorOrMinor, String targetWord) {
    List<String> majors = new LinkedList<>();
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
      sb.setLength(sb.length() - 1);
      majors.add(sb.toString());
      wordIndex = 0;
      currLine++;
    } while (!report.get(currLine)[0].equals(targetWord));

    return majors;
  }

  private List<Advisor> getAdvisors() {
    List<Advisor> advisors = new ArrayList<>();
    Advisor advisor = new Advisor();
    advisor.lastname = removeLastChar(report.get(currLine)[1]);
    advisor.firstname = report.get(currLine)[2];
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
      advisor.lastname = removeLastChar(report.get(currLine)[0]);
      advisor.firstname = report.get(currLine)[1];
      advisors.add(advisor);
    }
    return advisors;
  }

  private boolean isHonorsStudent() {
    return report.get(currLine)[0].equals("Honors");
  }

  private void getInProgress() {
    advanceUntil("In-progress", 1);
    student.inProgress.numCredits = Integer.parseInt(report.get(currLine)[2]);
    int numClasses = student.inProgress.numClasses = Integer.parseInt(report.get(currLine)[5]);
    int endIndex = currLine + numClasses;
    currLine++;
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

      // year
      course.semester = report.get(currLine)[wordIndex];

      student.inProgress.courses.add(course);
      currLine++;
    }
  }

  private static String removeLastChar(String string) {
    return string.substring(0, string.length() - 1);
  }
}
