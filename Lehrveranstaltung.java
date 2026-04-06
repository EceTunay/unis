import java.util.ArrayList;
import java.util.Date;

public class Lehrveranstaltung {

  private String code;
  private String name;
  private ArrayList<WissenschaftlMA> vortragende = new ArrayList();
  private ArrayList studierende = new ArrayList();
  private ArrayList<Pruefungstermin> pruefungstermine = new ArrayList();

  public Lehrveranstaltung(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public Lehrveranstaltung(String code, String name, WissenschaftlMA wimi) {
    this.code = code;
    this.name = name;
    this.vortragende.add(wimi);
  }

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }
  
  public void addVortragende(WissenschaftlMA wimi) {
    this.vortragende.add(wimi);
  }

  public void removeVortragende(WissenschaftlMA wimi) {
    this.vortragende.remove(wimi);
  }

  public void listPruefungstermine() {
    for (Pruefungstermin pt:pruefungstermine) {
      System.out.println(pt);
    }
  }

  public void addPruefungstermin(Pruefungstermin pt) {
    pruefungstermine.add(pt);
  }
  
  

  public ArrayList<Pruefungstermin> searchPruefungstermine(String query) {
    ArrayList<Pruefungstermin> result = new ArrayList(); 
    for (Pruefungstermin pt:pruefungstermine) {
      System.out.println("" + pt.getDatum().getMonth());
      System.out.println("" + pt.getDatum().getDay());
      if (pt.getHoersaal().equals(query)) {
        result.add(pt);
      } else if (("" + (pt.getDatum().getYear()+1900)).equals(query)) {
        result.add(pt);
      } else if (("" + pt.getDatum().getMonth()).equals(query)) {
        result.add(pt);
      } else if (("" + pt.getDatum().getDay()).equals(query)) {
        result.add(pt);
      }
    }
    return result;
  }

  @Override
  public String toString() {
    String result = this.code + ": " + this.name + "\n";
    result += "Vortragende:" + "\n";
    for (WissenschaftlMA wimi: vortragende) {
      result += wimi.toString(); // = result += wimi;
    }
    return result;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o instanceof Lehrveranstaltung) {
      Lehrveranstaltung lva = (Lehrveranstaltung) o; // type casting
      if (this.code.equals(lva.code)) {
        return true;
      }
    }
    return false;
  }
}