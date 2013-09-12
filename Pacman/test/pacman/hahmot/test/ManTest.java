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
import pacman.Suunta;
import pacman.alusta.Pelialusta;
import pacman.hahmot.Haamu;
import pacman.hahmot.Man;

/**
 *
 * @author hhkopper
 */
public class ManTest {

    private Pelialusta alusta;

    public ManTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        alusta = new Pelialusta(10, 10);
        alusta.luoPelialusta();
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void hello() {
    }

    @Test
    public void manLuodaanOikein() {
        Man man = new Man(2, 2, Suunta.ALAS);
        String vastaus = man.toString();
        assertEquals("2,2", vastaus);
    }

    @Test
    public void manLiikkuuOikeinAlas() {
        Man man = new Man(2, 2, Suunta.ALAS);
        man.luoManAlustalle(alusta);
        man.liiku(alusta);
        String vastaus = man.toString();
        assertEquals("3,2", vastaus);
    }

    @Test
    public void manLiikkuuOikeinYlos() {
        Man man = new Man(2, 2, Suunta.YLOS);
        man.luoManAlustalle(alusta);
        man.liiku(alusta);
        assertEquals("1,2", man.toString());
    }

    @Test
    public void manLiikkuuOikeinVasen() {
        Man man = new Man(2, 2, Suunta.VASEN);
        man.luoManAlustalle(alusta);
        man.liiku(alusta);
        assertEquals("2,1", man.toString());
    }

    @Test
    public void manLiikkuuOikeinOikea() {
        Man man = new Man(2, 2, Suunta.OIKEA);
        man.luoManAlustalle(alusta);
        man.liiku(alusta);
        assertEquals("2,3", man.toString());
    }

    @Test
    public void manOsuukoSeinaanOikein() {
        Man man = new Man(2, 2, Suunta.OIKEA);
        alusta.getPeliruutu(2, 3).setRuudunTyyppi(0);
        man.luoManAlustalle(alusta);
        man.liiku(alusta);
        assertEquals("2,2", man.toString());
    }

    @Test
    public void kuoleekoMan() {
        Man man = new Man(2, 2, Suunta.ALAS);
        man.luoManAlustalle(alusta);
        Haamu haamu = new Haamu(2, 2, Suunta.OIKEA, "punainen");
        haamu.luoHaamuAlustalle(alusta);

        man.tarkistaKuoleeko(alusta);

        assertEquals("11,9", man.toString());
    }
}
