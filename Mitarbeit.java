public class Mitarbeit {

  private WissenschaftlMA wimi;
  private Projekt projekt;
  private int stunden;

  
  public Mitarbeit(WissenschaftlMA wimi, Projekt projekt) {
    this.wimi = wimi;
    this.projekt = projekt;
    this.stunden = 0;
  }

  public Mitarbeit(WissenschaftlMA wimi, Projekt projekt, int stunden) {
    this.wimi = wimi;
    this.projekt = projekt;
    this.stunden = stunden;
  }

  public void addStunden(int stunden) {
    this.stunden = this.stunden + stunden;  
  }
  
  public WissenschaftlMA getWimi() {
    return wimi;
  }
  
  public Projekt getProjekt() {
    return projekt;
  }

  public int getStunden() {
    return stunden;
  }
}