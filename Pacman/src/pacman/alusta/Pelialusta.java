package pacman.alusta;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import javax.swing.JPanel;
import pacman.peli.Pacman;

public class Pelialusta {

    private Peliruutu[][] pelialusta;
    private int korkeus;
    private int leveys;

    public Pelialusta(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.pelialusta = new Peliruutu[korkeus][leveys];
//        korkeus tulee olla 21 ja leveys 19, ei vielä kovakoodata
    }
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }

    public void luoPelialusta() {
        for (int i = 0; i <= korkeus - 1; i++) {
            for (int j = 0; j <= leveys - 1; j++) {
                this.pelialusta[i][j] = new Peliruutu(i, j);
                this.pelialusta[i][j].setRuudunTyyppi(1);
                this.pelialusta[i][j].setOnkoMan(false);
                this.pelialusta[i][j].setOnkoHaamu(false);
            }
        }
    }

    public void rakennaSeinat() throws Exception {
        File tiedosto = new File("Kentta");
        Scanner lukija = new Scanner(tiedosto);

        int luku = 0;
                
        while (lukija.hasNextLine()) {
            for (int i = 0; i < 19; i++) {
                if(lukija.nextInt() == 0) {
                    this.pelialusta[luku][i].setRuudunTyyppi(0);
                }
//                if(lukija.nextInt() == 3) {
//                    this.pelialusta[luku][i].setRuudunTyyppi(3);
//                }
            }
            luku++;
        }

        lukija.close();
    }
    
    public void luoPistepallot() {
        
    }

    public Peliruutu getPeliruutu(int i, int j) {
        return this.pelialusta[i][j];
    }
    
    public String toString() {
        return "Korkeus:" + this.korkeus + ", leveys:" + this.leveys;
    }
}
