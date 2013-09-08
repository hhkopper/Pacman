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
import pacman.hahmot.Man;

/**
 *
 * @author hhkopper
 */
public class ManTest {

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
        Pelialusta alusta = new Pelialusta();
        alusta.luoPelialusta();
        Man man = new Man(2,2, Suunta.ALAS);
        man.luoMan(alusta);
        man.liiku(alusta);
        String vastaus = man.toString();
        assertEquals("2,3", vastaus);
    }
    
    @Test
    public void manLiikkuuOikeinYlos() {
        Pelialusta alusta = new Pelialusta();
        alusta.luoPelialusta();
        Man man = new Man(2, 2, Suunta.YLOS);
        man.luoMan(alusta);
        man.liiku(alusta);
        assertEquals("2,1", man.toString());
    }
    
    @Test
    public void manLiikkuuOikeinVasen() {
        Pelialusta alusta = new Pelialusta();
        alusta.luoPelialusta();
        Man man = new Man(2, 2, Suunta.VASEN);
        man.luoMan(alusta);
        man.liiku(alusta);
        assertEquals("1,2", man.toString());
    }
    @Test
    public void manLiikkuuOikeinOikea() {
        Pelialusta alusta = new Pelialusta();
        alusta.luoPelialusta();
        Man man = new Man(2, 2, Suunta.OIKEA);
        man.luoMan(alusta);
        man.liiku(alusta);
        assertEquals("3,2", man.toString());
    }
//    
//    @Test void manLiikkuuYliReunan() {
//        
//    }
}
