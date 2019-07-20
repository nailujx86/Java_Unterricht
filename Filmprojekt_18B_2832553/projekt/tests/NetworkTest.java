package projekt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import projekt.objekte.Film;
import projekt.objekte.Schauspieler;
import projekt.utils.DataEnum;
import projekt.utils.Network;

public class NetworkTest extends DataSetup {
    @Test
    public void filmNetworkTest() {
        var net = Network.filmNetwork(data2.get(DataEnum.SchauspielerFilm), data2.get(DataEnum.Film), data2.get(DataEnum.Schauspieler), 1);
        assertEquals(net.get(DataEnum.Schauspieler).size(), 2);
        assertEquals(net.get(DataEnum.Film).size(), 0);
        net.get(DataEnum.Schauspieler).values().forEach(e -> {
            assertTrue(e instanceof Schauspieler);
        });
        net.get(DataEnum.Film).values().forEach(e -> {
            assertTrue(e instanceof Film);
        });
    }

    @Test
    public void schauspielerNetworkTest() {
        var net = Network.schauspielerNetwork(data2.get(DataEnum.SchauspielerFilm), data2.get(DataEnum.Film), data2.get(DataEnum.Schauspieler), 123);
        assertEquals(net.get(DataEnum.Schauspieler).size(), 1);
        assertEquals(net.get(DataEnum.Film).size(), 1);
        net.get(DataEnum.Schauspieler).values().forEach(e -> {
            assertTrue(e instanceof Schauspieler);
        });
        net.get(DataEnum.Film).values().forEach(e -> {
            assertTrue(e instanceof Film);
        });
    }
}