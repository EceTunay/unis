import java.util.Date;
import java.util.ArrayList;

public class Projekt {
  private String name;
  private Date beginn;
  private Date ende;

  // fuehre eine Liste von Mitarbeit-Objekten
  private ArrayList projekt_mitarbeiten = new ArrayList();
  private ArrayList wimis = new ArrayList();
  
  public Projekt(String name, Date beginn, Date ende) {
    this.name = name;
    this.beginn = beginn;
    this.ende = ende;
  }

  public void addWimi(WissenschaftlMA wimi) {
    wimis.add(wimi);
    projekt_mitarbeiten.add(new Mitarbeit(wimi, this, 0));
  }
 
  public void addStundenZuMitarbeit(WissenschaftlMA wimi, int stunden) {
    for (int i = 0; i < projekt_mitarbeiten.size(); i++) {
      Mitarbeit m = (Mitarbeit) projekt_mitarbeiten.get(i); // type casting
      if (m.getWimi().equals(wimi)) { // compiler kann diesen Vergleich nicht machen
        m.addStunden(stunden);
      }
    }
  }

  public void printWimis() {
    for (int i = 0; i < wimis.size(); i++) {  //for (WissenschaftlMA w : wimis) {
      WissenschaftlMA w = (WissenschaftlMA) wimis.get(i); // type casting
      System.out.println(w.getName());
    }
  }

  public String getName() {
    return this.name;
  }

  public void printMitarbeiten() {
    for (int i = 0; i < projekt_mitarbeiten.size(); i++) {
      Mitarbeit m = (Mitarbeit) projekt_mitarbeiten.get(i); // type casting
      System.out.println(m.getWimi().getName() + ": " + m.getStunden());
    }
  }
}