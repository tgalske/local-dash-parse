package marist;

public class Advisor {
  public String lastname;
  public String firstname;
  
  @Override
  public String toString() {
    return this.firstname + " " + this.lastname;
  }
}
