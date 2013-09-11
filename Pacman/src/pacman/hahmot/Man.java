/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.hahmot;

import pacman.Suunta;
import pacman.alusta.Pelialusta;
import pacman.alusta.Peliruutu;

public class Man {

    private int alkuX;
    private int alkuY;
    private Suunta alkuSuunta;

    public Man(int alkuX, int alkuY, Suunta alkuSuunta) {
        this.alkuX = alkuX;
        this.alkuY = alkuY;
        this.alkuSuunta = alkuSuunta;
    }

    public void luoManAlustalle(Pelialusta alusta) {
        alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
    }

    public void setSuunta(Suunta suunta) {
        this.alkuSuunta = suunta;
    }

    public int getX() {
        return this.alkuX;
    }

    public int getY() {
        return this.alkuY;
    }

    public void liiku(Pelialusta alusta) {

        if (this.alkuSuunta == Suunta.ALAS) {
            this.alkuY = this.alkuY + 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuY--;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(false);


        } else if (this.alkuSuunta == Suunta.YLOS) {
            this.alkuY = this.alkuY - 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuY++;
            }
        } else if (this.alkuSuunta == Suunta.OIKEA) {
            this.alkuX = this.alkuX + 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuX--;
            }
        } else if (this.alkuSuunta == Suunta.VASEN) {
            this.alkuX = this.alkuX - 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuX++;
            }
        }
    }

    public boolean osuukoSeinaan(Pelialusta alusta) {
        Peliruutu ruutu = alusta.getPeliruutu(alkuX, alkuY);
        if (ruutu.getRuudunTyyppi() == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.alkuX + "," + this.alkuY;
    }
}
