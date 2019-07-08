package projekt.data;

import java.util.ArrayList;

import projekt.objekte.Film;
import projekt.objekte.Schauspieler;
import projekt.objekte.Regisseur;

public class Storage {
    private ArrayList<Film> filme;
    private ArrayList<Schauspieler> schauspieler;
    private ArrayList<Regisseur> regisseur;

    public Storage() {

    }

    public ArrayList<Regisseur> getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(ArrayList<Regisseur> regisseur) {
        this.regisseur = regisseur;
    }

    public ArrayList<Schauspieler> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(ArrayList<Schauspieler> schauspieler) {
        this.schauspieler = schauspieler;
    }

    public ArrayList<Film> getFilme() {
        return filme;
    }

    public void setFilme(ArrayList<Film> filme) {
        this.filme = filme;
    }

    public Storage(ArrayList<Film> filme, ArrayList<Schauspieler> schauspieler, ArrayList<Regisseur> regisseur) {
        this.setFilme(filme);
        this.setSchauspieler(schauspieler);
        this.setRegisseur(regisseur);
    }

    public void addFilm(Film film) {
        this.filme.add(film);
    }

    public void addSchauspieler(Schauspieler schauspieler) {
        this.schauspieler.add(schauspieler);
    }

    public void addRegisseur(Regisseur regisseur) {
        this.regisseur.add(regisseur);
    }
}