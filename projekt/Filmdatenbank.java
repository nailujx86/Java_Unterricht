package projekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import projekt.objekte.Film;
import projekt.utils.DataEnum;
import projekt.utils.DataParser;
import projekt.utils.Network;
import projekt.utils.Search;

public class Filmdatenbank {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            printHelp();
            return;
        }
        String choice = args[0];
        choice = choice.replace("--", "");
        if (!choice.contains("=")) {
            printHelp();
            return;
        }
        var choicearr = choice.split("=");
        if(choicearr.length == 1) {
            System.out.println("ohoh leerer string");
            return;
        }

        List<String> lines = Files.readAllLines(Paths.get("projekt/movieproject2019.db"));
        var data = DataParser.parse(lines);

        switch (choicearr[0]) {
            case "filmsuche": {
                var films = Search.searchFilme(data.get(DataEnum.Film), choicearr[1]);
                if(films.size() == 0)
                    System.out.println("keine ergebnisse :(");
                films.forEach(f -> {
                    System.out.print(f.getId() + "\t");
                    System.out.println(f.getTitel());
                });
                break;
            }
            case "schauspielersuche": {
                var schauspieler = Search.searchSchauspieler(data.get(DataEnum.Schauspieler), choicearr[1]);
                if(schauspieler.size() == 0)
                    System.out.println("keine ergebnisse :(");
                schauspieler.forEach(s -> {
                    System.out.print(s.getId() + "\t");
                    System.out.println(s.getName());
                });
                break;
            }
            case "filmnetzwerk": {
                var network = Network.schauspielerNetwork(data.get(DataEnum.SchauspielerFilm), data.get(DataEnum.Film), data.get(DataEnum.Schauspieler), Integer.valueOf(choicearr[1]));
                break;
            }
            case "schauspielernetzwerk":
                break;
            default:
                printHelp();
                return;
        }
    }

    private static void printHelp() {
        System.out.println("~~~Filmdatenbank~~~");
        System.out.println(String.join("\n", "\nParameter:", "--filmsuche=\"x\"\t\t\tsucht nach Filmen",
                "--schauspielersuche=\"y\"\t\tsucht nach Schauspielern",
                "--filmnetzwerk=123\t\tgibt das Filmnetzwerk aus",
                "--schauspielernetzwerk=321\tgibt das Schauspielernetzwerk aus"));
    }
}