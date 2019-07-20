package projekt.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;

import projekt.utils.DataEnum;
import projekt.utils.DataParser;

public abstract class DataSetup {
    HashMap<DataEnum, HashMap<Integer, Object>> data1;
    HashMap<DataEnum, HashMap<Integer, Object>> data2;

    @Before
    public void setup() {
        List<String> lines = Arrays.asList(
            "New_Entity: \"actor_id\",\"actor_name\"",
            "\"123\",\"Rainer Zufall\"",
            "\"321\",\"Zufall Heinz\""
        );
        data1 = DataParser.parse(lines);
        List<String> lines2 = Arrays.asList(
            "New_Entity: \"actor_id\",\"actor_name\"",
            "\"123\",\"Rainer Zufall\"",
            "\"321\",\"Zufall Heinz\"",
            "New_Entity: \"movie_id\",\"movie_title\"",
            "\"1\",\"TestFilm\",\"Ein toller Film\",\"action\",\"2003\",\"5\",\"5.6\"",
            "New_Entity: \"actor_id\",\"movie_id\"",
            "\"123\",\"1\"",
            "\"321\",\"1\""
        );
        data2 = DataParser.parse(lines2);
    }
}