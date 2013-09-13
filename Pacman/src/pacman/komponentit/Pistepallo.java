
package pacman.komponentit;

public class Pistepallo {  
    private int x;
    private int y;
    private int arvo;
    
    public Pistepallo(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = 20;
    }
    
    public int gerArvo() {
        return this.arvo;
    }
    
    public String toString() {
        return this.x + "," + this.y;
    }
}
