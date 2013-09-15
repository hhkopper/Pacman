/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.hahmot;

import pacman.alusta.Pelialusta;
import pacman.alusta.Peliruutu;

public class Man {

    private int x;
    private int y;
    private Suunta suunta;
    private Pelialusta alusta;
    private int elamat;

    public Man(int alkuX, int alkuY, Suunta alkuSuunta, Pelialusta alusta) {
        this.x = alkuX;
        this.y = alkuY;
        this.suunta = alkuSuunta;
        this.alusta = alusta;
        elamat = 3;
    }

    public void luoManAlustalle() {
        alusta.getPeliruutu(x, y).setOnkoMan(true);
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public int getElamat() {
        return elamat;
    }

    public void liiku() {

        if (this.suunta == Suunta.OIKEA) {
            this.y = this.y + 1;
            if (osuukoSeinaan()) {
                this.y--;
                return;
            }           
            alusta.getPeliruutu(x, y-1).setOnkoMan(false);

        } else if (this.suunta == Suunta.VASEN) {
            this.y = this.y - 1;
            if (osuukoSeinaan()) {
                this.y++;
                return;
            }
            alusta.getPeliruutu(x, y+1).setOnkoMan(false);
            
        } else if (this.suunta == Suunta.ALAS) {
            this.x = this.x + 1;
            if (osuukoSeinaan()) {
                this.x--;
                return;
            }
            alusta.getPeliruutu(x-1, y).setOnkoMan(false);
            
        } else if (this.suunta == Suunta.YLOS) {
            this.x = this.x - 1;
            if (osuukoSeinaan()) {
                this.x++;
                return;
            }
            alusta.getPeliruutu(x+1, y).setOnkoMan(false);            
        }
        
        alusta.getPeliruutu(x, y).setOnkoMan(true);
    }

    public boolean osuukoSeinaan() {
        Peliruutu ruutu = alusta.getPeliruutu(x, y);
        if (ruutu.getRuudunTyyppi() == 0) {
            return true;
        }
        return false;
    }
    
    public void tarkistaKuoleeko() {
        if(alusta.getPeliruutu(x, y).getOnkoMan() == true && alusta.getPeliruutu(x, y).getOnkoHaamu() == true) {
            kuole();   
        }
        
    }
    
    public void kuole() {
        alusta.getPeliruutu(x, y).setOnkoMan(false);
            this.x = 11;
            this.y = 9;
            alusta.getPeliruutu(x, y).setOnkoMan(true);
            elamat--;
    }
    

    public String toString() {
        return this.x + "," + this.y;
    }
}
