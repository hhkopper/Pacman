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
import pacman.hahmot.Haamu;

/**
 *
 * @author hhkopper
 */
public class HaamuTest {
    
    public HaamuTest() {
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
    public void haamuLuodaanOikein() {
        Haamu haamu = new Haamu(2,2,Suunta.YLOS, "Punainen");
        String vastaus = haamu.toString();
        assertEquals("(2,2) Nimi: Punainen", vastaus);
        
    }
}
