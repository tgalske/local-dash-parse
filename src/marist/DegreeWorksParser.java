package marist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import marist.Requirements.Status;

public class DegreeWorksParser {

    List<String[]> textLines = new ArrayList<>();
    public int index = 0;
    public Student student = new Student();

    public DegreeWorksParser() throws FileNotFoundException {
        extractStudentInfo();
    }

    private void extractStudentInfo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file.txt"));
        String currentLine;
        String[] wordsInLine;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            wordsInLine = currentLine.split("\\s+");
            // ignore arrays of size 0 to prevent ArrayIndexOutOfBoundsException           
            if (wordsInLine.length > 0) {
                if (wordsInLine.length == 1 && wordsInLine[0].length() == 0) {
                    // ignore lines with nothing in them
                } else {
                    textLines.add(wordsInLine);
                }
            }
        }

        advanceUntil("Student", 0);
        // Student name and [Undergraduate | Graduate]
        student.lastName = removeLastChar(textLines.get(index)[1]);
        student.firstName = textLines.get(index)[2];
        student.isUndergraduate = (findNextProperty("Level", 3).equals("Undergraduate"));
        index++;

        // CWID
        student.CWID = Integer.parseInt(textLines.get(index)[1]);
        index++;

        // Grade (ex: Senior) and School (ex: Computer Science & Mathematics)
        student.grade = textLines.get(index)[1];
        student.school = getSchool(2);
        index++;

        // Advisor and Major(s)
        student.advisor.lastname = removeLastChar(textLines.get(index)[1]);
        student.advisor.firstname = textLines.get(index)[2];
        student.majors = getMajorsMinors("Major", "Overall", 3);
        // don't enumerate index, already done in getMajorsMinors()

        // GPA and Minor(s)
        student.GPA = Double.parseDouble(textLines.get(index)[2]);
        student.minors = getMajorsMinors("Minor", "Student", 2);
        // don't enumerate index, already done in getMajorsMinors()

        // Degree Requirements %
        advanceUntil("Requirements", 0);
        String requirementsPercent = removeLastChar(textLines.get(index)[0]);
        student.degreeProgress.requirementsPercent = Integer.valueOf(requirementsPercent);

        // Degree Credits %
        advanceUntil("Credits", 0);

        String creditsPercent = removeLastChar(textLines.get(index)[0]);
        student.degreeProgress.creditsPercent = Integer.valueOf(creditsPercent);

        // Academic Year
        advanceUntil("Not", 0);
        student.academicYear = findNextProperty("Year:", 0);

        // Degree Credits Required
        student.degreeProgress.creditsRequired = Integer.valueOf(findNextProperty("Required:", 2));

        // Credits Applied
        advanceUntil("Academic", 0);
        student.degreeProgress.creditsApplied = Integer.valueOf(findNextProperty("Applied:", 0));

        // Requirements
        index++;
        student.requirements.isLast30Credits = checkStatus();
        student.requirements.hasMinLibArts = checkStatus();
        student.requirements.hasMinCredits = checkStatus();
        student.requirements.hasMinGPA = checkStatus();
        student.requirements.has20GPA = checkStatus();
        student.requirements.hasFoundation = checkStatus();
        student.requirements.hasBreadth = checkStatus();
        student.requirements.hasPathway = checkStatus();
        student.requirements.hasSkill = checkStatus();
        student.requirements.hasMajor = checkStatus();

        getInProgress();

        Gson g = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = g.toJson(student);
        System.out.println(jsonString);
    }

    private void advanceUntil(String targetWord, int targetIndex) {
        while (!textLines.get(index)[targetIndex].equals(targetWord)) {
            index++;
        }
        index++;
    }

    private Status checkStatus() {
        if (textLines.get(index)[0].equals("Complete")) {
            if (textLines.get(index)[1].equals("except")) {
                index++;
                return Status.IN_PROGRESS;
            } else {
                index++;
                return Status.COMPLETE;
            }
        } else {
            index += 2;
            return Status.INCOMPLETE;
        }
    }

    private String findNextProperty(String targetWord, int startingIndex) {
        int wordIndex = startingIndex;
        while (!textLines.get(index)[wordIndex].equals(targetWord)) {
            wordIndex++;
        }
        return textLines.get(index)[++wordIndex];
    }

    private String getSchool(int wordIndex) {
        while (!textLines.get(index)[wordIndex].equals("College")) {
            wordIndex++;
        }
        wordIndex++;
        int lineLength = textLines.get(index).length;
        StringBuilder schoolName = new StringBuilder();

        while (wordIndex < lineLength) {
            schoolName.append(textLines.get(index)[wordIndex]).append(" ");
            wordIndex++;
        }
        schoolName.setLength(schoolName.length() - 1);
        return schoolName.toString();
    }

    private List<String> getMajorsMinors(String majorOrMinor, String targetWord, int wordIndex) {
        List<String> majors = new LinkedList<>();
        while (!textLines.get(index)[wordIndex].contains(majorOrMinor)) {
            wordIndex++;
        }
        wordIndex++;

        do {
            int lineLength = textLines.get(index).length;
            StringBuilder sb = new StringBuilder();
            while (wordIndex < lineLength) {
                sb.append(textLines.get(index)[wordIndex]).append(" ");
                wordIndex++;
            }
            sb.setLength(sb.length() - 1);
            majors.add(sb.toString());
            wordIndex = 0;
            index++;
        } while (!textLines.get(index)[0].equals(targetWord));

        return majors;
    }

    private void getInProgress() {
        advanceUntil("In-progress", 1);
        student.inProgress.numCredits = Integer.parseInt(textLines.get(index)[2]);
        int numClasses = student.inProgress.numClasses = Integer.parseInt(textLines.get(index)[5]);
        int endIndex = index + numClasses;
        index++;
        while (index < endIndex) {
            Course course = new Course();
            course.dept = textLines.get(index)[0];
            course.number = textLines.get(index)[1];
            int wordIdx = 2;
            StringBuilder courseNameBuilder = new StringBuilder();
            while (!textLines.get(index)[wordIdx].equals("IP")) {
                courseNameBuilder.append(textLines.get(index)[wordIdx])
                        .append(" ");
                wordIdx++;
            }
            courseNameBuilder.setLength(courseNameBuilder.length() - 1);
            course.name = courseNameBuilder.toString();

            // skip "IP"
            wordIdx++;

            // credits
            course.credits = Integer.parseInt(textLines.get(index)[wordIdx]);
            wordIdx++;

            // semester
            course.semester = textLines.get(index)[wordIdx];

            student.inProgress.courses.add(course);
            index++;
        }
    }

    private static String removeLastChar(String string) {
        return string.substring(0, string.length() - 1);
    }
}
