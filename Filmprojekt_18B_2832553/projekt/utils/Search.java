package projekt.utils;

import java.util.ArrayList;
import java.util.HashMap;

import projekt.objekte.Film;
import projekt.objekte.Schauspieler;

public class Search {
    public static ArrayList<Schauspieler> searchSchauspieler(HashMap<Integer, Object> hashMap, String searchStr) {
        ArrayList<Schauspieler> list = new ArrayList<>();
        hashMap
            .entrySet()
            .stream()
            .filter(e -> 
                ((Schauspieler) e.getValue()).getName().contains(searchStr))
            .forEach(e -> list.add(((Schauspieler) e.getValue())));
        return list;
    }

    public static ArrayList<Film> searchFilme(HashMap<Integer, Object> map, String searchStr) {
        ArrayList<Film> list = new ArrayList<>();
        map
            .entrySet()
            .stream()
            .filter(e -> 
                ((Film) e.getValue()).getTitel().contains(searchStr))
            .forEach(e -> list.add(((Film) e.getValue())));
        return list;
    }
}