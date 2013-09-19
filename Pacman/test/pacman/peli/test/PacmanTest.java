package pacman.peli.test;

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
import pacman.peli.Pacman;

public class PacmanTest {

    private Pacman pacman;

    public PacmanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        pacman = new Pacman();       
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void kuoleekoManKunHaamuVahva() {
        pacman.getMan().setX(10);
        pacman.getMan().setY(7);
        pacman.getMan().setSuunta(Suunta.VASEN);
        pacman.getHaamuLista().get(0).setX(9);
        pacman.getHaamuLista().get(0).setY(8);
        pacman.getMan().liiku();
        pacman.getHaamuLista().get(0).liiku();        
        pacman.kuoleekoHaamuTaiMan();
        
        assertEquals(9, pacman.getMan().getX());
        assertEquals(11, pacman.getMan().getY());
    }
    
    @Test
    public void kuoleekoHaamuKunHaamuHeikko() {
        pacman.getHaamuLista().get(0).setTyyppi("heikko");
        pacman.getMan().setX(10);
        pacman.getMan().setY(7);
        pacman.getMan().setSuunta(Suunta.VASEN);
        pacman.getHaamuLista().get(0).setX(9);
        pacman.getHaamuLista().get(0).setY(8);
        pacman.getMan().liiku();
        pacman.getHaamuLista().get(0).liiku();        
        pacman.kuoleekoHaamuTaiMan();
        
        assertEquals(9,pacman.getHaamuLista().get(0).getX());
        assertEquals(9,pacman.getHaamuLista().get(0).getY());
    }
    
    @Test
    public void syokoManPistepallonOikein() {
        pacman.getMan().liiku();
        pacman.manSyoPistepallo();
        assertEquals(false, pacman.getAlusta().getPeliruutu(10, 11).getOnkoPistepallo());
        assertEquals(10, pacman.getPisteet());
    }
}
