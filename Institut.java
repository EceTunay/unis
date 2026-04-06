import java.util.ArrayList;

public class Institut {
  private String bezeichnung;
  private String email;
  private ArrayList wimis = new ArrayList();
  
  public Institut(String bezeichnung, String email) {
    this.bezeichnung = bezeichnung;
    this.email = email;
  }

  public void addWimi(WissenschaftlMA wimi) {
    this.wimis.add(wimi);
  }
}

// steht in einer starken Aggregationsbeziehung zur Klasse Fakultaet
// Institut Objekte sind Teil-von Fakultaet