package projekt.objekte;

public class RegisseurFilm {
    private int regisseurId;
    private int filmId;

    public RegisseurFilm(int regisseurId, int filmId) {
        this.regisseurId = regisseurId;
        this.filmId = filmId;
    }

    public int getRegisseurId() {
        return regisseurId;
    }

    public int getFilmId() {
        return filmId;
    }
}