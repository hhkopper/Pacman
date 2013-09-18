/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.alusta.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
    public void setUp() throws Exception {
        alusta = new Pelialusta(19,21);
        alusta.luoPelialusta();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alustaLuodaan() {
        assertEquals("Korkeus:21, leveys:19", alusta.toString());
    }
    
    @Test
    public void hakeeRuudunOikein() throws Exception {
        String vastaus = alusta.getPeliruutu(0, 0).toString();
        assertEquals("(0,0), onko man: false, onko haamu: false, ruuduntyyppi: 0", vastaus);        
    }
    
    @Test
    public void eiLaitaPistepalloaMinneSeEiKuulu() {
        assertEquals(alusta.getPeliruutu(0, 7).getOnkoPistepallo(), false);
        assertEquals(alusta.getPeliruutu(9, 11).getOnkoPistepallo(), false);
        assertEquals(alusta.getPeliruutu(9, 9).getOnkoPistepallo(), false);
        assertEquals(alusta.getPeliruutu(17, 7).getOnkoPistepallo(), false);
    }
}
