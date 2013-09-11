package pacman.hahmot;

import pacman.Suunta;
import pacman.alusta.Pelialusta;

public class Haamu {
    private int x;
    private int y;
    private Suunta alkuSuunta;
    private String nimi;
    
    public Haamu(int x, int y, Suunta suunta, String nimi) {
        this.x = x;
        this.y = y;
        this.alkuSuunta = suunta;
        this.nimi = nimi;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getY() {
        return this.y;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public void setAlkuSuunta(Suunta uusiSuunta) {
        this.alkuSuunta = uusiSuunta;
    }
    
    public Suunta getSuunta() {
        return this.alkuSuunta;
    }
    
    public void luoHaamuAlustalle(Pelialusta alusta) {
        alusta.getPeliruutu(x, y).setOnkoHaamu(true);
    }
    
    public String toString() {
        return "(" + this.x + "," + this.y + ") Nimi: " + this.nimi;
    }
    
}
