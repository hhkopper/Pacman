/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.alusta.test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pacman.alusta.Pelialusta;

/**
 *
 * @author hhkopper
 */
public class PelialustaTest {
    private Pelialusta alusta;
    
    public PelialustaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        alusta = new Pelialusta(19,21);
        alusta.luoPelialusta();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alustaLuodaan() {
        assertEquals(21, alusta.getKorkeus());
        assertEquals(19, alusta.getLeveys());
    }
    
    @Test
    public void hakeeRuudunOikein() {
        assertEquals(0, alusta.getPeliruutu(0, 9).getX());
        assertEquals(9, alusta.getPeliruutu(0, 9).getY());
    }
    
    @Test
    public void eiLaitaPistepalloaMinneSeEiKuulu() {
        assertEquals(alusta.getPeliruutu(0, 7).getOnkoPallo(), false);
        assertEquals(alusta.getPeliruutu(9, 11).getOnkoPallo(), false);
        assertEquals(alusta.getPeliruutu(9, 9).getOnkoPallo(), false);
        assertEquals(alusta.getPeliruutu(17, 7).getOnkoPallo(), false);
    }
    
    @Test
    public void laittaaEkstraPistepallonOikeaanPaikkaan() {
        assertEquals(2, alusta.getPeliruutu(1, 5).getRuudunTyyppi());
        assertEquals(true, alusta.getPeliruutu(1, 5).getOnkoExtraPallo());
    }
    
    @Test
    public void laittaaPistepallonOikeaanPaikkaan() {
        assertEquals(1, alusta.getPeliruutu(1, 1).getRuudunTyyppi());
        assertEquals(true, alusta.getPeliruutu(1, 1).getOnkoPallo());
    }
    
    @Test
    public void asettaaSeinan() {
        assertEquals(0, alusta.getPeliruutu(0, 0).getRuudunTyyppi());        
    }
}
