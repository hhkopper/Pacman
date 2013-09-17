/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.hahmot;

import pacman.alusta.Pelialusta;
import pacman.alusta.Peliruutu;
import pacman.komponentit.Hedelma;

public class Man {

    private int y;
    private int x;
    private Suunta suunta;
    private Pelialusta alusta;
    private int elamat;

    public Man(int y, int x, Suunta alkuSuunta, Pelialusta alusta) {
        this.y = y;
        this.x = x;
        this.suunta = alkuSuunta;
        this.alusta = alusta;
        elamat = 3;
    }

    public void luoManAlustalle() {
        alusta.getPeliruutu(y,x).setOnkoMan(true);
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getElamat() {
        return elamat;
    }

    public void liiku() {
        this.x = this.x + this.suunta.getX();
        this.y = this.y + this.suunta.getY();

        if (osuukoSeinaan()) {
            this.x = this.x - this.suunta.getX();
            this.y = this.y - this.suunta.getY();
        } else {
            alusta.getPeliruutu(y,x).setOnkoMan(true);
            alusta.getPeliruutu(y - suunta.getY(),x - suunta.getX()).setOnkoMan(false);
        }
    }
    
    public boolean osuukoSeinaan() {
        Peliruutu ruutu = alusta.getPeliruutu(y,x);
        if (ruutu.getRuudunTyyppi() == 0) {
            return true;
        }
        return false;
    }

    public void palaaAlkuun() {
        alusta.getPeliruutu(y,x).setOnkoMan(false);
        this.y = 11;
        this.x = 9;
        alusta.getPeliruutu(y,x).setOnkoMan(true);
        elamat--;
    }

    public String toString() {
        return this.y + "," + this.x;
    }

    public boolean osuuHedelmaan(Hedelma hedelma) {
        if (this.x == hedelma.getX() && this.y == hedelma.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
