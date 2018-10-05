package marist;

public class Requirements {
  public Status isLast30Credits;
  public Status hasMinLibArts;
  public Status hasMinCredits;
  public Status hasMinGPA;
  public Status has20GPA;
  public Status hasFoundation;
  public Status hasBreadth;
  public Status hasPathway;
  public Status hasSkill;
  public Status hasMajor;
  
  public enum Status {
    COMPLETE, INCOMPLETE, IN_PROGRESS
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n\tLast 30 Credits: ").append(this.isLast30Credits)
            .append("\n\tLib Arts: ").append(this.hasMinLibArts)
            .append("\n\tMininum Credits: ").append(this.hasMinCredits)
            .append("\n\tMinimum GPA: ").append(this.hasMinGPA)
            .append("\n\tFoundation: ").append(this.hasFoundation)
            .append("\n\tBreadth: ").append(this.hasFoundation)
            .append("\n\tPathway: ").append(this.hasPathway)
            .append("\n\tSkill: ").append(this.hasSkill)
            .append("\n\tMajor: ").append(this.hasMajor);
    return sb.toString();
  }
  
}
