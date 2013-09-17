package pacman.alusta;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import javax.swing.JPanel;
import org.omg.CORBA.INTERNAL;
import pacman.peli.Pacman;
import pacman.komponentit.Pistepallo;

public class Pelialusta {

    private Peliruutu[][] pelialusta;
    private int kor;
    private int lev;

    public Pelialusta(int lev, int kor) {
        this.kor = kor;
        this.lev = lev;
        this.pelialusta = new Peliruutu[kor][lev];
        
//        korkeus tulee olla 21 ja leveys 19, ei vielä kovakoodata
    }

    public void apu(){
        System.out.println(pelialusta.length);
        System.out.println(pelialusta[0].length);
    }
    
    public int getLeveys() {
        return this.lev;
    }

    public int getKorkeus() {
        return this.kor;
    }

    public void luoPelialusta() throws Exception {
        for (int i = 0; i <= kor - 1; i++) {
            for (int j = 0; j <= lev - 1; j++) {
                this.pelialusta[i][j] = new Peliruutu(i, j);
                this.pelialusta[i][j].setRuudunTyyppi(1);
                this.pelialusta[i][j].setOnkoMan(false);
                this.pelialusta[i][j].setOnkoHaamu(false);
                this.pelialusta[i][j].setOnkoPistepallo(false);
            }
        }
        rakennaSeinatJaLuoPisteet();
    }

    public void rakennaSeinatJaLuoPisteet() throws Exception {
        File tiedosto = new File("Kentta");
        Scanner lukija = new Scanner(tiedosto);
        int luku = 0;

        while (lukija.hasNextLine()) {
            for (int i = 0; i < 19; i++) {
                if (lukija.nextInt() == 0) {
                    this.pelialusta[luku][i].setRuudunTyyppi(0);
                } else {
                    if (tarkistaEtteiHaamujenKarsinassa(luku, i) == true) {
                    } else {
//                        Pistepallo pallo = new Pistepallo(luku, i);
                        this.pelialusta[luku][i].setOnkoPistepallo(true);
                    }
                }
            }
            luku++;
        }
        lukija.close();
    }

    public boolean tarkistaEtteiHaamujenKarsinassa(int luku, int i) {
        if (luku == 9 && i == 8 || luku == 9 && i == 9 || luku == 9 && i == 10 || luku == 8 && i == 9) {
            return true;
        }
        return false;
    }

    public Peliruutu getPeliruutu(int i, int j) {
        return this.pelialusta[i][j];
    }

    public String toString() {
        return "Korkeus:" + this.kor + ", leveys:" + this.lev;
    }
}
