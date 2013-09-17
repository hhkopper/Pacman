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
        alusta = new Pelialusta(19, 21);
        alusta.luoPelialusta();
        man = new Man(9, 11, Suunta.ALAS, alusta);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void manLuodaanOikein() {
        assertEquals("9,11", man.toString());
    }

    @Test
    public void manEiLiikuAlasSeinanLapi() {
        man.luoManAlustalle();
        man.liiku();
        assertEquals("9,11", man.toString());
        assertEquals(true, alusta.getPeliruutu(9, 11).getOnkoMan());
        assertEquals(false, alusta.getPeliruutu(9, 12).getOnkoMan());
    }

    @Test
    public void manEiLiikuYlosSeinanLapi() {
        man.setSuunta(Suunta.YLOS);
        man.luoManAlustalle();
        man.liiku();
        assertEquals("9,11", man.toString());
    }

    @Test
    public void manEiLiikuVasenSeinanLapi() {
        man = new Man(6, 11, Suunta.VASEN, alusta);
        man.liiku();
        assertEquals("6,11", man.toString());
    }

    @Test
    public void manEiLiikuOikeaSeinanLapi() {
        man = new Man(12, 11, Suunta.OIKEA, alusta);
        man.liiku();
        assertEquals("12,11", man.toString());
    }

    @Test
    public void manLiikkuuOikeinVasen() {
        man.setSuunta(Suunta.VASEN);
        man.luoManAlustalle();
        man.liiku();
        assertEquals("8,11", man.toString());
        assertEquals(true, alusta.getPeliruutu(8,11).getOnkoMan());
        assertEquals(false, alusta.getPeliruutu(9, 11).getOnkoMan());
    }

    @Test
    public void manLiikkuuOikeinOikea() {
        man.setSuunta(Suunta.OIKEA);
        man.luoManAlustalle();
        man.liiku();
        assertEquals("10,11", man.toString());
    }
//
////    @Test
////    public void manOsuukoSeinaanOikein() {
////        man.setSuunta(Suunta.OIKEA);
////        alusta.getPeliruutu(2, 3).setRuudunTyyppi(0);
////        man.luoManAlustalle();
////        man.liiku();
////        assertEquals("2,2", man.toString());
////    }
//
////    @Test
////    public void kuoleekoMan() {
////        man.luoManAlustalle();
////        Haamu haamu = new Haamu(2, 2, Suunta.OIKEA, "punainen");
////        haamu.luoHaamuAlustalle(alusta);
////
////        assertEquals(true, man.tarkistaKuoleeko());
////    }
}
