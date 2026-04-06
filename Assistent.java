import java.util.ArrayList;

public class Assistent extends WissenschaftlMA {

  private ArrayList<Lehrveranstaltung> lvas = new ArrayList();

  public Assistent(String tcno, String name, String email, String password, String fachrichtung) {
    super(tcno, name, email, password, fachrichtung);
  }
}