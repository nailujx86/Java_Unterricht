package projekt.objekte;

public class Film {
    private int id;
    private String titel;
    private String beschreibung;
    private String genre;
    private String eDatum;
    private int imdbVotes;
    private double imdbRating;

    public Film(int id, String titel, String beschreibung, String genre, String eDatum, int imdbVotes,
            double imdbRating) {
        this.setId(id);
        this.setTitel(titel);
        this.setBeschreibung(beschreibung);
        this.seteJahr(eDatum);
        this.setImdbRating(imdbRating);
        this.setImdbVotes(imdbVotes);
        this.setGenre(genre);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String geteDatum() {
        return eDatum;
    }

    public void seteJahr(String eDatum) {
        this.eDatum = eDatum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}