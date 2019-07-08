package woche_4;

public class Komplex2 implements Komplex3 {

    @Override
    public void hilfe() {
        System.out.println("hilfe");
    }

    public Komplex2() {
        hilfe();
    }
}