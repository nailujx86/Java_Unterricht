package projekt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import projekt.objekte.Film;
import projekt.objekte.Schauspieler;
import projekt.utils.DataEnum;

public class DataParserTest extends DataSetup {

    @Test
    public void parserTest1() {
        var map = data1.get(DataEnum.Schauspieler);
        assertEquals(map.size(), 2);
        map.values().forEach(e -> {
            assertTrue(e instanceof Schauspieler);
        });
        assertEquals(((Schauspieler) map.get(123)).getName(), "Rainer Zufall");
    }

    @Test
    public void parserTest2() {
        var mapSch = data2.get(DataEnum.Schauspieler);
        var mapSchF = data2.get(DataEnum.SchauspielerFilm);
        var mapMov = data2.get(DataEnum.Film);
        assertEquals(mapMov.size(), 1);
        assertEquals(mapSch.size(), 2);
        assertEquals(mapSchF.size(), 2);
        mapMov.values().forEach(e -> {
            assertTrue(e instanceof Film);
        });
    }
}