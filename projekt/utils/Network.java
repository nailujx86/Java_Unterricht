package projekt.utils;

import java.util.HashMap;
import java.util.TreeMap;

import projekt.objekte.Film;
import projekt.objekte.Schauspieler;
import projekt.objekte.SchauspielerFilm;

public class Network {
    public static HashMap<DataEnum, TreeMap<Integer, Object>> schauspielerNetwork(
            HashMap<Integer, Object> schauspielerFilme, HashMap<Integer, Object> filmeMap,
            HashMap<Integer, Object> schauspielerMap, int schauspielerId) {

        HashMap<DataEnum, TreeMap<Integer, Object>> map = new HashMap<>();
        map.put(DataEnum.Film, new TreeMap<>());
        map.put(DataEnum.Schauspieler, new TreeMap<>());

        schauspielerFilme.entrySet().stream()
                .filter(e -> ((SchauspielerFilm) e.getValue()).getSchauspielerId() == schauspielerId)
                .forEach(e -> map.get(DataEnum.Film).put(((SchauspielerFilm) e.getValue()).getFilmId(),
                        (Film) filmeMap.get(((SchauspielerFilm) e.getValue()).getFilmId())));

        schauspielerFilme.entrySet().stream()
                .filter(e -> map.get(DataEnum.Film).containsKey(((SchauspielerFilm) e.getValue()).getFilmId()))
                .forEach(e -> map.get(DataEnum.Schauspieler).put(((SchauspielerFilm) e.getValue()).getSchauspielerId(),
                        (Schauspieler) schauspielerMap.get(((SchauspielerFilm) e.getValue()).getSchauspielerId())));

        return map;
    }

    public static HashMap<DataEnum, TreeMap<Integer, Object>> filmNetwork(HashMap<Integer, Object> schauspielerFilme,
            HashMap<Integer, Object> filmeMap, HashMap<Integer, Object> schauspielerMap, int filmId) {
        HashMap<DataEnum, TreeMap<Integer, Object>> map = new HashMap<>();
        map.put(DataEnum.Schauspieler, new TreeMap<>());
        map.put(DataEnum.Film, new TreeMap<>());

        schauspielerFilme.entrySet().stream().filter(e -> ((SchauspielerFilm) e.getValue()).getFilmId() == filmId)
                .forEach(e -> map.get(DataEnum.Schauspieler).put(((SchauspielerFilm) e.getValue()).getSchauspielerId(),
                        (Schauspieler) schauspielerMap.get(((SchauspielerFilm) e.getValue()).getSchauspielerId())));

        schauspielerFilme.entrySet().stream().filter(
                e -> map.get(DataEnum.Schauspieler).containsKey(((SchauspielerFilm) e.getValue()).getSchauspielerId()))
                .forEach(e -> map.get(DataEnum.Film).put(((SchauspielerFilm) e.getValue()).getSchauspielerId(),
                        (Film) filmeMap.get(((SchauspielerFilm) e.getValue()).getFilmId())));

        return map;
    }

}