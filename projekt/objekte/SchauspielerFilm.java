package projekt.objekte;

public class SchauspielerFilm {
    private int schauspielerId;
    private int filmId;

    public SchauspielerFilm(int schauspielerId, int filmId) {
        this.schauspielerId = schauspielerId;
        this.filmId = filmId;
    }

    public int getSchauspielerId() {
        return schauspielerId;
    }

    public int getFilmId() {
        return filmId;
    }
}