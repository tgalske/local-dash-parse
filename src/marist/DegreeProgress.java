package marist;

public class DegreeProgress {
  public int requirementsPercent;
  public int creditsPercent;
  public int creditsRequired;
  public int creditsApplied;
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Requirements: ").append(this.requirementsPercent)
            .append("% - Credits: ").append(this.creditsPercent)
            .append("% - Credits Required: ").append(this.creditsRequired)
            .append(" - Credits Applied: ").append(this.creditsApplied);
    return sb.toString();
  }
  
}
