package woche_4.mitarbeiterdatenbank;

import java.util.Date;

class Geschaeftsfuehrer extends Manager {
    private double zulage;

    public Geschaeftsfuehrer(int personalnummer, String name, String adresse, Date geburtstag, double grundgehalt,
            double provision, double zulage) {
        super(personalnummer, name, adresse, geburtstag, grundgehalt, provision);
        this.setZulage(zulage);
    }

    public double getZulage() {
        return zulage;
    }

    public void setZulage(double zulage) {
        this.zulage = zulage;
    }

    @Override
    public double berechneGehalt(int arbeitsStunden, int ueberStunden, int schichtStunden) {
        return getGrundgehalt() + getProvision() + zulage;
    }

}