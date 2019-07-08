package woche_4;

public class Komplex extends Komplex2 implements Komplex3 {
    

    public void hilfe(int x) {
        System.out.println(x);
    }

    public void hilfe() {
        System.out.println(x);
    }
    
    public static void main(String[] args) {
        final int x = 31;
        Komplex2 komplex = (new Komplex());
        komplex.hilfe();
        ((Komplex) komplex).hilfe(Komplex3.x);
    }
}