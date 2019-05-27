package woche_3;

public class Quadrat extends Rechteck{

    public Quadrat(double seitenlaenge) {
        super(seitenlaenge, seitenlaenge);     
    }

    public double getSeitenlaenge() {
        return getBreite();
    }

    public void setSeitenlaenge(double seitenlaenge) {
        setLaenge(seitenlaenge);
        setBreite(seitenlaenge);
    }
}