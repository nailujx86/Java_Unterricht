package projekt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import projekt.objekte.Film;
import projekt.objekte.Schauspieler;
import projekt.utils.DataEnum;
import projekt.utils.Search;

public class SearchTest extends DataSetup {
    @Test
    public void searchTest1() {
        var list = Search.searchFilme(data2.get(DataEnum.Film), "TestFilm");
        assertEquals(list.size(), 1);
        list.forEach(e -> assertTrue(e instanceof Film));
        assertEquals(((Film) list.get(0)).getGenre(), "action");
    }

    @Test
    public void searchTest2() {
        var list = Search.searchSchauspieler(data1.get(DataEnum.Schauspieler), "Zufall");
        assertEquals(list.size(), 2);
        list.forEach(e -> assertTrue(e instanceof Schauspieler));
        assertTrue(list.get(0).getName().startsWith("Zufall"));
    }
}