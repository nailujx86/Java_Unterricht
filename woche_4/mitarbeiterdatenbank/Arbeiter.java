package woche_4.mitarbeiterdatenbank;

import java.util.Date;

class Arbeiter extends Person {
    private double stundenlohn;
    private double ueberstdzuschlag;
    private double schichtzulage;

    public Arbeiter(int personalnummer, String name, String adresse, Date geburtstag, double stundenlohn,
            double ueberstdzuschlag, double schichtzulage) {
        super(personalnummer, name, adresse, geburtstag);
        this.setStundenlohn(stundenlohn);
        this.setUeberstdzuschlag(ueberstdzuschlag);
        this.setSchichtzulage(schichtzulage);
    }

    public double getSchichtzulage() {
        return schichtzulage;
    }

    public void setSchichtzulage(double schichtzulage) {
        this.schichtzulage = schichtzulage;
    }

    public double getUeberstdzuschlag() {
        return ueberstdzuschlag;
    }

    public void setUeberstdzuschlag(double ueberstdzuschlag) {
        this.ueberstdzuschlag = ueberstdzuschlag;
    }

    public double getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn) {
        this.stundenlohn = stundenlohn;
    }

    @Override
    public double berechneGehalt(int arbeitsStunden, int ueberStunden, int schichtStunden) {
        return (arbeitsStunden * stundenlohn) 
        + (ueberStunden * ueberstdzuschlag) 
        + (schichtStunden * schichtzulage);
    }

}