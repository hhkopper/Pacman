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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alustaLuodaan() {
        Pelialusta alusta = new Pelialusta(21, 19);
        assertEquals("Korkeus:21, leveys:19", alusta.toString());
    }
    
    @Test
    public void hakeeRuudunOikein() throws Exception {
        Pelialusta alusta = new Pelialusta(21,19);
        alusta.luoPelialusta();
        alusta.rakennaSeinatJaLuoPisteet();
        String vastaus = alusta.getPeliruutu(0, 0).toString();
        assertEquals("(0,0), onko man: false, onko haamu: false, ruuduntyyppi: 0", vastaus);        
    }
}
