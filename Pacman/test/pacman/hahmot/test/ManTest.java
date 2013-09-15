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
import pacman.hahmot.Suunta;
import pacman.alusta.Pelialusta;
import pacman.hahmot.Haamu;
import pacman.hahmot.Man;

/**
 *
 * @author hhkopper
 */
public class ManTest {

    private Pelialusta alusta;
    private Man man;

    public ManTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        alusta = new Pelialusta(10, 10);
        alusta.luoPelialusta();
        man = new Man(2, 2, Suunta.ALAS, alusta);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void manLuodaanOikein() {
        assertEquals("2,2", man.toString());
    }

    @Test
    public void manLiikkuuOikeinAlas() {
        man.luoManAlustalle();
        man.liiku();
        assertEquals("3,2", man.toString());
    }

    @Test
    public void manLiikkuuOikeinYlos() {
        man.setSuunta(Suunta.YLOS);
        man.luoManAlustalle();
        man.liiku();
        assertEquals("1,2", man.toString());
    }

    @Test
    public void manLiikkuuOikeinVasen() {
        man.setSuunta(Suunta.VASEN);
        man.luoManAlustalle();
        man.liiku();
        assertEquals("2,1", man.toString());
    }

    @Test
    public void manLiikkuuOikeinOikea() {
        man.setSuunta(Suunta.OIKEA);
        man.luoManAlustalle();
        man.liiku();
        assertEquals("2,3", man.toString());
    }

    @Test
    public void manOsuukoSeinaanOikein() {
        man.setSuunta(Suunta.OIKEA);
        alusta.getPeliruutu(2, 3).setRuudunTyyppi(0);
        man.luoManAlustalle();
        man.liiku();
        assertEquals("2,2", man.toString());
    }

//    @Test
//    public void kuoleekoMan() {
//        man.luoManAlustalle();
//        Haamu haamu = new Haamu(2, 2, Suunta.OIKEA, "punainen");
//        haamu.luoHaamuAlustalle(alusta);
//
//        assertEquals(true, man.tarkistaKuoleeko());
//    }
}
