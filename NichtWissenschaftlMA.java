public class NichtWissenschaftlMA extends Mitarbeiter {
  
  public NichtWissenschaftlMA(String tcno, String name, String email, String password) {
    // erste Anweisung muss Aufruf super sein
    super(tcno, name, email, password);
  }

  // implementiert die abstrakte Methode der Mitarbeiter-Klasse
  public String toPrettyString() {
    String s = "TCNummer: " + tcno + "\n" +
      "Name: " + name + "\n" + 
      "Email: " + email + "\n";
    return s;
  }
}