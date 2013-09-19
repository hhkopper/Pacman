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

    public int getLeveys() {
        return this.lev;
    }

    public int getKorkeus() {
        return this.kor;
    }

    public Peliruutu getPeliruutu(int i, int j) {
        return this.pelialusta[j][i];
    }

    public void luoPelialusta() throws Exception {
        for (int i = 0; i <= kor - 1; i++) {
            for (int j = 0; j <= lev - 1; j++) {
                this.pelialusta[i][j] = new Peliruutu(j, i);
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
        int y = 0;

        while (lukija.hasNextLine()) {
            for (int x = 0; x < 19; x++) {
                asetaSeinatJaPistepallot(lukija, y, x);
            }
            y++;
        }
        lukija.close();
    }

    private void asetaPistepallot(int x, int y) {
        if (!tarkistaEtteiHaamujenKarsinassa(x, y) && !tarkistaEttaOikeastiKaytavallaJaEiManinLahto(x, y)) {
            this.pelialusta[y][x].setOnkoPistepallo(true);
        }
    }

    private void asetaSeinatJaPistepallot(Scanner lukija, int y, int x) {
        if (lukija.nextInt() == 0) {
            this.pelialusta[y][x].setRuudunTyyppi(0);
        } else {
            asetaPistepallot(x, y);
        }
    }

    public boolean tarkistaEtteiHaamujenKarsinassa(int x, int y) {
        if (x == 8 && y == 9 || x == 9 && y == 9 || x == 10 && y == 9 || x == 9 && y == 8) {
            return true;
        }
        return false;
    }

    public boolean tarkistaEttaOikeastiKaytavallaJaEiManinLahto(int x, int y) {
        if ((y == 7 || y == 11) && (x == 0 || x == 1 || x == 2 || x == 16 || x == 17 || x == 18) || x == 9 && y == 11) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Korkeus:" + this.kor + ", leveys:" + this.lev;
    }
}
