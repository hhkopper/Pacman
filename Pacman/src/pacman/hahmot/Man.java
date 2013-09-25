package pacman.hahmot;

import pacman.alusta.Pelialusta;
import pacman.alusta.Peliruutu;

/**
 * Man luokka kuvaa pelin päähahmoa jota pelaaja liikuttaa kentällä. 
 * Manin tehtävä on liikuttaa itseään kentällä ja tietää minne voi liikkua.
 * Man myös tietää omat elämänsä ja osaa vähentää niitä, kun man kuolee.
 * 
 * @author Hanna
 */
public class Man {

    private int x;
    private int y;
    private Suunta suunta;
    private Pelialusta alusta;
    private int elamat;

    public Man(int x, int y, Suunta alkuSuunta, Pelialusta alusta) {
        this.x = x;
        this.y = y;
        this.suunta = alkuSuunta;
        this.alusta = alusta;
        elamat = 3;
    }

    public void luoManAlustalle() {
        alusta.getPeliruutu(x,y).setOnkoMan(true);
    }
    
    public Suunta getSuunta() {
        return this.suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getX() {
        return this.x;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    public int getElamat() {
        return elamat;
    }
    
    public void vahennaElama() {
        this.elamat = this.elamat--;
    }

    public void liiku() {
        this.y = this.y + this.suunta.getY();
        this.x = this.x + this.suunta.getX();

        if (osuukoSeinaan()) {
            this.y = this.y - this.suunta.getY();
            this.x = this.x - this.suunta.getX();
        } else {
            alusta.getPeliruutu(x,y).setOnkoMan(true);
            alusta.getPeliruutu(x - suunta.getX(),y - suunta.getY()).setOnkoMan(false);
        }
    }
    
    public boolean osuukoSeinaan() {
        Peliruutu ruutu = alusta.getPeliruutu(x,y);
        if (ruutu.getRuudunTyyppi() == 0) {
            return true;
        }
        return false;
    }

    public void palaaAlkuun() {
        alusta.getPeliruutu(x,y).setOnkoMan(false);
        this.x = 9;
        this.y = 11;
        alusta.getPeliruutu(x,y).setOnkoMan(true);
        elamat--;
    }
}
