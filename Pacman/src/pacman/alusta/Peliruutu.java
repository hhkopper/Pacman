
package pacman.alusta;

public class Peliruutu {
    private int x;
    private int y;
    private int ruudunTyyppi;
    private boolean onkoMan;
    
    public Peliruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    
   //jos ruutu on polku se on 1, jos seinä on 0 
    public int getRuudunTyyppi() {
        return this.ruudunTyyppi;
    }
    
    public void setRuudunTyyppi(int uusiTyyppi) {
        this.ruudunTyyppi = uusiTyyppi;
    }
    
    public void setOnkoMan(boolean arvo) {
        this.onkoMan = arvo;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "), onko man: " + this.onkoMan;
    }
    
}
