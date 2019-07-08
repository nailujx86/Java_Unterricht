package woche_4.mitarbeiterdatenbank;

import java.util.Date;

public class Angestellter extends Person {
    private double grundgehalt;
    private double zulagen;

    public Angestellter(int personalnummer, String name, String adresse, Date geburtstag, double grundgehalt,
            double zulagen) {
        super(personalnummer, name, adresse, geburtstag);
        this.grundgehalt = grundgehalt;
        this.zulagen = zulagen;
    }

    public double getZulagen() {
        return zulagen;
    }

    public void setZulagen(double zulagen) {
        this.zulagen = zulagen;
    }

    public double getGrundgehalt() {
        return grundgehalt;
    }

    public void setGrundgehalt(double grundgehalt) {
        this.grundgehalt = grundgehalt;
    }

    @Override
    public double berechneGehalt(int arbeitsStunden, int ueberStunden, int schichtStunden) {
        return grundgehalt + zulagen;
    }

}