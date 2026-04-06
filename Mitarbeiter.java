public abstract class Mitarbeiter extends User {

  public Mitarbeiter(String tcno, String name, String email, String password) {
    super(tcno, name, email, password);
  }
    

  protected int kademe;

  public abstract String toPrettyString();
  
}