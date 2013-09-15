/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.hahmot;

import pacman.alusta.Pelialusta;
import pacman.alusta.Peliruutu;

public class Man {

    private int alkuX;
    private int alkuY;
    private Suunta alkuSuunta;
    private Pelialusta alusta;
    private int elamat;

    public Man(int alkuX, int alkuY, Suunta alkuSuunta, Pelialusta alusta) {
        this.alkuX = alkuX;
        this.alkuY = alkuY;
        this.alkuSuunta = alkuSuunta;
        this.alusta = alusta;
        elamat = 3;
    }

    public void luoManAlustalle() {
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

    public void liiku() {

        if (this.alkuSuunta == Suunta.OIKEA) {
            this.alkuY = this.alkuY + 1;
            if (osuukoSeinaan()) {
                this.alkuY--;
                return;
            }
            tarkistaKuoleeko();
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX, alkuY-1).setOnkoMan(false);


        } else if (this.alkuSuunta == Suunta.VASEN) {
            this.alkuY = this.alkuY - 1;
            if (osuukoSeinaan()) {
                this.alkuY++;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX, alkuY+1).setOnkoMan(false);
            
        } else if (this.alkuSuunta == Suunta.ALAS) {
            this.alkuX = this.alkuX + 1;
            if (osuukoSeinaan()) {
                this.alkuX--;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX-1, alkuY).setOnkoMan(false);
            
        } else if (this.alkuSuunta == Suunta.YLOS) {
            this.alkuX = this.alkuX - 1;
            if (osuukoSeinaan()) {
                this.alkuX++;
                return;
            }
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
            alusta.getPeliruutu(alkuX+1, alkuY).setOnkoMan(false);
            
        }
    }

    public boolean osuukoSeinaan() {
        Peliruutu ruutu = alusta.getPeliruutu(alkuX, alkuY);
        if (ruutu.getRuudunTyyppi() == 0) {
            return true;
        }
        return false;
    }
    
    public boolean tarkistaKuoleeko() {
        if(alusta.getPeliruutu(alkuX, alkuY).getOnkoMan() == true && alusta.getPeliruutu(alkuX, alkuY).getOnkoHaamu() == true) {
            kuole();
            return;
        }
        
    }
    
    public void kuole() {
        alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(false);
            this.alkuX = 11;
            this.alkuY = 9;
            alusta.getPeliruutu(alkuX, alkuY).setOnkoMan(true);
    }
    

    public String toString() {
        return this.alkuX + "," + this.alkuY;
    }
}
