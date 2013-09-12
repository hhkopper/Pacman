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

        if (this.alkuSuunta == Suunta.OIKEA) {
            this.alkuY = this.alkuY + 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuY--;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX, alkuY-1).setOnkoMan(false);


        } else if (this.alkuSuunta == Suunta.VASEN) {
            this.alkuY = this.alkuY - 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuY++;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX, alkuY+1).setOnkoMan(false);
            
        } else if (this.alkuSuunta == Suunta.ALAS) {
            this.alkuX = this.alkuX + 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuX--;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX-1, alkuY).setOnkoMan(false);
            
        } else if (this.alkuSuunta == Suunta.YLOS) {
            this.alkuX = this.alkuX - 1;
            if (osuukoSeinaan(alusta)) {
                this.alkuX++;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX+1, alkuY).setOnkoMan(false);
            
        }
    }

    public boolean osuukoSeinaan(Pelialusta alusta) {
        Peliruutu ruutu = alusta.getPeliruutu(alkuX, alkuY);
        if (ruutu.getRuudunTyyppi() == 0) {
            return true;
        }
        return false;
    }
    
    public void tarkistaKuoleeko(Pelialusta alusta) {
        if(alusta.getPeliruutu(alkuX, alkuY).getOnkoMan() == true && alusta.getPeliruutu(alkuX, alkuY).getOnkoHaamu() == true) {
            this.alkuX = 11;
            this.alkuY = 9;
        }
    }
    

    public String toString() {
        return this.alkuX + "," + this.alkuY;
    }
}
