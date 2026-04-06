import java.util.ArrayList;

public class Fakultaet {

  private String bezeichnung;
  private Mitarbeiter dekan;
  private ArrayList institute = new ArrayList();

  public Fakultaet(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public void setDekan(Mitarbeiter m) {
    this.dekan = m;
  }

  public void addInstitut(Institut i) {
    this.institute.add(i);
  }
}

// steht in einer starken Aggregationsbeziehung zur Klasse Fakultaet
// Institut Objekte sind Teil-von Fakultaet
// starke Aggregation heisst, dass die Institut-Objekte von dem Fakultaet
// Objekt abhaengen