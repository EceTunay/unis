import java.util.ArrayList;

public abstract class WissenschaftlMA extends Mitarbeiter { 
  // ist-ein Beziehung zur Klasse Mitarbeiter
  // erbt somit alle Attribute und Methoden der Super-Klasse

  // zusaetzlich
  private String fachrichtung;
  // fuehre eine Liste von Mitarbeit-Objekten
  private ArrayList projekt_mitarbeiten = new ArrayList();
  private ArrayList projekte = new ArrayList();
  
  public WissenschaftlMA(String tcno, String name, String email, String password, String fachrichtung) {
    // erste Anweisung muss sein
    super(tcno, name, email, password);
    this.fachrichtung = fachrichtung;
  }

  public void addProjekt(Projekt projekt) {
    projekte.add(projekt);
    projekt_mitarbeiten.add(new Mitarbeit(this, projekt, 0));
  }

  public void addStundenZuMitarbeit(Projekt p, int stunden) {
    // ToDo: finde Mitarbeit-Objekt fuer Projekt in der Liste projekt_mitarbeiten
    for (int i = 0; i < projekt_mitarbeiten.size(); i++) {
      Mitarbeit m = (Mitarbeit) projekt_mitarbeiten.get(i); // type casting
      // ist m.projekt gleich p

      if (m.getProjekt().equals(p)) {
        // Operator == kann nicht auf Objekten angewandt werden 
        // == ist nur fuer primitive Datentypen definiert

        // zum Vergleich von Objekten kann/muss die equals-Methode verwendet werden
        m.addStunden(stunden);
      }
    }
  }

  public void printProjekte() {
      for (int i = 0; i < projekte.size(); i++) { // for (Projekt p : projekte) {
        Projekt p = (Projekt) projekte.get(i); // type casting
        System.out.println(p.getName());
      }
  }

  public void printMitarbeiten() {
    for (int i = 0; i < projekt_mitarbeiten.size(); i++) {
      Mitarbeit m = (Mitarbeit) projekt_mitarbeiten.get(i); // type casting
      System.out.println(m.getProjekt().getName() + ": " + m.getStunden());
    }
  }


  @Override
  public String toString() {
    return tcno + "\n" + name + "\n" + email + "\n" + fachrichtung + "\n";
  }

  // implementiert die abstrakte Methode der Mitarbeiter-Klasse
  public String toPrettyString() {
    String s = "TCNummer: " + tcno + "\n" +
      "Name: " + name + "\n" + 
      "Email: " + email + "\n" +
      "Fachrichtung: " + fachrichtung + "\n";
    return s;
  }
  
}