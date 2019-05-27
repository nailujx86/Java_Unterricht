package woche_3;

public class Rechteck {
    private double breite, laenge;

    public double getBreite() {
        return breite;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public Rechteck(double laenge, double breite) {
        this.laenge = laenge;
        this.breite = breite;
    }
}