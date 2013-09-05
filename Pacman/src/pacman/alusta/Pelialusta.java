package pacman.alusta;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;
import pacman.peli.Pacman;

public class Pelialusta {

    private Peliruutu[][] pelialusta;
    private int korkeus;
    private int leveys;

    public Pelialusta() {
        this.korkeus = 21;
        this.leveys = 19;
        this.pelialusta = new Peliruutu[korkeus][leveys];
    }

    public void luoPelialusta() {
        for (int i = 0; i <= korkeus - 1;i++) {
            for(int j = 0; j <= leveys -1; j++) {
                this.pelialusta[i][j] = new Peliruutu(i,j);
            }
        }
    }
    
    public void rakennaSeinat() {
        for(int m = 0; m <= korkeus-1; m++) {
            for(int n = 0; n <= leveys-1; n++) {
                this.pelialusta[m][n].setRuudunTyyppi(1);
            }
        }
        
        for (int i = 0; i < 21; i++) {
            this.pelialusta[i][0].setRuudunTyyppi(0);
            this.pelialusta[i][18].setRuudunTyyppi(0);
            
        }
        
        for (int j = 0; j < 19; j++) {
            this.pelialusta[0][j].setRuudunTyyppi(0);
            this.pelialusta[20][j].setRuudunTyyppi(0);
        }
        
    }
    
    public Peliruutu getPeliruutu(int i, int j) {
        return this.pelialusta[i][j];
    }
}
