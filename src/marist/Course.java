package marist;

public class Course {
  public String name;
  public String grade;
  public int credits;
  public Semester semester;
  public int year;
  
  public enum Semester {
    WINTER, SPRING, SUMMER, FALL
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(this.name)
            .append("\n\tGrade: ").append(this.grade)
            .append("\n\tCredits: ").append(this.credits)
            .append("\n\tSemester: ").append(this.semester);
    return sb.toString();
  }
  
}
