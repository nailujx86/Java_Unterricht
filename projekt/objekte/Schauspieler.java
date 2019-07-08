package projekt.objekte;

public class Schauspieler {
    private int id;
    private String name;

    public Schauspieler(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}