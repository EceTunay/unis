import java.util.Date;

public class Pruefungstermin {

  private Date datum;
  private int dauer;
  private String hoersaal;
  // ToDo: attribut fuer Noten

  public Pruefungstermin(Date datum, int dauer, String hoersaal) {
    this.datum = datum;
    this.dauer = dauer;
    this.hoersaal = hoersaal;
  }

  public String getHoersaal() {
    return this.hoersaal;
  }

  public Date getDatum() {
    return this.datum;
  }
  
  @Override
  public String toString() {
    return this.datum + "," + dauer + "," + hoersaal;  
  }
  
  @Override
    public boolean equals(Object o) {
      if (o instanceof Pruefungstermin) {
        Pruefungstermin pt = (Pruefungstermin) o; // type casting
        // ToDo: date equalsi istedigimiz gibi mi calisiyor kontrol edelim
        if (this.datum.equals(pt.datum)) {
          return true;
        }
      }
      return false;
    }
}