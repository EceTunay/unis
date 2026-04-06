import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    private static ArrayList<NichtWissenschaftlMA> verwaltungspersonal = new ArrayList();
    private static ArrayList<Assistent> assistenten = new ArrayList();
    private static ArrayList<Dozent> dozenten = new ArrayList();
    private static ArrayList<Student> studenten = new ArrayList();
    private static ArrayList<Lehrveranstaltung> lvas = new ArrayList();
    
    private static ArrayList<String> benutzer_tcnos = new ArrayList();
    
    public static void main(String[] args) {
        int choice;
        int i;

        loadVerwaltungspersonal("verwaltungspersonal.csv");
        
        assistenten.add(new Assistent("12345678913", "Helga Morgenroth", "hm@gmail.com", "helga123", "Informatik"));
        benutzer_tcnos.add("12345678913");

        Lehrveranstaltung lva1 = new Lehrveranstaltung("INF101", "Einfuehrung in die Informatik");
        lva1.addPruefungstermin(new Pruefungstermin(new Date(), 90, "HS01"));
        lva1.addPruefungstermin(new Pruefungstermin(new Date(126,3,12,13,0,0), 90, "HS02"));
        lvas.add(lva1);
        lvas.add(new Lehrveranstaltung("INF102", "OOP"));

        UserDaten ud;
        do {
            System.out.println("\n===== University Management System =====");
            System.out.println("1. Login fuer Verwaltungspersonal");
            System.out.println("2. Login fuer Assistenten");
            System.out.println("3. Login fuer Dozenten");
            System.out.println("4. Login fuer Studenten");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
                
            switch (choice) {
                case 1:
                    ud = readUserLoginData();
                    if (loginUser(verwaltungspersonal, ud)) {
                        printVerwaltungsPersonal();
                    } else {
                        System.out.println("Login-Daten falsch");
                    }
                    break;
                case 2:
                    ud = readUserLoginData();
                    if (loginUser(assistenten, ud)) {
                        // printVerwaltungsPersonal();
                    } else {
                        System.out.println("Login-Daten falsch");
                    }
                    break;
                case 3:
                    ud = readUserLoginData();
                    if (loginUser(dozenten, ud)) {
                        // printVerwaltungsPersonal();
                    } else {
                        System.out.println("Login-Daten falsch");
                    }
                    break;
                case 4:
                    ud = readUserLoginData();
                    if (loginUser(studenten, ud)) {
                        // printVerwaltungsPersonal();
                    } else {
                        System.out.println("Login-Daten falsch");
                    }
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    } 

    public static void printVerwaltungsPersonal() {
        int choice;
        String fachrichtung, query;
        UserDaten m;
        do {
            System.out.println("1. Verwaltungspersonal Hinzufuegen");
            System.out.println("2. Assisten Hinzufuegen");
            System.out.println("3. Dozent Hinzufuegen");
            System.out.println("4. Student Hinzufuegen");
            System.out.println("5. Lehrveranstaltung Hinzufuegen");
            System.out.println("6. Pruefungstermin Hinzufuegen");
            System.out.println("7. Verwaltungspersonal Suchen");
            System.out.println("8. Assistent Suchen");
            System.out.println("9. Dozent Suchen");
            System.out.println("10. Student Suchen");
            System.out.println("11. Lehrveranstaltung Suchen");
            System.out.println("12. Pruefungstermin Suchen");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    m = readUserSignupData();
                    NichtWissenschaftlMA nw = new NichtWissenschaftlMA(m.getTCNO(), m.getName(), m.getEmail(), m.getPassword());
                    addUser(nw,verwaltungspersonal);
                    writeIntoVerwaltungspersonal(nw, "verwaltungspersonal.csv");
                    break;
                case 2:
                    m = readUserSignupData();
                    System.out.println("Geben sie eine Fachrichtung ein");
                    fachrichtung = scanner.nextLine();
                    Assistent wimi = new Assistent(m.getTCNO(), m.getName(), m.getEmail(), m.getPassword(), fachrichtung);
                    addUser(wimi,assistenten);
                    break;
                case 3:
                    m = readUserSignupData();
                    System.out.println("Geben sie eine Fachrichtung ein");
                    fachrichtung = scanner.nextLine();
                    Dozent d = new Dozent(m.getTCNO(), m.getName(), m.getEmail(), m.getPassword(), fachrichtung);
                    addUser(d,dozenten);
                    break;
                case 4:
                    m = readUserSignupData();
                    System.out.println("Geben sie eine Matrikelnummer ein");
                    String mtr = scanner.nextLine();
                    System.out.println("Geben sie einen Studiengang ein");
                    String stg = scanner.nextLine();
                    Student s = new Student(m.getTCNO(), m.getName(), m.getEmail(), m.getPassword(), mtr, stg);
                    addUser(s,studenten);
                    break;
                case 5:
    
                    break;
                case 6:

                    break;
                case 7:
                    query = scanner.nextLine();
                    searchUser(verwaltungspersonal, query);
                    break;
                case 8:
                    query = scanner.nextLine();
                    searchUser(assistenten, query);
                    break;    
                case 11:
                    System.out.println("Geben Sie den Code oder Namen der LVA ein:");
                    query = scanner.nextLine();
                    ArrayList<Lehrveranstaltung> result = searchLVA(query);
                    if (result.size() == 0) {
                        System.out.println("Keine LVA gefunden fuer: " + query);
                    } else {
                        for (Lehrveranstaltung lva:result) {
                            System.out.println(lva);
                        }
                    }
                    break;
                case 12:
                    System.out.println("Geben Sie den Code der LVA ein:");
                    query = scanner.nextLine();
                    Lehrveranstaltung result2 = searchLVAExact(query);
                    if (result2 == null) {
                        System.out.println("Keine LVA gefunden fuer: " + query);
                    } else {
                        System.out.println("Geben Sie Datum oder Hoersaal ein:");
                        query = scanner.nextLine();
                        ArrayList<Pruefungstermin> ptlist = result2.searchPruefungstermine(query);
                        for (Pruefungstermin pt:ptlist) {
                            System.out.println(pt);
                        }
                    }
                    break;
                case 13:
                    System.out.println("Exiting menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 13);
    }

    private static UserDaten readUserSignupData() {
        UserDaten m = null;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Geben sie eine TC Nummer ein");
            String tc = scanner.nextLine();
            System.out.println("Geben sie einen Namen ein");
            String name = scanner.nextLine();
            System.out.println("Geben sie eine Email-Adresse ein");
            String email = scanner.nextLine();
            System.out.println("Geben sie ein Passwort ein");
            String pw = scanner.nextLine();

            // Als Beispiel, Alter wird eigentlich nicht weiter verwendet
            System.out.println("Geben sie ein Alter ein");
            int alter = scanner.nextInt(); // potentieller InputMismatchException
            System.out.println("Alter:" + alter);

            m = new UserDaten(tc, name, email, pw);
        } catch (InputMismatchException ime) {
            System.out.println("Alter muss eine ganze Zahl sein");
        } catch (InvalidIdentificationFormatException iife) {
            System.out.println(iife.getMessage());
        } catch (Exception e) {
            System.out.println("Ein Systemfehler ist aufgetreten. Versuchen Sie spaeter erneut");
        } 
        
        return m;
    }

    public static UserDaten readUserLoginData() throws InvalidIdentificationFormatException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Geben sie ihre TC Nummer ein");
        String tc = scanner.nextLine();
        System.out.println("Geben sie ihr Passwort ein");
        String pw = scanner.nextLine();

        return new UserDaten(tc, pw);
    }

    private static void addUser(User m, ArrayList l) {
        if (benutzer_tcnos.contains(m.getTCNO())) {
            System.out.println("Benutzer mit dieser TC-Nummer existiert bereits");
        } else {
            l.add(m);
            benutzer_tcnos.add(m.getTCNO());
        }
    }

    
    
    // SOLID principles - S: Single Responsibility
    private static boolean loginUser(ArrayList<? extends User> liste, UserDaten userdaten) {
        User u;
        for (int i=0; i < liste.size(); i++) {
            u = liste.get(i);
            if (u.comparePassword(userdaten.getPassword()) && u.compareTCNO(userdaten.getTCNO())) {
                return true;
            } 
        }
        return false;
    }

    public static void searchUser(ArrayList<? extends User> list, String query) {
        boolean found = false;
        for (User u : list)
            if (u.getName().equalsIgnoreCase(query)
             || u.getTCNO().equalsIgnoreCase(query)
             || u.getEmail().equalsIgnoreCase(query)) {
                System.out.println(u);
                found = true;
            }
        if (!found) System.out.println("Benutzer nicht gefunden fuer: " + query);
    }

    public static void writeIntoVerwaltungspersonal(NichtWissenschaftlMA vw, String file_name) {
        try {
            FileWriter fw = new FileWriter(file_name, true);
            fw.write(vw.getTCNO() + ";" + vw.getName() + ";" + vw.getEmail() + ";" + vw.getPassword() + "\n");
            fw.flush();
        } catch (IOException e) {
            System.out.println("Datei konnte nicht geoeffnet werden: " + file_name);
        }
        
    }
    
    public static void loadVerwaltungspersonal(String file_name) {
        try {
            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            br.readLine(); // skip header line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                
                String[] parts = line.split(";");
                verwaltungspersonal.add(new NichtWissenschaftlMA(parts[0], parts[1], parts[2], parts[3]));
            }
            //benutzer_tcnos.add("12345678912");
        } catch (FileNotFoundException e) {
            System.out.println("Datei konnte nicht geoeffnet werden: " + file_name);
        } catch (IOException e) {
            System.out.println("Aus der Datei konnte nicht gelesen werden: " + file_name);
        }
    }
    
    public static ArrayList<Lehrveranstaltung> searchLVA(String query) {
        ArrayList<Lehrveranstaltung> result = new ArrayList();
        for (Lehrveranstaltung lva: lvas) {
            if (lva.getCode().contains(query) 
             || lva.getName().contains(query) )
            result.add(lva);
        }
        return result;
    }

    public static Lehrveranstaltung searchLVAExact(String query) {
        Lehrveranstaltung result = null;
        for (Lehrveranstaltung lva: lvas) {
            if (lva.getCode().equalsIgnoreCase(query))
                result = lva;
        }
        return result;
    }
    
    
}

