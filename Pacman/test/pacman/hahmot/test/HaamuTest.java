/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.hahmot.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pacman.alusta.Pelialusta;
import pacman.hahmot.Haamu;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;

/**
 *
 * @author hhkopper
 */
public class HaamuTest {

    private Pelialusta alusta;
    private Haamu haamu;

    public HaamuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        alusta = new Pelialusta(19, 21);
        alusta.luoPelialusta();
        haamu = new Haamu(9, 8, Suunta.ALAS, "RED", alusta);
        haamu.luoHaamuAlustalle();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void haamuLuodaanOikein() {
        assertEquals("(9,8) Nimi: RED, ALAS", haamu.toString());
    }

    @Test
    public void haamuLiikkuuOikeinAlas() {
        haamu.liiku();
        assertEquals("(9,9) Nimi: RED, ALAS", haamu.toString());
        assertEquals(true, alusta.getPeliruutu(9, 9).getOnkoHaamu());
        assertEquals(false, alusta.getPeliruutu(9, 8).getOnkoHaamu());
    }

    @Test
    public void haamuLiikkuuOikeinYlos() {
        haamu.setSuunta(Suunta.YLOS);
        haamu.liiku();
        assertEquals("(9,7) Nimi: RED, YLOS", haamu.toString());
        assertEquals(true, alusta.getPeliruutu(9, 7).getOnkoHaamu());
        assertEquals(false, alusta.getPeliruutu(9, 8).getOnkoHaamu());
    }

    @Test
    public void haamuLiikkuuOikeinOikealla() {
        haamu.setX(7);
        haamu.setY(7);
        haamu.setSuunta(Suunta.OIKEA);
        haamu.liiku();
        assertEquals("(8,7) Nimi: RED, OIKEA", haamu.toString());
        assertEquals(true, alusta.getPeliruutu(8, 7).getOnkoHaamu());
        assertEquals(false, alusta.getPeliruutu(7, 7).getOnkoHaamu());
    }

    @Test
    public void haamuLiikkuuOikeinVasemmalle() {
        haamu.setX(7);
        haamu.setY(7);
        haamu.setSuunta(Suunta.VASEN);
        haamu.liiku();
        assertEquals("(6,7) Nimi: RED, VASEN" , haamu.toString());
        assertEquals(true, alusta.getPeliruutu(6,7).getOnkoHaamu());
        assertEquals(false, alusta.getPeliruutu(7,7).getOnkoHaamu());
    }
    
    @Test
    public void huomioiKaikkiSuunnat() {
        haamu.setY(9);
        haamu.liiku();
        assertEquals(3, haamu.getSuuntaLista().size());
    }
    
    @Test
    public void palaaAlkuunOikein() {
        haamu.palaaAlkuun();
        assertEquals("(9,9) Nimi: RED, ALAS", haamu.toString());
    }
    
    @Test
    public void katsooOikeinVoikoLiikkuaSivuille() {
        haamu.setX(8);
        haamu.setY(7);
        haamu.setSuunta(Suunta.OIKEA);
        assertEquals(true, haamu.katsoVoikoLiikkuaSivuille());
    }
}
