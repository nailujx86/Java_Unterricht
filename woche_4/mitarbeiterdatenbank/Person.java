package woche_4.mitarbeiterdatenbank;

import java.util.Date;

public abstract class Person {

    private int personalnummer;
    private String name;
    private String adresse;
    private Date geburtstag;

    public Person(int personalnummer, String name, String adresse, Date geburtstag) {
        this.personalnummer = personalnummer;
        this.adresse = adresse;
        this.name = name;
        this.geburtstag = geburtstag;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(int personalnummer) {
        this.personalnummer = personalnummer;
    }

    public abstract double berechneGehalt(int arbeitsStunden, int ueberStunden, int schichtStunden);
}