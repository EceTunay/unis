import java.util.ArrayList;

public class Student extends User {

  private String matrikelnummer;
  private String studiengang;
  private int semester;
  private ArrayList<Lehrveranstaltung> lvas = new ArrayList();

  public Student(String tcno, String name, String email, String password, String matrikelnummer, String studiengang) {
    super(tcno, name, email, password);
    this.matrikelnummer = matrikelnummer;
    this.studiengang = studiengang;
  }

  public boolean addLVA(Lehrveranstaltung lva) {
    if (this.lvas.contains(lva) == false) {
      this.lvas.add(lva);
      return true;
    }
    return false;
  }

}