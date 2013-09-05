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
//    @Test
//    public void hello() {
//    }

    @Test
    public void manLiikkuuOikein() {
        Man man = new Man(2, 2, Suunta.ALAS);
        String vastaus = man.toString();
        assertEquals(man.getX() + "," + man.getY(), vastaus);
    }
}
