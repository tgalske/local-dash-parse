package marist;

import java.util.List;

public class Student {

  public String lastName;
  public String firstName;
  public boolean isUndergraduate;
  public int CWID;
  public String grade;
  public String school;
  public Advisor advisor;
  public List<String> majors;
  public double GPA;
  public List<String> minors;
  public DegreeProgress degreeProgress;
  public String catalogYear;
  public String academicYear;
  public Requirements requirements;
  
  public Student() {
    this.advisor = new Advisor();
    this.degreeProgress = new DegreeProgress();
    this.requirements = new Requirements();
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ")
            .append(this.firstName).append(" ")
            .append(this.lastName)
            .append("\n")
            .append("CWID: ")
            .append(this.CWID)
            .append("\n")
            .append("Grade: ")
            .append(this.grade)
            .append("\n")
            .append("School: ")
            .append(this.school)
            .append("\n")
            .append("Advisor: ")
            .append(this.advisor)
            .append("\n")
            .append("Majors: ")
            .append(this.majors)
            .append("\n")
            .append("GPA: ")
            .append(this.GPA)
            .append("\n")
            .append("Minors: ")
            .append(this.minors)
            .append("\n")
            .append("Degree Progress: ")
            .append(this.degreeProgress)
            .append("\n")
            .append("Academic Year: ")
            .append(this.academicYear)
            .append("\n")
            .append("Last 30 Credits At Marist: ")
            .append("\n")
            .append("Requirements: ")
            .append(this.requirements);
    return sb.toString();
  }
}
