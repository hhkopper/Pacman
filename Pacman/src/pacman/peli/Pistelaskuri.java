package pacman.peli;

import java.util.Scanner;

/**
 * Pistelaskuri luokan avulla seurataan pelin aikana kertyviä pisteitä.
 * 
 * @author Hanna
 */
public class Pistelaskuri {

    private int pisteet;

    public Pistelaskuri() {
        pisteet = 0;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    /**
     * Kasvatetaan pistemäärää
     * 
     * @param arvo kertoo kuinka paljon lisätään pisteisiin
     */
    public void kasvata(int arvo) {
        pisteet = pisteet + arvo;
    }
    
}
