/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.peli.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pacman.gui.Kayttoliittyma;
import pacman.peli.Highscore;
import pacman.peli.Pacman;

/**
 *
 * @author Hanna
 */
public class HighscoreTest {
    
    private Pacman peli;
    private File ennatykset;
    private Kayttoliittyma kayttis;
    private FileWriter kirjoittaja;
    private Scanner lukija;
    private Highscore highscore;
    
    public HighscoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        peli = new Pacman();
        kayttis = new Kayttoliittyma(peli);        
        ennatykset = new File("Ennatykset");
        try {
            kirjoittaja = new FileWriter(ennatykset);
            lukija = new Scanner(ennatykset);
        } catch (IOException ex) {
            kayttis.virheilmoitus("Virhe testejä suoritettaessa.");
        }
        highscore = new Highscore(kayttis);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void katsooOikeinOnkoUusiEnnatys() {
        assertEquals(true, highscore.tarkistaOnkoEnnatys(200));
        highscore.kirjaaEnnatys(200);
        assertEquals(false, highscore.tarkistaOnkoEnnatys(50));
        assertEquals(true, highscore.tarkistaOnkoEnnatys(500));        
    }
}
