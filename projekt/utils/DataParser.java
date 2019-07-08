package projekt.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import projekt.objekte.Film;
import projekt.objekte.Regisseur;
import projekt.objekte.RegisseurFilm;
import projekt.objekte.Schauspieler;
import projekt.objekte.SchauspielerFilm;

public class DataParser {
    public static HashMap<DataEnum, HashMap<Integer, Object>> parse(List<String> text) {
        DataEnum currentDataType = null;
        HashMap<DataEnum, HashMap<Integer, Object>> data = new HashMap<>();

        data.put(DataEnum.Schauspieler, new HashMap<>());
        data.put(DataEnum.Film, new HashMap<>());
        data.put(DataEnum.Regisseur, new HashMap<>());
        data.put(DataEnum.SchauspielerFilm, new HashMap<>());
        data.put(DataEnum.RegisseurFilm, new HashMap<>());

        int uIdCounter = 0; // Um id-clashes bei SchauspielerFilm und RegisseurFilm zu vermeiden
        for (String strline : text) {
            if (strline.startsWith("New_Entity:")) {
                String lineFiltered = strline.replace("New_Entity: ", "");
                if (lineFiltered.startsWith("\"actor_id\",\"actor_name\"")) {
                    currentDataType = DataEnum.Schauspieler;
                } else if (lineFiltered.startsWith("\"movie_id\",\"movie_title\"")) {
                    currentDataType = DataEnum.Film;
                } else if (lineFiltered.startsWith("\"director_id\",\"director_name\"")) {
                    currentDataType = DataEnum.Regisseur;
                } else if (lineFiltered.startsWith("\"actor_id\",\"movie_id\"")) {
                    currentDataType = DataEnum.SchauspielerFilm;
                } else if (lineFiltered.startsWith("\"director_id\",\"movie_id\"")) {
                    currentDataType = DataEnum.RegisseurFilm;
                }
            } else if (currentDataType == null) {
                System.err.println("ohoh kein new entity");
            } else {
                String[] results = strline.split(",\"");
                for (int i = 0; i < results.length; i++) {
                    results[i] = results[i].replaceAll("\"", "").trim();
                    if(results[i].equals(""))
                        results[i] = "0";
                }
                switch (currentDataType) {
                case Film: {
                    var map = data.get(DataEnum.Film);
                    map.put(Integer.parseInt(results[0]),
                            new Film(Integer.parseInt(results[0]), results[1], results[2], results[3],
                                    results[4], Integer.parseInt(results[5]),
                                    Double.parseDouble(results[6])));
                    break;
                }
                case Regisseur: {
                    var map = data.get(DataEnum.Regisseur);
                    map.put(Integer.parseInt(results[0]), new Regisseur(Integer.parseInt(results[0]), results[1]));
                    break;
                }
                case Schauspieler: {
                    var map = data.get(DataEnum.Schauspieler);
                    map.put(Integer.parseInt(results[0]), new Schauspieler(Integer.parseInt(results[0]), results[1]));
                    break;
                }
                case RegisseurFilm: {
                    var map = data.get(DataEnum.RegisseurFilm);
                    map.put(uIdCounter,
                            new RegisseurFilm(Integer.parseInt(results[0]), Integer.parseInt(results[1])));
                    uIdCounter++;
                    break;
                }
                case SchauspielerFilm: {
                    var map = data.get(DataEnum.SchauspielerFilm);
                    map.put(uIdCounter,
                            new SchauspielerFilm(Integer.parseInt(results[0]), Integer.parseInt(results[1])));
                    uIdCounter++;
                    break;
                }
                }
            }
        }
        return data;

    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("projekt/movieproject2019.db"));
        var data = parse(lines);
        var matrixfilms = Search.searchFilme(data.get(DataEnum.Film), "Matrix");
        for(Film matrixfilm : matrixfilms) {
            System.out.println(matrixfilm.getTitel());
        }
        System.out.println("---");
        var smiths = Search.searchSchauspieler(data.get(DataEnum.Schauspieler), "Smith");
        for(Schauspieler smith : smiths) {
            System.out.println(smith.getName());
        }
        System.out.println("---");
        var network = Network.schauspielerNetwork(data.get(DataEnum.SchauspielerFilm), data.get(DataEnum.Film), data.get(DataEnum.Schauspieler), 17562);
        for(Object nobj : network.get(DataEnum.Film).values()) {
            var nfilm = (Film) nobj;
            System.out.println(nfilm.getTitel());
        }
        System.out.println("oOoOoOoOoOoOoOoOo");
        for(Object nobj : network.get(DataEnum.Schauspieler).values()) {
            var nschauspieler = (Schauspieler) nobj;
            System.out.println(nschauspieler.getName());
        }
    }
}