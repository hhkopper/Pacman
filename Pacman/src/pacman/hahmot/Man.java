/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.hahmot;

import pacman.Suunta;

public class Man {

    private int alkuX;
    private int alkuY;
    private Suunta alkuSuunta;

    public Man(int alkuX, int alkuY, Suunta alkuSuunta) {
        this.alkuX = alkuX;
        this.alkuY = alkuY;
        this.alkuSuunta = alkuSuunta;
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

        if (this.alkuSuunta == Suunta.ALAS) {
            this.alkuY = this.alkuY+1;
        } else if(this.alkuSuunta == Suunta.YLOS) {
            this.alkuY = this.alkuY-1;
        } else if(this.alkuSuunta == Suunta.OIKEA) {
            this.alkuX = this.alkuX+1;
        } else if(this.alkuSuunta == Suunta.VASEN) {
            this.alkuX = this.alkuX-1;
        }


    }

}
