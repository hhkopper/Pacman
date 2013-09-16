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
        alusta = new Pelialusta(21, 19);
        alusta.luoPelialusta();
        haamu = new Haamu(8, 9, Suunta.ALAS, "RED", alusta);
        haamu.luoHaamuAlustalle();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void haamuLuodaanOikein() {
        assertEquals("(8,9) Nimi: RED, ALAS", haamu.toString());
    }

    @Test
    public void haamuLiikkuuOikeinAlas() {
        haamu.liiku();
        assertEquals("(9,9) Nimi: RED, ALAS" + true + false, haamu.toString() + alusta.getPeliruutu(9, 9).getOnkoHaamu() + alusta.getPeliruutu(8, 9).getOnkoHaamu());
    }
    
    @Test
    public void haamuLiikkuuOikeinYlos() {
        haamu.setAlkuSuunta(Suunta.YLOS);
        haamu.liiku();
        assertEquals("(7,9) Nimi: RED, YLOS" + false +true, haamu.toString() + alusta.getPeliruutu(8, 9).getOnkoHaamu() + alusta.getPeliruutu(7, 9).getOnkoHaamu());        
    }
    
    @Test
    public void haamuLiikkuuOikeinOikealla() {
        haamu.setY(7);
        haamu.setAlkuSuunta(Suunta.OIKEA);
        haamu.liiku();
        assertEquals("(7,10) Nimi: RED, OIKEA" + true + false, haamu.toString() + alusta.getPeliruutu(7, 10).getOnkoHaamu() + alusta.getPeliruutu(7, 9).getOnkoHaamu());
    }
    
    @Test
    public void haamuLiikkuuOikeinVasemmalle() {
        haamu.setY(7);
        haamu.setAlkuSuunta(Suunta.VASEN);
        haamu.liiku();
        assertEquals("(7,8) Nimi: RED, VASEN" + true + false, haamu.toString() + alusta.getPeliruutu(7, 8).getOnkoHaamu() + alusta.getPeliruutu(7, 9).getOnkoHaamu());
    }
}
