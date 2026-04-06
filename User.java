public abstract class User {
  // Objektattribute
  protected String tcno;
  protected String name;
  protected String email;
  protected String password;

  public User(String tcno, String name, String email, String password) {
    // this-reference: referenziert das aktuelle Objekt
    this.tcno = tcno;
    this.name = name;
    this.email = email;
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


  @Override
  public boolean equals(Object obj) {
    if (obj instanceof User) {
      User m = (User) obj; // type casting
      // zwei Mitarbeiter sollen als gleich gelten, wenn tcno die gleichen Werte haben
      if (this.tcno.equals(m.tcno)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    // String representation von einem Mitarbeiter-Objekt
    return tcno + "\n" + name + "\n" + email + "\n";
  }

  public boolean comparePassword(String password) {
    return this.password.equals(password);
  }

  public boolean compareTCNO(String tc) {
    return this.tcno.equals(tc);
  }

  
  
}