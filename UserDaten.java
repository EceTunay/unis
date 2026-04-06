public class UserDaten {
  private String tcno;
  private String name;
  private String email;
  private String password;

  public UserDaten(String tcno, String name, String email, String password) throws InvalidIdentificationFormatException {
    if (tcno.length() == 11) {
      this.tcno = tcno;
    } else {
      throw new InvalidIdentificationFormatException();
    }
    
    this.name = name;
    this.email = email;
    this.password = password; 
  }

  public UserDaten(String tcno, String password) throws InvalidIdentificationFormatException {
    if (tcno.length() == 11) {
      this.tcno = tcno;
    } else {
      throw new InvalidIdentificationFormatException();
    }
    this.password = password; 
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return email;
  }

  public String getTCNO() {
    return tcno;
  }

  public String getPassword() {
    return password;
  }

}