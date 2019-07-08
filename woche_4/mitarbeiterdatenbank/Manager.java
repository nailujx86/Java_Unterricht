package woche_4.mitarbeiterdatenbank;

import java.util.Date;

class Manager extends Person {
    private double grundgehalt;
    private double provision;

    public Manager(int personalnummer, String name, String adresse, Date geburtstag, double grundgehalt,
            double provision) {
        super(personalnummer, name, adresse, geburtstag);
        this.setGrundgehalt(grundgehalt);
        this.setProvision(provision);
    }

    public double getProvision() {
        return provision;
    }

    public void setProvision(double provision) {
        this.provision = provision;
    }

    public double getGrundgehalt() {
        return grundgehalt;
    }

    public void setGrundgehalt(double grundgehalt) {
        this.grundgehalt = grundgehalt;
    }

    @Override
    public double berechneGehalt(int arbeitsStunden, int ueberStunden, int schichtStunden) {
        return grundgehalt + provision;
    }

}