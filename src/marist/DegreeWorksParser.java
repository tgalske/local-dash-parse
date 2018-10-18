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
    String degreeWorksText = "DWPROD\n" +
"Student View    AB218UVc as of 05-Sep-2018 at 09:44\n" +
"Student Byrne, Declan M Level Undergraduate\n" +
"ID 20066773 Degree B.S.  \n" +
"Classification Junior   College Computer Science & Mathematics\n" +
"Advisor DeCusatis, Casimer M  Major Computer Science\n" +
"Overall GPA 3.217 Minor\n" +
"Student Type Traditional Continuing Concentration CompSci: Software Development\n" +
"Term Location Poughkeepsie\n" +
"\n" +
"Degree Progress\n" +
"Requirements\n" +
"97%\n" +
" \n" +
"Credits\n" +
"82%\n" +
" \n" +
"\n" +
"Degree in Bachelor of Science\n" +
"Academic Year:   2015-2016 Credits Required:   120\n" +
"GPA:   3.217 Credits Applied:   98\n" +
"Last 30 Credits At Marist\n" +
"Mimimum Liberal Art Credits\n" +
"Minimum Degree Credits\n" +
"Still Needed: 120 CREDITS ARE REQUIRED. YOU CURRENTLY HAVE 98, (INCLUDING BOTH EARNED AND IN PROGRESS COURSES) YOU STILL NEED 22 ADDITIONAL CREDITS. COURSES THAT APPEAR TWICE ON THE AUDIT ARE ONLY COUNTED ONCE TOWARD THIS REQUIREMENT.\n" +
"Minimum GPA\n" +
"2.0 GPA Requirement\n" +
"Foundation\n" +
"Distribution: Breadth\n" +
"Distribution: Pathway\n" +
"Skill Requirement\n" +
"Major Requirements\n" +
"Still Needed: See Major in Computer Science section\n" +
"Foundation\n" +
"        ACADEMIC FOUNDATION REQUIREMENTS\n" +
"First-Year Seminar\n" +
"FYSH 101L FIRST YEAR SEMINAR HONORS B  4 Spring 2016\n" +
"Writing for College\n" +
"ENGH 120L WRITING FOR COLLEGE-HONORS B  3 Fall 2015\n" +
"Distribution: Breadth\n" +
"        Minimum Distribution Credit\n" +
"BREADTH REQUIREMENTS\n" +
"3 credits in Philosophical Perspectives\n" +
"PHIL 101L PHILOSOPHICAL PERSPECTIVES A-  3 Fall 2015\n" +
"3 credits in Fine Arts\n" +
"MUS 343L MUSIC IN AMERICA IP  (3) Fall 2018\n" +
"3 credits in History\n" +
"HIST 248L MEDIEVAL EUROPE C+  3 Spring 2018\n" +
"3 credits in Literature\n" +
"ENG 205L MOD SPEC FICTION B-  3 Fall 2017\n" +
"3 credits in Math\n" +
"MATH 205L DISCRETE MATHEMATICS A  4 Spring 2016\n" +
"3 credits in Natural Science\n" +
"BIOL 101L TOPICS IN BIOLOGY B  3 Spring 2018\n" +
"3 credits Ethics/Applied Ethics/Religious Studies\n" +
"HONR 360L SEM-IND:ETHICS+DECISIONS A-  3 Spring 2017\n" +
"3 credits in Social Science\n" +
"HONR 395L CSL-INDIVIDUAL & SOCIETY C-  3 Fall 2017\n" +
"DISTRIBUTION OVERFLOW\n" +
"EVERY STUDENT MUST HAVE A TOTAL OF 36 CORE DISTRIBUTION CREDITS. PATHWAY COURSES MAY BE LISTED IN EITHER THE BREADTH OR OVERFLOW AREAS. PLEASE NOTE, HOWEVER, THAT EVERY COURSE CAN ONLY COUNT ONCE TOWARD THE 36-CREDIT DISTRIBUTION TOTAL. \n" +
"Distribution Overflow\n" +
"MUS 120L THEORY OF MUSIC I A  3 Fall 2015\n" +
"Distribution Overflow\n" +
"CHEM 101L INTRO CHEMISTRY A-  3 Spring 2017\n" +
"Distribution Overflow\n" +
"MATH 130L INTRO-STATIST I B  3 Fall 2015\n" +
"Distribution Overflow\n" +
"MATH 241L CALCULUS I B  4 Fall 2016\n" +
"Pathway: Quantitative Studies\n" +
"        QUANTITATIVE STUDIES PATHWAY COURSES\n" +
"PATHWAYS REQUIRE A MIN OF 3 DIFFERENT AUTHORIZED AREAS FOR THIS PATHWAY - 1: [MUS 106L, 120L, 220L] AND 2: [MATH 130L, 205L, 210L, 241L, 242L] AND 3: [CHEM 101L, 132L, ENSC 305L, PHYS 108L, 201L,  202L, 211L, 212L, 221L] AND 4: [PHIL 203L, 235L, 310L] AND 5: [ECON 104L, 150L, 305L, POSC 121L, 122L, 124L,  235L, 289L, 325L, 342L, PSYC 350L, SOCW 383N] AND 6: [COM 200L, CMPT 120L, CRJU 374L, ENG 222L, FASH 304N] \n" +
"Quantitative Studies Options\n" +
"MUS 120L THEORY OF MUSIC I A  3 Fall 2015\n" +
"CHEM 101L INTRO CHEMISTRY A-  3 Spring 2017\n" +
"CMPT 120L INTRO TO PROGRAMMING A  4 Fall 2015\n" +
"HONR 395L CSL-INDIVIDUAL & SOCIETY C-  3 Fall 2017\n" +
"Skill Requirement\n" +
"        SKILL REQUIREMENT\n" +
"Technological Competency\n" +
"CMPT 120L INTRO TO PROGRAMMING A  4 Fall 2015\n" +
"Major in Computer Science\n" +
"Academic Year:   2015-2016\n" +
"GPA:   3.276\n" +
"A CONCENTRATION IS REQUIRED FOR THIS MAJOR \n" +
"Software Development Concentration\n" +
"Still Needed: See Concentration in Software Development section\n" +
"Concentration in Software Development\n" +
"Academic Year:   2015-2016 Credits Required:   67\n" +
"    Credits Applied:   58\n" +
"Unmet conditions for this set of requirements: 67 to 69 credits are required. You currently have 58, you still need 9 more credits. \n" +
"COURSE REQUIREMENTS FOR SOFTWARE DEVEL CONC\n" +
"Introduction to Programming\n" +
"CMPT 120L INTRO TO PROGRAMMING A  4 Fall 2015\n" +
"Software Development I\n" +
"CMPT 220L SOFTWARE DEVELOPMENT I A-  4 Spring 2016\n" +
"Software Development II\n" +
"CMPT 221L SOFTWARE DEVELOPMENT II A-  4 Fall 2016\n" +
"Software Systems and Analysis\n" +
"CMPT 230L SOFTWARE SYSTEMS+ANALYSIS A  4 Fall 2016\n" +
"Data Communications and Networks\n" +
"CMPT 306N DATA COMMUNICATIONS B+  4 Fall 2017\n" +
"Database Management\n" +
"CMPT 308N DATABASE MANAGEMENT C+  4 Fall 2017\n" +
"Internetworking\n" +
"CMPT 307N INTERNETWORKING C  4 Spring 2018\n" +
"System Design\n" +
"CMPT 330L SYSTEM DESIGN A-  4 Spring 2018\n" +
"Computer Organization and Architecture\n" +
"CMPT 422N COMPUTER ORG & ARCH IP  (4) Fall 2018\n" +
"Algorithm Analysis and Design\n" +
"Still Needed: 1 Class in CMPT 435L*\n" +
"CONCENTRATION ELECTIVES\n" +
"Still Needed: Choose from 2 of the following:\n" +
"System Elective Option\n" +
"Operating Systems\n" +
"CMPT 424N OPERATING SYSTEMS IP  (4) Fall 2018\n" +
"Language Elective Option\n" +
"( Choose from 1 of the following: ) and\n" +
"Theory of Programming Languages\n" +
"( 1 Class in CMPT 331L* ) or\n" +
"Formal Languages and Computability\n" +
"( 1 Class in CMPT 440L* )\n" +
"Third Required Elective\n" +
"( Choose from 1 of the following: )\n" +
"Language Study\n" +
"( 1 Class in CMPT 333L* ) or\n" +
"Alternate Elective Options\n" +
"( 1 Class in CMPT 331L* or 424L* or 432L* or 440L* )\n" +
"Project I\n" +
"CMPT 475N CS PROJECT IP  (3) Fall 2018\n" +
"Project II\n" +
"CMPT 476N CS PROJECT II IP  (1) Fall 2018\n" +
"COURSE REQUIREMENTS IN RELATED FIELDS\n" +
"Introduction to Business & Management\n" +
"BUS 100N INTRO BUS & MGT C+  3 Spring 2016\n" +
"Introduction to Statistics\n" +
"MATH 130L INTRO-STATIST I B  3 Fall 2015\n" +
"Calculus I\n" +
"MATH 241L CALCULUS I B  4 Fall 2016\n" +
"Discrete Mathematics\n" +
"MATH 205L DISCRETE MATHEMATICS A  4 Spring 2016\n" +
"\n" +
"  Electives\n" +
"Credits Applied: 6 Classes Applied: 6\n" +
"CMPT 105N MS EXCEL C-  1 Spring 2017\n" +
"MUS 107N BG PIANO I A  1 Spring 2017\n" +
"MUS 250N MC SINGERS-MEN A  1 Fall 2015\n" +
"MUS 250N MC SINGERS-MEN A  1 Spring 2016\n" +
"MUS 250N MC SINGERS-MEN A  1 Fall 2017\n" +
"MUS 320N IND INST STDY: PRIVATE VOICE IP  (1) Fall 2018\n" +
"  Insufficient\n" +
"Credits Applied: 0 Classes Applied: 3\n" +
"CMPT 307N INTERNETWORKING F  0 Spring 2017\n" +
"CMPT 308N DATABASE MANAGEMENT F  0 Fall 2016\n" +
"CMPT 330L SYSTEM DESIGN F  0 Spring 2017\n" +
"  In-progress\n" +
"Credits Applied: 16 Classes Applied: 6\n" +
"CMPT 422N COMPUTER ORG & ARCH IP  4 Fall 2018\n" +
"CMPT 424N OPERATING SYSTEMS IP  4 Fall 2018\n" +
"CMPT 475N CS PROJECT IP  3 Fall 2018\n" +
"CMPT 476N CS PROJECT II IP  1 Fall 2018\n" +
"MUS 320N IND INST STDY: PRIVATE VOICE IP  1 Fall 2018\n" +
"MUS 343L MUSIC IN AMERICA IP  3 Fall 2018\n" +
"\n" +
"\n" +
"Legend\n" +
"Complete Complete except for classes in-progress (T) Transfer Class\n" +
"Not Complete Nearly complete - see advisor @ Any course number\n" +
"\n" +
" Disclaimer\n" +
"You are encouraged to use this degree audit report as a guide when planning your progress toward completion of the above requirements. Your academic advisor or the Registrar's Office may be contacted for assistance in interpreting this report. This audit is not your academic transcript and it is not official notification of completion of degree or certificate requirements. Please contact the Registrar's Office regarding this degree audit report, your official degree/certificate completion status, or to obtain a copy of your academic transcript.";
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
      
      // check if there is no minor
      if (sb.length() == 0) {
        return majors;
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
