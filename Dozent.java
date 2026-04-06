import java.util.ArrayList;
import java.util.Date;

public class Dozent extends WissenschaftlMA {

  private ArrayList<Lehrveranstaltung> lvas = new ArrayList();
  private Date promotionsdatum;
  
  public Dozent(String tcno, String name, String email, String password, String fachrichtung) {
    super(tcno, name, email, password, fachrichtung);
  }

  public boolean addLVA(Lehrveranstaltung lva) {
    if (this.lvas.contains(lva) == false) {
      this.lvas.add(lva);
      return true;
    }
    return false;
  }

  public boolean deleteLVA(Lehrveranstaltung lva) {
    boolean b = this.lvas.remove(lva);
    return b;
  }
}